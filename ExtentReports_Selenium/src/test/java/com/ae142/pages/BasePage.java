package com.ae142.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	@SuppressWarnings("deprecation")
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//putting an implicit wait
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
	//Implementing Click Method
	public void click(By by)
	{
		waitVisibility(by).click();
	}
	
	//Write Text
    public void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }
    
    //Read Text
    public String readText(By by) {
        return waitVisibility(by).getText();
    }
    
    //Wait
    public WebElement waitVisibility(By by) {
    	// this returns a null object
    	@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,30);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    	
    }

}
