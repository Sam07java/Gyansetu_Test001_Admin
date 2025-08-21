package page;

import factory.BaseClass;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SubjectPAge extends BasePage {

    private Logger logger = BaseClass.getLogger();
    private WebDriverWait wait;

    public SubjectPAge(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    @FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input css-h4os0j']")
    WebElement subjectNameTextFieldElement;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveButtonElement;

    @FindBy(id = "simple-tab-1")
    WebElement schoolbuttonElement;

    @FindBy(id = "mui-component-select-class_id")
    WebElement classdropdownelement;

    public void click_ADD_SUBJECT_button() {
        wait.until(ExpectedConditions.elementToBeClickable(aDDSubjectElement)).click();
        logger.info("Clicked on 'Add Subject' button");
    }

    public boolean verify_Subjectpage() {
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOf(titelElement)).isDisplayed();
        logger.info("Subject page title displayed: " + isDisplayed);
        return isDisplayed;
    }

    public void select_institute_FromDropDown(String inst) {
        wait.until(ExpectedConditions.elementToBeClickable(institutedropdownElement)).click();
        logger.info("Clicked on Institute dropdown");
        selectFromDropdown(dropDownElement, inst, "Institute");
    }

    public void select_Course_from_Dropdown(String cou) {
        wait.until(ExpectedConditions.elementToBeClickable(coursedropdownElement)).click();
        logger.info("Clicked on Course dropdown");
        selectFromDropdown(dropDownElement, cou, "Course");
    }

    public void select_Semester_from_dropdown(String semester) {
        wait.until(ExpectedConditions.elementToBeClickable(semesterDropdownElement)).click();
        logger.info("Clicked on Semester dropdown");
        selectFromDropdown(dropDownElement, semester, "Semester");
    }

    public void enter_Subject_Name(String subject) {
        wait.until(ExpectedConditions.visibilityOf(subjectNameTextFieldElement)).sendKeys(subject);
        logger.info("Entered Subject Name: " + subject);
        click_Save_Button();
    }

    public void click_Save_Button() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButtonElement)).click();
        logger.info("Clicked on Save button");
    }

    public void click_School_Button() {
        wait.until(ExpectedConditions.visibilityOf(schoolbuttonElement));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", schoolbuttonElement);
        logger.info("Clicked on School button using JavaScriptExecutor");
    }

    public void select_class_from_dropdown(String clas) {
        wait.until(ExpectedConditions.elementToBeClickable(classdropdownelement)).click();
        logger.info("Clicked on Class dropdown");
        selectFromDropdown(dropDownElement, clas, "Class");
    }

    public String alertMessage() {
        By toastLocator = By.xpath("//div[@class='Toastify__toast-body']//div[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
        String message = driver.findElement(toastLocator).getText();
        logger.info("Toast message captured: " + message);
        return message;
    }

    private void selectFromDropdown(List<WebElement> options, String value, String type) {
        for (WebElement option : options) {
            String text = option.getText();
            if (text.equalsIgnoreCase(value)) {
                wait.until(ExpectedConditions.elementToBeClickable(option)).click();
                logger.info("Selected " + type + ": " + value);
                return;
            }
        }
        logger.warn(type + " value not found in dropdown: " + value);
    }
}




//package page;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//import java.util.List;
//
//public class SubjectPAge extends BasePage{
//    public SubjectPAge(WebDriver driver) {
//        super(driver);
//    }
//
//    @FindBy(xpath = "//a[text()='Add Subject']")
//    WebElement aDDSubjectElement;
//
//    @FindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-h6 mb-3 css-1anx036']")
//    WebElement titelElement;
//
//    @FindBy(id = "mui-component-select-institution_id")
//    WebElement institutedropdownElement;
//
//    @FindBy(xpath = "//li[@role='option']")
//    List<WebElement> dropDownElement;
//
//    @FindBy(id = "mui-component-select-course_id")
//    WebElement coursedropdownElement;
//
//    @FindBy(id = "mui-component-select-semester_id")
//    WebElement semesterDropdownElement;
//
//    @FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq']")
//    WebElement subjectNameTextFieldElement;
//
//    @FindBy(xpath = "//button[text()='Save']")
//    WebElement saveButtonElement;
//
//    @FindBy(id = "simple-tab-1")
//    WebElement schoolbuttonElement;
//
//    @FindBy(id = "mui-component-select-class_id")
//    WebElement classdropdownelement;
//
//    public void click_ADD_SUBJECT_button(){
//        aDDSubjectElement.click();
//    }
//
//    public boolean verify_Subjectpage(){
//       return titelElement.isDisplayed();
//    }
//
//    public void select_institute_FromDropDown(String inst){
//        institutedropdownElement.click();
//        for(WebElement dropdown: dropDownElement) {
//            String institute= dropdown.getText();
//            if(institute.equalsIgnoreCase(inst)) {
//                dropdown.click();
//                break;
//            }
//        }
//    }
//
//    public void select_Course_from_Dropdown(String cou){
//        coursedropdownElement.click();
//        for(WebElement dropdown: dropDownElement) {
//            String institute= dropdown.getText();
//            if(institute.equalsIgnoreCase(cou)) {
//                dropdown.click();
//                break;
//            }
//        }
//    }
//
//    public void select_Semester_from_dropdown(String semester) {
//        semesterDropdownElement.click();
//        for(WebElement dropdown: dropDownElement) {
//            String institute= dropdown.getText();
//            if(institute.equalsIgnoreCase(semester)) {
//                dropdown.click();
//                break;
//            }
//        }
//    }
//
//    public void enter_Subject_Name(String subject)
//    {
//        subjectNameTextFieldElement.sendKeys(subject);
//        saveButtonElement.click();
//    }
//
//    public void click_Save_Button(){
//        saveButtonElement.click();
//    }
//
//    public void click_School_Button(){
//       // schoolbuttonElement.click();
//        JavascriptExecutor js=(JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click()",schoolbuttonElement);
//
//    }
//
//
//    public void select_class_from_dropdown(String clas){
//        classdropdownelement.click();
//        for(WebElement dropdown: dropDownElement) {
//            String cl= dropdown.getText();
//            if(cl.equalsIgnoreCase(clas)) {
//                dropdown.click();
//                break;
//            }
//        }
//
//    }
//
//
//    public String alertMessage()
//    {
//        return driver.findElement(By.xpath("//div[@class='Toastify__toast-body']//div[2]")).getText();
//    }
//
//}
