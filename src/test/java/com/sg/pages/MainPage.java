package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

	private static By myInfoLocator=By.partialLinkText("My Info");
	
	public static String getMainPageUrl(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	
	public static void clickOnMyInfo(WebDriver driver)
	{
		driver.findElement(myInfoLocator).click();
	}
}
