package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }
  public void initContactCreation() {
    click(By.linkText("add_new"));
  }
  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());

    if (isElementPresent(By.name("new_group"))) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      // обращение к выпадающему списку поля new_group+
    }
  }
  public void submitContactCreation() {
    click(By.name("submit"));
  }
  public void returnToHomePage() {
    click(By.name("home_page"));
  }
  public void initContactModification() {
    click(By.name("img[alt='Edit']"));
  }
  public void submitContactModification() {
    click(By.name("update"));
  }

}
