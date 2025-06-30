package stepDefinition;

import factory.BaseClass;
import io.cucumber.java.en.And;
import page.CoursePage;
import page.InstitutePage;
import page.SubjectPAge;
import page.TeacherPage;
import utility.ExelUtility;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static utility.Screenshot.captureScreenshot;

public class addData_Excel_College {
    InstitutePage institutePage;
    CoursePage coursePage;
    SubjectPAge subjectPAge;
    ExelUtility exelUtility;
    TeacherPage teacherPage;
    String path= System.getProperty("user.dir") + "\\src\\test\\test-Data\\Data for Users.xlsx";
    @And("Fetch the data from excel sheet for add institute data {string} , {}")
    public void Fetch_the_data_from_excel_sheet_for_add_institute_data(String sheet, Integer rowNo) throws IOException {
        BaseClass.getLogger().info("Select Entity from dropdown for collage Institute creation");
        institutePage=new InstitutePage(BaseClass.getDriver());
        institutePage.click_entityDropDown();
        institutePage.click_CollageElement_fromEntityDropDown();

        exelUtility=new ExelUtility(path);
       List<Map<String, String>> instituteCollage = exelUtility.storeData(path, sheet);

       //Select University from dropdown
       String university = instituteCollage.get(rowNo).get("University");
        BaseClass.getLogger().info("Select University from dropdown: "+ university);
        institutePage.selectUniversityFromDropDown(university);

        //Select country
       String country = instituteCollage.get(rowNo).get("Country");
        BaseClass.getLogger().info("Select Country from dropdown: "+ country);
        institutePage.selectCountryfromDropDown(country);

        //Select State
       String state = instituteCollage.get(rowNo).get("State");
        BaseClass.getLogger().info("Select State from dropdown: " + state);
        institutePage.selectStatefromDropDown(state);

        //Enter the Institute Name
       String institute = instituteCollage.get(rowNo).get("InstituteNAME");
        BaseClass.getLogger().info("Enter name on Institute text field: "+ institute);
        institutePage.enter_InstituteNameTextField(institute);

        //Enter Address
       String address = instituteCollage.get(rowNo).get("Address");
        BaseClass.getLogger().info("Enter the address on text field: "+ address);
        institutePage.enter_addressTextField(address);

        //Enter the Email Id
       String email = instituteCollage.get(rowNo).get("Email Id");
        BaseClass.getLogger().info("Enter the Email id on text field: "+email);
        institutePage.enter_Email(email);

        //Enter Mobile Number
       String mobileNo = instituteCollage.get(rowNo).get("Mobile No.");
        BaseClass.getLogger().info("Enter the mobile number on text field: "+ mobileNo);
        institutePage.enter_mobile_number(mobileNo);

        //Enter the City Namw
       String city = instituteCollage.get(rowNo).get("City");
        BaseClass.getLogger().info("Enter the City Name on the text field: "+city);
        institutePage.enter_cityName(city);

        //Enter the district name
       String dis = instituteCollage.get(rowNo).get("District");
        BaseClass.getLogger().info("Enter the District Name on the text field: "+dis);
        institutePage.enter_districtName(dis);

        //Enter the pincode
        String pincode = instituteCollage.get(rowNo).get(" Pincode");
        BaseClass.getLogger().info("Enter the Pincode Number on the text field: "+ pincode);
        institutePage.enter_pincodeNumber(pincode);

        //Enter the WebSite Addresss
        String website = instituteCollage.get(rowNo).get("WebSite");
        BaseClass.getLogger().info("Enter the Website on the text field: "+ website);
        institutePage.enter_website(website);

    }

    @And("Fetch the data from excel sheet add course {string} {}")
    public void fetchTheDataFromExcelSheetAddCourse(String course, Integer rowNu) throws IOException {
        coursePage=new CoursePage(BaseClass.getDriver());

        exelUtility=new ExelUtility(path);
        List<Map<String, String>> courseCollage = exelUtility.storeData(path, course);

       String institutteName = courseCollage.get(rowNu).get("Institute");
        BaseClass.getLogger().info("Click on the Institute DropDown and Select one of them by "+ institutteName);
        coursePage.click_Add_Course_DropDown(institutteName);

       String courseName = courseCollage.get(rowNu).get("Course Name");
        BaseClass.getLogger().info("Click on the Course DropDown and Select one of them by "+ courseName);
        coursePage.enter_CourseName_OnTextField(courseName);

       String duration = courseCollage.get(rowNu).get("Duration");
        BaseClass.getLogger().info("Select Duration from DropDown "+duration);
        coursePage.select_DurationFrom_DropDown(duration);

    }

    @And("Fetch data from excel sheet add subject {string} {}")
    public void fetchDataFromExcelSheetAddSubject(String collegeSubjectSheetName , Integer rownumber) throws IOException {

        subjectPAge = new SubjectPAge(BaseClass.getDriver());
        exelUtility=new ExelUtility(path);
        List<Map<String, String>> subjectCollage = exelUtility.storeData(path, collegeSubjectSheetName);

        String institutedropdown =  subjectCollage.get(rownumber).get("Institute");
        BaseClass.getLogger().info("Selecting institute from dropdown: "+ institutedropdown);
        subjectPAge.select_institute_FromDropDown(institutedropdown);

        String cousedropdown = subjectCollage.get(rownumber).get("Course");
        BaseClass.getLogger().info("Click on course dropdown and select one of them by "+cousedropdown);
        subjectPAge.select_Course_from_Dropdown(cousedropdown);

        String semesterDropdown =  subjectCollage.get(rownumber).get("Semester");
        BaseClass.getLogger().info("Select the Semester from dropdown: "+semesterDropdown);
        subjectPAge.select_Semester_from_dropdown(semesterDropdown);

        String subjectName = subjectCollage.get(rownumber).get("Subject Name");
        BaseClass.getLogger().info("Enter the Subject Name: "+subjectName);
        subjectPAge.enter_Subject_Name(subjectName);

    }

    @And("Enter the details on add teacher page by fetch data from Excel sheet {string} {}")
    public void enterTheDetailsOnAddTeacherPageByFetchDataFromExcelSheet(String collegeSheetTeacher, Integer rowNum) throws IOException {
        exelUtility=new ExelUtility(path);
        teacherPage=new TeacherPage(BaseClass.getDriver());
        List<Map<String,String>> teacherdata= exelUtility.storeData(path,collegeSheetTeacher);

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

            //Select University
            String universityName = teacherdata.get(rowNum).get("University");
            BaseClass.getLogger().info("University Name fetch from excel sheer: " + universityName);
            teacherPage.select_University(universityName);
            BaseClass.getLogger().info("School Name entered on Add Teacher page");

            //Select College NAme
            String instituteName = teacherdata.get(rowNum).get("College Name");
            BaseClass.getLogger().info("College name fetch from excel sheer: " + instituteName);
            teacherPage.select_collegeName(instituteName);

            //Select Course
            String courseName= teacherdata.get(rowNum).get("Course");
            BaseClass.getLogger().info("Course fetch from excel sheet: "+ courseName);
            teacherPage.selectCourse(courseName);

            //Select Semester
            String smester = teacherdata.get(rowNum).get("Semester");
            BaseClass.getLogger().info("Semester is selected by excel sheet: "+ smester);
            teacherPage.select_Semester(smester);

            //Select Subject
            String subA = teacherdata.get(rowNum).get("Subject A");
            String subB = teacherdata.get(rowNum).get("Subject B");

            BaseClass.getLogger().info("Subjects fetch from excel sheet: " + subB + " " + subA);

            teacherPage.select_subjectCollege(subA, subB);

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
}
