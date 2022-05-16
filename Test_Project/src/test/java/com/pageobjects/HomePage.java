package com.pageobjects;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public class HomePage {

	By homePageHeader_lbl=By.xpath("//img[@title='Flipkart']");
	By homePageCrossLogin_btn=By.xpath("//span[contains(text(),'Get access')]/ancestor::div[@tabIndex]/div/button");
	By homePageSearch_inp=By.xpath("//input[contains(@title,'Search for products')]");
	By homePageSearch_btn=By.xpath("//button[@type='submit']");
	
	
}
