package com.ae142.utils.listeners;

import java.util.Objects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ae142.tests.BaseTest;
import com.ae142.utils.extentreports.ExtentManager;
import com.ae142.utils.extentreports.ExtentTestManager;
import com.ae142.utils.logs.Log;
import com.aventstack.extentreports.Status;

public class TestListener extends BaseTest implements ITestListener{
	
	private static String getTestMethodName(ITestResult iTestResult)
	{
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	@Override
	public void onStart(ITestContext iTestContext)
	{
		Log.info("In onStart method" + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", this.driver);
		// this.driver issue was resolved after extending BaseTest
	}
	
	@Override
	 public void onFinish(ITestContext iTestContext) {
        Log.info("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!
        ExtentManager.extentReports.flush();
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is starting.");
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is succeed.");
        //ExtentReports log operation for passed tests.
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }
    
    @Override
    public void onTestFailure(ITestResult iTestResult)
    {
    	Log.info(getTestMethodName(iTestResult) + " test is failed.");
    	
    	//Get driver from BaseTest and assign to local webdriver vars
    	Object testClass = iTestResult.getInstance();
    	WebDriver driver = ((BaseTest) testClass).getDriver();
    	
    	// take screenshot for extent reports
    	
    	//I'm getting an error as driver is null in this part
    	String scrshot = "data:image/png;" + ((TakesScreenshot)Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
    	//ExtentReports log and screenshot operations for failed tests.
    	// I will include a ExtentTestManager.startTest()
    	ExtentTestManager.startTest(scrshot,"Starting Test");
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed",
            ExtentTestManager.getTest().addScreenCaptureFromBase64String(scrshot).getModel().getMedia().get(0));
    }
    
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is skipped.");
        //ExtentReports log operation for skipped tests.
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }
    
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}
