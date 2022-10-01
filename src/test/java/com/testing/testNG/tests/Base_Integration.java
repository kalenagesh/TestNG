package com.testing.testNG.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.testing.testNG.utils.TestUtils;

public class Base_Integration {

	WebDriver driver;
	Properties prop;
	String tName;
	TestUtils test = new TestUtils();
	
	
	public void doSetUp() throws IOException {
		prop = test.readProp();
		if(prop.getProperty("browser1").equals("chrome")) {
			System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromeVal"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else {
			
		}
		driver.get(prop.getProperty("siteUrl"));
	}
	
	//2.LoginTest_DataProvi :
	@DataProvider
	public Object[][] loginData() throws IOException {
		return test.readExcelData("Login Data");
	}
	
	//3. Resistration DataProvi :
		@DataProvider
		public Object[][] resisterData() throws IOException {
			return test.readExcelData("ResisterData");
		}
		
	
}
