import org.junit.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.SignInBO;

public class SignInPageTest extends BaseTest {

  @Test
  public void verifyErrorMessageAppearsForIncorrectUser() {
    new HomeBO()
      .proceedToHomePage()
      .clickSignInButton()
      .login("abc@gmail.com","abc");
    new SignInBO()
      .verifyFailedLoginErrorMessageDisplayed();
  }

  @Test
  public void ferifyUserSuccessfullyLoggedIn() {

    HomeBO homeBO = new HomeBO();
    homeBO
      .proceedToHomePage()
      .clickSignInButton()
      .login("vitaliy.babiak@gmail.com", "Pswepam_")
      .verifyUserIsLoggedIn();
    homeBO.verifyRightUserNameIsDisplayed("vitaliy.babiak");
  }

}
