package com.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;

public class GenericUtil {
		
	
	String url;
	String browser;
	PropertiesUtil objProp= new PropertiesUtil();
	WebDriverWait wd;
	WebDriver driver;
	
	public WebDriver initBrowser() {
		
		url =objProp.getProperty("App_Url");
		browser=objProp.getProperty("Browser");
		
		//if chrome -- rest of the code to be implemented latter
		if(browser.equalsIgnoreCase("Chrome")) {
			driver=initChromeBrowser();
		}
		else {
			
			throw new PendingException("Only Chrome Driver has been implemented!");
		}
		
		driver.navigate().to(url);
		
		return driver;
		
	}
	
	
	public WebDriver initChromeBrowser() {
		
		//initiate
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		//customize
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	
	public void terminateBrowser(WebDriver driver) {
		//terminate
		driver.quit();
		
	}
	
	public byte[] takeScreenshot(WebDriver driver) {
		//screenshot stored as byte[]		
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
	}
	
	public WebElement getVisibleElement(WebDriver driver,By locator) throws TimeoutException{
		
		//return if visible
		wd= new WebDriverWait(driver,10);
		return wd.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
}
