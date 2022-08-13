package com.automation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;

	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	

	@BeforeSuite
	public void setUpSuite() {
		
		Reporter.log("Setting up reports and test is getting ready", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent =new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ClassicCRMPRO.html"));
	    report= new ExtentReports();
	    report.attachReporter(extent);
	    
	    Reporter.log("Setting up done & test can be started", true);
	
	}

	@BeforeClass
	public void setup() {
		Reporter.log("Trying to start browser & getting app ready", true);
		
		driver = BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingurl());
		
		Reporter.log("Browser &  app is up & running", true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.closeApplication(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenShot(driver);
		}
		report.flush();
	}

}
