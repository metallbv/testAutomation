import consts.Constants;
import driver.DriverFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runners.Parameterized;

import java.lang.reflect.Method;

public abstract class BaseTest extends DriverFactory {

  private Logger logger = Logger.getLogger(BaseTest.class);
  private Test test;
  private Method method;

  //@Parameterized.Parameters(name = ("browserName"))
  @Before
  public void beforeMethod() {
    initDriver(Constants.BusinessConfigs.BASE_URL);
    logger = Logger.getLogger(method.getDeclaringClass());
    test = method.getAnnotation(Test.class);
    logger.info("");
    logger.info("");
  }

  @After
  public void afterMethod(final Method method) {
    this.method = method;
    logger.info(String.format("Test '%s' completed", method.getName()));
    quitDriver();
  }
}
