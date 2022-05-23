package com.pdp.test;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.pdp.pageobjects.GetOperation_PageActions;
import com.pdp.pageobjects.OutSystemLoginPage;
import com.pdp.utilities.ActionMethods;
import com.pdp.utilities.Constant;
import com.pdp.utilities.ExceptionHandler;
import com.pdp.utilities.Log;
import com.pdp.utilities.PropertiesFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginFunction {
	
	
	ActionMethods user=new ActionMethods();
	Constant constant = new Constant();
	WebDriver driver = SetUp.driver;
	public static Properties data =	null;
	OutSystemLoginPage loginpageobj=SetUp.loginpageobj;
	
	@Given("^Login Page of UI Loads Sucessfully$")
	public void google_page_loads() throws Throwable{
		try {
			//data = PropertiesFile.readPropertiesFile(constant.propertyFileName);
			data = PropertiesFile.readPropertiesFile();
			
			System.out.println("url: "+data.getProperty(constant.TestURLUI));
			driver.get(data.getProperty(constant.TestURLUI));			
			Log.info(constant.homepageText +" loaded successfully");	
				
	}catch(Exception e) {
		ExceptionHandler.handler(e, "Login Page");	
	}
  }
	
	@Then("^User is login with valid \"([^\"]*)\" and \"([^\"]*)\" to the application$")
	public void login_with_valid_credantial(String UserId, String Password) throws Throwable{
		try {
			Thread.sleep(3000);
			user.sync(driver, loginpageobj.userid);	
			user.type(loginpageobj.userid, UserId);
			Thread.sleep(2000);
			user.sync(driver, loginpageobj.userPass);	
			user.type(loginpageobj.userPass, Password);
			Thread.sleep(2000);
			user.sync(driver, loginpageobj.buttonLogin);
			user.click(loginpageobj.buttonLogin);			
			Thread.sleep(2000);
				
	}catch(Exception e) {
		ExceptionHandler.handler(e, "Login Page");	
	}
  }
}

