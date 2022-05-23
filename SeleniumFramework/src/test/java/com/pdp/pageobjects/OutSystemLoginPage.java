package com.pdp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OutSystemLoginPage {
	
	/*@FindBy(how=How.XPATH, using = "//input[@id='Input_UsernameVal']" )
	public WebElement userid;
	
	@FindBy(how=How.XPATH, using = "//input[@id='Input_PasswordVal']" )
	public WebElement userPass;
	
	@FindBy(how=How.XPATH, using = "//button[@type='submit']//div[text()='Login']" )
	public WebElement buttonLogin;*/
	
	
	@FindBy(how=How.XPATH, using = "//input[@id='username']" )
	public WebElement userid;
	
	@FindBy(how=How.XPATH, using = "//input[@id='password']" )
	public WebElement userPass;
	
	@FindBy(how=How.XPATH, using = "//input[@id='btnSubmit']" )
	public WebElement buttonLogin;

	
	
}
