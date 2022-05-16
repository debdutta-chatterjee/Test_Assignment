package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	Properties objProp;
	
	public PropertiesUtil() {
		objProp= new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File("Test_Data/Config.properties"));
			try {
				objProp.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String getProperty(String key) {
		//return the property value if found, else null
		return objProp.getProperty(key);
		
	}
}
