package com.snow.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.snow.base.InitiateDriver;

public class IncidentVerifications extends InitiateDriver {

	public static boolean elementVisibility(String xpath)
	{
		Boolean status=driver.findElement(By.xpath(xpath)).isDisplayed();
		return status;
	}
	
	public static String verifyFieldValue(String xpath)
	{
		String fieldvalue=driver.findElement(By.xpath(xpath)).getAttribute("value");
		return fieldvalue;
	}
	
	public static String verifyDropdownFieldValue(String xpath)
	{
		Select s1=new Select(driver.findElement(By.xpath(xpath)));
		String value=s1.getFirstSelectedOption().getText();
		return value;
	}
}
