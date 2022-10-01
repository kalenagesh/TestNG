package com.testing.testNG.tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterClass extends Base_Integration {

	WebElement name, email, mobile, password, signIn;
	 String actResult;

	 @BeforeSuite
		public void getSetUp() throws IOException {
			doSetUp();
		}
	 
	@BeforeTest
	public void goToResisterPage() {
		if (driver.getTitle().equals("Queue Codes | Log in")) {
			driver.findElement(By.partialLinkText("Register a new")).click();
			;
		}
	}

	@BeforeMethod
	public void getXpath() {
		name = driver.findElement(By.id("name"));
		name.clear();
		mobile = driver.findElement(By.id("mobile"));
		mobile.clear();
		email = driver.findElement(By.id("email"));
		email.clear();
		password = driver.findElement(By.id("password"));
		password.clear();
		signIn = driver.findElement(By.xpath("//button[@type='submit']"));
	}

         @Test(dataProvider = "resisterData")
         public void doTest(String testName, String uEmail, String uName, String uPassword, String uMobile) {
	         tName = testName;
        	 name.sendKeys(uName);	    
        	 mobile.sendKeys(uMobile);	     
        	 email.sendKeys(uEmail);	     
        	 password.sendKeys(uPassword);
        	 signIn.click();
    }
         @AfterMethod
         public void doAssert() {
        	 
        	 if (tName.equals("All are correct")) {
        	 Alert alt = driver.switchTo().alert();
        	 String actResult = alt.getText();
        	 alt.accept();
        	 Assert.assertEquals(actResult, "User registered successfully.");
        	 }else {
        		 actResult = driver.getTitle();
        		 Assert.assertEquals(actResult, "Queue Codes | Registration Page");
        	 }
         }
         
         @AfterSuite
     	public void tearDown() {
     		driver.close();
     	}
}
         
