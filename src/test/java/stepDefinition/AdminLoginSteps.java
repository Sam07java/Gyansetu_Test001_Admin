package stepDefinition;

import factory.BaseClass;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.LoginPage;

import java.io.IOException;
import java.util.Properties;

public class AdminLoginSteps {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    Properties properties;

    @Given("Navigate to Login Page")
    public void navigate_to_login_page() {
        BaseClass.getLogger().info("click on HomePage button");
        homePage=new HomePage(BaseClass.getDriver());
        homePage.click_SignInWithEmailorPhoneButton();
    }

    @When("Enter the admin credential on Username field and password")
    public void enter_the_admin_credential_on_username_field_password() throws IOException {
        properties= BaseClass.getProperties();
        loginPage=new LoginPage(BaseClass.getDriver());
        BaseClass.getLogger().info("get data from properties file to Admin login Page");
        loginPage.setEmailorPhoneTextField(properties.getProperty("email"));
        loginPage.setPasswordTextField(properties.getProperty("password"));
        loginPage.setClickDropDown();
        loginPage.setClickAdminOpton();
    }

    @Then("Validate Dashborad is displayed")
    public void validate_dashborad_is_displayed() {
        BaseClass.getLogger().info("click on signbutton");
        loginPage.setClickSignInButton();
    }

}
