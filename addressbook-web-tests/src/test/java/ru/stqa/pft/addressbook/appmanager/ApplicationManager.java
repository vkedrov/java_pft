package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private WebDriver wd;
  private GroupHelper groupHelper;
  private NavigationHelper navigationHelper; // объявление переменной класса с адресом экземпляра класса
  private SessionHelper sessionHelper;
  private String browser;
  private ContactHelper contactHelper;
  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {

    switch (browser) {
      case BrowserType.FIREFOX:
        wd = new FirefoxDriver();
        break;
      case BrowserType.CHROME:
        wd = new ChromeDriver();
        break;
      case BrowserType.IE:
        wd = new InternetExplorerDriver();
        break;
    }

    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd); // создание нового экземпляра класса и присвоение его адреса переменной класса
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
    contactHelper = new ContactHelper(wd);
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
  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
