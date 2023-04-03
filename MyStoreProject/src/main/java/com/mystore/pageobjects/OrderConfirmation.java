/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author harshverma
 *
 */
public class OrderConfirmation extends BaseClass{
	Action action = new Action();
	
	@FindBy(xpath = "//h2[@class = \"complete-header\"]")
	WebElement finalConfirmation;
	
	public void thanks() {
		action.click(driver, finalConfirmation);
	}
}
