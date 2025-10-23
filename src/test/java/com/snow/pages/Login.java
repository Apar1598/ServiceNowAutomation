package com.snow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.snow.assertions.LoginVerification;
import com.snow.utilities.PageActions;
import com.snow.utilities.PropertyReader;

public class Login {
	
	WebDriver driver=null;
	PageActions action;
	SoftAssert sa1=new SoftAssert();
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		action=new PageActions(driver);
	}
	
	public void enterUserName(String uname)
	{
		action.enterDataintoField(driver.findElement
				(By.xpath(PropertyReader.elementReader("login_uname_xpath"))), 
				                                      uname);
	}
	public void enterPassword(String pass)
	{
		action.enterDataintoField(driver.findElement
				(By.xpath(PropertyReader.elementReader("login_pass_xpath"))), 
				                                        pass);
	}
	public void clickLogin()
	{
		action.clickElement(driver.findElement(By.xpath(PropertyReader.elementReader("login_submit_xpath"))));
	}
	public void verifyloginSuccessfull(String uname, String pass)
	{
		if(uname.equals(PropertyReader.configReader("Snow_Uname"))&&pass.equals(PropertyReader.configReader("Snow_Password")))
		{
			sa1.assertEquals(LoginVerification.verifyVisibilityofElement
					(PropertyReader.elementReader("home_loginproof_xpath")), true);
		}
		else
		{
			sa1.assertEquals(LoginVerification.verifyVisibilityofElement
					(PropertyReader.elementReader("login_errormsg_xpath")), true);
		}
		sa1.assertAll();
	}
}
