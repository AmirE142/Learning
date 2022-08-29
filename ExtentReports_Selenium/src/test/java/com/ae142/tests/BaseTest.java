package com.ae142.tests;



import com.ae142.pages.HomePage;
import com.ae142.utils.logs.Log;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {
	public WebDriver driver;
	public HomePage homePage;
	
	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_104\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
  @BeforeMethod
  public void methodLevelSetup() {
	  homePage = new HomePage(driver);
  }

  @BeforeClass
  public void classLevelSetup() {
	  Log.info("Test is starting!");
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_104\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
  }

  @AfterClass
  public void teardown() {
	  Log.info("Tests are ending!");
	  driver.quit();
  }

}
