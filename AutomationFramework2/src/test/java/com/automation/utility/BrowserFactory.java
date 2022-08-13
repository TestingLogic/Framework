package com.automation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver,String browserName,String appURL)
	{
		if(browserName.equals("Chrome"))

		{

			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}

		else if(browserName.equals("Firefox"))
		{
		}
		else if(browserName.equals("IE"))
		{
		}
		else
		{

			System.out.println("We do not support");
		}

		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		return driver;

	}

	public static void closeApplication(WebDriver driver) {
		driver.quit();

	}
}