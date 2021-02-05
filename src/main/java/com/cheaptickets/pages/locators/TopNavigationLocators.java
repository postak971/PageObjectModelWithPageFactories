package com.cheaptickets.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavigationLocators {
	
	@FindBy(css = "#header-account-menu")
	public WebElement account;
	
	@FindBy(css = "#account-signin")
	public WebElement signin;
	
	@FindBy(css = "#account-register")
	public WebElement createAccount;

}
