package com.pdp.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.assertj.core.api.SoftAssertions;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.github.fge.jsonschema.main.JsonSchema;
import com.pdp.test.SetUp;
import com.pdp.utilities.ActionMethods;
import com.pdp.utilities.Constant;
import com.pdp.utilities.ExceptionHandler;
import com.pdp.utilities.Log;
import com.pdp.utilities.PropertiesFile;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.assertj.core.api.Assertions.*;
import org.json.JSONTokener;

public class GetOperation_PageActions{

	ActionMethods user=new ActionMethods();
	Constant constant = new Constant();
	public  Properties data;
	public String URI;
	public HashMap<String,Object> CodeResponse =new HashMap<String,Object>();
	public static HashMap<String, Response> Respose_storer = new HashMap<String, Response>();
	public Response response;
	public JSONObject jsonobject_val;
	public JSONObject inside_response;
	
	public JSONArray inside_response_storeVersionPeriods;
	public JSONObject inside_StoreVersionPeriods;
	public JSONObject inside_response_storeVersionPeriods_Inner;
		
	public JSONArray inside_response_storeParameters;
	public JSONObject inside_StoreParameters;
	public JSONObject inside_response_StoreParameters_Inner;
	
	public JSONArray inside_response_temporaryClosurePeriods;
	public JSONObject inside_temporaryClousrePeriods;
	
	public JSONArray inside_response_storeOrgStructureMembershipPeriods;
	public JSONObject inside_storeOrgMembershipPeriods;
	public JSONObject inside_response_storeOrgMembershipPeriods_Inner;
	
	public JSONArray inside_response_storeGroupMembershipPeriods;
	public JSONObject inside_storeGroupMembershipPeriods;
	public JSONObject inside_response_storeGroupMembershipPeriods_Inner;
	
	public SoftAssertions softAssertions = new SoftAssertions();
	int size_of_StoreVersionPeriods;
	int size_of_StoreParameterArray;
	int size_of_temporaryClousrePeriods;
	int size_of_storeOrgStructureMembershipPeriods;
	int size_of_storeGroupMembershipPeriods;
	

	/*WebDriver driver = SetUp.driver;
	public static Properties data =	null;
	PackagePage packagpageobj=SetUp.packagpageobj;*/


	/*	@FindBy(how=How.XPATH, using = "//div[@class='UserName']" )
	public WebElement userid;

	@FindBy(how=How.XPATH, using = "//div[@class='UserName']" )
	public List<WebElement> userid1;

	public WebElement button(String text) {
		return driver.findElement(By.xpath("//input[@type='text']"));
	}*/

