package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	Action action = new Action();
	@FindBy(id = "user-name")
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement login;
	
	@FindBy(css = "[class = \"app_logo\"]")
	WebElement logo;	
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	public InverntoryPage clickOnLogin() {
		action.click(driver, login);
		return new InverntoryPage();
	}
	public boolean validateLogo() {
		return action.isDisplayed(driver, logo);
	}
	public String getTitle() {
		String myStoreTitle = driver.getTitle();
		return myStoreTitle;
	}
	public void enterUser(String username) {
		action.selectBySendkeys(username, userName);
	}
	
	public void enterPass(String Pass) {
		action.selectBySendkeys(Pass, password);
	}

	
}
