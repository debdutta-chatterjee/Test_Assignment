package com.pageobjects;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public class CheckoutPage {
	
	
	public By getProductPrice_lbl(String price){
		String xpath="//*[normalize-space(text())='Total Amount']/parent::*/following-sibling::*//*[normalize-space(text())='"+price+"']";
		return By.xpath(xpath);
		
	}
	By checkOutPagePlaceOrder_btn=By.xpath("//button[normalize-space(.)='Place Order']");
	
	By checkOutPageContinue_btn=By.xpath("//button[normalize-space(.)='CONTINUE']");
	
}
