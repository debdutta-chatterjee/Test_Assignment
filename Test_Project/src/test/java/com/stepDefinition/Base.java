package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageobjects.CheckoutPage;
import com.pageobjects.HomePage;
import com.pageobjects.ProductPage;
import com.utility.GenericUtil;

import cucumber.api.Scenario;

public class Base {
	
	WebDriver driver;
	Scenario sc;
	WebDriverWait wd;
	
	//PageObjects
	HomePage objHome;
	CheckoutPage objCheckout;
	ProductPage objProduct;
	
	GenericUtil objUtil;
	
	
	public Base() {
		
		//init pom
		objHome= new HomePage();
		objCheckout= new CheckoutPage();
		objProduct = new ProductPage();
		
		//init util
		objUtil= new GenericUtil();
		
	}
	
	public void attachScreenshot() {
		//attache screenshot to report
		sc.embed(objUtil.takeScreenshot(driver),"image/png");
		
	}
	
	
	
	
}
