package com.pdp.test;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pdp.pageobjects.OutSystemLoginPage;
import com.pdp.pageobjects.StoreStmsUIPage;
import com.pdp.utilities.ActionMethods;
import com.pdp.utilities.Constant;
import com.pdp.utilities.ExceptionHandler;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class StmsStoreUIValidation {
	ActionMethods user=new ActionMethods();
	Constant constant = new Constant();
	WebDriver driver = SetUp.driver;
	public static Properties data =	null;
	OutSystemLoginPage loginpageobj=SetUp.loginpageobj;
	StoreStmsUIPage storeuiobj=SetUp.storeuiobj;
	
	@Then("^Enter the value of \"([^\"]*)\" to Store Number input field$")
	public void login_with_valid_credantial(String StoreNo) throws Throwable{
		try {
			Thread.sleep(3000);
			user.sync(driver, storeuiobj.inputStoreNo);	
			user.type(storeuiobj.inputStoreNo, StoreNo);
			Thread.sleep(2000);
				
	}catch(Exception e) {
		throw e;
	}
  }
	
	@Then("^Click on search icon link$")
	public void click_search_icon() throws Throwable{
		try {
						
			user.sync(driver, storeuiobj.linkSearch);
			user.click(storeuiobj.linkSearch);			
			Thread.sleep(2000);
				
	}catch(Exception e) {
		throw e;
	}
  }
	
	@Then("^Click on \"([^\"]*)\" tab header$")
	public void click_tab_header(String tabHeader) throws Throwable{
		try {
						
			user.sync(driver, storeuiobj.tabHeader(driver, tabHeader));
			user.click(storeuiobj.tabHeader(driver, tabHeader));			
			Thread.sleep(2000);
				
	}catch(Exception e) {
		throw e;
	}
  }
	
	@Then("^Validate for \"([^\"]*)\" grid following lebels are getting populated$")
	public void validate_labels_for_grid(String gridHeader,DataTable value) throws Throwable{
		try {
			List<List<String>> col = value.asLists();
			
			for (int list = 0;list<storeuiobj.gridLabel(driver, gridHeader).size();list++) {
				
				String labelText = user.getElementText(storeuiobj.gridLabel(driver, gridHeader).get(list));
				String colValue = col.get(list).get(0).trim();
				System.out.println(labelText);
				System.out.println(colValue);
				Assert.assertTrue(labelText.contains(colValue));				
			}
			
				
	}catch(Exception e) {
		throw e;
	}
  }
	
	@Then("^Validate for grid following lebels are getting populated for Temp Closr$")
	public void validate_labels_for_grid_tempclosr(DataTable value) throws Throwable{
		try {
			List<List<String>> col = value.asLists();
			
			for (int list = 0;list<storeuiobj.gridLabelTempClosr.size();list++) {
				
				String labelText = user.getElementText(storeuiobj.gridLabelTempClosr.get(list));
				String colValue = col.get(list).get(0).trim();
				System.out.println(labelText);
				System.out.println(colValue);
				Assert.assertTrue(labelText.contains(colValue));				
			}
			
				
	}catch(Exception e) {
		throw e;
	}
  }
	
	@Then("^Validate for grid following lebels are getting populated for Opening Hrs$")
	public void validate_labels_for_grid_openinghrs(DataTable value) throws Throwable{
		try {
			List<List<String>> col = value.asLists();
			
			for (int list = 0;list<storeuiobj.gridLabelOpeningHrs.size();list++) {
				
				String labelText = user.getElementText(storeuiobj.gridLabelOpeningHrs.get(list));
				String colValue = col.get(list).get(0).trim();
				System.out.println(labelText);
				System.out.println(colValue);
				Assert.assertTrue(labelText.contains(colValue));				
			}
			
	}catch(Exception e) {
		throw e;
	}
	}
		
		@Then("^Validate for grid following lebels are getting populated for Group membership$")
		public void validate_labels_for_grid_group_membr(DataTable value) throws Throwable{
			try {
				List<List<String>> col = value.asLists();
				
				for (int list = 0;list<storeuiobj.gridLabelGroupmembr.size();list++) {
					
					String labelText = user.getElementText(storeuiobj.gridLabelGroupmembr.get(list));
					String colValue = col.get(list).get(0).trim();
					System.out.println(labelText);
					System.out.println(colValue);
					Assert.assertTrue(labelText.contains(colValue));				
				}
				
					
		}catch(Exception e) {
			throw e;
		}
  }
		
		@Then("^Validate for grid following lebels are getting populated for Org membership$")
		public void validate_labels_for_grid_org_membr(DataTable value) throws Throwable{
			try {
				List<List<String>> col = value.asLists();
				
				for (int list = 0;list<storeuiobj.gridLabelOrgmembr.size();list++) {
					
					String labelText = user.getElementText(storeuiobj.gridLabelOrgmembr.get(list));
					String colValue = col.get(list).get(0).trim();
					System.out.println(labelText);
					System.out.println(colValue);
					Assert.assertTrue(labelText.contains(colValue));				
				}
				
					
		}catch(Exception e) {
			throw e;
		}
  }
		
		@Then("^Validate for grid following lebels are getting populated for Parameters$")
		public void validate_labels_for_grid_parameters(DataTable value) throws Throwable{
			try {
				List<List<String>> col = value.asLists();
				
				for (int list = 0;list<storeuiobj.gridLabelParam.size();list++) {
					
					String labelText = user.getElementText(storeuiobj.gridLabelParam.get(list));
					String colValue = col.get(list).get(0).trim();
					System.out.println(labelText);
					System.out.println(colValue);
					Assert.assertTrue(labelText.contains(colValue));				
				}
				
					
		}catch(Exception e) {
			throw e;
		}
  }
//---------------------------------------------------------------------------------------------------------------
		
		@Then("^Click on \"([^\"]*)\" tab name$")
		public void click_tab_name(String tabHeader) throws Throwable{
			try {
							
				user.sync(driver, storeuiobj.tabName(driver, tabHeader));
				user.click(storeuiobj.tabName(driver, tabHeader));			
				Thread.sleep(2000);
					
		}catch(Exception e) {
			throw e;
		}
		}
			
			@Then("^Click on \"([^\"]*)\" Button$")
			public void click_button_name(String buttonName) throws Throwable{
				try {
								
					user.sync(driver, storeuiobj.buttonName(driver, buttonName));
					user.click(storeuiobj.buttonName(driver, buttonName));			
					Thread.sleep(2000);
						
			}catch(Exception e) {
				throw e;
			}
	  }
			
			@Then("^Click on \"([^\"]*)\" radio button under reward section$")
			public void click_radio_button(String buttonRadioName) throws Throwable{
				try {
								
					user.sync(driver, storeuiobj.radioRewardEvalutaion(driver, buttonRadioName));
					user.click(storeuiobj.radioRewardEvalutaion(driver, buttonRadioName));			
					Thread.sleep(2000);
						
			}catch(Exception e) {
				throw e;
			}
	  }

			
			@Then("^Enter \"([^\"]*)\" text to \"([^\"]*)\" input field$")
			public void etner_input_field(String offerName,String inputName) throws Throwable{
				try {
								
					user.sync(driver, storeuiobj.inputName(driver, inputName));
					user.type(storeuiobj.inputName(driver, inputName), offerName);
							
					Thread.sleep(2000);
						
			}catch(Exception e) {
				throw e;
			}
	  }
			
			@Then("^Enter \"([^\"]*)\" text to decription field$")
			public void etner_description_field(String descName) throws Throwable{
				try {
								
					user.sync(driver, storeuiobj.inputDesc);
					user.type(storeuiobj.inputDesc, descName);
							
					Thread.sleep(2000);
						
			}catch(Exception e) {
				throw e;
			}
			}
				
				@Then("^Enter future date to Production end date field$")
				public void etner_production_end_date_field() throws Throwable{
					try {
						
						Date now = new Date();					    
						now.setMonth(now.getMonth()+1);
					    System.out.println("Date : "+  now);
					    SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");  
					    String strDate = dateFormat.format(now); 					  
					    System.out.println("End Date : "+ strDate);
					    
						user.sync(driver, storeuiobj.inputProdEndDate);
						//user.click(storeuiobj.inputProdEndDate);
						user.type(storeuiobj.inputProdEndDate, strDate);								
						Thread.sleep(2000);
						user.type(storeuiobj.inputTestEndDate, strDate);						
						Thread.sleep(2000);
							
				}catch(Exception e) {
					throw e;
				}
	  }

				@Then("^Click on issuence check box$")
				public void click_issuence_checkbox() throws Throwable{
					try {
									
						user.sync(driver, storeuiobj.checkboxIssuence);
						user.click(storeuiobj.checkboxIssuence);			
						Thread.sleep(2000);
							
				}catch(Exception e) {
					throw e;
				}
				}
				
				@Then("^Click on \"([^\"]*)\" tab$")
				public void click_conditions(String tabName) throws Throwable{
					try {
									
						user.sync(driver, storeuiobj.nameSubtab(driver,tabName));
						user.click(storeuiobj.nameSubtab(driver,tabName));			
						Thread.sleep(2000);
							
				}catch(Exception e) {
					throw e;
				}
				}
				
				@Then("^Click on Add button for Global condition$")
				public void click_add_button_conditions() throws Throwable{
					try {
									
						user.sync(driver, storeuiobj.addGlobalCondtionButton);
						user.click(storeuiobj.addGlobalCondtionButton);			
						Thread.sleep(2000);
							
				}catch(Exception e) {
					throw e;
				}
				}
				
				@Then("^Click on Add button for Global rewards$")
				public void click_add_button_rewards() throws Throwable{
					try {
									
						user.sync(driver, storeuiobj.addGlobalReward);
						user.click(storeuiobj.addGlobalReward);			
						Thread.sleep(2000);
							
				}catch(Exception e) {
					throw e;
				}
				}
				
				@Then("^Validate the Staus Bar$")
				public void validate_status_bar() throws Throwable{
					try {
									
						user.sync(driver, storeuiobj.lableStatusBar);
						Assert.assertTrue(storeuiobj.lableStatusBar.getText().equalsIgnoreCase("This offer has been modified."));
						Thread.sleep(2000);
							
				}catch(Exception e) {
					throw e;
				}
				}
				
				@Then("^Seledct Any Card holder from customer group and click on \"([^\"]*)\" button$")
				public void select_any_card_holder(String buttonName) throws Throwable{
					try {
						//Window switch code starts
						
						String parent=driver.getWindowHandle();
						Set<String>s=driver.getWindowHandles();	
						
						Iterator<String> I1= s.iterator();
						while(I1.hasNext()){
						String child_window=I1.next();
						if(!parent.equals(child_window))
						{
						driver.switchTo().window(child_window);
						System.out.println("Windo is switching");
						System.out.println(driver.switchTo().window(child_window).getTitle());						
						//Window switch code end
						
						user.sync(driver, storeuiobj.lnikAnyCardholder);
						user.click(storeuiobj.lnikAnyCardholder);			
						Thread.sleep(2000);
						user.click(storeuiobj.buttonSelect);			
						Thread.sleep(2000);
						user.sync(driver, storeuiobj.buttonName(driver, buttonName));
						user.click(storeuiobj.buttonName(driver, buttonName));			
						Thread.sleep(15000);
						
						}

					}
						
						driver.switchTo().window(parent);
							
				}catch(Exception e) {
					throw e;
			}
				}
				
				@Then("^Select \"([^\"]*)\" from product group and quantity \"([^\"]*)\" and click on \"([^\"]*)\" button$")
				public void select_product_quantity(String productName, String quantity,String buttonName) throws Throwable{
					try {
						//Window switch code starts
						
						String parent=driver.getWindowHandle();
						Set<String>s=driver.getWindowHandles();	
						
						Iterator<String> I1= s.iterator();
						while(I1.hasNext()){
						String child_window=I1.next();
						if(!parent.equals(child_window))
						{
						driver.switchTo().window(child_window);
						System.out.println("Windo is switching");
						System.out.println(driver.switchTo().window(child_window).getTitle());						
						//Window switch code end
						
						user.sync(driver, storeuiobj.inputProductGroup);
						user.type(storeuiobj.inputProductGroup, productName);									
						Thread.sleep(2000);
						user.sync(driver, storeuiobj.desairedProductGroup(driver, productName));
						user.click(storeuiobj.desairedProductGroup(driver, productName));			
						Thread.sleep(2000);
						user.click(storeuiobj.buttonSelect);	
						Thread.sleep(2000);
						user.sync(driver, storeuiobj.inputQuantity);
						user.type(storeuiobj.inputQuantity, quantity);	
						Thread.sleep(2000);
						user.sync(driver, storeuiobj.buttonName(driver, buttonName));
						user.click(storeuiobj.buttonName(driver, buttonName));			
						Thread.sleep(15000);
						
						}

					}
						
						driver.switchTo().window(parent);
							
				}catch(Exception e) {
					throw e;
			}
				}
				
				@Then("^Select \"([^\"]*)\" from product group and discount amount \"([^\"]*)\" and receipt text \"([^\"]*)\" and click on \"([^\"]*)\" button$")
				public void select_product_discount(String productName, String amount,String textReceipt,String buttonName) throws Throwable{
					try {
						//Window switch code starts
						
						String parent=driver.getWindowHandle();
						Set<String>s=driver.getWindowHandles();	
						
						Iterator<String> I1= s.iterator();
						while(I1.hasNext()){
						String child_window=I1.next();
						if(!parent.equals(child_window))
						{
						driver.switchTo().window(child_window);
						System.out.println("Windo is switching");
						System.out.println(driver.switchTo().window(child_window).getTitle());						
						//Window switch code end
						
						user.sync(driver, storeuiobj.inputProductGroup);
						user.type(storeuiobj.inputProductGroup, productName);									
						Thread.sleep(2000);
						user.sync(driver, storeuiobj.desairedProductGroup(driver, productName));
						user.click(storeuiobj.desairedProductGroup(driver, productName));			
						Thread.sleep(2000);
						user.click(storeuiobj.buttonSelectReward);	
						Thread.sleep(2000);
						user.sync(driver, storeuiobj.inputDiscountAmount);
						user.type(storeuiobj.inputDiscountAmount, amount);	
						Thread.sleep(1000);
						user.sync(driver, storeuiobj.inputReceiptText);
						user.type(storeuiobj.inputReceiptText, textReceipt);	
						Thread.sleep(2000);
						user.sync(driver, storeuiobj.buttonName(driver, buttonName));
						user.click(storeuiobj.buttonName(driver, buttonName));			
						Thread.sleep(15000);
						
						}

					}
						
						driver.switchTo().window(parent);
							
				}catch(Exception e) {
					throw e;
			}
				}
				
				@Then("^Select \"([^\"]*)\" terminal from locations tab$")
				public void click_terminal(String terminalName) throws Throwable{
					try {
									
						user.sync(driver, storeuiobj.nameTerminals(driver,terminalName));
						user.click(storeuiobj.nameTerminals(driver,terminalName));			
						Thread.sleep(1000);
						user.sync(driver, storeuiobj.buttonTerminalSelect);
						user.click(storeuiobj.buttonTerminalSelect);			
						Thread.sleep(2000);
							
				}catch(Exception e) {
					throw e;
				}
				}
				
				@Then("^Select Priority \"([^\"]*)\" for the offer$")
				public void select_priority(String priority) throws Throwable{
					try {
									
						user.sync(driver, storeuiobj.valuePriority(driver,priority));
						user.selectElementFromDropDown(driver, storeuiobj.valuePriority(driver,priority), priority);
						Thread.sleep(2000);
							
				}catch(Exception e) {
					throw e;
				}
				}
				
				@Then("^Select \"([^\"]*)\" Store from locations tab$")
				public void click_store(String storeName) throws Throwable{
					try {
						
						user.sync(driver, storeuiobj.inputProductGroup);
						user.type(storeuiobj.inputProductGroup, storeName);									
						Thread.sleep(2000);
						user.sync(driver, storeuiobj.desairedStoreGroup(driver, storeName));
						user.click(storeuiobj.desairedStoreGroup(driver, storeName));			
						Thread.sleep(2000);
						user.sync(driver, storeuiobj.buttonTerminalSelect);
						user.click(storeuiobj.buttonTerminalSelect);			
						Thread.sleep(2000);
							
				}catch(Exception e) {
					throw e;
				}
				}
}



