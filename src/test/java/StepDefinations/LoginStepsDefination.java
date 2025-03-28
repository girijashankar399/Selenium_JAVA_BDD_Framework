package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExtentReportManager;


public class LoginStepsDefination {
	
	
	WebDriver driver = Hooks.driver;;
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
	    
	    
	    driver.get("https://practicetestautomation.com/practice-test-login/");
	    
	    //ExtentReportManager.createTest("Login Test");
	    //ExtentTest test = ExtentReportManager.getReportInstance().createTest(scenario.getName());
	   // ExtentReportManager.setTest(test);
        ExtentReportManager.test.log(Status.INFO, "User is on the login page");
	    
	    	
	}
	
	@When("User enter correct username and pwd")
	public void user_enter_correct_username_and_pwd() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		
		ExtentReportManager.test.log(Status.PASS, "Entered username");
		ExtentReportManager.test.log(Status.PASS, "Entered password");
		
		
	}
	
	@And("click on login button")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//button[@id='submit']")).click();
	    
	    ExtentReportManager.test.log(Status.PASS, "Clicked submit button");
	    
	}
	
	@Then("user is navigate to HomePage")
	public void user_is_navigate_to_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertTrue(driver.findElements(By.xpath("//h1[@class='post-title']")).size() > 0, "Loginsucessfully");
	   String title = driver.getTitle();
	   if (title.equals("Logged In Successfully | Practice Test Automation")) {
           ExtentReportManager.test.log(Status.PASS, "User successfully redirected to homepage");
       } else {
           ExtentReportManager.test.log(Status.FAIL, "Homepage redirection failed");
       }
	}
	
	@And("Close the browser")
	public void close_the_browser() {
		if (driver != null) {
            driver.quit(); // Ensures proper browser shutdown
            ExtentReportManager.test.log(Status.INFO, "Browser closed successfully");
            driver = null; // Reset driver
		}
		else {
			System.out.println("Driver is already null");
			ExtentReportManager.test.log(Status.INFO, "Browser is Not closed");
		}
		
		
	}
}
