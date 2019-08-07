package pageObjects.businessObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.TrainingListPage;

import java.util.List;
import java.util.stream.Collectors;

public class TrainingListBO {

  private TrainingListPage trainingListPage;

  public TrainingListBO() {
    trainingListPage = new TrainingListPage();
  }

  public TrainingListBO expandSkillsModalWindow() {
    //if (!trainingListPage.isSkillModalWindowExpanded() && trainingListPage.isSkillModalWindowCollapsed()) {
    if (trainingListPage.isSkillModalWindowCollapsed()) {
      trainingListPage.expandSkillsModalWindow();
    }
    return this;
  }

  public TrainingListBO performSearchInSkills(String searchTerm) {
    trainingListPage.performSearchInSkills(searchTerm);
    return this;
  }

  public TrainingListBO clearSkillsInput() {
    trainingListPage.clearSkillsInput();
    return this;
  }

  public List<String> getSkillsSearchResultsTextList() {
    return trainingListPage.getSkillsSearchResultsElements().stream().map(WebElement::getText)
      .collect(Collectors.toList());
  }

  public void verifyEachListElementContainsWord(List<String> list, final String word) {
    list.stream().forEach(element->Assert.assertTrue(String.format("Element '%s' does not contain word '%s'", element, word), element.contains(word)));
  }

  public void verifyNoSearchResultsAreReturnedForSkillsSearch(List<String> list, final String word) {
    list.stream().forEach(element->Assert.assertFalse(String.format("Element '%s' contain word '%s'", element, word), element.contains(word)));
    Assert.assertFalse("Search results are returned", trainingListPage.isSkillSearchResultsPresent());
  }
}
