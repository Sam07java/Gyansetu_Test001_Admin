package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddClassPage extends BasePage {
    public AddClassPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Add Class']")
    WebElement elementAddClass;

    @FindBy(id= "mui-component-select-class_name")
    WebElement classdropdownelemement;

    @FindBy(xpath = "//li[@role='option']")
    List<WebElement> classElement;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement save_button;

    public void click_addClass() {elementAddClass.click();}

    public void click_dropdown(){classdropdownelemement.click();}

    public void select_class_byInput(String ClasName){
        for(WebElement wb: classElement){
           String clasnamef= wb.getText();
            if(clasnamef.equalsIgnoreCase(ClasName)){
                wb.click();
                break;
            }
        }
    }

    public void clickonSave_Button(){save_button.click();}

    public WebElement alertMessage() {
        return driver.findElement(By.xpath("//div[@class='Toastify__toast-body']//div[2]"));
    }
}
