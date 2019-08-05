package pageObjects;

import decorator.elements.Button;
import decorator.elements.PageElement;
import decorator.elements.TextInput;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {

  private static final Logger logger = Logger.getLogger(SignInPage.class);

  @FindBy(id = "signInEmail")
  private TextInput mailInput;

  @FindBy(id = "signInPassword")
  private TextInput passwordInput;

  @FindBy(xpath = "//input[@class=\"popup-reg-sign-in-form__sign-in\"]")
  private Button signInButton;

  @FindBy(xpath = "//div[@class=\"popup__error-message ng-binding\"]")
  private PageElement loginFailedErrorMessage;

  public SignInPage enterEmail(String email) {
    mailInput.sendKeys(email);
    logger.info("Mail was entered");
    return this;
  }

  public SignInPage enterPassword(String password) {
    passwordInput.sendKeys(password);
    logger.info("Password was entered");
    return this;
  }

  public HomePage clickSignInButton() {
    signInButton.click();
    logger.info("Sign in button was clicked");
    return new HomePage();
  }

  public boolean isLoginFailedErrorMessageDisplayed() {
    boolean isDisplayed = loginFailedErrorMessage.isDisplayed();
    logger.info("Login failed");
    return isDisplayed;
  }

}
