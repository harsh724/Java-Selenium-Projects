package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass{
	Action action = new Action();
	
	@FindBy(id = "first-name")
	WebElement firstName;
	
	@FindBy(id = "last-name")
	WebElement lastName;
	
	@FindBy(id = "postal-code")
	WebElement postalCode;
	
	@FindBy(id = "continue")
	WebElement Submit;
	
	public void enterFirstName(String firstname) {
		action.selectBySendkeys(firstname, firstName);
	}
	
	public void enterLastName(String lastname) {
		action.selectBySendkeys(lastname, lastName);
	}
	
	public void enterPostalCode(String postalcode) {
		action.selectBySendkeys(postalcode, postalCode);
	}
	
	public OverView Continue() {
		action.click(driver, Submit);
		return new OverView();
	}
	
}
