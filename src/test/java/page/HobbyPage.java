package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HobbyPage extends BasePage{
    public HobbyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Add Hobbies']")
    WebElement elementOfADDHobbiesButton;

    @FindBy(xpath = "//input[1]")
    WebElement textfieldAddHobbies;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveElementButton;

    public void click_ADD_HOBBIES(){
        elementOfADDHobbiesButton.click();
    }

    public void enter_Hobbies_OnTextField(String hobbies){
        textfieldAddHobbies.sendKeys(hobbies);
    }

    public void click_Save_Button(){
        saveElementButton.click();
    }
}
