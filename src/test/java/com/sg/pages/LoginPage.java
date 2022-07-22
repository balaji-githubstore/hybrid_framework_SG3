package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private static By usernameLocator = By.id("txtUsername");
	private static By passwordLocator = By.cssSelector("#txtPassword");
	private static By loginLocator = By.cssSelector("[name='Submit']");
	private static By errorLocator = By.id("spanMessage");
	private static By linkedinLocator = By.xpath("//img[@alt='LinkedIn OrangeHRM group']");

	public static void enterUsername(WebDriver driver, String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public static void enterPassword(WebDriver driver, String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public static void clickOnLogin(WebDriver driver) {
		driver.findElement(loginLocator).click();
	}

	public static String getInvalidErrorMessage(WebDriver driver) {
		return driver.findElement(errorLocator).getText();
	}

	public static void clickOnLinkedin(WebDriver driver) {
		driver.findElement(linkedinLocator).click();
	}
}
