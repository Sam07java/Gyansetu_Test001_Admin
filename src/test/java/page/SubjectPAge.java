package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SubjectPAge extends BasePage{
    public SubjectPAge(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Add Subject']")
    WebElement aDDSubjectElement;

    @FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-h6 mb-3 css-1anx036']")
    WebElement titelElement;

    @FindBy(id = "mui-component-select-institution_id")
    WebElement institutedropdownElement;

    @FindBy(xpath = "//li[@role='option']")
    List<WebElement> dropDownElement;

    @FindBy(id = "mui-component-select-course_id")
    WebElement coursedropdownElement;

    @FindBy(id = "mui-component-select-semester_id")
    WebElement semesterDropdownElement;

    @FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq']")
    WebElement subjectNameTextFieldElement;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveButtonElement;

    @FindBy(id = "simple-tab-1")
    WebElement schoolbuttonElement;

    @FindBy(id = "mui-component-select-class_id")
    WebElement classdropdownelement;

    public void click_ADD_SUBJECT_button(){
        aDDSubjectElement.click();
    }

    public boolean verify_Subjectpage(){
       return titelElement.isDisplayed();
    }

    public void select_institute_FromDropDown(String inst){
        institutedropdownElement.click();
        for(WebElement dropdown: dropDownElement) {
            String institute= dropdown.getText();
            if(institute.equalsIgnoreCase(inst)) {
                dropdown.click();
                break;
            }
        }
    }

    public void select_Course_from_Dropdown(String cou){
        coursedropdownElement.click();
        for(WebElement dropdown: dropDownElement) {
            String institute= dropdown.getText();
            if(institute.equalsIgnoreCase(cou)) {
                dropdown.click();
                break;
            }
        }
    }

    public void select_Semester_from_dropdown(String semester) {
        semesterDropdownElement.click();
        for(WebElement dropdown: dropDownElement) {
            String institute= dropdown.getText();
            if(institute.equalsIgnoreCase(semester)) {
                dropdown.click();
                break;
            }
        }
    }

    public void enter_Subject_Name(String subject)
    {
        subjectNameTextFieldElement.sendKeys(subject);
        saveButtonElement.click();
    }

    public void click_Save_Button(){
        saveButtonElement.click();
    }

    public void click_School_Button(){
       // schoolbuttonElement.click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",schoolbuttonElement);

    }


    public void select_class_from_dropdown(String clas){
        classdropdownelement.click();
        for(WebElement dropdown: dropDownElement) {
            String cl= dropdown.getText();
            if(cl.equalsIgnoreCase(clas)) {
                dropdown.click();
                break;
            }
        }

    }


    public String alertMessage()
    {
        return driver.findElement(By.xpath("//div[@class='Toastify__toast-body']//div[2]")).getText();
    }

}
