/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author harshverma
 *
 */
public class CartPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(id = "checkout")
	WebElement checkout;
	
	public ShippingPage checkout() {
		action.click(driver, checkout);
		return new ShippingPage();
	}

}
