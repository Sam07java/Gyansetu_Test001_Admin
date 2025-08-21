package stepDefinition;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.*;
import utility.ExelUtility;
import utility.Screenshot;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class addData_Excel_School {
     //   public String path= "src\\test\\test-Data\\Data for Users.xlsx";
    //    public String path = System.getProperty("user.dir") + "/src/test-data/Data for Users.xlsx";
     String path= System.getProperty("user.dir") + "\\src\\test\\test-Data\\Data for Users.xlsx";
        public UniversityPage universityPage;
        public ExelUtility exelUtility;
        public InstitutePage institutePage;
        public AdminDashBoard adminDashBoard;
        public AddClassPage addClassPage;
        public SubjectPAge subjectPAgee;

    @When("Fetch data from excel sheet, Enter the university Name on the text field {string} and {int}")
    public void fetch_data_from_excel_sheet_enter_the_university_name_on_the_text_field_and(String string, Integer int1) throws IOException {
        exelUtility=new ExelUtility(path);
     List<Map<String, String>> universityData =  exelUtility.storeData(path,string);
      String university=  universityData.get(int1).get("University Name");
        universityPage = new UniversityPage(BaseClass.getDriver());
        universityPage.setAdduniversityTextField(university);
    }

    @And("Click Save button")
    public void clickSaveButton() throws InterruptedException {
        universityPage.click_saveButton();
    }

    @And("Verify with toaster message whether University is added or not.")
    public void verifyWithToasterMessageWhetherUniversityIsAddedOrNot() throws InterruptedException {
        Thread.sleep(300);

      String alert=  universityPage.alertMessage();
        System.out.println(alert);
        Assert.assertEquals(alert,"University added successfully");
    }


    @And("Fetch data from excel sheet, Enter the dtails on text field {string} and {}")
    public void fetchDataFromExcelSheetEnterTheDtailsOnTextFieldAnd(String arg0, Integer introw) throws IOException {
        institutePage = new InstitutePage(BaseClass.getDriver());
        exelUtility = new ExelUtility(path);

        try {
            BaseClass.getLogger().info("Fetching data from Excel sheet: " + arg0 + " at row: " + introw);
            List<Map<String, String>> instituteData = exelUtility.storeData001(path, arg0);

            String country = instituteData.get(introw).get("Country");
            BaseClass.getLogger().info("Selecting Country: " + country);
            institutePage.selectCountryfromDropDown(country);

            String state = instituteData.get(introw).get("State");
            BaseClass.getLogger().info("Selecting State: " + state);
            institutePage.selectStatefromDropDown(state);

            String schoolname = instituteData.get(introw).get("School NAME");
            BaseClass.getLogger().info("Entering School Name: " + schoolname);
            institutePage.enter_schoolName(schoolname);

            String address = instituteData.get(introw).get("Address");
            BaseClass.getLogger().info("Entering Address: " + address);
            institutePage.enter_addressTextField(address);

            String emailid = instituteData.get(introw).get("Email Id");
            BaseClass.getLogger().info("Entering Email ID: " + emailid);
            institutePage.enter_Email(emailid);

            String mobileno = instituteData.get(introw).get("Mobile No.");
            BaseClass.getLogger().info("Entering Mobile No: " + mobileno);
            institutePage.enter_mobile_number(mobileno);

            String city = instituteData.get(introw).get("City");
            BaseClass.getLogger().info("Entering City: " + city);
            institutePage.enter_cityName(city);

            String district = instituteData.get(introw).get("District");
            BaseClass.getLogger().info("Entering District: " + district);
            institutePage.enter_districtName(district);

            String pincodei = instituteData.get(introw).get("Pincode");
            BaseClass.getLogger().info("Entering Pincode: " + pincodei);
            institutePage.enter_pincodeNumber(pincodei);

            String website = instituteData.get(introw).get("WebSite");
            BaseClass.getLogger().info("Entering Website: " + website);
            institutePage.enter_website(website);

            BaseClass.getLogger().info("All data entered successfully from Excel row: " + introw);

        } catch (Exception e) {
            String screenshotName = "ExcelDataEntry_Failure_Row_" + introw;
            BaseClass.getLogger().error("Error while entering data from Excel: " + e.getMessage());
            Screenshot.captureScreenshot(BaseClass.getDriver(),"Teacher add filure");
            throw new RuntimeException("Failed during Excel data entry. Screenshot captured: " + screenshotName, e);
        }
    }


    @Given("Click on class button in sidebar.")
    public void clickOnClassButtonInSidebar() {
         adminDashBoard=new AdminDashBoard(BaseClass.getDriver());
         adminDashBoard.click_classButton();
    }

    @And("Click on Add Class button.")
    public void clickOnAddClassButton() {
        addClassPage=new AddClassPage(BaseClass.getDriver());
        addClassPage.click_addClass();
    }

    @And("Select class from dropdown {string}")
    public void selectClassFromDropdown(String clas) {
        addClassPage.click_dropdown();
        addClassPage.select_class_byInput(clas);

    }

    @When("Click on Save button in class page.")
    public void clickOnSaveButtonInClassPage() {
        addClassPage.clickonSave_Button();
    }

    @And("Select class from dropdown.")
    public void selectClassFromDropdown(DataTable dataTable) {
        List<String>values=dataTable.asList();
        for (String classes:values){
            addClassPage.click_dropdown();
            addClassPage.select_class_byInput(classes);
            addClassPage.clickonSave_Button();
        }
    }


    @And("Verify the toaster message is displayed or not in Add class page.")
    public void verifyTheToasterMessageIsDisplayedOrNotInAddClassPage() throws InterruptedException {

            Thread.sleep(1000);
            WebElement alert=addClassPage.alertMessage();
            try {
                if (alert.isDisplayed()) {
                    if (alert.getText().equalsIgnoreCase("Institute saved successfully")) {
                        System.out.println(alert.getText());
                        org.junit.Assert.assertTrue(true);
                    } else {
                        System.out.println(alert.getText());
                        org.junit.Assert.fail(alert.getText());
                    }
                }
            }catch (AssertionError assertionError){
                adminDashBoard.logOut();
            }
    }


    @And("Fetch data from excel sheet for select class and enter the Subject {string} {}.")
    public void fetchDataFromExcelSheetForSelectClassAndEnterTheSubject(String sheetname, Integer in) throws IOException, InterruptedException {
        exelUtility=new ExelUtility(path);
        subjectPAgee=new SubjectPAge(BaseClass.getDriver());
        List<Map<String, String>> classesSubjectData =  exelUtility.storeData(path,sheetname);

        String institutedropdown =  classesSubjectData.get(in).get("Institute");
        BaseClass.getLogger().info("Selecting institute from dropdown: "+ institutedropdown);
        subjectPAgee.select_institute_FromDropDown(institutedropdown);
        String classes= classesSubjectData.get(in).get("Class");
        System.out.println(classes);
        subjectPAgee.select_class_from_dropdown(classes);
        String subject=classesSubjectData.get(in).get("Subject A");
        System.out.println(subject);
        subjectPAgee.enter_Subject_Name(subject);

        Thread.sleep(500);
        String institutedropdown1 =  classesSubjectData.get(in).get("Institute");
        BaseClass.getLogger().info("Selecting institute from dropdown: "+ institutedropdown1);
        subjectPAgee.select_institute_FromDropDown(institutedropdown1);
        String classes1= classesSubjectData.get(in).get("Class");
        System.out.println(classes1);
        subjectPAgee=new SubjectPAge(BaseClass.getDriver());
        subjectPAgee.select_class_from_dropdown(classes1);
        String subjectb=classesSubjectData.get(in).get("Subject B");
        System.out.println(subjectb);
        subjectPAgee.enter_Subject_Name(subjectb);

        Thread.sleep(500);
        String institutedropdown2 =  classesSubjectData.get(in).get("Institute");
        BaseClass.getLogger().info("Selecting institute from dropdown: "+ institutedropdown2);
        subjectPAgee.select_institute_FromDropDown(institutedropdown2);
        String classes2= classesSubjectData.get(in).get("Class");
        System.out.println(classes2);
        subjectPAgee=new SubjectPAge(BaseClass.getDriver());
        subjectPAgee.select_class_from_dropdown(classes2);
        String subjectc=classesSubjectData.get(in).get("Subject C");
        System.out.println(subjectc);
        subjectPAgee.enter_Subject_Name(subjectc);

        Thread.sleep(500);
        String institutedropdown3 =  classesSubjectData.get(in).get("Institute");
        BaseClass.getLogger().info("Selecting institute from dropdown: "+ institutedropdown3);
        subjectPAgee.select_institute_FromDropDown(institutedropdown3);
        String classes3= classesSubjectData.get(in).get("Class");
        System.out.println(classes3);
        subjectPAgee=new SubjectPAge(BaseClass.getDriver());
        subjectPAgee.select_class_from_dropdown(classes3);
        String subjectd=classesSubjectData.get(in).get("Subject D");
        System.out.println(subjectd);
        subjectPAgee.enter_Subject_Name(subjectd);



    }
}
