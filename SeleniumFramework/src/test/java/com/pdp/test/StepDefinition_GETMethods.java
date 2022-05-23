package com.pdp.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.pdp.pageobjects.GetOperation_PageActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class StepDefinition_GETMethods {
	
	
	
	public GetOperation_PageActions gp = new GetOperation_PageActions();

	
	
	/*@Then("Validate the json schema for GET Method")
	public void Validate_the_json_schema_for_GET_Method() throws Throwable
	{
		gp.JSONSchemaValidator_for_get_method();
	}*/
	@Then("The response code is {string} for given {string} URI")
	public void The_response_code_is_for_given_URI(String statuscode, String ENVR) throws Throwable {
		
		gp.validatetheresponsecode(statuscode, ENVR);
	}

	@Then("Validate the following value from the JSON header")
	public void Validate_the_following_value_from_the_JSON_header(DataTable table) throws Throwable {
		
		gp.validate_generic_json_headers(table);
	}
	
	/*@Then("Validate the following value from the JSON header where storesize is {string}")
        public void Validate_the_following_value_from_the_JSON_header(DataTable table) throws Throwable {
		
		gp.validate_generic_json_headers(table);
	}*/
	
	@Then("Convert the Response element to a JSONObject where storesize is {string}")
	public void Convert_the_Response_element_to_a_JSONObject_where_storesize_is(String storesize) throws Throwable
	{
		gp.Convert_Reponse_Element_toJSONObject(storesize);
	}
	
	@Then("The response code is {string} for given {string} URI of storenum {string}")
	public void The_response_code_is_for_given_URI_of_storenum(String statuscode, String ENVR, String storenum) throws Throwable {
		
		gp.validatetheresponsecode(statuscode, ENVR,storenum);
	}
	
	@Then("Validate that the {string} and {string} is being represented correctly or not in {string}")
	public void Validate_that_the_and_is_being_represented_correctly_or_not_in(String newval, String newvaldayfrom, String Parameters) throws Throwable
	{
		gp.Response_StoreParameters_VerifytheNewValAndNewValValidFrom(newval, newvaldayfrom, Parameters);
	}
	
	@Then("Get the JSONOBject of the Respective Storenumber {string}")
	public void  Get_the_JSONOBject_of_the_Respective_Storenumber(String storenum) throws Throwable
	{
		gp.Convert_response_to_JSONOBject(storenum);
	}
	@Then("validate whether the {string} of that store in the Request is {string}")
	public void validate_whether_the_of_that_store_in_the_Request_is(String attribute, String Value)
	{
		gp.Get_Response_Element_attributes_validated(attribute, Value);
	}
	@Then("validate whether the {string} of that store in the Request is notnull")
	public void validate_whether_the_of_that_store_in_the_Request_is_notnull(String attribute)
	{
		gp.Check_REPONSE_ELEMENT_NotNull(attribute);
	}
	@Then ("Get the JSON Array for SVP {string}")
	public void Get_the_JSON_Array_for_SVP(String attribute) throws Throwable
	{
		gp.Covert_store_Version_Periods_to_a_json_array(attribute);
	}
	@Then("validate whether the {string} of that store in the storeVersionPeriods is notnull")
	public void validate_whether_the_of_that_store_in_the_storeVersionPeriods_is_notnull(String attribute) throws Throwable
	{
		gp.Check_storeVersionPeriods_ELEMENT_NotNull(attribute);
	}
	@Then("Get the JSONObject for SVP {string} and validate whether {string} of that store in it is notnull")
	public void get_the_JSONObject_for_SVP_and_validate_whether_of_that_store_in_it_is_notnull(String Main_Attribute, String attribute) throws Throwable
	{
		gp.Validate_StoreVersionPeriods_InnerObjectAttributes_and_validate_AttributesNotNull_withinThat(Main_Attribute,attribute);
	}
	
	@Then("Get the JSON Array for SP {string}")
	public void Get_the_JSON_Array_for_SP(String attribute) throws Throwable
	{
		gp.Covert_store_parameter_to_a_json_array(attribute);
	}
	@Then("Get the JSONObject for SP {string} and validate whether {string} of that store in the parameter is notnull")
	public void Get_the_JSONObject_for_SP_and_validate_whether_of_that_store_in_the_parameter_is_notnull(String MainAttribute, String attribute) throws Throwable
	{
		gp.Validate_StoreParameters_InnerObjectAttributes_and_validate_AttributesNotNull_withinThat(MainAttribute,attribute);
	}
	@Then("Get the JSON Array for TCP {string}")
	public void Get_the_JSONArray_for_TCP(String attribute) throws Throwable
	{
		gp.Covert_temporary_closure_periods_to_a_json_array(attribute);
	}
	@Then("validate whether in TCP {string} of that store in the temporaryClosurePeriods is notnull")
	public void  validate_whether_in_TCP_of_that_store_in_the_temporaryClosurePeriods_is_notnull(String attribute) throws Throwable
	{
		gp.Validate_TemporaryClousrePeriods_InnerObjectAttributes_and_validate_AttributesNotNull_withinThat(attribute);
	}
	@Then("Get the JSON Array for SOMP {string}")
	public void Get_the_JSON_Array_for_SOMP(String attribute) throws Throwable
	{
		gp.Covert_store_OrgStructure_Membership_Periods_to_a_json_array(attribute);
	}
	@Then("validate whether in SOMP {string} of that store in the storeOrgMembershipPeriods is notnull")
	public void validate_whether_in_SOMP_of_that_store_in_the_storeOrgMembershipPeriods_is_notnull(String attribute) throws Throwable
	{
		gp.Check_storeOrgMembershipPeriods_ELEMENT_NotNull(attribute);
	}
	@Then("Get the JSONObject for SOMP {string} and validate whether {string} of that attribute is notnull")
	public void get_the_JSONObject_for_SOMP_and_validate_whether_of_that_attribute_is_notnull(String Main_attribute,String attribute) throws Throwable
	{
		gp.Validate_storeOrgStructureMembershipPeriods_InnerObjectAttributes_and_validate_AttributesNotNull_withinThat(Main_attribute,attribute);
	}
	
	@Then("Get the JSON Array for SGMP {string}")
	public void Get_the_JSON_Array_for_SGMP(String attribute) throws Throwable
	{
		gp.Covert_store_GroupMembership_Periods_to_a_json_array(attribute);
	}
	@Then("validate whether in SGMP {string} of that store in the storeGroupMembershipPeriods is notnull")
	public void validate_whether_in_SGMP_of_that_store_in_the_storeGroupMembershipPeriods_is_notnull(String attribute) throws Throwable
	{
		gp.Validate_storeGroupMembershipPeriods_Elements_NotNull(attribute);
	}
	@Then("Get the JSONObject for SGMP {string} and validate whether {string} of that attribute is notnull")
	public void Get_the_JSONObject_for_SGMP_and_validate_whether_of_that_attribute_is_notnull(String Main_Attribute, String attribute) throws Throwable
	{
		gp.Validate_storeGroupMembershipPeriods_InnerObjectAttributes_and_validate_AttributesNotNull_withinThat(Main_Attribute,attribute);
	}
	


	
	
	
}
