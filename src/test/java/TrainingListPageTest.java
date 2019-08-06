import org.junit.Test;
import pageObjects.TrainingListPage;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.TrainingListBO;

public class TrainingListPageTest {

  @Test
  public void testVerifyTrainingsSearchWorksProperlyForSkills() {
    TrainingListBO trainingListBO = new TrainingListBO();

    new HomeBO()
      .proceedToHomePage()
      .clickSignInButton()
      .login("vitaliy.babiak@gmail.com", "Pswepam_")
      .openPage(TrainingListPage.class);
    trainingListBO
      .expandSkillsModalWindow()
      .performSearchInSkills("Java")
      .verifyEachListElementContainsWord(trainingListBO.getSkillsSearchResultsTextList(), "Java");
    trainingListBO
      .clearSkillsInput()
      .performSearchInSkills("DATA")
      .verifyEachListElementContainsWord(trainingListBO.getSkillsSearchResultsTextList(), "Data");
    trainingListBO
      .clearSkillsInput()
      .performSearchInSkills("DATA")
      .verifyEachListElementContainsWord(trainingListBO.getSkillsSearchResultsTextList(), "Data");

  }
}
