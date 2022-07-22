package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

	private By myInfoLocator=By.partialLinkText("My Info");
	
	private WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String getMainPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public void clickOnMyInfo()
	{
		driver.findElement(myInfoLocator).click();
	}
}
