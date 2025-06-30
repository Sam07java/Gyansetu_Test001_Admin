package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InstitutePage extends BasePage{
    public InstitutePage(WebDriver driver) {
        super(driver);
    }

@FindBy(xpath = "//a[text()='Add Institute']")
    WebElement addinstituteButton;


@FindBy(id = "mui-component-select-entity_id")
    WebElement entityDroDownElement;

@FindBy(className = "top-header")
    WebElement heading;

@FindBy(xpath = "//li[text()='school']")
    WebElement schoolElementfromEntityDropDown;

@FindBy(xpath = "//li[text()='college']")
    WebElement collageElementfromEntituDropDown;

@FindBy(id = "mui-component-select-university_id")
    WebElement universityDropDownElement;
@FindBy(xpath = "//li[@role='option']")
    List<WebElement> university;

@FindBy(name = "rcrs-country")
    WebElement countryDropDownElement;

@FindBy(name= "rcrs-region")
    WebElement stateDropDownElement;

//@FindBy(xpath = "div[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq']")
//    List<WebElement> textFields;

@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input institute-name css-1x5jdmq']")
    WebElement instituteNameTextFieldElement;

@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input address css-1x5jdmq']")
    WebElement addressTextFieldElement;

@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input email css-1x5jdmq']")
    WebElement emailTextFieldElement;

@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input mobile css-1x5jdmq']")
    WebElement mobileNumberTextFieldElement;

@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input city css-1x5jdmq']")
    WebElement cityTextFieldElement;

@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input district css-1x5jdmq']")
    WebElement districtTextFieldElement;

@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input pincode css-1x5jdmq']")
    WebElement pincodeTextFieldElement;

@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input website css-1x5jdmq']")
    WebElement websiteTextFieldlElement;

@FindBy(xpath = "//button[@class='btn btn-primary mainbutton mt-4']")
    WebElement saveButtonElement;


//public void enterTextFields(List<String> inputValues){
//    for (int i = 0; i < textFields.size(); i++) {
//        textFields.get(i).clear();  // Clear any existing text
//        textFields.get(i).sendKeys(inputValues.get(i));  // Enter new text
//    }
//}

    public void click_Add_Institute() {
        addinstituteButton.click();
    }

    public boolean institutePageDisaplyes(){
         return heading.isDisplayed();
    }

    public void click_entityDropDown() {
        entityDroDownElement.click();
    }

    public void click_SchoolElementfromEntityDropDown() {
        schoolElementfromEntityDropDown.click();
    }

    public void click_CollageElement_fromEntityDropDown() {
        collageElementfromEntituDropDown.click();
    }

    public void selectUniversityFromDropDown(String univer){
        universityDropDownElement.click();
        for(WebElement universityEle:university) {
           String universityText= universityEle.getText();
           if(universityText.equalsIgnoreCase(univer)){
               universityEle.click();
               break;
           }
        }
    }

    public void selectCountryfromDropDown(String cou)
    {
        Select select=new Select(countryDropDownElement);
        select.selectByValue(cou);
    }

    public void selectStatefromDropDown(String state)
    {
        Select select=new Select(stateDropDownElement);
        select.selectByValue(state);
    }

    public void enter_InstituteNameTextField(String institute){
        instituteNameTextFieldElement.sendKeys(institute);
    }

    public void enter_addressTextField(String addres)
    {
        addressTextFieldElement.sendKeys(addres);
    }

    public void enter_Email(String email){
        emailTextFieldElement.sendKeys(email);
    }

    public void enter_mobile_number(String no){
        mobileNumberTextFieldElement.sendKeys(no);
    }

    public void enter_cityName(String city) {
        cityTextFieldElement.sendKeys(city);
    }

    public void enter_districtName(String dist){
        districtTextFieldElement.sendKeys(dist);
    }

    public void enter_pincodeNumber(String pincode){
        pincodeTextFieldElement.sendKeys(pincode);
    }

    public void enter_website(String web){
        websiteTextFieldlElement.sendKeys(web);
    }

    public void click_saveButton()
    {
        saveButtonElement.click();
    }

    public void enter_schoolName(String schoolName){
        WebElement schoolfieldelement=driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input institute-name css-1x5jdmq']"));
        schoolfieldelement.sendKeys(schoolName);
    }

    public WebElement alertMessage() {
       return driver.findElement(By.xpath("//div[@class='Toastify__toast-body']//div[2]"));
    }

    public void textfieldValidation(){
       List<WebElement> textfieldAlertMessage=driver.findElements(By.xpath("//form//div//div//div//p"));
       for (WebElement alertMessage: textfieldAlertMessage) {
          String alert= alertMessage.getText();
           System.out.println(alert);
       }
    }
}
