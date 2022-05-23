package com.pdp.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pdp.test.SetUp;

import io.cucumber.java.Scenario;

/*import com.target.objects.HomePageObjects;
import com.target.objects.PensionPageObjects;*/


import junit.framework.Assert;

public class ActionMethods {

	static Logger Log = Logger.getLogger(ActionMethods.class);

	

	public void sync(WebDriver driver, WebElement element) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, 30)
					.ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sync_element_not_visible(WebDriver driver, List<WebElement> element) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, 30)
					.ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.invisibilityOfAllElements(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sync1(WebDriver driver, WebElement element) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, 100)
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void syncClickable(WebDriver driver, WebElement element) {
		try {
			Wait<WebDriver> wait = (WebDriverWait) new WebDriverWait(driver, 100)
					.ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void type(WebElement element, String str) {
		element.clear();
		element.sendKeys(str.toString());

	}
	
	public void clear(WebElement element) {
		element.clear();
		

	}
	
	
	/* override default value */
	public void type2(WebElement element, String str) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"), str);
	}

	public void click(WebElement element) {
		element.click();
	}

	public boolean verifyElement(Object element) {
		try {
			if (element instanceof WebElement) {
				if (((WebElement) element).isDisplayed()) {
					return true;
				} else {
					return false;
				}
			} else

			{
				return false;
			}
		} catch (NullPointerException e) {
			System.out.println("Object value null");
			e.printStackTrace();
		} catch (ElementNotVisibleException e) {
			System.out.println("Object not visible");
			e.printStackTrace();
		} catch (MoveTargetOutOfBoundsException e) {
			System.out.println("Object Cannot be scrolled into view");
			e.printStackTrace();
		} 
		/*catch (ElementNotFoundException e) {
			System.out.println("Object Not Found");
			e.printStackTrace();
		}*/
		catch (NoSuchElementException e) {
			Assert.assertTrue("Object does Not exist", false);
			System.out.println("Object Not exists");
			e.printStackTrace();
		}  catch (WebDriverException e) {
			System.out.println("Webdriver Exception: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Unknown Exception: " + e.getMessage());
			e.printStackTrace();
		}
		return false;

	}

	public boolean isWebElementPresent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}
	
	//To check if element is present

	public static boolean isElementPresent(WebDriver driver,By by){
	try	{

	//WebDriverWait wait = new WebDriverWait(driver,60);
	//wait.until( ExpectedConditions.visibilityOfElementLocated(by));
	driver.findElement(by);
	//System.out.println("ELEMENT PRESENT................");
	return true;
	}
	catch (NoSuchElementException e)
	{
	return false;
	}
	}

	
	

	public void setClipBoardData(String str) {
		StringSelection stringselection = new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
	}

	public void selectElementFromDropDown(WebDriver driver, WebElement element, String visibleText) {
		
		Select dropDown = new Select(element);
		dropDown.selectByValue(visibleText);
		//dropDown.selectByVisibleText(visibleText);

	}
	
	
	
	

	public boolean containsText(WebDriver driver,String str)
	{
		try{
			String containsObject = "//*[contains(text(),'" + str + "')]";
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(containsObject)));
			return true;
		}
		catch (Exception e) {
			System.out.println("Text : " + str + " is not present in the view");
			return false;
		}
		
	}
	
	public boolean exactText(WebDriver driver, String str) {

		try {
			String exactobjects = "//*[text()='" + str + "')]";
			new WebDriverWait(driver, 30)
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(exactobjects)));
			return true;

		} catch (Exception e) {
			System.out.println("Exact Text : " + str + " is not present in the view");
			return false;
		}

	}
	
	public void scrolldown(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("window.scrollTo(200, document.body.scrollHeight)");

	}
	
	public boolean redirect(WebDriver driver, String url) {

		String currentURL = driver.getCurrentUrl();
		boolean urlRediection = false;
			if (!currentURL.contains(url)) {
				urlRediection = true;
			}
		return urlRediection;

	}
	
	public boolean checkTitle(WebDriver driver, String title )
	{
		try {

			if (driver.getTitle().equalsIgnoreCase(title)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void highlightElement(WebDriver driver, WebElement element)
	{
		try{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: LightGreen; border: 2px solid yellow;' )", element);
		Thread.sleep(1000);
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px white')", element);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void checkBrokenLinks(WebDriver driver) 
	{
		try{
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links present in the page are  "+links.size());
		
		for(int i=0;i<links.size();i++)
		{
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			verifyActiveLink(url);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void verifyActiveLink(String linkurl)
	{
		try {
			URL url = new URL(linkurl);
			HttpURLConnection httpconnect  = (HttpURLConnection)url.openConnection();
			httpconnect.setConnectTimeout(3000);
			httpconnect.connect();
			
			if(httpconnect.getResponseCode()==200)
			{
				System.out.println(linkurl+"  -"+httpconnect.getResponseMessage());
			}
			
			if(httpconnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
			{
				System.out.println(linkurl +"  -"+httpconnect.getResponseMessage()+" "+HttpURLConnection.HTTP_NOT_FOUND);
			}
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String checkTextForParticularElement(WebDriver driver, WebElement element)
	{
		String text =element.getText();
		return text;
	}
	
	
	
	public void takeScreenshot(WebDriver driver) throws IOException {
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    String currentDir = System.getProperty("user.dir");
	    FileUtils.copyFile(scrFile, new File(currentDir + "\\screenshots\\"+"\\"+SetUp.ScenarioName+"\\" + System.currentTimeMillis() + ".png"));

	}
	
	public String getEncodedString(String str)
	{
		byte[]   bytesEncoded = Base64.encodeBase64(str .getBytes());
		String encoded = new String(bytesEncoded);
		return encoded;
	}
	
	public String getDecodedString(String str)
	{
		byte[] valueDecoded= Base64.decodeBase64(str );
		String decoded = new String(valueDecoded);
		return decoded;
	}
	
	public String getTextForParticularElement(WebDriver driver, WebElement element) {
		String text = element.getText();
		return text;
	}

	
	@SuppressWarnings("unused")
	public String getTextFromTextBox(WebDriver driver, WebElement element) {
		String text = element.getAttribute("value");
		String newText = text.trim(); 
		String noText = "Text Box is Empty";
		if (text != null) {
			if (newText.length() == 0) {
				return noText;
			}

			else
				return text;
		} else

			return noText;

	}
	
	public String getCurrentValueFromDropDown(WebDriver driver, By element)
	{
		Select dropDown = new Select(driver.findElement(element));
		WebElement value = dropDown.getFirstSelectedOption();
		String text = value.getText();
		return text;
	}
	
	public String getElementColorHex(WebDriver driver, WebElement element)
	{
		String color = element.getCssValue("color");
		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

		int hexValue1=Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2=Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3=Integer.parseInt(hexValue[2]);

		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;
	}

	
	
	public void checkcontainsTextForParticularElement(WebDriver driver,WebElement element,String str)
	{
		String text =element.getText().trim();
		
		try{
			/*String containsObject = "//*[contains(text(),'" + str + "')]";
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(containsObject)));
			return true;*/
			System.out.println(text);
			Assert.assertEquals(str, text);
			
		}
		catch (Exception e) {
			System.out.println("Text : " + str + " is not present in the view");
			//return false;
		}
		
	}
	public void waiting(long a)
	{
		
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void clickCheckbox(WebElement element) {
		System.out.println("Starting point");
		try{
		if(element.isSelected()){
			System.out.println("ending point");
			//element.click();	
		}
		else{
			
			System.out.println("1st");
			element.click();
			Thread.sleep(500);
			//System.out.println("2nd");
			//element.click();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
	

	public void clickNew(List<WebElement> okButton) {
		System.out.println("check");
		if(okButton.size() >0 )
		okButton.get(0).click();
		else
			System.out.println("No Pop up");
	}
	
	public void clickCheckbox2(WebElement element) {
		System.out.println("Starting point");
		
			element.click();	
			element.click();
		
		
	}
	
	public void clickCheckbox1(WebElement element) {
		System.out.println("Starting point");
		
				
			element.click();
		
		
	}
	
	public String getdate(int days,String op)
	{
		String dt;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMMM-dd");
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		if(op.equals("-"))
			c.add(Calendar.DATE, -days);  // number of days to add
		else
			c.add(Calendar.DATE, days);  // number of days to add
		
		dt = sdf.format(c.getTime()); 
		System.out.println(dt);
		return dt;
	}
	
	public String ShortLabel(String Label){
		String ShortLabel="";
		if(Label.contains("'")){
			 ShortLabel = Label.split("'")[0];
		}
		else{
			ShortLabel=Label;
		}
		return ShortLabel;
	}
	
	public void scrollToElement(WebDriver driver,WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);

	}
	
	public boolean isAlertPresent(WebDriver driver) 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}
	
	
	

	private Collection<String> getDirectoryInfo() {
		List<String> fileNameList = new ArrayList<String>();
		File file = new File(System.getProperty("user.home") + "/Downloads");
		if (file.isDirectory()) {
			String[] fileList = file.list();
			fileNameList.addAll(Arrays.asList(fileList));
		}
		return fileNameList;
	}
	
	public void pageLaodWait(final WebDriver driver)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 180);
		 wait.until(new ExpectedCondition<Boolean>() {
		        public Boolean apply(WebDriver wdriver) {
		            return ((JavascriptExecutor) driver).executeScript(
		                "return document.readyState"
		            ).equals("complete");
		        }
		    });

	    System.out.println("End Loading");
		
	}
	
	public void jsClick(WebDriver driver,WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);

	}

	public void embedScreenshot(WebDriver driver,Scenario result,String message) {
		
		//result.write(result.toString());
		//result.write("ScreenShot taken for passed step ");
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		result.write(message);
		result.embed(screenshot, "image/png");	
		
	}
	public void Message(Scenario result,String message) {
		result.write(message);
	}
	
	
	
		public void waitForSpinner(WebDriver driver) {
		
			List<WebElement> lws = driver.findElements(By.cssSelector("#loader-wrapper"));
	        List<WebElement> plos = driver.findElements(By.cssSelector(".preloader-overlay"));

	        WebDriverWait wait0 = new WebDriverWait(driver,40);
	        wait0.until(ExpectedConditions.invisibilityOfAllElements(lws));

	        WebDriverWait wait1 = new WebDriverWait(driver,40);
	        wait1.until(ExpectedConditions.invisibilityOfAllElements(plos));				
		
	}
		
		
	
	public static String NullToZero(String s_data)
    {
    	s_data=s_data==null ? "0":s_data;
    	return s_data;
    }
	
	
	public static String removeBracket(String s)
	{
		return s.replace("(","").replace(")", "");
	}
	

	public static String removeCommas(String s)
	{
		return s.replace(",","");
	}
	
	




	public File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	


	public boolean isElementPrsent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	
	public void selectElementFromDropDown(WebDriver driver, By element, String visibleText) {

		Select dropDown = new Select(driver.findElement(element));
		dropDown.selectByVisibleText(visibleText);

	}

	
	public void click2(WebDriver driver,WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}


	

	

	

	

	

	

	

	

	public String getPageTitle(WebDriver driver)
	{
		String title = driver.getTitle();
		return title;
	}

	public String getElementText(WebElement element)
	{
		String elementText=null;
		try {
			elementText=element.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return elementText;
	}


	public void movetoElement(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}


	public List<String> getWebElementnames(List<WebElement> elementlist)
	{
		List<String> elementlistname=new ArrayList<String>();
		String s1=null;
		for(WebElement we:elementlist)
		{
			s1=we.getText();
			elementlistname.add(s1);
		}
		return elementlistname;
	}

	public List<String> getWebElementnamesByAttribute(List<WebElement> elementlist)
	{
		List<String> elementlistname=new ArrayList<String>();
		String s1=null;
		for(WebElement we:elementlist)
		{
			s1=we.getAttribute("innerText");
			elementlistname.add(s1);
		}
		return elementlistname;
	}

	public boolean searchList(String str,List<String> stringList)
	{
		boolean blnFound = stringList.contains(str);  
		return blnFound;
	}

	public void sync(WebDriver driver, List<WebElement> elements) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, 3000).ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<String> splitSringOnNewline(String str){
		String[] words= str.split("\\r\\n|\\n|\\r");
		List<String> strList = Arrays.asList(words);
		return strList;
	}

	public boolean isSelected(WebElement element)
	{
		return element.isSelected();
	}


	public static boolean equals(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equals(str2);
	}


	public int search_string_list_webelement(String str,List<WebElement> lwe){
		boolean stringfound=false;
		int i=0;
		Iterator<WebElement> itr = lwe.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			i++;
			System.out.println("userlist: "+element.getText());
			if (element.getText().equals(str))
			{
				stringfound=true;
				break;
			}
		}
		System.out.println("string position "+i);
		if (stringfound)
			return i;
		else return 0;
	}

	public void refresh_page(WebDriver driver)
	{
		driver.navigate().refresh();
	}

	public boolean isElementVisible(WebDriver driver,String id)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;

		String script = "return $(document.getElementById('"+id+"')).is(':visible')";
		boolean visible=(Boolean) js.executeScript(script);
		return visible;
	}


	//sumit
	public int search_substring_list_webelement(String str,List<WebElement> lwe){
		boolean stringfound=false;
		int i=0;
		Iterator<WebElement> itr = lwe.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			i++;
			System.out.println("userlist: "+element.getText());
			if (element.getText().contains(str))
			{
				stringfound=true;
				break;
			}
		}
		System.out.println("string position "+i);
		if (stringfound)
			return i;
		else return 0;
	}
	
	

	public void open_file_dialog(String filepath) throws AWTException, InterruptedException{
		setClipBoardData(filepath);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	public boolean searchList1(List<String> s1list,List<String> stringList)
	{
		boolean blnFound = stringList.contains(s1list);
		return blnFound;
	}
	
	public void elementIsDisable(WebDriver driver, WebElement element) throws Exception {
	   
	    Thread.sleep(2000);
	    String disableAttribute = element.getAttribute("disabled");
	    Assert.assertEquals("true", disableAttribute);
	}
	
	public int click_string_list_webelement(WebDriver driver,String str,List<WebElement> lwe){
		boolean stringfound=false;
		int i=0;
		Iterator<WebElement> itr = lwe.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			i++;
			System.out.println("userlist: "+element.getText());
			if (element.getText().equals(str))
			{
				stringfound=true;
				click2(driver,element);
				break;
			}
		}
		System.out.println("string position "+i);
		if (stringfound)
			return i;
		else return 0;
	}
	
	public int click_substring_list_webelement_ignore_case(WebDriver driver,String str,List<WebElement> lwe){
		boolean stringfound=false;
		int i=0;
		Iterator<WebElement> itr = lwe.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			i++;
			System.out.println("userlist: "+element.getText());
			if (element.getText().toLowerCase().contains(str.toLowerCase()))
			{
				stringfound=true;
				click(element);
				break;
			}
		}
		System.out.println("string position "+i);
		if (stringfound)
			return i;
		else return 0;
	}

	
	
	
	
	
	
	
	
}
	
	

