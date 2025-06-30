package stepDefinition;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page.AdminDashBoard;
import page.TeacherPage;
import utility.ExelUtility;
import utility.Screenshot;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static utility.Screenshot.captureScreenshot;

public class addteacher_Excel {
    //public String path= "src\\test\\test-Data\\Data for Users.xlsx";
    String path= System.getProperty("user.dir") + "\\src\\test\\test-Data\\Data for Users.xlsx";
    AdminDashBoard adminDashBoard;
    TeacherPage teacherPage;
    ExelUtility exelUtility;

    @Given("Click on Teacher button in sidebar")
    public void Click_on_Teacher_button_in_sidebar(){
        adminDashBoard=new AdminDashBoard(BaseClass.getDriver());
        adminDashBoard.click_teacherButton_inSideBar();
    }


    @When("Verify teacher list page displayed or not")
    public void verifyTeacherListPageDisplayedOrNot() throws InterruptedException {
        Thread.sleep(500);
        teacherPage=new TeacherPage(BaseClass.getDriver());
    }

    @And("Click on Add Teacher button")
    public void clickOnAddTeacherButton() throws InterruptedException {

        teacherPage.click_on_Add_Teacher_Button();
        Thread.sleep(4000);
    }

    @And("Enter details on add teacher page by Excel Sheet {string}, {}")
    public void enterDetailsOnAddTeacherPageByExcelSheet(String arg0, Integer rowNum) throws IOException {
        exelUtility=new ExelUtility(path);
      List<Map<String,String>> teacherdata= exelUtility.storeData(path,arg0);

      try {
          //First Name of Teacher
          String firstname = teacherdata.get(rowNum).get("First Name");
          BaseClass.getLogger().info("fisrt name fetch from excel sheet: " + firstname);
          teacherPage.enter_First_Name(firstname);
          BaseClass.getLogger().info("first name enter on add teacher page");

          //Second Name of Teacher
          String lastName = teacherdata.get(rowNum).get("Last Name");
          BaseClass.getLogger().info("Last name fetched from Excel sheet: " + lastName);
          teacherPage.enter_Secound_Name(lastName);
          BaseClass.getLogger().info("Last name entered on Add Teacher page");

          //Select Gender
          String gender = teacherdata.get(rowNum).get("Gender");
          BaseClass.getLogger().info("Gender fetched from Excel sheet: " + gender);
          teacherPage.select_gender(gender);
          BaseClass.getLogger().info("Gender selected on Add Teacher page");

          //Select DOB
          String date = teacherdata.get(rowNum).get("DOB_Date");
          String month = teacherdata.get(rowNum).get("DOB_Month");
          String year = teacherdata.get(rowNum).get("DOM_Year");

          BaseClass.getLogger().info("DOB fetched from Excel sheet: Date=" + date + ", Month=" + month + ", Year=" + year);
          teacherPage.select_DOB(date, month, year);
          BaseClass.getLogger().info("DOB selected on Add Teacher page");

          //Enter email id
          String emailid = teacherdata.get(rowNum).get("Email I'd");
          BaseClass.getLogger().info("email id fetch from excel sheer: " + emailid);
          teacherPage.enter_emailId(emailid);
          BaseClass.getLogger().info("Email id entered on Add Teacher page");


          //Enter Mobile Number
          String mobileNumber = teacherdata.get(rowNum).get("Mobile Number");
          BaseClass.getLogger().info("mobile number fetch from excel sheer: " + mobileNumber);
          teacherPage.enter_mobileNumber(mobileNumber);
          BaseClass.getLogger().info("Mobile Number entered on Add Teacher page");

          //Selecr Qualification
          String qualify = teacherdata.get(rowNum).get("Qualification");
          BaseClass.getLogger().info("qualification fetch from excel sheer: " + qualify);
          teacherPage.select_qualification(qualify);
          BaseClass.getLogger().info("Qualification entered on Add Teacher page");

          //Enter experience
          String exper = teacherdata.get(rowNum).get("Experience");
          BaseClass.getLogger().info("experience fetch from excel sheer: " + exper);
          teacherPage.enter_experience(exper);
          BaseClass.getLogger().info("Experience entered on Add Teacher page");

          //select entity
          String entity = teacherdata.get(rowNum).get("Entity");
          BaseClass.getLogger().info("Entity fetch from excel sheer: " + entity);
          teacherPage.select_entity(entity);
          BaseClass.getLogger().info("Entity selected on Add Teacher page");

          //Select School
          String schoolName = teacherdata.get(rowNum).get("School Name");
          BaseClass.getLogger().info("School Name fetch from excel sheer: " + schoolName);
          teacherPage.select_school(schoolName);
          BaseClass.getLogger().info("School Name entered on Add Teacher page");

          //Select class
          String classname = teacherdata.get(rowNum).get("Class");
          BaseClass.getLogger().info("Class name id fetch from excel sheer: " + classname);
          teacherPage.select_class(classname);

          String subA = teacherdata.get(rowNum).get("Subject A");
          String subB = teacherdata.get(rowNum).get("Subject B");

          BaseClass.getLogger().info("Subjects fetch from excel sheet: " + subB + " " + subA);

          teacherPage.select_subject(subA, subB);

          BaseClass.getLogger().info("Subject selected on Add Teacher page");

          //Enter the address
          String address = teacherdata.get(rowNum).get("Address");
          BaseClass.getLogger().info("Address fetch from excel sheer: " + address);
          teacherPage.enter_address(address);
          BaseClass.getLogger().info("Address entered on Add Teacher page");

          //Select the Country in dropdown
          String country = teacherdata.get(rowNum).get("Country");
          BaseClass.getLogger().info("Country fetch from excel sheer: " + country);
          teacherPage.select_country(country);
          BaseClass.getLogger().info("Country selected on Add Teacher page");

          //Select the State from dropdown
          String state = teacherdata.get(rowNum).get("State");
          BaseClass.getLogger().info("State fetch from excel sheer: " + state);
          teacherPage.select_state(state);
          BaseClass.getLogger().info("State selected on Add Teacher page");

          //Enter the city name
          String city = teacherdata.get(rowNum).get("City");
          teacherPage.enter_city(city);
          BaseClass.getLogger().info("City entered on Add Teacher page " +city);

          //Enter the district name
          String district = teacherdata.get(rowNum).get("District");
          teacherPage.enter_district(district);
          BaseClass.getLogger().info("District entered on Add Teacher page: "+ district);

          //Enter the pincode
          String pincode = teacherdata.get(rowNum).get("Pincode");
          teacherPage.enter_pincode(pincode);
          BaseClass.getLogger().info("pincode entered on Add Teacher page");

      } catch (Exception e){
          BaseClass.getLogger().error("Error while filling Add Teacher form: " + e.getMessage());
          captureScreenshot(BaseClass.getDriver(), "Error_Occurred");
          throw e; // Rethrow to fail the test
      }

    }


