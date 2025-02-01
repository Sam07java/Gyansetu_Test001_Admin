package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email/phone")
    WebElement emailorPhoneTextField;

    @FindBy(id= "passwordInput")
    WebElement passwordTextField;

    @FindBy(xpath = "//div[text()='Student']")
    WebElement clickDropDown;

    @FindBy(xpath = "//li[text()='Admin']")
    WebElement clickAdminOpton;

    @FindBy(xpath = "//button[text()='Sign in Now']")
    WebElement clickSignInButton;

    public void setEmailorPhoneTextField(String email) {
        emailorPhoneTextField.sendKeys(email);
    }

    public void setPasswordTextField(String password) {
        passwordTextField.sendKeys(password);
    }

    public void setClickDropDown() {
        clickDropDown.click();
    }

    public void setClickAdminOpton() {
        clickAdminOpton.click();
    }

    public void setClickSignInButton(){
        clickSignInButton.click();
    }
}
