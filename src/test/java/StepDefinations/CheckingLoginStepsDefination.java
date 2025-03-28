package StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExtentReportManager;

public class CheckingLoginStepsDefination {
	
	 	WebDriver driver = Hooks.driver;
		@Given("the user is on the login page")
		public void the_user_is_on_the_login_page() {
		    // Write code here that turns the phrase above into concrete actions
			//driver = new ChromeDriver();
			driver.get("https://practicetestautomation.com/practice-test-login/");
			
			//ExtentReportManager.createTest("Scenario Testcase");
			//ExtentTest test = ExtentReportManager.getReportInstance().createTest("Scenario Testcase");
			//ExtentReportManager.setTest(test);
	        ExtentReportManager.test.log(Status.INFO, "User is on the login page");
		}
		
		@When("the user enters {string} as the username")
		public void the_user_enters_as_the_username(String username) {
		    // Write code here that turns the phrase above into concrete actions
		    WebElement usernameFeild = driver.findElement(By.id("username"));
		    usernameFeild.clear();
		    usernameFeild.sendKeys(username);
		    
		    ExtentReportManager.test.log(Status.PASS, "Entered username" + username);
		}
		
		@And("the user enters {string} as the password")
		public void the_user_enters_as_the_password(String password) {
		    WebElement passwordFeild = driver.findElement(By.id("password"));
		    passwordFeild.clear();
		    passwordFeild.sendKeys(password);
		    
		    ExtentReportManager.test.log(Status.PASS, "Entered password" + password );
		}
		
		@And("the user clicks the submit button")
		public void the_user_clicks_the_submit_button() {
		    driver.findElement(By.id("submit")).click();
		    
		    ExtentReportManager.test.log(Status.PASS, "Clicked submit button");
		    
		}
		
		@Then("the user should be redirected to the homepage")
		public void the_user_should_be_redirected_to_the_homepage() {
		    // Write code here that turns the phrase above into concrete actions
			 Assert.assertTrue(driver.findElements(By.xpath("//h1[@class='post-title']")).size() > 0, "Loginsucessfully");
			 String title = driver.getTitle();
			 if (title.equals("Logged In Successfully | Practice Test Automation")) {
		           ExtentReportManager.test.log(Status.PASS, "User successfully redirected to homepage");
		       } else {
		           ExtentReportManager.test.log(Status.FAIL, "Homepage redirection failed");
		       }
		
		}
		
		@Then("an error message should be displayed saying {string}")
		public void an_error_message_should_be_displayed_saying(String ErrorMessage) {
		    // Write code here that turns the phrase above into concrete actions
		    WebElement errormessage = driver.findElement(By.id("error"));
		    Assert.assertEquals(ErrorMessage, errormessage.getText());
		    
		    ExtentReportManager.test.log(Status.INFO, "Correct message seen successfully");
		}
		
		@When("the user leaves the username field empty")
		public void the_user_leaves_the_username_field_empty() {
		    // Write code here that turns the phrase above into concrete actions
			 WebElement usernameFeild = driver.findElement(By.id("username"));
			 usernameFeild.clear();
			 
			 ExtentReportManager.test.log(Status.INFO, "Username field is empty");
		}
		
		@And("the user leaves the password field empty")
		public void the_user_leaves_the_password_field_empty() {
		    // Write code here that turns the phrase above into concrete actions
			WebElement passwordFeild = driver.findElement(By.id("password"));
		    passwordFeild.clear();
		    
		    ExtentReportManager.test.log(Status.INFO, "Password field is empty");
		    
		    
		}
		
		




}
