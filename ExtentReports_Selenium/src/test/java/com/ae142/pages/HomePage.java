package com.ae142.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ae142.utils.logs.Log;
import com.ae142.pages.BasePage;


public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	String baseUrl = "https://www.saucedemo.com/";
	
	//By loginInButton = By.id("login-button");
	
	//private static Logger logger = Logger.getLogger(HomePage.class.getName());
	
	public HomePage goToSauceDemo()
	{
		Log.info("Going to SauceDemo");
		driver.get(baseUrl);
		
		return this;
	}
	
	
	public LoginPage goToLoginPage()
	{
		Log.info("Going to Login Page");
		//super.click(signInButtonClass);
		return new LoginPage(driver);
	}
	
	
	
	
	
}
