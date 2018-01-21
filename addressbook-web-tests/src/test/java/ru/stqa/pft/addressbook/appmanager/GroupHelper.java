package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends BaseHepler{

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"),groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }


  public void createGroup(GroupData group) { // Функция для создания новой группы
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAgroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() { //Метод который считает и возвращает количество элементов типа checkbox на странице Groups
    return wd.findElements(By.name("selected[]")).size(); // Поиск всех элементов и подсчёт их количества
  }
}
