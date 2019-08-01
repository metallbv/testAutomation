package homeWork2;

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

public class WorkWithLocators2 {

  final static Logger logger = Logger.getLogger(WorkWithLocators2.class);

  private WebDriver driver;
  private String wikiUrlEpam = "https://en.wikipedia.org/wiki/EPAM_Systems";

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Test
  public void testFindDates() {
    driver.get(wikiUrlEpam);

    List<WebElement> dateElements = driver.findElements(By.xpath("//table[@class=\"wikitable sortable jquery-tablesorter\"]/tbody/tr/td/span/a[text()='USA']"));
    logger.debug("count dates " + dateElements.size());

    Assert.assertTrue(true);
    driver.close();
  }

  @After
  public void afterTest() {
    driver = null;
  }

}
