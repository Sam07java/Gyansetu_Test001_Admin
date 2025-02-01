package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features ={"src/test/java/Features/admin_login_001.feature"},
        glue = {"stepDefinition","hooks"},
        plugin = {"pretty", "html:reports/myreport.html",
               // "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                //"rerun:target/rerun.txt",
                },
dryRun=false,
monochrome = true,
        publish = true
)

public class TestRunner {
}
