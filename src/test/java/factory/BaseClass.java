package factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

public class BaseClass {

   public static WebDriver driver;
   public static Properties p;
    public static Logger logger;

    public static WebDriver initlizeBrowser() throws IOException {
        p= getProperties();
        String browser= p.getProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome": driver=new ChromeDriver(); break;
            case "edge": driver=new EdgeDriver(); break;
            case "firefox": driver=new FirefoxDriver(); break;
            default: System.out.println("No matching browse"); break;
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        return driver;
    }

    public static Properties getProperties() throws IOException {
        FileReader file=new FileReader("C:\\Users\\WIIS\\IdeaProjects\\Gyansetu_Admin_TestCases\\src\\test\\resources\\config.properties");
      //System.getProperty("user.dir")+
        p=new Properties();
        p.load(file);
        return p;
    }

    public static Logger getLogger() {
        logger= LogManager.getLogger();
        return logger;
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

}
