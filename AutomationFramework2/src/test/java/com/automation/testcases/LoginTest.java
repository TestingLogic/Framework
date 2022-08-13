package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utility.BrowserFactory;
import com.automation.utility.ExcelDataProvider;

public class LoginTest extends BaseClass{


	//WebDriver driver;
	
	
	
	
	@Test(priority=2)
	public void loginApp()
	{
		logger=report.createTest("Login to CRM Application");
		
		
		excel.getStringData("Login",0,0);
		LoginPage loginPage=PageFactory.initElements(driver,LoginPage.class);
		
		logger.info("Starting application");
		
		loginPage.loginToCRM(excel.getStringData("Login",0,0),excel.getStringData("Login",0,1));
		
		logger.pass("Login successfull");
		
	}
	
	@Test(priority=1)
	public void loginApp1()
	{
		
		
		logger=report.createTest("Login to CRM Application");
		
		
		logger.fail("Login unsuccessfull");
		
	}
	
	

}
