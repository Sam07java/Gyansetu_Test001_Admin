package hooks;

import factory.BaseClass;
import io.cucumber.java.*;
import org.openqa.selenium.*;
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
    public static void setup() throws IOException, InterruptedException {
        driver= BaseClass.initlizeBrowser();
        BaseClass.getLogger().info("browser initialized");

        p=BaseClass.getProperties();
        BaseClass.getLogger().info("get properties file from file directory");
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
//        driver.findElement(By.xpath("//button[text()='Visit Site']")).click();
        Thread.sleep(3000);
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
