package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sg.base.WebDriverKeywords;

public class LoginPage extends WebDriverKeywords {
	private By usernameLocator = By.id("txtUsername");
	private By passwordLocator = By.cssSelector("#txtPassword");
	private By loginLocator = By.cssSelector("[name='Submit']");
	private By errorLocator = By.id("spanMessage");
	private By linkedinLocator = By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
	
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterUsername(String username) {
		typeUsingLocator(usernameLocator, username);
	}

	public void enterPassword(String password) {
		typeUsingLocator(passwordLocator, password);
	}

	public void clickOnLogin() {
		super.clickUsingLocator(loginLocator);
	}

	public String getInvalidErrorMessage() {
		return super.getTextUsingLocator(errorLocator);
	}

	public void clickOnLinkedin() {
		driver.findElement(linkedinLocator).click();
	}
}