    @Then("Click on Save button in Add teacher page.")
    public void clickOnSaveButtonInAddTeacherPage() {
        teacherPage.click_Save_Button();
    }

    @And("verify the teacher added successfull or not")
    public void verifyTheTeacherAddedSuccessfullOrNot() {
        //  WebElement alertElement= teacherPage.alertMessage();
        WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(10));

        // Wait for the toaster message to appear
        WebElement toasterMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']//div[2]"))
        );

        // Capture text
        String message = toasterMessage.getText();
        System.out.println("Toaster Message: " + message);

        // Screenshot path
        String screenshotPath = "";

        // Validation
        if (message.equals("Teacher created successfully")) {
            System.out.println("✅ Success: Teacher was added.");
            captureScreenshot(BaseClass.getDriver(),"Teacher_Created_Successfully");
        } else if (message.equals("User with this email or phone already exists")) {
            System.out.println("❌ Error: Duplicate user.");
            captureScreenshot(BaseClass.getDriver(),"Teacher_Creation_Failed");
            Assert.fail("Teacher_Creation_Failed");
        } else {
            System.out.println("⚠️ Unexpected message: " + message);
            captureScreenshot(BaseClass.getDriver(),"Unexpected_Message");
            Assert.fail("Unexpected_Message");
        }

        System.out.println("Screenshot saved at: " + screenshotPath);
    }


}

