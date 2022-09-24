package com.testing.testNG.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.testing.testNG.utils.TestUtils;
import com.testing.testNG.utils.TestUtils_DataProvi;

public class BaseInte_DataProvi {

	WebDriver driver;
	Properties prop;
	TestUtils_DataProvi test = new TestUtils_DataProvi();
	
	@BeforeSuite
	public void doSetUp() throws IOException {
		prop = test.readProp();
		if(prop.getProperty("browser1").equals("chrome")) {
			System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromeVal"));
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}else {
			
		}
		driver.get(prop.getProperty("siteUrl"));
	}
	
	@DataProvider
	public Object[][] loginData() throws IOException {
		return test.readExcelData("Login Data");
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
