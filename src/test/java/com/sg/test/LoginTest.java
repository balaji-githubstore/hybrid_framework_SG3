package com.sg.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.sg.base.WebDriverWrapper;
import com.sg.pages.LoginPage;
import com.sg.pages.MainPage;
import com.sg.utilities.DataUtils;
	
public class LoginTest extends WebDriverWrapper {

	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider",groups = {"positive","high"})
	public void validCredentialTest(String username,String password,String expectedUrl) {

		LoginPage.enterUsername(driver, username);
		test.log(Status.INFO, "Entered Username: "+username);
		
		LoginPage.enterPassword(driver, password);
		test.log(Status.INFO, "Entered password: "+password);
		
		LoginPage.clickOnLogin(driver);
		test.log(Status.INFO, "Clicked on login");

		// wait for some element in that new page present
		
		String actualUrl = MainPage.getMainPageUrl(driver);
		test.log(Status.INFO, "actualUrl="+actualUrl);
		
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider",groups = {"negative","low"})
	public void invalidCredentialTest(String username, String password, String expectedError) {
		
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLogin(driver);

		String actualError = LoginPage.getInvalidErrorMessage(driver);
		Assert.assertEquals(actualError, expectedError);
	}

}
