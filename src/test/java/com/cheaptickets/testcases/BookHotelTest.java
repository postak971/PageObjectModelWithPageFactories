package com.cheaptickets.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cheaptickets.base.Page;
import com.cheaptickets.pages.actions.HomePage;
import com.cheaptickets.utilities.Utilities;

public class BookHotelTest {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")

	public void bookHotelTest(Hashtable<String, String>data) throws InterruptedException {
		if(data.get("Runmode").equalsIgnoreCase("N")) {
			throw new SkipException("Skipped the test due to runmode set to No");
		}
		Page.initConfiguration();
		HomePage home = new HomePage();
		home.goToHotels().bookHotels(data.get("city"), data.get("checkin"), data.get("checkout"), data.get("rooms"), data.get("adults"), data.get("children"));

	}
	@AfterMethod
	public void tearDown() {
		if(Page.driver != null) {
			Page.quitBrowser();
		}
	}

}
