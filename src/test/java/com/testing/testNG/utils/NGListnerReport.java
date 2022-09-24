package com.testing.testNG.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class NGListnerReport implements ITestListener {
	ExtentReports extent = ManualTestReportGen.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test case passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, "Due to assertion failure");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Skipped test cases");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
}
