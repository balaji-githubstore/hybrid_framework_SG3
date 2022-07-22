package com.sg.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sg.base.WebDriverWrapper;
import com.sg.pages.LoginPage;
import com.sg.pages.MainPage;
import com.sg.utilities.DataUtils;
	
public class LoginTest extends WebDriverWrapper {

	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider", groups = { "positive", "high" })
	public void validCredentialTest(String username, String password, String expectedUrl) {
		
		LoginPage login = new LoginPage(driver);
		
		login.enterUsername(username);
		test.log(Status.INFO, "Entered Username: " + username);

		login.enterPassword(password);
		test.log(Status.INFO, "Entered password: " + password);

		login.clickOnLogin();
		test.log(Status.INFO, "Clicked on login");

		// wait for some element in that new page present
		
		MainPage main=new MainPage(driver);
		String actualUrl = main.getMainPageUrl();
		test.log(Status.INFO, "actualUrl=" + actualUrl);

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(dataProviderClass = DataUtils.class, dataProvider = "commonDataProvider", groups = { "negative", "low" })
	public void invalidCredentialTest(String username, String password, String expectedError) {

		LoginPage login = new LoginPage(driver);
				
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();

		String actualError = login.getInvalidErrorMessage();
		Assert.assertEquals(actualError, expectedError);
	}

}
