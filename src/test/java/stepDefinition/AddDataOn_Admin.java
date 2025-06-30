package stepDefinition;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.bson.BsonArray;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import page.*;
import page.InstitutePage;
import java.io.IOException;
import java.util.Arrays;
import io.cucumber.datatable.DataTable;
import utility.ExelUtility;
import utility.Screenshot;

import java.util.List;

import java.util.Properties;

import static hooks.Hooks.softAssert;

public class AddDataOn_Admin {
   public HomePage homePage;
   public LoginPage loginPage;
   public Properties properties;
   public AdminDashBoard adminDashBoard;
   public UniversityPage universityPage;
   public InstitutePage institutePage;
   public CoursePage coursePage;
   public SubjectPAge subjectPAge;
   public LanguagePage languagePage;
   public HobbyPage hobbyPage;
   public ExelUtility exelUtility;
        WebDriver driver;
    //Adding Univercity
    @Given("Login to the Admin Panel.")
    public void login_to_the_admin_panel() throws IOException {
        BaseClass.getLogger().info("Click on HomePage Sign-In button");
        homePage = new HomePage(BaseClass.getDriver());
        homePage.click_SignInWithEmailorPhoneButton();

        properties = BaseClass.getProperties();
        loginPage = new LoginPage(BaseClass.getDriver());

        BaseClass.getLogger().info("Entering login credentials from properties file");
        loginPage.setEmailorPhoneTextField(properties.getProperty("email"));
        loginPage.setPasswordTextField(properties.getProperty("password"));

//        BaseClass.getLogger().info("Selecting Admin option from dropdown");
//        loginPage.setClickDropDown();
//        loginPage.setClickAdminOpton();

        BaseClass.getLogger().info("Clicking on Sign-In button");
        loginPage.setClickSignInButton();

        // Post-login verification
//        AdminDashBoard adminDashBoard = new AdminDashBoard(BaseClass.getDriver());
//        boolean isDisplayed = adminDashBoard.getDashboardHeading().isDisplayed();
//        Assert.assertTrue(isDisplayed, "Admin dashboard is not displayed");
//        BaseClass.getLogger().info("Login successful and Admin dashboard is visible");
    }


    @When("Validate DashBoard is displayed Successfully.")
    public void valdate_dash_board_is_dispalyed_successfull() throws IOException, InterruptedException {
        BaseClass.getLogger().info("Initializing Admin Dashboard page");
        adminDashBoard=new AdminDashBoard(BaseClass.getDriver());
    }

    @When("Click on Master Management in sidebar.")
    public void click_on_master_managment_in_sidebar() throws InterruptedException {
        Thread.sleep(2000);
        BaseClass.getLogger().info("Clicking on Master Management in sidebar");
        adminDashBoard.click_masterManagment();
    }

    @When("Click on Institution in sidebar.")
    public void click_on_insitution_in_sidebar() {
        adminDashBoard.click_institutionButton();
        BaseClass.getLogger().info("Clicked on institution Management button");
    }

    @When("Click on University in sidebar for add University data.")
    public void click_on_university_in_sidebar_for_add_university_data() {
        adminDashBoard.click_UniversityButton();
        BaseClass.getLogger().info("Click on university button");
    }

    @When("Check whether list of University Page is displayed or not.")
    public void check_whether_list_of_university_page_is_displayed_or_not() {
        universityPage=new UniversityPage(BaseClass.getDriver());
    }

    @When("Click on add University Button.")
    public void click_on_add_university_button() {
        universityPage.click_addUniversity();
        BaseClass.getLogger().info("clicked on Add University button");
    }

    @When("Enter the University Name {string} on the text field.")
    public void enter_the_university_name_on_the_text_field(String string) {
        universityPage.setAdduniversityTextField(string);
    }

    @When("Click on Save button.")
    public void click_on_save_button() throws InterruptedException {
        universityPage.click_saveButton();
        BaseClass.getLogger().info("clicked on Save button");

    }

    @And("Enter the University Name on text field and Click Save Button.")
    public void enterTheUniversityNameOnTextFieldAndClickSaveButton(DataTable dataTable) throws InterruptedException {
        List<String > values=dataTable.asList();
        for (String value:values){
            Thread.sleep(500);
            universityPage.setAdduniversityTextField(value);
            universityPage.click_saveButton();
        }
    }


