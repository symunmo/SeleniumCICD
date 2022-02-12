package selenium.cucumber.runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources/features",
        glue = {"selenium.cucumber.steps" },
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
        dryRun=false,
        monochrome = true,
        strict =true,
        
        tags = {"@HomePageTest"})
public class EBFSTestRunner extends TestRunner{

}
