package com.techhelpline.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.techhelpline.utilities.ReadConfigPropertiesFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCase {
	
	public static void loginIntoApplication(String appURL, String userName, String password, String chromeDriverPath, WebDriver driver)
	{
		System.out.println("In Login Method!!!");
		try
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--ignore-certificate-errors"); //to ignore ssl certificate
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(appURL);
			
			driver.findElement(By.name("uid")).sendKeys(userName);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("btnLogin")).click();
			driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
			driver.switchTo().alert().accept();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			driver.close();
			driver.quit();
		}
		
	}
	public static void main(String[] args) {
		
		ReadConfigPropertiesFile configPropertiesFile=new ReadConfigPropertiesFile();
		
		String appURL=configPropertiesFile.getAppURL();
		String appUserName=configPropertiesFile.getAPPUserName();
		String appPassword=configPropertiesFile.getAPPPassword();
		String chromeDriverPath=configPropertiesFile.getDriverPath();
		WebDriver driver=null;
		
		System.out.println("Calling Login Method!!!!");
		loginIntoApplication(appURL, appUserName, appPassword, chromeDriverPath, driver);
		
	}

}
