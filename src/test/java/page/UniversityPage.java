package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UniversityPage extends BasePage {


    public UniversityPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Add University']")
    WebElement addUniversityButton;

    @FindBy(name = "university_name")
    WebElement adduniversityTextField;

    @FindBy(xpath = "//button[@class='btn btn-primary mainbutton']")
    WebElement saveButton;

    public void click_addUniversity()
    {
        addUniversityButton.click();
    }

    public void setAdduniversityTextField(String university)
    {
        adduniversityTextField.sendKeys(university);
    }

    public void click_saveButton()
    {
        saveButton.click();
    }

    public String alertMessage()
    {
        return driver.findElement(By.xpath("//div[@class='Toastify__toast-body']//div[2]")).getText();
    }
}
