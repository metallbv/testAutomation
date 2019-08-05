package driver;

import consts.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

  private static WebDriver webDriver;

  protected void initDriver(final String browserName) {
    if (Constants.DriverConfigs.CHROME_NAME.equalsIgnoreCase(browserName)) {
      System.setProperty(Constants.DriverConfigs.CHROME_NAME, Constants.DriverConfigs.CHROME_DRIVER_LOCATION);
      webDriver = new ChromeDriver();
    }
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(Constants.DriverConfigs.IMPLICITY_WAIT_VALUE, TimeUnit.SECONDS);
  }

  public static WebDriver getDriver() {
    return webDriver;
  }

  protected void quitDriver() {
    if (webDriver != null) {
      webDriver.quit();
      webDriver = null;
    }
  }

}
