package pageObjects;

import decorator.elements.Button;
import decorator.elements.PageElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import pageObjects.businessObjects.SignInBO;

public class HomePage extends AbstractPage {

  private static final Logger logger = Logger.getLogger(HomePage.class);

  @FindBy(xpath = "//p[@class=\"header-auth__signin\"]")
  private Button signInButton;

  @FindBy(xpath = "//div[@class=\"user-info__name\"]")
  private PageElement userNameLabel;

  public HomePage() {
    super();
  }

  public SignInBO clickSignInButton() {
    signInButton.click();
    logger.info("Sign in button was clicked");
    return new SignInBO();
  }

  public boolean isUserNameShown() {
    return userNameLabel.isDisplayed();
  }

  public String getUserName() {
    return userNameLabel.getText();
  }

}
