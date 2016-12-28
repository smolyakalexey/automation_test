package com.epam.ta.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://adobeid-na1.services.adobe.com/renga-idprovider/pages/login?callback=https%3A%2F%2Fims-na1.adobelogin.com%2Fims%2Fadobeid%2FBehanceWebSusi1%2FAdobeID%2Ftoken%3Fredirect_uri%3Dhttps%253A%252F%252Fwww.behance.net%252F%253Fisa0%253D1%2523from_ims%253Dtrue%2526old_hash%253D%2526api%253Dauthorize%26state%3D%257B%2522ac%2522%253A%2522behance.net%2522%257D&client_id=BehanceWebSusi1&scope=AdobeID%2Copenid%2Cgnav%2Csao.cce_private%2Ccreative_cloud%2Ccreative_sdk%2Cbe.pro2.external_client%2Cadditional_info.roles&denied_callback=https%3A%2F%2Fims-na1.adobelogin.com%2Fims%2Fdenied%2FBehanceWebSusi1%3Fredirect_uri%3Dhttps%253A%252F%252Fwww.behance.net%252F%253Fisa0%253D1%2523from_ims%253Dtrue%2526old_hash%253D%2526api%253Dauthorize%26response_type%3Dtoken%26state%3D%257B%2522ac%2522%253A%2522behance.net%2522%257D&display=web_v2&state=%7B%22ac%22%3A%22behance.net%22%7D&relay=ef21baa5-364e-4b1f-8193-fb3c57fb2054&locale=en_US&flow_type=token&client_redirect=https%3A%2F%2Fims-na1.adobelogin.com%2Fims%2Fredirect%2FBehanceWebSusi1%3Fclient_redirect%3Dhttps%253A%252F%252Fwww.behance.net%252F%253Fisa0%253D1%2523from_ims%253Dtrue%2526old_hash%253D%2526api%253Dauthorize%26state%3D%257B%2522ac%2522%253A%2522behance.net%2522%257D&idp_flow_type=login";

	@FindBy(id = "adobeid_username")
	private WebElement inputLogin;

	@FindBy(id = "adobeid_password")
	private WebElement inputPassword;

	@FindBy(id = "sign_in")
	private WebElement buttonSubmit;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void login(String username, String password)
	{
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
		logger.info("Login performed");
	}


}
