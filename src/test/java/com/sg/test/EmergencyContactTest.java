package com.sg.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.LoginPage;
import com.sg.utilities.DataUtils;

public class EmergencyContactTest extends WebDriverWrapper{
	
	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider")
	public void addValidEmergencyContactTest(String username,String password,String name,String relationship,String homeTelephone,String workTelephone,String mobile,String expectedValue)
	{
		LoginPage login = new LoginPage(driver);

		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();
		
		driver.findElement(By.linkText("My Info")).click();
		driver.findElement(By.partialLinkText("Emergency Con")).click();
		
		driver.findElement(By.id("btnAddContact")).click();
		driver.findElement(By.id("emgcontacts_name")).sendKeys(name);
		//fill remaining fields 
		
		//assert the added record in table
	}

}
