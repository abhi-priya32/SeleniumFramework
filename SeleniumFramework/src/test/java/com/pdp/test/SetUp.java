package com.pdp.test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pdp.pageobjects.GetOperation_PageActions;
import com.pdp.pageobjects.OutSystemLoginPage;
import com.pdp.pageobjects.StoreStmsUIPage;
import com.pdp.utilities.Log;
import com.pdp.utilities.PropertiesFile;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;




public class SetUp {
	
	public static WebDriver driver;
	public static Scenario scenario_current; 	
	public static OutSystemLoginPage loginpageobj = new OutSystemLoginPage();
	public static StoreStmsUIPage storeuiobj = new StoreStmsUIPage();
	public  Actions action;
	public  String message ="";
	FileOutputStream fop =null;
	File file;
	public static byte[][] screenshotsArray = new byte[10][10000];
	public  Date date;
	public  String BrowserName="";
	public  Properties data=null;
	public static String ScenarioName = "";
	public  HashMap<String,String> InspectionDataMap = new HashMap<String,String>();
	public  String lastUpdatedDateTime="";
	
	static {
		DOMConfigurator.configure("log4j.xml");
	}
	
	@Before
	public void setupTest(Scenario scenario) throws Exception{
		
		scenario_current=scenario;
		ScenarioName = scenario.getName();
		System.out.println("Starting Scenario execution for Scenario Name >> "+ScenarioName);
		String ChromeDriverServer = System.getProperty("user.dir") + "/browserserver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromeDriverServer);

		ChromeOptions options = new ChromeOptions();
		 options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		// options.addArguments("--incognito");
         options.addArguments("--allow-running-insecure-content");
         options.addArguments("--allow-insecure-websocket-from-https-origin");
         options.addArguments("disable-extensions");
         options.addArguments("allow-running-insecure-content");
         options.addArguments("--start-maximized");
         options.addArguments("disable-extensions");            
         options.addArguments("disable-plugins");
         options.addArguments("--enable-precise-memory-info"); 
         options.addArguments("--disable-popup-blocking");
         options.addArguments("--disable-default-apps");
         options.addArguments("test-type=browser");
         options.addArguments("disable-infobars");
         options.setExperimentalOption("useAutomationExtension", false);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver =  new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/* * Proxy proxy = new Proxy();
		 * proxy.setProxyAutoconfigUrl("http://newproxy.ah.nl:8000/kpn.pac");
		 * //proxy.setHttpProxy("localhost:8888"); //Add the proxy to our capabilities
		 * capabilities.setCapability("proxy", proxy);*/
		 

		// --------------------------- To enable
		// Flash-----------------------------------------------------------------------

		/*Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("profile.default_content_setting_values.plugins", 1);
		prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
		prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("test-type");
		options.addArguments("disable-popup-blocking");
		options.addArguments("disable-infobars");*/

		//options.addArguments("--incognito");
		/*options.addArguments("--allow-running-insecure-content");
		options.addArguments("--allow-insecure-websocket-from-https-origin");
		options.addArguments("disable-extensions");
		options.addArguments("allow-running-insecure-content");
		options.addArguments("--start-maximized");
		options.addArguments("disable-extensions");			
		options.addArguments("disable-plugins");
		options.addArguments("--enable-precise-memory-info"); 
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");
		options.setExperimentalOption("useAutomationExtension", false);*/
		
		//driver =  new ChromeDriver(options);
		// driver = new RemoteWebDriver(new
		// URL("http://10.201.165.149:4444/wd/hub"),capabilities);
		// driver = new RemoteWebDriver(new
		// URL("http://10.135.15.67:4444/wd/hub"),capabilities);
		 /*driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
		// System.out.println("********************************************************");
		
		loginpageobj =  PageFactory.initElements(driver, OutSystemLoginPage.class);
		storeuiobj =  PageFactory.initElements(driver, StoreStmsUIPage.class);
	
		
		//PackagePage pp = new PackagePage();
		
		//System.out.println("path "+System.getProperty("user.dir"));
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		action = new Actions(driver);
		
		Capabilities  cap1 = ((RemoteWebDriver) driver).getCapabilities();
		BrowserName =cap1.getBrowserName().toLowerCase();
		
	}
	
	@After
	public  void tearDown(Scenario result) throws Exception{
		if(result.isFailed()) {
			
			result.write(result.toString());
			//result.write("Screenshot takn for failed steps");
			/*byte[] screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			result.write(message);
			result.embed(screenshot, "image/png");			*/
		}
		driver.close();
		driver.quit();
		Log.endTestCase("Ending scenario execution with Execution result as >> "+result.getStatus());
		System.out.println("Ending scenario execution with Execution result as >> "+result.getStatus());
				
	}
	
}
