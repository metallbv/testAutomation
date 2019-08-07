import consts.Constants;
import driver.DriverFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class BaseTest extends DriverFactory {

  private Logger logger = Logger.getLogger(BaseTest.class);
  private Test test;

  //@Parameterized.Parameters(name = ("browserName"))
  @Before
  public void beforeMethod() {
    initDriver(Constants.DriverConfigs.CHROME_NAME);
    /*logger = Logger.getLogger(method.getDeclaringClass());
    test = method.getAnnotation(Test.class);
    logger.info("");
    logger.info("");*/
  }

  @After
  public void afterMethod() {
    //this.method = method;
    //logger.info(String.format("Test '%s' completed", method.getName()));
    quitDriver();
  }
}