    @When("Verify the toaster message with added successfully or not")
    public void Verify_the_toaster_message_with_added_successfully_or_not() throws InterruptedException {
        Thread.sleep(1000);
        String alert=universityPage.alertMessage();
        System.out.println("!st "+alert);
        softAssert=new SoftAssert();
        if (alert.equalsIgnoreCase("University added successfully")) {
                System.out.println("If codition= "+alert);
                softAssert.assertTrue(true);
            } else {
                System.out.println("else condition= "+alert);
                softAssert.fail(alert);
            }

//        try {
//            if (alert.equalsIgnoreCase("University added successfully")) {
//                System.out.println("If codition= "+alert);
//                Assert.assertTrue(true);
//            } else {
//                System.out.println("else condition= "+alert);
//                Assert.fail(alert);
//            }
//        } catch (AssertionError error){
//            System.out.println("Assertion Handling= "+alert);
//        }
    }


    //Adding Institution
    @When("Click on Institute in sidebar for add institute data.")
    public void click_on_institute_in_sidebar_for_add_institute_data() {
        BaseClass.getLogger().info("Click on Institute in sidebar for add institute data.");
        adminDashBoard.click_instituteElement();

    }

    @When("Check whether list of Institute Page is displayed or not.")
    public void check_whether_list_of_institute_page_is_displayed_or_not() {
        institutePage=new InstitutePage(BaseClass.getDriver());
    }

    @When("Click on ADD INSTITUTE Button.")
    public void click_on_add_institute_button() throws InterruptedException {
        Thread.sleep(1000);
        BaseClass.getLogger().info("Click on ADD INSTITUTE Button.");
        institutePage.click_Add_Institute();
    }

    @When("Check add institute page is displayed or not.")
    public void check_add_institute_page_is_displayed_or_not() {
        BaseClass.getLogger().info("Check add institute page is displayed or not");
        Assert.assertTrue(institutePage.institutePageDisaplyes());

    }

    @When("Select Entity from dropdown.")
    public void select_entity_from_dropdown() {
        BaseClass.getLogger().info("Select Entity from dropdown");
        institutePage.click_entityDropDown();
        institutePage.click_CollageElement_fromEntityDropDown();
    }

    @When("Select Entity from dropdown for School.")
    public void Select_Entity_from_dropdown_for_School(){
        BaseClass.getLogger().info("Select Entity from dropdown for School.");
        institutePage.click_entityDropDown();
        institutePage.click_SchoolElementfromEntityDropDown();
    }

    @When("Select University from dropdown {string}.")
    public void select_university_from_dropdown(String string) {
        BaseClass.getLogger().info("Select University from dropdown"+ string);
       institutePage.selectUniversityFromDropDown(string);
    }

    @When("Select Country from dropdown {string}.")
    public void select_country_from_dropdown(String string) {
        BaseClass.getLogger().info("Select Country from dropdown"+ string);
        institutePage.selectCountryfromDropDown(string);
    }

    @When("Select State from dropdown {string}.")
    public void select_state_from_dropdown(String string) {
        BaseClass.getLogger().info("Select State from dropdown: " + string);
        institutePage.selectStatefromDropDown(string);
    }

    //List<String> inputValues = Arrays.asList("John", "Doe", "john@example.com", "1234567890", "New York", "USA", "12345", "Software Engineer");
    @When("Enter name on Institute text field {string}.")
    public void enter_name_on_institute_text_field(String insti) {
      //  List<String> inputValues = Arrays.asList("John", "Doe", "john@example.com", "1234567890", "New York", "USA", "12345", "Software Engineer");
       // institutePage.enterTextinField(inputValues);
        BaseClass.getLogger().info("Enter name on Institute text field"+ insti);
        institutePage.enter_InstituteNameTextField(insti);
    }

    @When("Enter the address on text field {string}.")
    public void enter_the_address_on_text_field(String string) {
        BaseClass.getLogger().info("Enter the address on text field"+ string);
       institutePage.enter_addressTextField(string);
    }

