package com.cheaptickets.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.cheaptickets.base.Page;
import com.cheaptickets.pages.locators.TopNavigationLocators;

public class TopNavigation { //can not extend Page. TopNavigation IS not a Page but HAS Page)
	
	public TopNavigationLocators topNavigation;
	
	public TopNavigation() {
		this.topNavigation = new TopNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(Page.driver, 10);
		PageFactory.initElements(factory, this.topNavigation);
	}
	
	
	public SigninPage goToSignIn() { //goToSignIn takes to SigninPage.
		Page.click(topNavigation.account);
		Page.click(topNavigation.signin);
		return new SigninPage();
		
		
	}
	public void goToCreateAccount() {
		Page.click(topNavigation.createAccount);
		
	}
	
	public void goToSupport() {
		
		
	}

}
