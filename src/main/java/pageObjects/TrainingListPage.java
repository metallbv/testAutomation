package pageObjects;

import decorator.elements.Button;
import decorator.elements.TextInput;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TrainingListPage extends AbstractPage {

  private static final Logger logger = Logger.getLogger(TrainingListPage.class);

  @FindBy (xpath = "//div[@class=\"filter-field__arrow-icon\" & @ng-click=\"openSkillsDropDown()\"]")
  private Button expandAllSkillsArrow;

  @FindBy (xpath = "//class=\"filter-field__arrow-icon arrow-icon-rotate\" & @ng-click=\"openSkillsDropDown()\"]")
  private Button collapseAllSkillsArrow;

  @FindBy (xpath = "//input[@ng-model=\"searchTrainingBySkills\"]")
  private TextInput skillsSearchInput;

  @FindBy (xpath = "//label[contains(@ng-class, 'Skill')]")
  private List<WebElement> skillsSearchResultsList;

  public TrainingListPage expandSkillsModalWindow() {
    waitForElementToBeVisible(expandAllSkillsArrow);
    expandAllSkillsArrow.click();
    logger.info("Expand 'Skills' modal window");
    return this;
  }

  public TrainingListPage collapseSkillsModalWindow() {
    waitForElementToBeVisible(collapseAllSkillsArrow);
    collapseAllSkillsArrow.click();
    logger.info("Collapse 'Skills' modal window");
    return this;
  }

  public boolean isSkillModalWindowExpanded() {
    return collapseAllSkillsArrow.isDisplayed();
  }

  public TrainingListPage performSearchInSkills(String searchTerm) {
    skillsSearchInput.sendKeys(searchTerm);
    return this;
  }

  public TrainingListPage clearSkillsInput() {
    skillsSearchInput.clear();
    return this;
  }

  public List<WebElement> getSkillsSearchResultsElements() {
    return skillsSearchResultsList;
  }

  public boolean isSkillSearchResultsPresent() {
    return !skillsSearchResultsList.isEmpty();
  }

}
