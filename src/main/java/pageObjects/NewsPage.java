package pageObjects;

import decorator.elements.Button;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends AbstractPage {

  @FindBy(xpath = "//div[@class=\"tab-nav\"]/div/div/span[text()=\"News\"]/..")
  private Button newsButton;

  @FindBy(xpath = "//div[@class=\"tab-nav\"]/div/div/span[text()=\"Success Stories\"]/..")
  private Button successStoriesButton;

  @FindBy(xpath = "//div[@class=\"tab-nav\"]/div/div/span[text()=\"Materials\"]/..")
  private Button materialsButton;

  @FindBy(xpath = "//div[@class=\"tab-nav\"]/div/div/span[text()=\"Videos\"]/..")
  private Button videosButton;
}
