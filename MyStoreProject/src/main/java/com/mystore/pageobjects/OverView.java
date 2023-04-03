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
public class OverView extends BaseClass{
	Action action = new Action();
	
	@FindBy(id = "finish")
	WebElement finalSubmit;
	
	public OrderConfirmation clickOnFinish() {
		action.click(driver, finalSubmit);
		return new OrderConfirmation();
		
	}
	}
