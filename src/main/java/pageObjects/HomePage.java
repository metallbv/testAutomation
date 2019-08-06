package pageObjects;

import decorator.elements.Button;
import decorator.elements.PageElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import pageObjects.businessObjects.SignInBO;

public class HomePage extends AbstractPage {

  private static final Logger logger = Logger.getLogger(HomePage.class);

  @FindBy(xpath = "//p[@class=\"header-auth__signin\"]//span")
  private Button signInButton;

  @FindBy(className = "user-info__name")
  private PageElement topRightCornerUserNameElement;

  @FindBy(xpath = "//ul[@class=\"main-nav__list\"]//a[contains(@class, 'training')]")
  private Button trainingListPageButton;

  @FindBy(className = "//ul[@class=\"main-nav__list\"]//a[contains(@class, 'news')]")
  private Button newsPageButton;

  @FindBy(className = "//ul[@class=\"main-nav__list\"]//a[contains(@class, 'about')]")
  private Button aboutPageButton;

  @FindBy(xpath = "//ul[@class=\"main-nav__list\"]//a[contains(@class, 'faq')]")
  private Button FAQPageButton;

  public HomePage() {
    super();
  }

  public SignInBO clickSignInButton() {
    signInButton.click();
    logger.info("Sign in button was clicked");
    return new SignInBO();
  }

  public boolean isUserNameShown() {
    return topRightCornerUserNameElement.isDisplayed();
  }

  public String getUserName() {
    return topRightCornerUserNameElement.getText();
  }

}
