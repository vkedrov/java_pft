package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private WebDriver wd;
  private GroupHelper groupHelper;
  private NavigationHelper navigationHelper; // объявление переменной класса с адресом экземпляра класса
  private SessionHelper sessionHelper;
  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd); // создание нового экземпляра класса и присвоение его адреса переменной класса
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }
    public void stop() {
    wd.findElement(By.linkText("Logout")).click();
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  } // метод возвращающий адрес экземпляра класса
}
