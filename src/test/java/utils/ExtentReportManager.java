package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    public static ExtentReports extent;
    public static ExtentTest test;

    // Initialize Extent Reports
    public static ExtentReports getReportInstance() {
        if (extent == null) {
    	
    	ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        }
        return extent;
    }

    // Create a test case in the report
    public static void setTest(ExtentTest newTest) {
        test = newTest;
    }
    
    public static ExtentTest getTest() {
        return test;
    }

    // Close the report after execution
    public static void flushReport() {
        extent.flush();
    }

}

