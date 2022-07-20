package com.sg.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sg.base.WebDriverWrapper;
import com.sg.utilities.DataUtils;
	
public class LoginTest extends WebDriverWrapper {

	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider",groups = {"positive","high"})
	public void validCredentialTest(String username,String password,String expectedUrl) {

		driver.findElement(By.id("txtUsername")).sendKeys(username);
		test.log(Status.INFO, "Entered Username: "+username);
		
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
		test.log(Status.INFO, "Entered password: "+password);
		
		driver.findElement(By.cssSelector("[name='Submit']")).click();
		test.log(Status.INFO, "Clicked on login");

		// wait for some element in that new page present
		
		String actualUrl = driver.getCurrentUrl();
		test.log(Status.INFO, "actualUrl="+actualUrl);
		
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider",groups = {"negative","low"})
	public void invalidCredentialTest(String username, String password, String expectedError) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("[name='Submit']")).click();

		String actualError = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(actualError, expectedError);
	}

}
