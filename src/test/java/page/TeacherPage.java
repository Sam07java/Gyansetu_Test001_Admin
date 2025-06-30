package page;

import factory.BaseClass;
import io.cucumber.java.eo.Se;
import io.cucumber.java.nl.Stel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utility.DatePicker;

import java.util.Arrays;
import java.util.List;

public class TeacherPage extends BasePage{
    public TeacherPage(WebDriver driver) {
        super(driver);
    }

    DatePicker datePicker;

    @FindBy(xpath = "//a[text()='Add Teacher']")
    WebElement click_Add_Teacher_Button;

    @FindBy(xpath = "//input[@data-id='first-name']")
    WebElement first_Name_element;

    @FindBy(xpath ="//input[@data-id='last-name']")
    WebElement last_Name_element;

    @FindBy(xpath = "//div[@id='mui-component-select-gender']")
    WebElement gender_element;

   @FindBy(xpath = "//input[@data-id='email']")
   WebElement email_element;
    //input[@data-id='address']
   @FindBy(xpath ="//input[@data-id='phone']" )
   WebElement mobile_Number_element;

   @FindBy(id= "mui-component-select-qualification")
   WebElement qualification_element;

   @FindBy(xpath = "//input[@data-id='experience']")
   WebElement experince_element;

   @FindBy(id = "mui-component-select-entity_id")
   WebElement entity_element;

   @FindBy(id = "mui-component-select-university_id")
   WebElement university_element;

   @FindBy(id = "mui-component-select-institute_id")
   WebElement insitute_element;

   @FindBy(id = "mui-component-select-classes.0.class_id")
   WebElement classs_element;

   @FindBy(id = "mui-component-select-classes.0.subjects")
   WebElement subject_element;

   @FindBy(xpath = "//input[@data-id='address']")
   WebElement address_element;

   @FindBy(name = "rcrs-country")
   WebElement countryDropdown_element;

   @FindBy(name = "rcrs-region")
   WebElement stateDropDown_element;

   @FindBy(xpath = "//input[@data-id='city']")
   WebElement city_text_element;

   @FindBy(xpath = "//input[@data-id='district']")
   WebElement district_text_element;

   @FindBy(xpath = "//input[@data-id='pincode']")
   WebElement pincode_text_element;

   @FindBy(xpath = "//button[text()='Save']")
   WebElement saveButton_element;

   @FindBy(xpath = "//div[@class='Toastify__toast-body']//div[2]")
   WebElement alert_Message_element;

   @FindBy(id = "mui-component-select-courses.0.course_id")
   WebElement courseElement;

   @FindBy(id = "mui-component-select-courses.0.semester")
   WebElement semesterElement;


    public void click_on_Add_Teacher_Button(){
        click_Add_Teacher_Button.click();
    }
    public void enter_First_Name(String firstName){
        first_Name_element.sendKeys(firstName);
    }

    public void enter_Secound_Name(String secoundName){
        last_Name_element.sendKeys(secoundName);
    }

    public void select_gender(String gender) {
        BaseClass.getLogger().info("Clicking on gender dropdown element.");
        gender_element.click();

        BaseClass.getLogger().info("Fetching gender options from the dropdown.");
        List<WebElement> genderOptions = driver.findElements(By.xpath("//li[@role='option']"));
                //li[@class = 'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1vdyady']"));

        for (WebElement gen : genderOptions) {
            BaseClass.getLogger().info("Checking option: " + gen.getText());
            if (gen.getText().equalsIgnoreCase(gender)) {
                BaseClass.getLogger().info("Selecting gender: " + gender);
                gen.click();
                break;
            }
        }
    }

    public void enter_mobileNumber(String mobileNumber){
        mobile_Number_element.sendKeys(mobileNumber);
    }

    public void select_DOB(String date, String month, String year) {
        BaseClass.getLogger().info("Passing date values to the date picker - Date: " + date + ", Month: " + month + ", Year: " + year);
        datePicker=new DatePicker(BaseClass.getDriver());
        datePicker.datepickerGy(date, month, year);
    }

    public void enter_emailId(String email){
        email_element.sendKeys(email);
    }

    public void select_qualification(String qualification){
        qualification_element.click();
        List<WebElement> quli = driver.findElements(By.xpath("//li[@role='option']"));
        for(WebElement qlificat: quli){
            if(qlificat.getText().equalsIgnoreCase(qualification)){
                qlificat.click();
                break;
            }
        }
    }

    public void enter_experience(String exp){
        experince_element.sendKeys(exp);
    }

    public void select_entity(String entity){
        entity_element.click();
        List<WebElement> entit = driver.findElements(By.xpath("//li[@role='option']"));
        for(WebElement enty: entit){
            if(enty.getText().equalsIgnoreCase(entity)){
                enty.click();
                break;
            }
        }
    }

    public void select_University(String uni){
        university_element.click();
        List<WebElement> entit = driver.findElements(By.xpath("//li[@role='option']"));
        for(WebElement enty: entit){
            if(enty.getText().equalsIgnoreCase(uni)){
                enty.click();
                break;
            }
        }
    }

