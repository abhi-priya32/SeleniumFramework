package com.pdp.pageobjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestPractice {

	public static void main(String[] args) {
		
		//int i =1;
		//Calendar now = Calendar.getInstance();  
		//Date now = Calendar.getInstance().getTime();        
		Date now = new Date();
	    //now.setMonth(1);
	    
		//now.setDate(10);
		now.setMonth(now.getMonth()+1);
	    System.out.println("Date : "+  now);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");  
	    //String strDate = dateFormat.format(now.getTime()); 
	    String strDate = dateFormat.format(now); 
	  
	    System.out.println("End Date : "+ strDate);
		
	}

}
