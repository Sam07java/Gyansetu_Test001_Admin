package hooks;

import factory.BaseClass;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;


public class Hooks {
    static WebDriver driver;
    static Properties p;
   public static SoftAssert softAssert;
    @Before
   // @BeforeAll
    public static void setup() throws IOException {

    driver= BaseClass.initlizeBrowser();
    BaseClass.getLogger().info("browser initialized");
      //  logger.info("browser initialized");
    p=BaseClass.getProperties();
    BaseClass.getLogger().info("get properties file from file directory");
   //     logger.info("get properties file from file directory");
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
    }

    @After
    public static void tearDown()
    {
      //  softAssert.assertAll();
    //driver.quit();
    }

//    @AfterStep
//    public void addScreenshot(Scenario scenario) {
//        if(scenario.isFailed()) {
//        TakesScreenshot ts= (TakesScreenshot) driver;
//            byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png",scenario.getName());
//        }
//    }
}
