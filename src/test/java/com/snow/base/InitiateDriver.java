package com.snow.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.snow.utilities.CaptureScreenshot;
import com.snow.utilities.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitiateDriver {
	
	public static WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setup(String br)
	{
		if(br.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		else if(br.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.get(PropertyReader.configReader("Snow_URL"));
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			String testname=result.getName();
			CaptureScreenshot.screenshot(driver, testname);
		}
		if(driver!=null)
		{
		driver.quit();
		}
	}
}
