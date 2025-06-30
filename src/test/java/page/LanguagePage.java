package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguagePage extends BasePage{
    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Add Language']")
    WebElement addLanguageElement;

    @FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq']")
    WebElement languageTextFieldElement;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement clickSaveButtonElement;

    public void click_on_ADD_Language_Button(){
        addLanguageElement.click();
    }

    public void enter_Language_on_textField(String language){
        languageTextFieldElement.clear();
        languageTextFieldElement.sendKeys(language);

    }

    public void click_on_Save_Button(){
        clickSaveButtonElement.click();
    }

    public String alertMessage()
    {
        return driver.findElement(By.xpath("//div[@class='Toastify__toast-body']//div[2]")).getText();
    }
}
