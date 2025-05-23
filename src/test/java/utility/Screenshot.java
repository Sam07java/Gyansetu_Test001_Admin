package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Screenshot {

        public static void captureScreenshot(WebDriver driver, String screenshotName) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);

                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = screenshotName + "_" + timestamp + ".png";
                File destination = new File("./screenshots/" + fileName);

                Files.createDirectories(destination.getParentFile().toPath());
                Files.copy(source.toPath(), destination.toPath());

                System.out.println("Screenshot saved to: " + destination.getAbsolutePath());

            } catch (IOException e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
        }

}
