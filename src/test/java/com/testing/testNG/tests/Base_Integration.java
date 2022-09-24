package com.testing.testNG.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.testing.testNG.utils.TestUtils;

public class Base_Integration {

	WebDriver driver;
	Properties prop;
	TestUtils test = new TestUtils();
	
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
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
