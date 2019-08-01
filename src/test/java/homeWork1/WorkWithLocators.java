package homeWork1;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WorkWithLocators {

  final static Logger logger = Logger.getLogger(WorkWithLocators.class);

  private WebDriver driver;
  private String baseUrlEpam = "https://www.epam.com/";
  private String trainingUrlEpam = "https://www.training.by/";
  private String positionsAnalystUrlEpam = "https://www.epam.com/careers/job-listings?country=Ukraine&city=Lviv";
  private String pastEventsUrlEpam = "https://www.epam.com/about/who-we-are/events";


  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Test
  public void findElementsMainMenu() {
    driver.get(baseUrlEpam);

    List<WebElement> sectionList = driver.findElements(By.xpath("//ul[@class=\"hamburger-menu__list\"]/li/a"));
    logger.debug("Count of section " + sectionList.size());
    Assert.assertEquals(6, sectionList.size());
    driver.close();
  }

  @Test
  public void findCalendars() {

    driver.get(trainingUrlEpam);

    WebElement arrowElement = driver.findElement(By.xpath("//div[@class=\"filter-field__arrow-icon\" and @ng-click=\"openLocationsDropDown()\"]"));
    arrowElement.click();
    logger.debug("Found and click arrow button");

    WebElement chekBoxLocations = driver.findElement(By.xpath("//div[@class=\"drop-down drop-down-locations drop-down-visibility\"]/ul[@class=\"drop-down__input-search__list\"]/li/label[text()[contains(.,'Belarus')]]/span"));
    if (!chekBoxLocations.isSelected()) {
      chekBoxLocations.click();
    }
    logger.debug("Selected country check box");

    List<WebElement> trainingsList = driver.findElements(By.xpath("//div[@class=\"training-list__container training-list__desktop\"]/div/div/div[contains(text(), \"Minsk\")]/../div[@class=\"training-item__duration\"]/div[@class=\"duration-calendar ng-binding\"]"));
    logger.debug("Count actual trainings " + trainingsList.size());

    Assert.assertEquals(9, trainingsList.size());
    driver.close();
  }

  @Test
  public void testFindPositionsAnalyst() {
    driver.get(positionsAnalystUrlEpam);

    List<WebElement> positionElements = driver.findElements(By.xpath("//ul[@class=\"search-result__list\"]/li/div/h5/a[contains(text(), 'Analyst')]"));
    logger.debug("Count of positions " + positionElements.size());

    Assert.assertEquals(5, positionElements.size());
    driver.close();
  }

  @Test
  public void testFindLernMoreButtons() {
    driver.get(pastEventsUrlEpam);

    WebElement pastEventsElement = driver.findElement(By.xpath("//div[@class=\"tabs__title\"]/a[text()[contains(.,'Past Events')]]"));
    pastEventsElement.click();
    logger.debug("Button Past events was clicked");

    List<WebElement> buttonElements = driver.findElements(By.xpath("//ul[@class=\"events-viewer__list\"]/li/time[contains(text(), 'MAY')]/../div[@class=\"events-viewer__button-wrapper\"]/a/span[text()='Learn more']"));
    logger.debug("Count of past events is " + buttonElements.size());

    Assert.assertEquals(2, buttonElements.size());
    driver.close();
  }

  @After
  public void afterTest() {
    driver = null;
  }

}
