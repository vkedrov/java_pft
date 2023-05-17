package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver wd) {
    super(wd);
  }
  public void initContactCreation() {
    click(By.linkText("add_new"));
  }
  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
            // обращение к выпадающему списку поля new_group, заполнение поля с выпадающим списком значением
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
            // аварийное завершение, если на форме модификации контакта появилось поле группы
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
