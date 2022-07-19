package com.sg.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

	
	@DataProvider
	public Object[][] invalidCredentialData()
	{
		Object[][] main=new Object[2][3];
		
		main[0][0]="Peter";
		main[0][1]="Peter123";
		main[0][2]="Invalid credentials";
		
		main[1][0]="john";
		main[1][1]="john123";
		main[1][2]="Invalid credentials";
		
		return main;
	}
	
	@Test(dataProvider = "invalidCredentialData")
	public void invalidCredentialTest(String username,String password,String expectedError) {
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("[name='Submit']")).click();

		String actualError = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(actualError, expectedError);
	}

}
