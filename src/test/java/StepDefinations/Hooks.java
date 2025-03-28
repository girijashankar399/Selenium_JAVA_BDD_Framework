package StepDefinations;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.ExtentReportManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

public class Hooks {
    public static WebDriver driver;
    private ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {
        // Start Extent Test with the Scenario Name
    	test = ExtentReportManager.getReportInstance().createTest(scenario.getName());
        ExtentReportManager.setTest(test); // Store in ExtentReportManager

        // Initialize WebDriver (Modify as per your setup)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        test.info("Browser launched");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("Test Failed: " + scenario.getName());
        } else {
            test.pass("Test Passed: " + scenario.getName());
        }

        if (driver != null) {
            driver.quit();
            test.info("Browser closed");
        }

        ExtentReportManager.flushReport();
    }
}
