package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Month;

import java.time.Duration;
import java.util.List;
public class DatePicker {

    WebDriver driver;
    private final Logger logger = LogManager.getLogger(this.getClass().getName());
    public DatePicker(WebDriver driver) {
        this.driver=driver;
    }


    public void DatePickers()
    {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");

        driver.manage().window().maximize();

        WebElement Frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

        driver.switchTo().frame(Frame);

        // Since there are one frame we can use below code too

        // driver.switchTo().frame(0);

        // Approach Number One : This is used almost all time
        /*
         * WebElement datePicker=driver.findElement(By.xpath("//input[@id='datepicker']"));
         * datePicker.sendKeys("04/12/2025");
         */

        //Approach Two
        String year = "2028";
        String month = "March";
        String date = "23";

        WebElement datePicker=driver.findElement(By.xpath("//input[@id='datepicker']"));

        datePicker.click();

        while (true) {

            String Month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String Year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (Month.equals(month) && Year.equals(year)) {
                break;
            }

            WebElement next = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
            next.click();
        }
        List<WebElement> allDates =  driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        for (WebElement eachDate : allDates)
        {
            if (eachDate.getText().equals(date))
            {
                eachDate.click();
                break;
            }
        }
    }

    public void selectYear(String Year)
    {
        WebElement datepick=driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw']"));
        datepick.click();
       // WebElement select_year=driver.findElement(By.xpath("//button[@aria-label='calendar view is open, switch to year view']"));
        //select_year.click();
        List<WebElement> years=driver.findElements(By.xpath("//div[@class='MuiPickersYear-root css-j9zntq']//button"));
        //For Year selection
        boolean yearFound=false;
        for(WebElement dateWebElement:years)
        {
            String yearText=dateWebElement.getText();
            if(yearText.equals(Year))
            {
                dateWebElement.click();
                yearFound=true;
                break;
            }
        }
        if(yearFound)
        {
            System.out.println("clicked on year");
        }
        else
        {
            System.out.println("Year not found");
        }
        driver.findElement(By.xpath("//button[@class='chat_search_btn']")).click();
    }


    public void datepickerGy(String date, String month, String year) {
        try {
            logger.info("Opening date picker...");
            WebElement datepick = driver.findElement(By.xpath("//button[@aria-label='Choose date']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", datepick);

            // Switch to year view
            WebElement select_year = driver.findElement(By.xpath("//button[@aria-label='calendar view is open, switch to year view']"));
            select_year.click();
            logger.info("Switched to year view");

            // Select the desired year
            List<WebElement> years = driver.findElements(By.xpath("//div[@class='MuiPickersYear-root css-j9zntq']//button"));
            boolean yearFound = false;
            for (WebElement yearElement : years) {
                if (yearElement.getText().equals(year)) {
                    yearElement.click();
                    yearFound = true;
                    logger.info("Year {} selected", year);
                    break;
                }
            }
            if (!yearFound) {
                logger.warn("Year {} not found in list", year);
                return;
            }

            // Compare current and target month/year
            Month targetMonthEnum = CalanderObject.convertMonth(month);
            int targetMonthNum = targetMonthEnum.getValue();
            int targetYearNum = Integer.parseInt(year);

            while (true) {
                WebElement displayed = driver.findElement(By.xpath("//div[@class='MuiPickersCalendarHeader-label css-1v994a0']"));
                String[] currentParts = displayed.getText().split(" ");
                Month currentMonthEnum = CalanderObject.convertMonth(currentParts[0]);
                int currentMonthNum = currentMonthEnum.getValue();
                int currentYearNum = Integer.parseInt(currentParts[1]);

                if (currentMonthNum == targetMonthNum && currentYearNum == targetYearNum) {
                    logger.info("Target month/year visible: {} {}", currentMonthEnum, currentYearNum);
                    break;
                }

                if (currentYearNum > targetYearNum || (currentYearNum == targetYearNum && currentMonthNum > targetMonthNum)) {
                    // Navigate to previous month
                    driver.findElement(By.xpath("//button[@aria-label='Previous month']")).click();
                    logger.info("Clicked previous month");
                } else {
                    // Navigate to next month
                    driver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
                    logger.info("Clicked next month");
                }
            }

            // Select the date
            List<WebElement> dates = driver.findElements(By.xpath("//button[contains(@class,'MuiPickersDay-root')]"));
            for (WebElement day : dates) {
                if (day.getText().equals(date)) {
                    day.click();
                    logger.info("Date {} selected", date);
                    break;
                }
            }

        } catch (Exception e) {
            logger.error("Exception in datepickerG: {}", e.getMessage(), e);
        }
    }


    public void datepickerG(String date, String month, String year) {
        try {
            logger.info("Opening date picker...");
           // Thread.sleep(1000);
            WebElement datepick = driver.findElement(By.xpath("//button[@aria-label='Choose date']"));
            JavascriptExecutor js=(JavascriptExecutor)driver;js.executeScript("arguments[0].click()",datepick);
          //  datepick.click();

            WebElement monthYear = driver.findElement(By.xpath("//div[@class='MuiPickersCalendarHeader-label css-1v994a0']"));
            String[] parts = monthYear.getText().split(" ");
            String displayed_month = parts[0];
            String displayed_year = parts[1];
            logger.info("Initially displayed month and year: {} {}", displayed_month, displayed_year);

            WebElement select_year = driver.findElement(By.xpath("//button[@aria-label='calendar view is open, switch to year view']"));
            select_year.click();
            logger.info("Switched to year view");

            List<WebElement> years = driver.findElements(By.xpath("//div[@class='MuiPickersYear-root css-j9zntq']//button"));
            boolean yearFound = false;
            for (WebElement yearElement : years) {
                String yearText = yearElement.getText();
                if (yearText.equals(year)) {
                    yearElement.click();
                    yearFound = true;
                    logger.info("Year {} selected", year);
                    break;
                }
            }
            if (!yearFound) {
                logger.warn("Year {} not found in list", year);
                return;
            }

            logger.info("Waiting for month {} to be visible", month);
            while (true) {
                WebElement monthYear1 = driver.findElement(By.xpath("//div[@class='MuiPickersCalendarHeader-label css-1v994a0']"));
                String afterMonthYear = monthYear1.getText();
                if ((month + " " + year).equals(afterMonthYear)) {
                    logger.info("Desired month and year displayed: {}", afterMonthYear);
                    break;
                }
                driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeStart MuiIconButton-sizeMedium MuiPickersArrowSwitcher-button css-1fklenr']")).click();
                logger.info("Navigating to previous month...");
            }

            List<WebElement> dateF = driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-zo8nzd']"));
            logger.info("Total dates visible: {}", dateF.size());

            boolean dateSelected = false;
            for (int i = 0; i < dateF.size(); i++) {
                WebElement cell = dateF.get(i);
                if (cell.getText().equals(date)) {
                    cell.click();
                    logger.info("Date {} clicked", date);
                    dateSelected = true;
                    break;
                }
            }

            if (!dateSelected) {
                logger.warn("Date {} not found in calendar", date);
                return;
            }

//            driver.findElement(By.xpath("//button[@class='chat_search_btn']")).click();
//            logger.info("Search button clicked after date selection");

        } catch (NoSuchElementException e) {
            logger.error("Element not found: {}", e.getMessage());
        } catch (Exception e) {
            logger.error("An unexpected error occurred: ", e);
        }
    }

}
