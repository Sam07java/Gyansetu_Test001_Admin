package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CoursePage extends BasePage {
    public CoursePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-h6 mb-3 css-1anx036']")
    WebElement pageHeading;

   @FindBy(xpath = "//a[text()='Add Course']")
    WebElement aDDCOURSEbuttonElement;

    @FindBy(id = "mui-component-select-institute")
   // mui-component-select-institute
    //label[text()='Institute *']
    WebElement courseDropDownElement;

    @FindBy(xpath = "//li[@role='option']")
    List<WebElement> dropDownElement;

    @FindBy(name = "course_name")
    WebElement courseNameElement;

    @FindBy(id = "mui-component-select-duration")
    WebElement durationElement;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveBottunElement;


   public boolean verifyPageisDisplayed()
   {
      return pageHeading.isDisplayed();
   }

    public void click_ADD_COURSE_button() {
        aDDCOURSEbuttonElement.click();
    }

    public void click_Add_Course_DropDown(String inst) {
        courseDropDownElement.click();
        for(WebElement dropdown: dropDownElement) {
           String institute= dropdown.getText();
           if(institute.equalsIgnoreCase(inst)) {
               dropdown.click();
               break;
           }
        }
    }

    public void enter_CourseName_OnTextField(String course) {
       courseNameElement.sendKeys(course);
    }

    public void select_DurationFrom_DropDown(String duration){
       durationElement.click();
        for(WebElement dropdown: dropDownElement) {
            String institute= dropdown.getText();
            if(institute.equalsIgnoreCase(duration)) {
                dropdown.click();
                break;
            }
        }
    }

    public void click_Save_Button(){
       saveBottunElement.click();
    }

    public String alertMessage()
    {
        return driver.findElement(By.xpath("//div[@class='Toastify__toast-body']//div[2]")).getText();
    }
}
