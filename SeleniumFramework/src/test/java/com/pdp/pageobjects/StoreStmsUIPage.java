package com.pdp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StoreStmsUIPage {	
	
	public WebElement tabHeader(WebDriver driver,String text) {
		return driver.findElement(By.xpath("//div[contains(@class,'tabs-header-tab') and (text()='"+text+"')]"));	
 }
	
	public WebElement gridHeader(WebDriver driver,String text) {
		return driver.findElement(By.xpath("//span[contains(@class,'heading') and (text()='"+text+"')]"));
 }
	
	public List<WebElement> gridLabel(WebDriver driver,String text) {
		return driver.findElements(By.xpath("//span[text()='"+text+"']/..//span[@class='font-bold']"));	
 }
	

	@FindBy(how=How.XPATH, using = "//button[@id='Btn_Search_Store']/i" )
	public WebElement linkSearch;
	
	@FindBy(how=How.XPATH, using = "//label[text()='Store Number']/..//span/input" )
	public WebElement inputStoreNo;
	
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'_0-TemporaryClosureItem')]//span[@class='font-bold']" )
	public List<WebElement> gridLabelTempClosr;
	
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'_0-OpeningHourItem')]//span[@class='font-bold']" )
	public List<WebElement> gridLabelOpeningHrs;
	
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'_0-GroupMembershipItem')]//span[@class='font-bold']" )
	public List<WebElement> gridLabelGroupmembr;
	
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'_0-OrgMembershipItem')]//span[@class='font-bold']" )
	public List<WebElement> gridLabelOrgmembr;
	
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'_0-ParameterItem')]//span[@class='font-bold']" )
	public List<WebElement> gridLabelParam;
	
	//--------------------------------------------------------------------------------------------------------------------------------
	
	
	public WebElement tabName(WebDriver driver,String text) {
		return driver.findElement(By.xpath("//div[@id='tabs']/a[@title='"+text+"']"));
	}	
		public WebElement buttonName(WebDriver driver,String text) {
			return driver.findElement(By.xpath("//input[@type='submit' and (@value='"+text+"')]"));	
 }
		
		public WebElement inputName(WebDriver driver,String text) {
			return driver.findElement(By.xpath("//input[@type='text' and (@id='"+text+"')]"));	
 }
		
		public WebElement radioRewardEvalutaion(WebDriver driver,String text) {
			return driver.findElement(By.xpath("//div[@id='discounteval']//label[text()='"+text+"']"));	
 }
		
		public WebElement desairedProductGroup(WebDriver driver,String text) {
			return driver.findElement(By.xpath("//select[@id='functionselect']//option[text()='"+text+"']"));	
 }
		
		public WebElement desairedStoreGroup(WebDriver driver,String text) {
			return driver.findElement(By.xpath("//select[@id='sgroups-available']//option[text()='"+text+"']"));	
 }
		
		public WebElement nameSubtab(WebDriver driver,String text) {
			return driver.findElement(By.xpath("//div[@id='subtabs']//a[text()='"+text+"']"));	
 }
		
		public WebElement nameTerminals(WebDriver driver,String text) {
			return driver.findElement(By.xpath("//select[@id='terminals-available']/option[text()='"+text+"']"));	
 }
		
		public WebElement valuePriority(WebDriver driver,String text) {
			return driver.findElement(By.xpath("//select[@id='priority']/option[@value='"+text+"']"));	
 }
		
		@FindBy(how=How.XPATH, using = "//textarea[@name='form_Description']" )
		public WebElement inputDesc;
		
		@FindBy(how=How.XPATH, using = "//input[@id='productionend']" )
		public WebElement inputProdEndDate;
		
		@FindBy(how=How.XPATH, using = "//input[@id='testingend']" )
		public WebElement inputTestEndDate;
		
		@FindBy(how=How.XPATH, using = "//div[@id='statusbar']" )
		public WebElement lableStatusBar;
		
		@FindBy(how=How.XPATH, using = "//input[@type='checkbox' and (@name = 'issuance')]" )
		public WebElement checkboxIssuence;
		
		@FindBy(how=How.XPATH, using = "//div[@id='subtabs']//a[@id='subtab5']" )
		public WebElement tabConditions;
		
		@FindBy(how=How.XPATH, using = "//input[@id='addGlobal' and (@value='Add')]" )
		public WebElement addGlobalCondtionButton;
		
		@FindBy(how=How.XPATH, using = "//input[@id='addglobal' and (@value='Add')]" )
		public WebElement addGlobalReward;
		
		@FindBy(how=How.XPATH, using = "//div[@id='cgList']//option[text()='Any Cardholder']" )
		public WebElement lnikAnyCardholder;
		
		@FindBy(how=How.XPATH, using = "//input[@type='button' and (@id='select1' )]" )
		public WebElement buttonSelect;
		
		@FindBy(how=How.XPATH, using = "//input[@type='button' and (@id='pselect' )]" )
		public WebElement buttonSelectReward;
		
		@FindBy(how=How.XPATH, using = "//input[@id='functioninput']" )
		public WebElement inputProductGroup;
		
		@FindBy(how=How.XPATH, using = "//input[@name='t1_limit']" )
		public WebElement inputQuantity;
		
		@FindBy(how=How.XPATH, using = "//input[@id='tier1_l1discountamt']" )
		public WebElement inputDiscountAmount;
		
		@FindBy(how=How.XPATH, using = "//input[@id='tier1_rdesc']" )
		public WebElement inputReceiptText;
		
		@FindBy(how=How.XPATH, using = "//input[@id='terminals-add1']" )
		public WebElement buttonTerminalSelect;
		
		@FindBy(how=How.XPATH, using = "//input[@id='stores-add1']" )
		public WebElement buttonStoreSelect;
		
		
}
