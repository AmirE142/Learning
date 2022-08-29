package com.ae142.tests;

import java.lang.reflect.Method;

import org.testng.annotations.Test;
import com.ae142.utils.extentreports.*;

public class LoginTests extends BaseTest {
	
  @Test(priority=0,description ="Invalid Login Scenario with wrong username")
  public void invalidLoginTest_InvalidUserNameInvalidPassword(Method method)
  {
	  
	  ExtentTestManager.startTest(method.getName(), "Invalid Login Scenario with invalid credentials");
	  homePage
	  .goToSauceDemo()
	  .goToLoginPage()
	  .loginToSauce("standad_user", "secret_sauce")
	  .verifyLogError();  
  }
  
  @Test(priority=1, description="Invalid Login Scenario with empty credentials")
  public void invalidLoginTest_EmptyUserEmptyPassword(Method method)
  {
	  ExtentTestManager.startTest(method.getName(), "Invalid Login Scenario with empty creds");
	  homePage
	  .goToSauceDemo()
	  .goToLoginPage()
	  .loginToSauce("","")
	  .verifyLoginUserName("std_user")
	  .verifyLoginPassword("scrt_sauce");
  }
}
