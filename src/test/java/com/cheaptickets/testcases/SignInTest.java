package com.cheaptickets.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cheaptickets.base.Page;
import com.cheaptickets.pages.actions.SigninPage;
import com.cheaptickets.utilities.Utilities;

public class SignInTest {
	
	@Test(dataProviderClass = Utilities.class, dataProvider ="dp")
	public void signinTest(Hashtable<String, String>data) {	
		
		if(data.get("Runmode").equalsIgnoreCase("N")) {
			throw new SkipException("Skipped the test as the runmode is set to No");
		}
		Page.initConfiguration();
		SigninPage signin = Page.topNav.goToSignIn();
		signin.doSignIn(data.get("username"),data.get("password"));	
		
	}
	@AfterMethod
	public void tearDown() {
		if(Page.driver !=null) { //if browser is present, then quit it OR it will through exception when trying to quit the browser that doesn't exist)
		Page.quitBrowser();
		}
	}
}
