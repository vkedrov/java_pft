package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
  public NavigationHelper (WebDriver wd) {
    super(wd);  // вызов конструктора базового класса
  }
  public void gotoGroupPage() {
    click(By.linkText("groups"));   // метод
  }
  public void gotoHomePage() {
    click(By.linkText("home"));   // метод
  }
}
