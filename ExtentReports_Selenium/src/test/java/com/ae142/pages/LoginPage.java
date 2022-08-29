package com.ae142.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ae142.utils.logs.JSErrorLogs;
import com.ae142.utils.logs.Log;
//import com.ae142.pages.HomePage;
public class LoginPage extends BasePage {
	
	//private static Logger logger = Logger.getLogger(HomePage.class.getName());
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	By userNameId = By.id("user-name");
	By passwordId = By.id("password");
	By loginButtonId = By.id("login-button");
	By errorMessageUserNameXpath = By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[3]/h3");
	By errorMessagePasswordXpath = By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[3]/h3");
	
	public LoginPage loginToSauce(String username,String password)
	{
		Log.info("Trying to log into SauceDemo");
		writeText(userNameId, username);
		writeText(passwordId, password);
		click(loginButtonId);
		return this;
	}
	
	public LoginPage verifyLoginUserName(String expectedText) {
        Log.info("Verifying login username.");
        waitVisibility(errorMessageUserNameXpath);
        assertEquals(readText(errorMessageUserNameXpath), expectedText);
        return this;
    }
	
	public LoginPage verifyLoginPassword(String expectedText)
	{
		Log.info("Verifying login password");
		waitVisibility(errorMessagePasswordXpath);
		assertEquals(readText(errorMessagePasswordXpath),expectedText );
		return this;
	}
	
	public LoginPage verifyLogError() {
        Log.info("Verifying javascript login errors.");
        //I got an Assertion Error because apparently it is false
        assertTrue(JSErrorLogs.isLoginErrorLog(driver));
        return this;
    }
}
