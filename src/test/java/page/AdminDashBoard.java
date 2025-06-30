package page;

import factory.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.WaitHelper;

import java.time.Duration;

public class AdminDashBoard extends BasePage{
    WaitHelper waitHelper;
    public AdminDashBoard(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "sidebar-nav")
    WebElement sidebarElement;

    @FindBy(xpath = "//a[text()='Institution Management']")
    WebElement institutionElement;

    @FindBy(xpath = "//a[text()='University']")
    WebElement universityElement;

    @FindBy(xpath = "//a[text()='Institute']")
    WebElement instituteElement;

    @FindBy(xpath = "//a[text()='Course']")
    WebElement courseElement;

    @FindBy(xpath = "//a[text()='Subject']")
    WebElement subjectElement;

    @FindBy(xpath = "//div[text()='Language']")
    WebElement languageElement;

    @FindBy(xpath = "//a[@class='dropdown-toggle dropdown-toggle-nocaret']")
    WebElement dropdowntoggle;

    @FindBy(xpath = "//button[text()=' Logout']")
    WebElement dropdownLogoutelemnt;

    @FindBy(xpath = "//div[text()='Hobby']")
    WebElement hobbyElement;

    @FindBy(xpath = "//div[text()='Class']")
    WebElement classelement;

    @FindBy(xpath="//div[text()='Teacher']")
    WebElement teacherButton_inSideBar;

    public void click_teacherButton_inSideBar(){
        teacherButton_inSideBar.click();
    }

    public void click_masterManagment() throws InterruptedException {
       // Thread.sleep(9000);
        Actions action=new Actions(driver);
        WebElement el= driver.findElement(By.xpath("//div[text()='Master Management']"));
//        By ll = By.className("sidebar-nav");
//        WebElement epp = waitHelper.waitForVisibility(ll, 10);
        action.moveToElement(sidebarElement).build().perform();

     //   WebElement el =  waitHelper.waitForVisibility(By.xpath("//div[text()='Master Management']"), 1);

        //action.moveToElement(masterManagementElement).click().build().perform();
        //moveToElement(masterManagementElement).click().build().perform();
       // action.moveToElement(masterMangmentElement).click().perform();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",el);
    }

    public void click_instituteElement() {
        Actions action=new Actions(driver);
      //  WebElement el= driver.findElement(By.xpath("//a[text()='Institute']"));
        action.moveToElement(sidebarElement).build().perform();
      //  el.click();
        instituteElement.click();
       // JavascriptExecutor js=(JavascriptExecutor)driver;
     //   js.executeScript("arguments[0].click()",el);
    }

    public void click_institutionButton() {
        BaseClass.getLogger().info("clicking on Institute management button");
        institutionElement.click();
       // masterMangmentElement.click();
//        BaseClass.getLogger().info("Running click_institutionButton methode");
//       JavascriptExecutor js=(JavascriptExecutor)driver;
//       js.executeScript("arguments[0].click()",institutionElement);
//        BaseClass.getLogger().info("Execute java script executor");
    }

    public void click_UniversityButton() {
     //   universityElement.click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",universityElement);
    }

    public void click_CourseButton() {
        courseElement.click();
    }

    public void click_SubjectButton(){
       // subjectElement.click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",subjectElement);
    }

    public void click_languageButton(){
        languageElement.click();
    }

    public void click_hobbyButton(){
        hobbyElement.click();
    }

    public void click_classButton(){classelement.click();}

    public void logOut() throws InterruptedException {
     //   Thread.sleep(1000);
       //WebElement dropdownToggle= driver.findElement(By.xpath("//a[@class='dropdown-toggle dropdown-toggle-nocaret']"));

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",dropdowntoggle);

        //driver.findElement(By.xpath("//button[@class='dropdown-item d-flex align-items-center gap-2 py-2']")).click();
       // dropdownLogoutelemnt.click();

        JavascriptExecutor js1=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",dropdownLogoutelemnt);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement dropdownToggle= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='dropdown-toggle dropdown-toggle-nocaret']")));
        // WebElement dropdownToggle= driver.findElement(By.xpath("//a[@class='dropdown-toggle dropdown-toggle-nocaret']"));
        // dropdownToggle.click();

    }


}
