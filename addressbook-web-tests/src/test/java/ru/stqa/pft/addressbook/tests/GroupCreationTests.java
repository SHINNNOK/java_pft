package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider //Провайдер тестовыъ данных
  public Iterator<Object[]> validGroups() throws IOException { //Список массивов объектов
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv"))); //Чтение данных для теста из файла
    String line = reader.readLine(); // Чтение строки из файла
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])}); //В список добавляем массив объектов типа GroupData
      line = reader.readLine();
    }
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      assertThat(app.group().count(), equalTo(before.size() + 1)); // count - работает быстрее, чем size при подсчёте элементов в списке (Это есть предварительная более быстрая проверка или хэширование)
      Groups after = app.group().all();
      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

  @Test
  public void testGroupBadCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test11'");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }


}
