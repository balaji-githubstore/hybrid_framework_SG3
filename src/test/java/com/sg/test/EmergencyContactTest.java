package com.sg.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
import com.sg.utilities.DataUtils;

public class EmergencyContactTest extends WebDriverWrapper{
	
	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider")
	public void addValidEmergencyContactTest(String username,String password,String name,String relationship,String homeTelephone,String workTelephone,String mobile,String expectedValue)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("[name='Submit']")).click();
		driver.findElement(By.linkText("My Info")).click();
		driver.findElement(By.partialLinkText("Emergency Con")).click();
		
		driver.findElement(By.id("btnAddContact")).click();
		driver.findElement(By.id("emgcontacts_name")).sendKeys(name);
		//fill remaining fields 
		
		//assert the added record in table
	}

}
