package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
  private WebDriver wd; // передаваемая переменная
  public NavigationHelper (WebDriver wd) { this.wd = wd; } // конструктор

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  } // метод

}