    public void select_school(String school){
        insitute_element.click();
        List<WebElement> schoolelement = driver.findElements(By.xpath("//li[@role='option']"));
        for(WebElement schoolsingleelement: schoolelement){
            if(schoolsingleelement.getText().equalsIgnoreCase(school)){
                schoolsingleelement.click();
                break;
            }
        }
    }

    public void select_class(String classes){
        classs_element.click();
        List<WebElement> classelement = driver.findElements(By.xpath("//li[@role='option']"));
        for(WebElement classsingleelement: classelement){
            if(classsingleelement.getText().equalsIgnoreCase(classes)){
                classsingleelement.click();
                break;
            }
        }
    }

    public void select_collegeName(String college){
        insitute_element.click();
        List<WebElement> classelement = driver.findElements(By.xpath("//li[@role='option']"));
        for(WebElement classsingleelement: classelement){
            if(classsingleelement.getText().equalsIgnoreCase(college)){
                classsingleelement.click();
                break;
            }
        }
    }

    public void selectCourse(String cou){
        courseElement.click();
        List<WebElement> classelement = driver.findElements(By.xpath("//li[@role='option']"));
        for(WebElement classsingleelement: classelement){
            if(classsingleelement.getText().equalsIgnoreCase(cou)){
                classsingleelement.click();
                break;
            }
        }
    }

    public void select_Semester(String sem){
        semesterElement.click();
        List<WebElement> classelement = driver.findElements(By.xpath("//li[@role='option']"));
        for(WebElement classsingleelement: classelement){
            if(classsingleelement.getText().equalsIgnoreCase(sem)){
                classsingleelement.click();
                break;
            }
        }
    }

    public void select_subject(String subjA, String subjB) {
        BaseClass.getLogger().info("Clicking on Subject dropdown");
        subject_element.click();
      //  driver.findElement(By.id("mui-component-select-courses.0.subjects")).click();
        BaseClass.getLogger().info("Subject dropdown clicked.");

        List<String> subjectsToSelect = Arrays.asList(subjA.trim(), subjB.trim());
        List<WebElement> subjectOptions = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

        for (String subject : subjectsToSelect) {
            boolean isFound = false;
            for (WebElement option : subjectOptions) {
                String value = option.getAttribute("data-value").trim();
                if (value.equalsIgnoreCase(subject)) {
                    WebElement checkbox = option.findElement(By.xpath(".//input[@type='checkbox']"));
                    if (!checkbox.isSelected()) {
                        option.click();
                        BaseClass.getLogger().info("Selected subject: " + subject);
                    } else {
                        BaseClass.getLogger().info("Subject already selected: " + subject);
                    }
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                BaseClass.getLogger().warn("Subject not found in dropdown: " + subject);
            }
        }
        WebElement ss = driver.findElement(By.xpath("//div[@class='MuiBackdrop-root MuiBackdrop-invisible MuiModal-backdrop css-esi9ax']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",ss);
    }



    public void select_subjectCollege(String subjA, String subjB) {
            driver.findElement(By.id("mui-component-select-courses.0.subjects")).click();
        BaseClass.getLogger().info("Subject dropdown clicked....");
        List<String> subjectsToSelect = Arrays.asList(subjA.trim(), subjB.trim());
        List<WebElement> subjectOptions = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

        for (String subject : subjectsToSelect) {
            boolean isFound = false;
            for (WebElement option : subjectOptions) {
                String value = option.getAttribute("data-value").trim();
                if (value.equalsIgnoreCase(subject)) {
                    WebElement checkbox = option.findElement(By.xpath(".//input[@type='checkbox']"));
                    if (!checkbox.isSelected()) {
                        option.click();
                        BaseClass.getLogger().info("Selected subject: " + subject);
                    } else {
                        BaseClass.getLogger().info("Subject already selected: " + subject);
                    }
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                BaseClass.getLogger().warn("Subject not found in dropdown: " + subject);
            }
        }
        WebElement ss = driver.findElement(By.xpath("//div[@class='MuiBackdrop-root MuiBackdrop-invisible MuiModal-backdrop css-esi9ax']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",ss);
    }

    public void enter_address(String address){
        address_element.sendKeys(address);
    }

    public void select_country(String country){
        Select select=new Select(countryDropdown_element);
        select.selectByVisibleText(country);
    }

    public void select_state(String state){
        Select select=new Select(stateDropDown_element);
        select.selectByVisibleText(state);
    }

    public void enter_city(String city){
        city_text_element.sendKeys(city);
    }

    public void enter_district(String dis){
        district_text_element.sendKeys(dis);
    }

    public void enter_pincode(String pincode){
        pincode_text_element.sendKeys(pincode);
    }

    public void click_Save_Button(){
        saveButton_element.click();
    }

    public WebElement alertMessage()
    {
      return alert_Message_element;
    }
}
