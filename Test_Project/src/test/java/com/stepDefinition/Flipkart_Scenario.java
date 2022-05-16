package com.stepDefinition;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Flipkart_Scenario extends Base {

	String strPrice;

	// Hooks
	@Before
	public void BeforeScenario(Scenario sc) {
		super.sc = sc;
		driver = objUtil.initBrowser();
		wd = new WebDriverWait(driver, 10);
	}

	@After
	public void afterScenario() {

		objUtil.terminateBrowser(driver);
	}

	@Given("^Uer is at the Flipkart home page$")
	public void uer_is_at_the_flipkart_home_page() throws Throwable {

		// cross the login popup
		try {
			objUtil.getVisibleElement(driver, objHome.getHomePageCrossLogin_btn()).click();
		} catch (Exception e) {
		}

		// verify header
		objUtil.getVisibleElement(driver, objHome.getHomePageHeader_lbl()).isDisplayed();
		attachScreenshot();

		sc.write("Navigated to home page");
	}

	@When("^User searched for (.+) in the search section$")
	public void user_searched_for_in_the_search_section(String productname) throws Throwable {
		// search the item
		objUtil.getVisibleElement(driver, objHome.getHomePageSearch_inp()).sendKeys(productname);
		attachScreenshot();
		objUtil.getVisibleElement(driver, objHome.getHomePageSearch_btn()).click();

		sc.write("searched product" + productname);

	}

	@Then("^User navigates to cart and validates the price$")
	public void user_navigates_to_cart_and_validates_the_price() throws Throwable {

		objUtil.getVisibleElement(driver, objProduct.getProductPageAddToCart_btn()).click();

		boolean flag = objUtil.getVisibleElement(driver, objCheckout.getProductPrice_lbl(strPrice)).isDisplayed();

		try {
			Assert.assertTrue(flag, "Price of orderd item should match" + strPrice);
		} catch (Exception e) {
			attachScreenshot();
			throw e;
		}
		sc.write("Product Price matched" + strPrice);
		attachScreenshot();
	}

	@And("^User Selects the (.+) th mobile for checkout$")
	public void user_selects_the_th_mobile_for_checkout(String productindex) throws Throwable {

		strPrice = objUtil.getVisibleElement(driver, objProduct.getProductPrice(productindex)).getText().trim();

		String baseHandle = driver.getWindowHandle();
		objUtil.getVisibleElement(driver, objProduct.getProductLink(productindex)).click();

		wd.until(ExpectedConditions.numberOfWindowsToBe(2));

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(baseHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}

		attachScreenshot();
		sc.write("stored product price" + strPrice);

	}

	@And("^User places order and navigate to order page$")
	public void user_places_order_and_navigate_to_order_page() throws Throwable {

		objUtil.getVisibleElement(driver, objCheckout.getCheckOutPagePlaceOrder_btn()).click();
		boolean flag = objUtil.getVisibleElement(driver, objCheckout.getCheckOutPageContinue_btn()).isDisplayed();

		try {
			Assert.assertTrue(flag, "User should navigate to checkout page");
		} catch (Exception e) {
			attachScreenshot();
			throw e;
		}
		sc.write("Navigated to Chekout page.");
		attachScreenshot();

	}

}
