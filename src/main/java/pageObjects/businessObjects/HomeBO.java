package pageObjects.businessObjects;

import consts.Constants;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.TrainingListPage;

public class HomeBO {

  private HomePage homePage;

  public HomePage proceedToHomePage() {
    homePage = new HomePage();
    homePage.proceedToPage(Constants.BusinessConfigs.BASE_URL);
    return homePage;
  }

  public HomePage openPage(Class<TrainingListPage> trainingListPageClass) {
    return homePage;
  }

  public SignInBO clickSignInButton() {
    return homePage.clickSignInButton();
  }

  public void verifyUserIsLoggedIn() {
    Assert.assertTrue("", this.proceedToHomePage().isUserNameShown());
  }

  public  void verifyRightUserNameIsDisplayed(String userName) {
    Assert.assertTrue("", userName.equals(homePage.getUserName()));
  }

}
