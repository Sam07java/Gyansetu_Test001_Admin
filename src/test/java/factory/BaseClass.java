package factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

   public static WebDriver driver;
   public static Properties p;
    public static Logger logger;

    public static WebDriver initlizeBrowser() throws IOException {
        p= getProperties();
        String browser= p.getProperty("browser");

        ChromeOptions options = new ChromeOptions();
        // Ignore SSL certificate errors
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");

        switch (browser.toLowerCase()) {
            case "chrome": driver=new ChromeDriver(options); break;
            case "edge": driver=new EdgeDriver(); break;
            case "firefox": driver=new FirefoxDriver(); break;
            default: System.out.println("No matching browser"); break;
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return driver;
    }

    public static Properties getProperties() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        FileReader file=new FileReader(path);
        //"C:\\Users\\WIIS\\IdeaProjects\\Gyansetu_Admin_TestCases\\src\\test\\resources\\config.properties");
      // FileReader file=new FileReader( System.getProperty("user.dir")+"Gyansetu_Admin_TestCases\\src\\test\\resources\\config.properties");
        p=new Properties();
        p.load(file);
        return p;
    }

    public static Logger getLogger() {
        logger= LogManager.getLogger();
        return logger;
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
