package pageObjects.businessObjects;

import org.junit.Assert;
import pageObjects.SignInPage;

public class SignInBO {

  private SignInPage signInPage;

  public SignInBO() {
    signInPage = new SignInPage();
  }

  public HomeBO login(String mail, String password) {
    signInPage.enterEmail(mail)
      .enterPassword(password)
      .clickSignInButton();
    return new HomeBO();
  }

  public void verifyFailedLoginErrorMessageDisplayed() {
    Assert.assertTrue("Login failed - error message is not displayed", signInPage.isLoginFailedErrorMessageDisplayed());
  }

}
