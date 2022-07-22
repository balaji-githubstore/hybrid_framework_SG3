package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private By usernameLocator = By.id("txtUsername");
	private By passwordLocator = By.cssSelector("#txtPassword");
	private By loginLocator = By.cssSelector("[name='Submit']");
	private By errorLocator = By.id("spanMessage");
	private By linkedinLocator = By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
	
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(loginLocator).click();
	}

	public String getInvalidErrorMessage() {
		return driver.findElement(errorLocator).getText();
	}

	public void clickOnLinkedin() {
		driver.findElement(linkedinLocator).click();
	}
}
