package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper {

  private BaseHepler baseHepler;

  public ContactHelper(FirefoxDriver wd) {
      baseHepler = new BaseHepler(wd);
  }

  public void fillContactForm(ContactData contactData) {
    baseHepler.wd.findElement(By.name("firstname")).click();
    baseHepler.wd.findElement(By.name("firstname")).clear();
    baseHepler.wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
    baseHepler.wd.findElement(By.name("lastname")).click();
    baseHepler.wd.findElement(By.name("lastname")).clear();
    baseHepler.wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    baseHepler.wd.findElement(By.name("address")).click();
    baseHepler.wd.findElement(By.name("address")).clear();
    baseHepler.wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    baseHepler.wd.findElement(By.name("mobile")).click();
    baseHepler.wd.findElement(By.name("mobile")).clear();
    baseHepler.wd.findElement(By.name("mobile")).sendKeys(contactData.getMobilePhoneNumber());
    baseHepler.wd.findElement(By.name("email")).click();
    baseHepler.wd.findElement(By.name("email")).clear();
    baseHepler.wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  public BaseHepler getBaseHepler() {
    return baseHepler;
  }

  public void initContactModification() {
    baseHepler.wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();
  }

  public void submitContactModification() {
    baseHepler.wd.findElement(By.xpath("//div[@id='content']/form[1]/input[22]")).click();
  }

  public void selectContact() {
    baseHepler.wd.findElement(By.id("24")).click();
   }

  public void deleteContact() {
    baseHepler.wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }

  public void confirmContactDeletion() {
    baseHepler.wd.switchTo().alert().accept();
  }
}
