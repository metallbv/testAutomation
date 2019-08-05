package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

  /*By usernameLocator = By.id("signInEmail");
  By passwordLocator = By.id("signInPassword");
  By loginButtonLocator = By.xpath("//input[@class=\"popup-reg-sign-in-form__sign-in\"]");

  private final WebDriver driver;

  public LoginPage(WebDriver driver) {
    this.driver = driver;

    if (!"Login".equals(driver.getTitle())) {
      throw new IllegalStateException("This is not the login page");
    }
  }

  public LoginPage typeUsername(String username) {
    driver.findElement(usernameLocator).sendKeys(username);
    return this;
  }

  public LoginPage typePassword(String password) {
    driver.findElement(passwordLocator).sendKeys(password);
    return this;
  }

  public HomePage submitLogin() {
    driver.findElement(loginButtonLocator).submit();
    return new HomePage(driver);
  }

  public LoginPage submitLoginExpectingFailure() {
    driver.findElement(loginButtonLocator).submit();
    return new LoginPage(driver);
  }

  public HomePage loginAs(String username, String password) {
    typeUsername(username);
    typePassword(password);
    return submitLogin();
  }*/

}
