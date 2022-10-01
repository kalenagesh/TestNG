package com.testing.testNG.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest_DataProvi extends Base_Integration {

	
	WebElement email, pass, submit;
	
	@BeforeSuite
	public void getSetUp() throws IOException {
		doSetUp();
	}
	
	@BeforeMethod
	public void getXpath() {
		email= driver.findElement(By.xpath("//input[@type='text']"));
		email.clear();
		pass= driver.findElement(By.xpath("//input[@type='password']"));
		pass.clear();
		submit= driver.findElement(By.xpath("//button[@type='submit']"));
	}

	@Test(dataProvider = "loginData")
	public void doLogin(String testName, String uName, String uPass) {
		tName = testName;
		email.sendKeys(uName);
		pass.sendKeys(uPass);
		submit.click();
	}

	@AfterMethod
	public void doAssert() {
		String actResult = driver.getTitle();
		if (tName.equals("Both are valid")) {
			AssertJUnit.assertEquals(actResult, "Queue Codes | Dashboard");
		} else {
			AssertJUnit.assertEquals(actResult, "Queue Codes | Log in");
		}
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
