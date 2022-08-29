package com.ae142.utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static final ExtentReports extentReports =new ExtentReports();
	
	public synchronized static ExtentReports createExtentReports()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Sample Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Blog Name", "AmirE142");
        extentReports.setSystemInfo("Author", "Amir Ehsan");
        return extentReports;
	}

}