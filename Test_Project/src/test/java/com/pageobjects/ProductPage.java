package com.pageobjects;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public class ProductPage {
	
	By productPageAddToCart_btn=By.xpath("//button[normalize-space(.)='ADD TO CART']");
	
	
	public By getProductLink(String index){
		String xpath="(//div[@data-id]//a)[<param>]";
		return By.xpath(xpath.replace("<param>",index));
		
	}
	
	
	public By getProductPrice(String index){
		String xpath="(//div[@data-id]//a)[<param>]//span[contains(text(),'off')]/parent::*/parent::*/div[1]";
		return By.xpath(xpath.replace("<param>",index));
		
	}
	
	
}
