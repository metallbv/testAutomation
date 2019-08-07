package consts;

public interface Constants {

  interface DriverConfigs {
    String CHROME_NAME = "webdriver.chrome.driver";

    String CHROME_DRIVER_LOCATION = "D:\\Drivers\\chromedriver.exe";

    int IMPLICITY_WAIT_VALUE = 20;
  }

  interface BusinessConfigs {
    String BASE_URL = "https://www.training.by/";
    String HOME_PAGE_URL = BASE_URL + "/#/Home";
  }
}
