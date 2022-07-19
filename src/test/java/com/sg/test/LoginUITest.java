package com.sg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
	
public class LoginUITest extends WebDriverWrapper {
	
	@Test
	public void verifyTitleTest()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	
}
