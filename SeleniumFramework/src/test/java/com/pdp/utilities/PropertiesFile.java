package com.pdp.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	//public static Properties properties = null;
	public static Properties readPropertiesFile() {
		Properties properties = null;
		
		try {
			
			//File file = new File("Data\\"+Input+".properties");
			File file = new File("Data\\Input.properties");
			FileInputStream fileInputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInputStream);
			fileInputStream.close();	
		
	}catch(Exception e) {
		
		e.printStackTrace();
	}
	return properties;
	}
	
	public static Properties setPropertyValue(Properties property, String fileName, String field, String value) throws IOException{
		File file = new File("Data\\"+fileName+".properties");
		FileWriter fileOut = new FileWriter(file);
		try {
			
			if(!(field==null || field=="")){
				property.setProperty(field, value);				
			}
			property.store(fileOut, null);
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return property;
	}
	
}
