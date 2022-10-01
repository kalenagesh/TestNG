package com.testing.testNG.utils;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ManualTestReportGen {

	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		String path = "test-output/TestNGReport.html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setReportName("Test Automation Report");
		reporter.config().setDocumentTitle("Queue Codes Test Reports");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "NK Automation");
		extent.setSystemInfo("User Name", "Nagesh Kale");
		return extent;
	}
}
