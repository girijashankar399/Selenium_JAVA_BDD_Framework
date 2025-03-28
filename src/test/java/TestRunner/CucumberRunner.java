package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="", features= {"C:\\Users\\Hp\\eclipse-workspace\\Project_TestNG_BDD\\src\\test\\resources\\Feature\\CheckingLoginFun.feature"}, 
glue=	{"StepDefinations"}, 
plugin= {"pretty", "html:target/htmlreport.html"})

public class CucumberRunner extends AbstractTestNGCucumberTests{
	
	

}
