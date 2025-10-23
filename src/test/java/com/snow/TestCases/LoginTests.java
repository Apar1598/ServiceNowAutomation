package com.snow.TestCases;

import org.testng.annotations.Test;

import com.snow.base.InitiateDriver;
import com.snow.pages.Login;

public class LoginTests extends InitiateDriver {

	@Test(dataProvider = "loginData", dataProviderClass = com.snow.utilities.DataProviders.class)
	public void tc_001_verifyLoginfunctionality(String uname, String pass)
	{
		Login login=new Login(driver);
		login.enterUserName(uname);
		login.enterPassword(pass);
		login.clickLogin();
		login.verifyloginSuccessfull(uname,pass);
	}
}
