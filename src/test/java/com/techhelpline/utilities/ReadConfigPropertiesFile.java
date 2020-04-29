package com.techhelpline.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigPropertiesFile {

	Properties properties;
	
	public ReadConfigPropertiesFile()
	{
		
		File src=new File("./Configuration_Files/config.properties");
		
		try {
			
			FileInputStream readFile=new FileInputStream(src);
			properties=new Properties();
			properties.load(readFile);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured : "+e);
		}
	}
	
	//to get UEL
	public String getAppURL()
	{
		String appURL=properties.getProperty("appURL");
		return appURL;
		
	}
	
	//to get username
	public String getAPPUserName()
	{
		String appUserName=properties.getProperty("appUserName");
		return appUserName;
		
	}
	
	//to get password
	public String getAPPPassword()
	{
		String appPassword=properties.getProperty("appPassword");
		return appPassword;
		
	}
	
	//to get driverPath
	public String getDriverPath()
	{
		String driverPath=properties.getProperty("chromeDriverPath");
		return driverPath;
		
	}
}
