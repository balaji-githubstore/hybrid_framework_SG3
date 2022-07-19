package com.sg.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
import com.sg.utilities.DataUtils;
	
public class LoginTest extends WebDriverWrapper {

	@Test(dataProviderClass = DataUtils.class,dataProvider = "validCredentialData")
	public void validCredentialTest(String username,String password,String expectedUrl) {

		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("[name='Submit']")).click();

		// wait for some element in that new page present

		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(dataProviderClass = DataUtils.class,dataProvider = "invalidCredentialData")
	public void invalidCredentialTest(String username, String password, String expectedError) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("[name='Submit']")).click();

		String actualError = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(actualError, expectedError);
	}

}
