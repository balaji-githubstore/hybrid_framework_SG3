package com.sg.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;

public class LoginTest extends WebDriverWrapper {

	@Test
	public void validCredentialTest() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");
		driver.findElement(By.cssSelector("[name='Submit']")).click();

		// wait for some element in that new page present

		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}

	//create a dataprovider - invalidCredentialData
		//Peter,Peter123, Invalid credentials
//	john,john123, Invalid credentials
	
	@Test
	public void invalidCredentialTest(String username,String password,String expectedError) {
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("[name='Submit']")).click();

		String actualError = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(actualError, expectedError);
	}

}
