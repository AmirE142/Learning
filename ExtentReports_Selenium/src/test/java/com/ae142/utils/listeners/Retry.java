package com.ae142.utils.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.ae142.tests.BaseTest;
import com.ae142.utils.extentreports.ExtentTestManager;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import org.openqa.selenium.TakesScreenshot;

public class Retry implements IRetryAnalyzer {
	private int count = 0;
	private static int maxTry = 1; //Rerun the failed test one time only

	
	
	
	@Override
	public boolean retry(ITestResult iTestResult)
	{
		if(!iTestResult.isSuccess()) //if test is not successful
		{
			if(count<maxTry)
			{
				count++;
				iTestResult.setStatus(ITestResult.FAILURE);
				extendReportsFailOperations(iTestResult);
				return true;
			}
		}
			else
			{
				iTestResult.setStatus(ITestResult.SUCCESS);
			}
			
			return false;
		}
		
		public void extendReportsFailOperations(ITestResult iTestResult)
		{
			Object testClass = iTestResult.getInstance();
			WebDriver webDriver = ((BaseTest)testClass).getDriver();
			String scrshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
			ExtentTestManager.getTest().log(Status.FAIL,"Test Failed",
					ExtentTestManager.getTest().addScreenCaptureFromBase64String(scrshot).getModel().getMedia().get(0));		
		}
	}
	
	

