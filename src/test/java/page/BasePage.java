package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.WaitHelper;

public class BasePage {
   // protected Object waitHelper;
    WebDriver driver;
  //  WaitHelper waitHelper;
    BasePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