    @When("Enter the Email id on text field {string}.")
    public void enter_the_email_id_on_text_field(String string) {
        BaseClass.getLogger().info("Enter the Email id on text field"+string);
        institutePage.enter_Email(string);
    }

    @When("Enter the mobile number on text field {string}.")
    public void enter_the_mobile_number_on_text_field(String string) {
        BaseClass.getLogger().info("Enter the mobile number on text field"+ string);
        institutePage.enter_mobile_number(string);
    }

    @When("Enter the City Name on the text field {string}.")
    public void enter_the_city_name_on_the_text_field(String string) {
        BaseClass.getLogger().info("Enter the City Name on the text field"+string);
        institutePage.enter_cityName(string);
    }

    @When("Enter the District Name on the text field {string}.")
    public void enter_the_district_name_on_the_text_field(String string) {
        BaseClass.getLogger().info("Enter the District Name on the text field"+string);
        institutePage.enter_districtName(string);
    }

    @When("Enter the Pincode Number on the text field {string}.")
    public void enter_the_pincode_number_on_the_text_field(String string) {
        BaseClass.getLogger().info("Enter the Pincode Number on the text field"+ string);
        institutePage.enter_pincodeNumber(string);
    }

    @When("Enter the Website on the text field {string}.")
    public void enter_the_website_on_the_text_field(String string) {
        BaseClass.getLogger().info("Enter the Website on the text field"+ string);
        institutePage.enter_website(string);
    }

    @When("Click on Save button institution.")
    public void click_on_Save_button() {
        BaseClass.getLogger().info("Click on Save button institution.");
        institutePage.click_saveButton();
    }

    @Then("Verify the toaster message is displayed or not.")
    public void verify_the_toaster_message_is_displayed_or_not() throws InterruptedException {
        BaseClass.getLogger().info("Verifying if toaster message is displayed or not.");
      //  Thread.sleep(1000);
        WebElement alert = institutePage.alertMessage();
        try {
            if (alert.isDisplayed()) {
                BaseClass.getLogger().info("Alert is displayed with text: " + alert.getText());
                if (alert.getText().equalsIgnoreCase("Institute saved successfully")) {
                    System.out.println(alert.getText());
                    Assert.assertTrue(true);
                }
                else {
                    BaseClass.getLogger().info("Toaster message: "+alert.getText());
                    Assert.fail(alert.getText());
                }
            } else {
                BaseClass.getLogger().info("Alert not displayed, validating textfields.");
                Screenshot.captureScreenshot(BaseClass.getDriver(), "instituteAddError");
                institutePage.textfieldValidation();
            }
        } catch (AssertionError assertionError){
            BaseClass.getLogger().error("Assertion failed: " + assertionError.getMessage());
           Screenshot.captureScreenshot((BaseClass.getDriver()), "Assertion error on institute add");
            adminDashBoard.logOut();
            Assert.fail();
        } catch (NoSuchElementException e){
            BaseClass.getLogger().error("Element not found: " + e.getMessage());
          //  BaseClass.captureScreenshot("instituteADD_failure");
            adminDashBoard.logOut();
            Assert.fail();
        }
    }

    @And("Click on Course button in sidebar.")
    public void clickOnCourseButtonInSidebar() {
        BaseClass.getLogger().info("Click on course in sidebar");
        adminDashBoard.click_CourseButton();
    }

    @And("Verify the Course page list is displayed.")
    public void verifyTheCoursePageListIsDisplayed() {
        coursePage=new CoursePage(BaseClass.getDriver());

    }

    @And("Click on ADD COURSE button")
    public void clickOnADDCOURSEButton() throws InterruptedException {
        Thread.sleep(2000);
        BaseClass.getLogger().info("Click on ADD COURSE button");
        coursePage.click_ADD_COURSE_button();
    }

    @And("Verify the Add Course page is displayed.")
    public void verifyTheAddCoursePageIsDisplayed() {
        BaseClass.getLogger().info("Verifying the Add Course page is displayed.");
        Assert.assertTrue(coursePage.verifyPageisDisplayed());
    }

