package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
     //   features ={"src/test/java/Features/admin_login_001.feature",
        features= {
                "src/test/java/Features/add_dataFrom_ExelSheet_ForSchool_006.feature",
//                "src/test/java/Features/add_dataFrom_ExlSheet_ForCollege_007.feature",
//                "src/test/java/Features/add_dataOn_admin_002.feature",
//                 "src/test/java/Features/add_Language_OnAdmin_003.feature"

                },

        //feature={"@target/rerun.txt"},
        //feature={".//Feature/"},
       // features={"src/test/java/Features/add_Language_OnAdmin_003.feature"},
        glue = {"stepDefinition","hooks"},
        plugin = {"pretty", "html:reports/myreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt",
                },
                    dryRun=false,
                    monochrome = false,
                        publish = true
)
public class TestRunner {

}
