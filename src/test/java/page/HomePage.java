package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='Sign in with Email / Phone']")
    WebElement signInWithEmailorPhoneButton;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement registrationButton;

    public void click_SignInWithEmailorPhoneButton()
    {
        signInWithEmailorPhoneButton.click();
    }

    public void click_RegistrationButton()
    {
        registrationButton.click();
    }
}