    @And("Click on the Institute DropDown and Select one of them by {string}")
    public void clickOnTheInstituteDropDownAndSelectOneOfThemBy(String string) {
        BaseClass.getLogger().info("Click on the Institute DropDown and Select one of them by "+string);
        coursePage.click_Add_Course_DropDown(string);
    }


    @And("Enter Course Name on the text field {string}.")
    public void enterCourseNameOnTheTextField(String string) {
        BaseClass.getLogger().info("Enter Course Name on the text field "+string);
        coursePage.enter_CourseName_OnTextField(string);
    }


    @And("Select Duration from DropDown {string}.")
    public void selectDurationFromDropDown(String string) {
        BaseClass.getLogger().info("Select Duration from DropDown "+string);
        coursePage.select_DurationFrom_DropDown(string);
    }


    @And("Click on Save Button in Add Course page.")
    public void clickOnSaveButtonInAddCoursePage() {
        BaseClass.getLogger().info("Click on Save Button in Add Course page.");
        coursePage.click_Save_Button();
    }


    @Then("Validate the Course added successfully by toaster message.")
    public void validateTheCourseAddedSuccessfullyByToasterMessage() throws InterruptedException {
        Thread.sleep(1000);
        String alert = coursePage.alertMessage();
        BaseClass.getLogger().info("Toaster message received: " + alert);

        if(alert.equalsIgnoreCase("Course created successfully")) {
            System.out.println(alert);
            Assert.assertTrue(true);
        } else {
            System.out.println(alert);
            Assert.fail(alert);
        }
    }


    @And("Click on Subject Button in sidebar.")
    public void clickOnSubjectButtonInSidebar() {
        BaseClass.getLogger().info("Click on Subject Button in sidebar");
        adminDashBoard.click_SubjectButton();
    }

    @And("Verify list of Subject page is shown.")
    public void verifyListOfSubjectPageIsShown() {
        subjectPAge=new SubjectPAge(BaseClass.getDriver());
    }

    @And("Click on School Button for add subject.")
    public void clickOnSchoolButtonForAddSubject() {
        BaseClass.getLogger().info("Click on School Button for add subject.");
        subjectPAge.click_School_Button();
    }

    @And("Click on ADD SUBJECT button")
    public void clickOnADDSUBJECTButton() {
        BaseClass.getLogger().info("Click on ADD SUBJECT button");
        subjectPAge.click_ADD_SUBJECT_button();
    }

    @And("Verify the add subject page is displayed.")
    public void verifyTheAddSubjectPageIsDisplayed() {
        BaseClass.getLogger().info("Verifying the add subject page is displayed");
        Assert.assertTrue(subjectPAge.verify_Subjectpage());
    }

    @And("Click on institute dropdown and select one of them by {string}.")
    public void clickOnInstituteDropdownAndSelectOneOfThemBy(String arg0) {
    BaseClass.getLogger().info("Selecting institute from dropdow");
    subjectPAge.select_institute_FromDropDown(arg0);
    }

    @And("Click on course dropdown and select one of them by {string}.")
    public void clickOnCourseDropdownAndSelectOneOfThemBy(String string) {
        BaseClass.getLogger().info("Click on course dropdown and select one of them by "+string);
        subjectPAge.select_Course_from_Dropdown(string);
    }

    @And("Select the Semester from dropdown {string}.")
    public void selectTheSemesterFromDropdown(String arg0) {
        BaseClass.getLogger().info("Select the Semester from dropdown"+arg0);
        subjectPAge.select_Semester_from_dropdown(arg0);
    }

    @And("Enter the Subject Name {string}.")
    public void enterTheSubjectName(String arg0) {
        BaseClass.getLogger().info("Enter the Subject Name "+arg0);
        subjectPAge.enter_Subject_Name(arg0);
    }


    @And("Click on Save Button in Subject Page.")
    public void clickOnSaveButtonInSubjectPage() {
        BaseClass.getLogger().info("Click on Save Button in Subject Page.");
        subjectPAge.click_Save_Button();
    }

