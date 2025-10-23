package com.snow.utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {
	
	public static void screenshot(WebDriver driver,String name)
	{
		try
		{
		TakesScreenshot  s1=(TakesScreenshot)driver;
		File source=s1.getScreenshotAs(OutputType.FILE);
		File destination=new File("./src/test/resources/Screenshots/"+name+System.currentTimeMillis()+".png");
		FileHandler.copy(source, destination);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
