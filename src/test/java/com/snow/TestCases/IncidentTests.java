package com.snow.TestCases;

import org.testng.annotations.Test;

import com.snow.base.InitiateDriver;
import com.snow.pages.Incident;

public class IncidentTests extends InitiateDriver {

	@Test(dataProvider="Incident data", dataProviderClass = com.snow.utilities.DataProviders.class)
	public void verifyIncidentProcess(String Impact, String Urgency, String priority, String Category, String subcategory, String caller, String ShortDescription, String Channel, String group) throws InterruptedException
	{
		Incident inc=new Incident(driver);
		inc.loginSnow();
		inc.openIncidentList();
		inc.clickNewButton();
		inc.verifySubmitButtonsVisibility();
		inc.verifyResolveButtonsVisibility();
		inc.clickSubmitBeforeFillingFields();
		inc.verifyValidationMessage();
		inc.setFieldValues(Impact,Urgency,Category,subcategory,caller,ShortDescription,Channel,group);
		inc.incSubmissionAndOpen();
		inc.verifyIncFieldValuesAfterSubmission(Impact,Urgency,priority,Category,subcategory,caller,ShortDescription,Channel,group);
	}
}
