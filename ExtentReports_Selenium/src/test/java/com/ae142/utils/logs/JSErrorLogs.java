package com.ae142.utils.logs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

public class JSErrorLogs {
	
	public static LogEntries getLogs(WebDriver driver)
	{
		return driver.manage().logs().get(LogType.BROWSER);
	}
	
	public static void log(String message)
	{
		System.out.println(message);
	}
	
	
	public static Boolean isLoginErrorLog(WebDriver driver)
	{
		/*
		Logs log = driver.manage().logs();
		if(log != null)
		{
			LogEntries logEntries = log.get(LogType.BROWSER);
			
			for(LogEntry logEntry:logEntries)
			{
				log(logEntry.getMessage()+"\n");
			}
		    
			return logEntries.getAll().stream()
					.anyMatch(logEntry -> logEntry.getMessage().contains("Epic sadface: Username and password do not match any user in this service"));
			// issue with the last line is resolved by changing project compliance to JAVA SE 1.8
		}
		
		else
		{
			System.out.println("Logs are empty");
			return false;
		}
				//.get(LogType.BROWSER);
		*/
		
		if((driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[3]/h3")).isDisplayed()))
		{
			return true;
		}
		
		else
			return false;
		
		
		
		
	}
	
	

}
