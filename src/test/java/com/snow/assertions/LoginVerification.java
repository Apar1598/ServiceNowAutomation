package com.snow.assertions;
import org.openqa.selenium.By;

import com.snow.base.InitiateDriver;

public class LoginVerification extends InitiateDriver {

	public static boolean verifyVisibilityofElement(String xpath)
	
	{
		Boolean element=true;
		element=driver.findElement(By.xpath(xpath)).isDisplayed();
		
		return element;
	}
}
