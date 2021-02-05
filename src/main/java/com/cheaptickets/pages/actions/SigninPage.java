package com.cheaptickets.pages.actions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.cheaptickets.base.Page;
import com.cheaptickets.pages.locators.SigninPageLocators;

public class SigninPage extends Page{

	public SigninPageLocators signin;
	String mainwindow;


	public SigninPage() {
		this.signin = new SigninPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this.signin);			
	}
	public void doSignIn(String useremail, String userpassword) {
		mainwindow = Page.driver.getWindowHandle();
		Set<String> windowHandles = Page.driver.getWindowHandles();
		Iterator<String>it = windowHandles.iterator();

		while(it.hasNext()) {
			String childWindow = it.next();
			if(!mainwindow.equalsIgnoreCase(childWindow)){
				Page.driver.switchTo().window(childWindow);	
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		type(signin.email, useremail);
		//signin.email.sendKeys(useremail);
		
		type(signin.password, userpassword);
		//signin.password.sendKeys(userpassword);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//signin.signinBtn.click(); used when log report is not implemented.
		click(signin.signinBtn);
		driver.switchTo().window(mainwindow);
	}
}
