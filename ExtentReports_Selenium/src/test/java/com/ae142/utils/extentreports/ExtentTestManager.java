package com.ae142.utils.extentreports;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.*;

//creates an extentTestMap that holds info of thread ids and ExtentTest Instances
// ExtentReports instance is created by calling getExtentReports()
// at startTest, an instance of ExtentTest is created into extentTestMap with current thread id
// getTest, return ExtentTest instance in extentTestMap by using current thread id

public class ExtentTestManager {
	static Map<Integer,ExtentTest> extentTestMap = new HashMap<>();
	static ExtentReports extent = ExtentManager.createExtentReports();
	
	public static synchronized ExtentTest getTest()
	{
		return extentTestMap.get((int)Thread.currentThread().getId());
	}
	
	public static synchronized ExtentTest startTest(String testName, String desc)
	{
		ExtentTest test = extent.createTest(testName,desc);
		extentTestMap.put((int)Thread.currentThread().getId(), test);
		return test;
	}
	

}
