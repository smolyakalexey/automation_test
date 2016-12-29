package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;

import org.openqa.selenium.WebDriver;

import com.epam.ta.pages.LoginPage;

public class Steps
{
	private WebDriver driver;

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		driver.quit();
	}

	public void loginBehance(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

}
