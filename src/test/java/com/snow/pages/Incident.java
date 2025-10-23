package com.snow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.snow.assertions.IncidentVerifications;
import com.snow.assertions.LoginVerification;
import com.snow.utilities.PageActions;
import com.snow.utilities.PropertyReader;

public class Incident {
	
	WebDriver driver=null;
	PageActions action;
	
	SoftAssert sa1=new SoftAssert();
	
	public Incident(WebDriver driver)
	{
		this.driver=driver;
		action=new PageActions(driver);
	}
	
	public void loginSnow()
	{
		driver.get(PropertyReader.configReader("Snow_URL"));
		
		action.enterDataintoField(driver.findElement(By.xpath
				(PropertyReader.elementReader("login_uname_xpath"))), 
				                 PropertyReader.configReader("Snow_Uname"));
		
		action.enterDataintoField(driver.findElement(By.xpath
				(PropertyReader.elementReader("login_pass_xpath"))), 
				                 PropertyReader.configReader("Snow_Password"));
		
		action.clickElement(driver.findElement(By.xpath(PropertyReader.elementReader("login_showpass_xpath"))));
		
		action.clickElement(driver.findElement(By.xpath(PropertyReader.elementReader("login_submit_xpath"))));
		
		sa1.assertEquals(LoginVerification.verifyVisibilityofElement
				(PropertyReader.elementReader("home_loginproof_xpath")), true);
	}
	public void openIncidentList()
	{
		driver.get(PropertyReader.configReader("Inc_URL"));
	}
	
	public void clickNewButton()
	{
		action.clickElement(driver.findElement(By.xpath(PropertyReader.elementReader("Inc_New_xpath"))));
	}
	
	public void verifySubmitButtonsVisibility()
	{
		sa1.assertEquals(IncidentVerifications.elementVisibility
				(PropertyReader.elementReader("Inc_submit_xpath")), true);
		sa1.assertAll();
	}
	public void verifyResolveButtonsVisibility()
	{
		sa1.assertEquals(IncidentVerifications.elementVisibility
				(PropertyReader.elementReader("Inc_Resolve_xpath")), true);
		sa1.assertAll();
	}
	public void clickSubmitBeforeFillingFields()
	{
		action.clickElement(driver.findElement(By.xpath(PropertyReader.elementReader("Inc_submit_xpath"))));
	}
	public void verifyValidationMessage()
	{
		sa1.assertEquals(IncidentVerifications.elementVisibility
				(PropertyReader.elementReader("Inc_Submit_button_validation")), true);
		sa1.assertAll();
	}
	public void setFieldValues(String Impact, String Urgency, String Category, String subcategory, String caller, String ShortDescription, String Channel, String group) throws InterruptedException
	{
		action.enterDataintoField(driver.findElement
				(By.xpath(PropertyReader.elementReader("Inc_SD_xpath"))), ShortDescription);
		
		action.selectValueFromDropdown(driver.findElement(By.xpath(PropertyReader.elementReader("Inc_Category_xpath"))), Category);
		action.selectValueFromDropdown(driver.findElement(By.xpath(PropertyReader.elementReader("Inc_SubCategory_xpath"))), subcategory);
		action.selectValueFromDropdown(driver.findElement(By.xpath(PropertyReader.elementReader("Inc_Channel_xpath"))), Channel);
		action.selectValueFromDropdown(driver.findElement(By.xpath(PropertyReader.elementReader("Inc_Impact_xpath"))), Impact);
		action.selectValueFromDropdown(driver.findElement(By.xpath(PropertyReader.elementReader("Inc_Urgency_xpath"))), Urgency);
		
		action.enterDataintoField(driver.findElement
				(By.xpath(PropertyReader.elementReader("Inc_caller_xpath"))), caller);
		action.enterDataintoField(driver.findElement(By.xpath(PropertyReader.elementReader("Inc_group_xpath"))), group);
		Thread.sleep(5000);
	}
	
	public void incSubmissionAndOpen() throws InterruptedException
	{
		String IncNumber=action.getElementValue(driver.findElement(By.xpath(PropertyReader.elementReader("Inc_number_xpath"))));
		System.out.println(IncNumber);
		
		action.clickElement(driver.findElement(By.xpath(PropertyReader.elementReader("Inc_submit_xpath"))));
		
		driver.findElement(By.xpath("//a[contains(text(),'" + IncNumber + "')]")).click();
		Thread.sleep(5000);
	}
	
	public void verifyIncFieldValuesAfterSubmission(String Impact, String Urgency, String priority, String Category, String subcategory, String caller, String ShortDescription, String Channel, String group)
	{
		sa1.assertEquals(IncidentVerifications.verifyDropdownFieldValue(PropertyReader.elementReader("Inc_Category_xpath")), Category);
		sa1.assertEquals(IncidentVerifications.verifyDropdownFieldValue(PropertyReader.elementReader("Inc_SubCategory_xpath")), subcategory);
		sa1.assertEquals(IncidentVerifications.verifyDropdownFieldValue(PropertyReader.elementReader("Inc_Channel_xpath")), Channel);
		sa1.assertEquals(IncidentVerifications.verifyDropdownFieldValue(PropertyReader.elementReader("Inc_State_xpath")), "New");
		sa1.assertEquals(IncidentVerifications.verifyDropdownFieldValue(PropertyReader.elementReader("Inc_Impact_xpath")), Impact);
		sa1.assertEquals(IncidentVerifications.verifyDropdownFieldValue(PropertyReader.elementReader("Inc_Urgency_xpath")), Urgency);
		sa1.assertEquals(IncidentVerifications.verifyDropdownFieldValue(PropertyReader.elementReader("Inc_Priority_xpath")), priority);
		
		
		sa1.assertEquals(IncidentVerifications.verifyFieldValue(PropertyReader.elementReader("Inc_SD_xpath")), ShortDescription);
		sa1.assertEquals(IncidentVerifications.verifyFieldValue(PropertyReader.elementReader("Inc_caller_xpath")), caller);
		sa1.assertEquals(IncidentVerifications.verifyFieldValue(PropertyReader.elementReader("Inc_group_xpath")), group);
		
		sa1.assertAll();
	}
	
}