	public GetOperation_PageActions(){


	}
	//----------------------------------------------Utilities
	public int Requestspecifcationcreator(String uri) throws SocketException
	{
		try{
			RequestSpecification request = RestAssured.given();
			String a = constant.clientid;
			String b= constant.clientsecret;
			String c= constant.ApiKey;
			request.header("client-id",a);
			request.header("client-secret",b);
			request.header("api-key",c);
			response = request.get(uri);
			System.out.println("Response : "+response);
			int code = response.getStatusCode();
			System.out.println("Response code of the object is "+code);
			
			return code;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return 0;
		}


	}
	public JSONObject get_Object(Response response_sent) throws Throwable{		
		try {

			String body1 = response_sent.asString();
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(body1);	       

			return jsonObject;

		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public JSONObject get_Object(String bodyvalue) throws Throwable{		
		try {

			JSONObject jsonObject = (JSONObject) new JSONParser().parse(bodyvalue);	       

			return jsonObject;

		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public JSONArray get_Array(Response response_sent) throws Throwable{		
		try {
			String body1 = response_sent.asString();
			JSONArray jsonarray = (JSONArray) new JSONParser().parse(body1);	       
			return jsonarray;

		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public JSONArray get_Array(String bodyvalue) throws Throwable{		
		try {

			JSONArray jsonarray = (JSONArray) new JSONParser().parse(bodyvalue);	       
			return jsonarray;

		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, Object> get_Map(String value) throws Throwable{		
		try {

			Map<String, Object> jsonattributemapper = response.jsonPath().getMap(value);	       
			return jsonattributemapper;

		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	/*public void JSONSchemaValidator_for_get_method() throws Throwable
	{
		try
		{
			 			  
			FileReader reader = new FileReader("DATA\\JSON GET SCHEMA.json");
	        String x = IOUtils.toString(reader);
	            //Read JSON file
	            JSONObject obj = (JSONObject) new JSONParser().parse(x);	  
	 	             
	            Schema originalSchema = SchemaLoader.builder()
	                    .schemaJson(obj)
	                    .build().load().build();
	            
	           
	            
			  JSONObject jsonSubject = get_Object(response);		
			  Schema GETcurrentSchema = SchemaLoader.builder()
	                    .schemaJson(jsonSubject)
	                    .build().load().build();
				   
			  originalSchema.validate(jsonSubject);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
*/
	//---------------------------------------------------Validation Codes
	public void validatetheresponsecode(String statuscode,String ENVR) throws Throwable{
		try {
			HashMap<String, Object> ranval = new HashMap<String,Object>();
			//data = PropertiesFile.readPropertiesFile(constant.propertyFileName);
			data = PropertiesFile.readPropertiesFile();
			String e = ENVR+constant.GET_URI;
			URI=data.getProperty(e);
			System.out.println("url: "+URI);

			String code_val=Integer.toString(Requestspecifcationcreator(URI));
			
			Assert.assertTrue(statuscode.equalsIgnoreCase(code_val));
			Log.info("Status code matched as 200");	

		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	public void validatetheresponsecode(String statuscode,String ENVR,String storenum) throws Throwable{
		try {
			HashMap<String, Object> ranval = new HashMap<String,Object>();
			data = PropertiesFile.readPropertiesFile();
			//data = PropertiesFile.readPropertiesFile(constant.propertyFileName);
			String e = ENVR+constant.GET_URI;
			URI=data.getProperty(e)+"/"+storenum;
			System.out.println("url: "+URI);

			String code_val=Integer.toString(Requestspecifcationcreator(URI));
			Respose_storer.put(storenum, response);
			user.Message(SetUp.scenario_current, "The Respose for :: "+storenum+" has been captured and the status code is 200");
			Assert.assertTrue(statuscode.equalsIgnoreCase(code_val));

			Log.info("Status code matched as 200");	

		}catch(Exception e) {
			System.out.println(e.getMessage());
			user.Message(SetUp.scenario_current,"Status Code didnot match");
			e.printStackTrace();
			Assert.fail(e.getMessage());
			
		}
	}
	
	public void validate_generic_json_headers(DataTable table) throws Throwable{
		try {


			jsonobject_val=get_Object(response);
			Assert.assertNotNull("The JSONOBJECT of the entire response should be not null", jsonobject_val);

			List<Map<String,String>> rows = table.asMaps();
			for(Map<String, String> columns :rows)
			{
				String attribute = columns.get("Attribute");
				System.out.println("The attribute:: "+attribute);
				String value_from_feature = columns.get("Value");
				System.out.println("The value from feature file:: "+value_from_feature);
				String value_of_attribute = jsonobject_val.get(attribute).toString();
				System.out.println("The value of attribute from json:: "+value_of_attribute);
				user.Message(SetUp.scenario_current, "The Attribute is :: "+attribute+" and the value should be :: "+value_from_feature+" and the value is :: "+value_of_attribute);
				Assert.assertTrue(value_from_feature.equalsIgnoreCase(value_of_attribute));
					
			}

		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			user.Message(SetUp.scenario_current,"Attributes didnot match");
			Assert.fail(e.getMessage());

		}
	}
	//---------------------------------------Response Attribute
	public void Convert_Reponse_Element_toJSONObject(String Storesize) throws Throwable
	{
		try{

		if(Storesize.equalsIgnoreCase("All")){

		}
		else
		{
			inside_response = get_Object(jsonobject_val.get("response").toString());
			Assert.assertNotNull("The JSONObject of the RESPONSE Attribute should be not null",inside_response);
			user.Message(SetUp.scenario_current,"The JSON Object of Response is Not Null");
			Set<String> s = inside_response.keySet();
			Iterator<String> itr = s.iterator();
			while(itr.hasNext())
			{
				String key =  itr.next();
				System.out.println(key);
				System.out.println(inside_response.get(key));
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			user.Message(SetUp.scenario_current,"There is issue with the Reponse attribute");
			Assert.fail(e.getMessage());
		}
	}
	public void Convert_response_to_JSONOBject(String storenum) throws Throwable
	{
		try
		{
			Response randomrespose = Respose_storer.get(storenum);
			Assert.assertNotEquals(null, randomrespose);
			user.Message(SetUp.scenario_current,"Retrieved the response of the store no ::"+storenum);
			jsonobject_val=get_Object(randomrespose);
			Assert.assertNotNull("The JSONOBJECT of the entire response should be not null", jsonobject_val);
			user.Message(SetUp.scenario_current,"Retrieved the JSONOBject of the Response of the store no ::"+storenum);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			user.Message(SetUp.scenario_current,"Couldnot Retrieve the Response");
			Assert.fail(e.getMessage());
		}
	}
	public void Check_REPONSE_ELEMENT_NotNull(String attribute)
	{
		try
		{
			String val = inside_response.get(attribute).toString();
			System.out.println("The Attribute is :: "+attribute+" and the value is :: "+val);
			user.Message(SetUp.scenario_current, "The Attribute is :: "+attribute+" and the value is :: "+val);
			Assert.assertNotNull(val);

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			user.Message(SetUp.scenario_current,"Couldnot Retrieve attribute value of :: "+attribute);
			Assert.fail(e.getMessage());
		}
	}

		
		
		public void Get_Response_Element_attributes_validated(String attribute, String value)
		{
			try
			{
				String val = inside_response.get(attribute).toString();
				System.out.println("The Attribute is :: "+attribute+" and the value should be :: "+value+" and the value is :: "+val);
				user.Message(SetUp.scenario_current, "The Attribute is :: "+attribute+" and the value should be :: "+value+" and the value is :: "+val);
				Assert.assertTrue(val.equals(value));
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				user.Message(SetUp.scenario_current,"Couldnot Retrieve attribute value of :: "+attribute);
				Assert.fail(e.getMessage());
			}
		}
		//--------------------------------------------Store Parameter
		public void Covert_store_parameter_to_a_json_array(String attribute) throws Throwable
		{
			try
			{
				inside_response_storeParameters= get_Array(inside_response.get(attribute).toString());
				Assert.assertNotNull("The JSONARRAY of the StoreParameter within RESPONSE should be not null", inside_response_storeParameters);
				user.Message(SetUp.scenario_current,"Retrived the JSON array for the attribute:: "+attribute+" and it is not null :: "+inside_response_storeParameters);
				size_of_StoreParameterArray = inside_response_storeParameters.size();
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				user.Message(SetUp.scenario_current,"Couldnot convert to the JSON array for attribute:: "+attribute);
				Assert.fail(e.getMessage());
			}
		}
		public void Validate_StoreParameters_InnerObjectAttributes_and_validate_AttributesNotNull_withinThat(String Main_Attribute, String attribute) throws Throwable
		{
			try
			{
				for(int i =0;i<size_of_StoreParameterArray;i++)
				{
					inside_StoreParameters = get_Object(inside_response_storeParameters.get(i).toString());
					inside_response_StoreParameters_Inner=get_Object(inside_StoreParameters.get(Main_Attribute).toString());
					user.Message(SetUp.scenario_current, "The Attribute is :: "+Main_Attribute+" and the value is :: "+inside_response_StoreParameters_Inner.toString()+" from the :: "+i+" th array position");
					Assert.assertNotNull(inside_response_StoreParameters_Inner);
					String val = inside_response_StoreParameters_Inner.get(attribute).toString();
					System.out.println("The attribute is :: "+attribute+" and the value is :: "+val+" and it is from the :: "+i+" th array position");
					user.Message(SetUp.scenario_current, "The Attribute is :: "+attribute+" and the value is :: "+val+" from the :: "+i+" th array position");
					//Asserting whether the secondary attribute is null or not null
					Assert.assertNotNull(val);
					if(val.equalsIgnoreCase("eslEnabled"))
					{
						System.out.println("The value is :: "+val);
						user.Message(SetUp.scenario_current, "The Value of the attribute is :: "+val+" and it is not null");
						String NewValuefield = inside_StoreParameters.get("newValue").toString();
						user.Message(SetUp.scenario_current, "The Value of the Attribute from the JSONObject of the "+i+"th position arrary where :: newValue and the value is :: "+NewValuefield);
						Assert.assertNotNull(NewValuefield);
						
						String NewValueValidfromfield = inside_StoreParameters.get("newValueValidFrom").toString();
						user.Message(SetUp.scenario_current, "The Value of the Attribute from the JSONObject of the "+i+"th position arrary where :: newValueValidfromField and the value is :: "+NewValueValidfromfield);
						Assert.assertNotNull(NewValueValidfromfield);
						
					}
					else if(val.equalsIgnoreCase("eslVendor"))
					{
						System.out.println("The value is :: "+val);
						user.Message(SetUp.scenario_current, "The Value of the parameter is :: "+val+" and it is not null");
						
						String valuefield = inside_StoreParameters.get("value").toString();
						user.Message(SetUp.scenario_current, "The Value of the Attribute from the JSONObject of the "+i+"th position arrary where :: Value and the value is :: "+valuefield);
						Assert.assertNotNull(valuefield);
						
					}
					
				}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				user.Message(SetUp.scenario_current,"Couldnot Retrieve value for the attribute :: "+attribute+" and the Parent attribute ::"+Main_Attribute);
				Assert.fail(e.getMessage());
			}
		}
		public void Response_StoreParameters_VerifytheNewValAndNewValValidFrom(String val1, String val2, String attribute) throws Throwable
		{
			try{
					
				
				for(int i =0;i<size_of_StoreParameterArray;i++)
				{
					inside_StoreParameters = get_Object(inside_response_storeParameters.get(i).toString());
					inside_response_StoreParameters_Inner=get_Object(inside_StoreParameters.get(attribute).toString());
					user.Message(SetUp.scenario_current, "The Attribute is :: "+attribute+" and the value is :: "+inside_response_StoreParameters_Inner.toString()+" from the :: "+i+" th array position");
					//Assert.assertNotNull(inside_response_StoreParameters_Inner);
					String val = inside_response_StoreParameters_Inner.get("name").toString();
					System.out.println("The attribute is :: name and the value is :: "+val+" and it is from the :: "+i+" th array position");
					user.Message(SetUp.scenario_current, "The Attribute is :: name and the value is :: "+val+" from the :: "+i+" th array position");
					//Asserting whether the secondary attribute is null or not null
					//Assert.assertNotNull(val);
					if(val.equalsIgnoreCase("eslEnabled"))
					{
						String NewValueValidFromDate = inside_StoreParameters.get(val2).toString();
						String NewValue = inside_StoreParameters.get(val1).toString();
						System.out.println(NewValueValidFromDate);
						System.out.println(NewValue);
		
						Date CurrentDate = new Date();
		
						// change the date format
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						Date result_Date = df.parse(NewValueValidFromDate);
						// Doing a comparision between 2 dates, 
						// int compareTo(Date date)-Compares the value of the invoking object with that of date. 
						// Returns 0 if the values are equal. 
						//Returns a negative value if the invoking object is earlier than date. 
						//Returns a positive value if the invoking object is later than date.
						int y = CurrentDate.compareTo(result_Date);		
						user.Message(SetUp.scenario_current,"The Current Date : "+CurrentDate+" and the Passed Date : "+result_Date );
						if(y>0 || y==0) //Invoking date i.e. Current date is greater than or equal Result_Date
						{
							user.Message(SetUp.scenario_current, "The newValue should be true and it is :: "+NewValue);
							//Assert.assertTrue(NewValue.equalsIgnoreCase("true"));
						}
						else if(y<0) //Invoking date i.e. Current date is earlier than that of the Result date
						{
							user.Message(SetUp.scenario_current, "The newValue should be false and it is :: "+NewValue);
							//Assert.assertTrue(NewValue.equalsIgnoreCase("false"));
						}
						break;
						
					}
				}
				
					/*Covert_store_parameter_to_a_json_array(n3);			
					
					for(int i=0;i<inside_response_storeParameters.size();i++)
					{
					inside_StoreParameters = get_Object(inside_response_storeParameters.get(0).toString());
					String NewValueValidFromDate = inside_StoreParameters.get(n2).toString();
					String NewValue = inside_StoreParameters.get(n1).toString();
					System.out.println(NewValueValidFromDate);
					System.out.println(NewValue);
	
					Date CurrentDate = new Date();
	
					// change the date format
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date result_Date = df.parse(NewValueValidFromDate);
					// Doing a comparision between 2 dates, 
					// int compareTo(Date date)-Compares the value of the invoking object with that of date. 
					// Returns 0 if the values are equal. 
					//Returns a negative value if the invoking object is earlier than date. 
					//Returns a positive value if the invoking object is later than date.
					int y = CurrentDate.compareTo(result_Date);		
					user.Message(SetUp.scenario_current,"The Current Date : "+CurrentDate+" and the Passed Date : "+result_Date );
					if(y>0 || y==0) //Invoking date i.e. Current date is greater than or equal Result_Date
					{
						user.Message(SetUp.scenario_current, "The newValue should be true and it is :: "+NewValue);
						Assert.assertTrue(NewValue.equalsIgnoreCase("true"));
					}
					else if(y<0) //Invoking date i.e. Current date is earlier than that of the Result date
					{
						user.Message(SetUp.scenario_current, "The newValue should be false and it is :: "+NewValue);
						Assert.assertTrue(NewValue.equalsIgnoreCase("false"));
					}
	*/

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				user.Message(SetUp.scenario_current,"Couldnot Retrieve value for the attribute :: "+attribute);
				Assert.fail(e.getMessage());
			}

		}
		
		//----------------------------------------------------Store Version Periods
		public void Covert_store_Version_Periods_to_a_json_array(String attribute) throws Throwable
		{
			try
			{
				inside_response_storeVersionPeriods= get_Array(inside_response.get(attribute).toString());
				Assert.assertNotNull("The JSONARRAY of the SToreVersionPeriod within RESPONSE should be not null", inside_response_storeVersionPeriods);
				user.Message(SetUp.scenario_current,"Retrived the JSON array for the attribute:: "+attribute+" and it is not null :: "+inside_response_storeVersionPeriods);
				size_of_StoreVersionPeriods = inside_response_storeVersionPeriods.size();
				
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				user.Message(SetUp.scenario_current,"Couldnot convert to the JSON array for attribute:: "+attribute);
				Assert.fail(e.getMessage());
			}
		}
		public void Check_storeVersionPeriods_ELEMENT_NotNull(String attribute) throws Throwable
		{
			try
			{
				
				for(int i =0;i<size_of_StoreVersionPeriods;i++)
				{
					inside_StoreVersionPeriods = get_Object(inside_response_storeVersionPeriods.get(i).toString());
					String val = inside_StoreVersionPeriods.get(attribute).toString();
					System.out.println("The attribute is :: "+attribute+" and the value is :: "+val+" and it is from the :: "+i+" th array position");
					user.Message(SetUp.scenario_current, "The Attribute is :: "+attribute+" and the value is :: "+val+" from the :: "+i+" th array position");
					Assert.assertNotNull(val);
				}

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				user.Message(SetUp.scenario_current,"Couldnot Retrieve value for the attribute :: "+attribute);
				Assert.fail(e.getMessage());
			}
		}
		public void Validate_StoreVersionPeriods_InnerObjectAttributes_and_validate_AttributesNotNull_withinThat(String Main_Attribute, String attribute) throws Throwable
		{
			try
			{
				for(int i =0;i<size_of_StoreVersionPeriods;i++)
				{
					inside_StoreVersionPeriods = get_Object(inside_response_storeVersionPeriods.get(i).toString());
					inside_response_storeVersionPeriods_Inner = get_Object(inside_StoreVersionPeriods.get(Main_Attribute).toString());
					//Asserting whether the main attribute is null or not null
					user.Message(SetUp.scenario_current, "The Attribute is :: "+Main_Attribute+" and the value is :: "+inside_response_storeVersionPeriods_Inner.toString()+" from the :: "+i+" th array position");
					Assert.assertNotNull(inside_response_storeVersionPeriods_Inner);
					String val = inside_response_storeVersionPeriods_Inner.get(attribute).toString();
					System.out.println("The attribute is :: "+attribute+" and the value is :: "+val+" and it is from the :: "+i+" th array position");
					user.Message(SetUp.scenario_current, "The Attribute is :: "+attribute+" and the value is :: "+val+" from the :: "+i+" th array position");
					//Asserting whether the secondary attribute is null or not null
					Assert.assertNotNull(val);
				}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				user.Message(SetUp.scenario_current,"Couldnot Retrieve value for the attribute :: "+attribute);
				Assert.fail(e.getMessage());
			}
		}

		//-----------------------------------------TemporaryClosurePeriods
		public void Covert_temporary_closure_periods_to_a_json_array(String attribute) throws Throwable
		{
			try
			{
				try{
				if(inside_response.get(attribute).toString()!=null)
				{
					inside_response_temporaryClosurePeriods= get_Array(inside_response.get(attribute).toString());
					Assert.assertNotNull (inside_response_temporaryClosurePeriods);
					user.Message(SetUp.scenario_current, "The TemporaryCosurePeriod within this response is not null ::"+inside_response_temporaryClosurePeriods);
					size_of_temporaryClousrePeriods = inside_response_temporaryClosurePeriods.size();
				}
				}
				catch(NullPointerException e)
				{
					size_of_temporaryClousrePeriods = 0;
					user.Message(SetUp.scenario_current, "The TemporaryCosurePeriod within this response is null ");
				}
				
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				user.Message(SetUp.scenario_current,"Failed for null exception");
				Assert.fail(e.getMessage());
			}
		}
		public void Validate_TemporaryClousrePeriods_InnerObjectAttributes_and_validate_AttributesNotNull_withinThat(String attribute) throws Throwable
		{
			try
			{
				if(size_of_temporaryClousrePeriods == 0)
				{
					user.Message(SetUp.scenario_current, "TemporaryClousrePeriods doesnot exist in this JSON request");
				}
				else
				{
				for(int i =0;i<size_of_temporaryClousrePeriods;i++)
				{
					inside_temporaryClousrePeriods = get_Object(inside_response_temporaryClosurePeriods.get(i).toString());
					String val = inside_temporaryClousrePeriods.get(attribute).toString();
					//Asserting whether the main attribute is null or not null
					user.Message(SetUp.scenario_current, "The Attribute is :: "+attribute+" and the value is :: "+val+" from the :: "+i+" th array position");
					Assert.assertNotNull(val);

				}
				}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				user.Message(SetUp.scenario_current,"Couldnot Retrieve value for the attribute :: "+attribute);
				Assert.fail(e.getMessage());
			}
		}
		//-------------------------------------------------storeOrgMembershipPeriods
		public void Covert_store_OrgStructure_Membership_Periods_to_a_json_array(String attribute) throws Throwable
		{
			try
			{

				inside_response_storeOrgStructureMembershipPeriods= get_Array(inside_response.get(attribute).toString());
				Assert.assertNotNull(inside_response_storeOrgStructureMembershipPeriods);
				user.Message(SetUp.scenario_current,"Retrived the JSON array for the attribute:: "+attribute+" and it is not null :: "+inside_response_storeOrgStructureMembershipPeriods);
				size_of_storeOrgStructureMembershipPeriods = inside_response_storeOrgStructureMembershipPeriods.size();
				
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				user.Message(SetUp.scenario_current,"Couldnot convert to the JSON array for attribute:: "+attribute);
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}
		}
		public void Check_storeOrgMembershipPeriods_ELEMENT_NotNull(String attribute) throws Throwable
		{
			try
			{
				
				for(int i =0;i<size_of_storeOrgStructureMembershipPeriods;i++)
				{
					inside_storeOrgMembershipPeriods = get_Object(inside_response_storeOrgStructureMembershipPeriods.get(i).toString());
					String val = inside_storeOrgMembershipPeriods.get(attribute).toString();
					System.out.println("The attribute is :: "+attribute+" and the value is :: "+val+" and it is from the :: "+i+" th array position");
					user.Message(SetUp.scenario_current, "The Attribute is :: "+attribute+" and the value is :: "+val+" from the :: "+i+" th array position");
					Assert.assertNotNull(val);
				}

			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				user.Message(SetUp.scenario_current, "Couldnot Retrieve value for the attribute :: "+attribute);
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}
		}
		public void Validate_storeOrgStructureMembershipPeriods_InnerObjectAttributes_and_validate_AttributesNotNull_withinThat(String Main_Attribute, String attribute) throws Throwable
		{
			try
			{
				for(int i =0;i<size_of_storeOrgStructureMembershipPeriods;i++)
				{
					inside_storeOrgMembershipPeriods = get_Object(inside_response_storeOrgStructureMembershipPeriods.get(i).toString());
					
						inside_response_storeOrgMembershipPeriods_Inner = get_Object(inside_storeOrgMembershipPeriods.get(Main_Attribute).toString());
						//Asserting whether the main attribute is null or not null
						user.Message(SetUp.scenario_current, "The Attribute is :: "+Main_Attribute+" and the value is :: "+inside_response_storeOrgMembershipPeriods_Inner.toString()+" from the :: "+i+" th array position");
						Assert.assertNotNull(inside_response_storeOrgMembershipPeriods_Inner);
						String val = inside_response_storeOrgMembershipPeriods_Inner.get(attribute).toString();
						System.out.println("The attribute is :: "+attribute+" and the value is :: "+val+" and it is from the :: "+i+" th array position");
						user.Message(SetUp.scenario_current, "The Attribute is :: "+attribute+" and the value is :: "+val+" from the :: "+i+" th array position");
						//Asserting whether the secondary attribute is null or not null
						Assert.assertNotNull(val);
					
				}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		//------------------------------------------------storeGroupMembershipPeriods
		public void Covert_store_GroupMembership_Periods_to_a_json_array(String attribute) throws Throwable
		{
			try
			{
				try{
				if(inside_response.get(attribute).toString()!=null)
				{
					inside_response_storeGroupMembershipPeriods= get_Array(inside_response.get(attribute).toString());
					Assert.assertNotNull (inside_response_storeGroupMembershipPeriods);
					user.Message(SetUp.scenario_current, "The TemporaryCosurePeriod within this response is not null ::"+inside_response_storeGroupMembershipPeriods);
					size_of_storeGroupMembershipPeriods = inside_response_storeGroupMembershipPeriods.size();
				}
				}
				catch(NullPointerException e)
				{
					size_of_storeGroupMembershipPeriods = 0;
					user.Message(SetUp.scenario_current, "The storeGroupMembershipPeriods within this response is null ");
				}
				
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				user.Message(SetUp.scenario_current,"Failed for null exception");
				Assert.fail(e.getMessage());
			}
		}
		public void Validate_storeGroupMembershipPeriods_Elements_NotNull(String attribute) throws Throwable
		{
			try
			{
				if(size_of_storeGroupMembershipPeriods == 0)
				{
					user.Message(SetUp.scenario_current, "storeGroupMembershipPeriods doesnot exist in this JSON request");
				}else
				{
				for(int i =0;i<size_of_storeGroupMembershipPeriods;i++)
				{
					inside_storeGroupMembershipPeriods = get_Object(inside_response_storeGroupMembershipPeriods.get(i).toString());
					String val = inside_storeGroupMembershipPeriods.get(attribute).toString();
					//Asserting whether the main attribute is null or not null
					user.Message(SetUp.scenario_current, "The Attribute is :: "+attribute+" and the value is :: "+val+" from the :: "+i+" th array position");
					Assert.assertNotNull(val);

				}
				}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
				user.Message(SetUp.scenario_current,"Couldnot Retrieve value for the attribute :: "+attribute);
				Assert.fail(e.getMessage());
			}
		}
		public void Validate_storeGroupMembershipPeriods_InnerObjectAttributes_and_validate_AttributesNotNull_withinThat(String Main_Attribute, String attribute) throws Throwable
		{
			try
			{
				if(size_of_storeGroupMembershipPeriods == 0)
				{
					user.Message(SetUp.scenario_current, "storeGroupMembershipPeriods doesnot exist in this JSON request");
				}
				else
				{
				for(int i =0;i<size_of_storeGroupMembershipPeriods;i++)
				{
					inside_storeGroupMembershipPeriods = get_Object(inside_response_storeGroupMembershipPeriods.get(i).toString());
					
						inside_response_storeGroupMembershipPeriods_Inner = get_Object(inside_storeGroupMembershipPeriods.get(Main_Attribute).toString());
						//Asserting whether the main attribute is null or not null
						user.Message(SetUp.scenario_current, "The Attribute is :: "+Main_Attribute+" and the value is :: "+inside_response_storeGroupMembershipPeriods_Inner.toString()+" from the :: "+i+" th array position");
						Assert.assertNotNull(inside_response_storeGroupMembershipPeriods_Inner);
						String val = inside_response_storeGroupMembershipPeriods_Inner.get(attribute).toString();
						System.out.println("The attribute is :: "+attribute+" and the value is :: "+val+" and it is from the :: "+i+" th array position");
						user.Message(SetUp.scenario_current, "The Attribute is :: "+attribute+" and the value is :: "+val+" from the :: "+i+" th array position");
						//Asserting whether the secondary attribute is null or not null
						Assert.assertNotNull(val);
					
				}
				}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