    @And("Validate the Subject added successfully by toaster message.")
    public void validateTheSubjectAddedSuccessfullyByToasterMessage() throws InterruptedException {
        Thread.sleep(1000);
        String alert = subjectPAge.alertMessage();
        BaseClass.getLogger().info("Toaster message received: " + alert);

        if(alert.equalsIgnoreCase("College subject created successfully")) {
            System.out.println(alert);
            Assert.assertTrue(true);
        }
        else if(alert.equalsIgnoreCase("School subject created successfully")) {
            System.out.println(alert);
            Assert.assertTrue(true);
        }
        else{
            System.out.println(alert);
            Assert.fail(alert);
        }
    }

    @And("Click on Class Dropdown select one of them by {string}")
    public void clickOnClassDropdownSelectOneOfThemBy(String arg0) {
        BaseClass.getLogger().info("Click on Class Dropdown select one of them by "+arg0);
        subjectPAge.select_class_from_dropdown(arg0);
    }

    @And("Click on Language Button.")
    public void clickOnLanguageButton() {
        BaseClass.getLogger().info("Clicking on Language Button in Admin Dashboard");
        adminDashBoard.click_languageButton();
        languagePage = new LanguagePage(BaseClass.getDriver());
        BaseClass.getLogger().info("Clicking on ADD Language Button");
        languagePage.click_on_ADD_Language_Button();
    }


    @And("Enter Language on textfield {string}.")
    public void enterLanguageOnTextfield(String arg0) {
        BaseClass.getLogger().info("Enter Language on textfield "+arg0);
        languagePage.enter_Language_on_textField(arg0);
    }

    @Then("click on Save Button.")
    public void clickOnSaveButton() {
        BaseClass.getLogger().info("click on Save Button.");
        languagePage.click_on_Save_Button();
    }

    @When("Enter language on textfield.")
    public void enterLanguageOnTextfield(DataTable dataTable) throws InterruptedException {
        List<String> values = dataTable.asList();
        for (String value : values) {
            BaseClass.getLogger().info("Entering language: " + value);
            languagePage.enter_Language_on_textField(value);
            languagePage.click_on_Save_Button();
            Thread.sleep(1000);
            String alert = languagePage.alertMessage();
            BaseClass.getLogger().info("Alert message received: " + alert);
            System.out.println("1st alert" + alert);
            //                if(alert.equalsIgnoreCase("Language created successfully")){
            //                    System.out.println("if condition"+alert);
            //                    Assert.assertTrue(true);
            //                } else {
            //                    System.out.println("Failed alert"+alert);
            //                    Assert.fail(alert);
            //                }
        }
    }


    @Then("Verify the toaster message is displayed.")
    public void verifyTheToasterMessageIsDisplayed() {
       String alert= languagePage.alertMessage();
        BaseClass.getLogger().info("Toaster message displayed: " + alert);
        System.out.println(alert);
    }

    @Given("Click on Hobby Button.")
    public void clickOnHobbyButton() {
        BaseClass.getLogger().info("Click on Hobby Button.");
        adminDashBoard.click_hobbyButton();
    }

    @And("Click on ADD HOBBIES Button.")
    public void clickOnADDHOBBIESButton() {
        hobbyPage=new HobbyPage(BaseClass.getDriver());
        BaseClass.getLogger().info("Click on ADD HOBBIES Button.");
        hobbyPage.click_ADD_HOBBIES();
    }

    @When("Enter hobbys on text field.")
    public void enterHobbysOnTextField(DataTable table) throws InterruptedException {
        List<String> values = table.asList();
        for (String value : values) {
            BaseClass.getLogger().info("Entering hobby: " + value);
            hobbyPage.enter_Hobbies_OnTextField(value);
            Thread.sleep(300);
            hobbyPage.click_Save_Button();
            BaseClass.getLogger().info("Clicked Save button for hobby: " + value);
        }
    }


    @And("Click on Save button on Hobbies.")
    public void clickOnSaveButtonOnHobbies() {

    }



//    @And("I enter institute details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
//    public void iEnterInstituteDetails(String institute, String address, String email, String mobile, String city, String district, String pincode, String website) {
//        List<String> inputValues = Arrays.asList(institute, address, email, mobile, city, district, pincode, website);
//        institutePage.enterTextFields(inputValues);
//    }
    
    
    
}
