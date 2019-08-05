package pageObjects;

import decorator.elements.Button;
import decorator.elements.TextInput;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TrainingListPage extends AbstractPage {
  private static final Logger logger = Logger.getLogger(TrainingListPage.class);

  @FindBy (xpath = "//div[@class=\"filter__item filter__item-skills\"]/div/div[@class=\"filter-field__arrow-icon\"]")
  private Button expandAllScillsArrow;

  @FindBy (xpath = "//div[@class=\"filter__item filter__item-skills\"]/div/div[@class=\"filter-field__arrow-icon\"]")
  private Button colapseAllScillsArrow;

  @FindBy (xpath = "///div[@class=\"drop-down drop-down-skills drop-down-visibility\"]/input")
  private TextInput scillsSearchInput;

  @FindBy (xpath = "///div[@class=\"drop-down drop-down-skills drop-down-visibility\"]/input")
  private List<WebElement> scillsSearchResultsList;

  public TrainingListPage expandScillsModalWindow() {
    waitForElementToBeVisible(expandAllScillsArrow);
    expandAllScillsArrow.click();
    logger.info("Expand 'Scills' modal window");
    return this;
  }

  public TrainingListPage collapseScillsModalWindow() {
    waitForElementToBeVisible(colapseAllScillsArrow);
    colapseAllScillsArrow.click();
    logger.info("Collapse 'Scills' modal window");
    return this;
  }

}
