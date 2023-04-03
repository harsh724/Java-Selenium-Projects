/**
 * 
 */
package com.mystore.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author harshverma
 *
 */
public class InverntoryPage extends BaseClass{
	Action action = new Action();
	@FindBy(css = "[class=\"btn btn_primary btn_small btn_inventory\"]")
	By inventory;
	
	@FindBy(css = "[class=\"shopping_cart_link\"]")
	WebElement cart;
	
	public void collectProducts() {
		List<WebElement> productList = action.FindElements(driver, inventory);
		for(WebElement ele : productList) {
			action.click(driver, ele);
		}
	}
	
	public CartPage moveToCart() {	
		action.click(driver, cart);
		return new CartPage();
	}
}
