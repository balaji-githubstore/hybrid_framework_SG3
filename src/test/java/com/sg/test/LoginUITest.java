package com.sg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;

public class LoginUITest extends WebDriverWrapper {

	@Test(groups = { "low" ,"positive"})
	public void verifyTitleTest() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

}
