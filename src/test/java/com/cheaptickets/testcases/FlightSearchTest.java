package com.cheaptickets.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cheaptickets.base.Page;
import com.cheaptickets.errorcollectors.ErrorCollector;
import com.cheaptickets.pages.actions.HomePage;
import com.cheaptickets.utilities.Utilities;

public class FlightSearchTest {	
	
	@Test(dataProviderClass = Utilities.class, dataProvider ="dp")
	public void flightSearchTest(Hashtable<String, String>data) {
		if(data.get("Runmode").equalsIgnoreCase("N")) {
			throw new SkipException("Skipped the test as the runmode is set to No");
		}
		Page.initConfiguration();		
		HomePage home = new HomePage();
		//Assert.assertEquals(home.findTabCount(), 6);
		ErrorCollector.verifyEquals(home.findTabCount(), 7);
		home.bookFlights(data.get("fromCity"), data.get("toCity"),data.get("departDate"), data.get("returnDate"), data.get("numAdults"), data.get("numChildren"));
		//home.goToHotels();
		

	}
	@AfterMethod
	public void tearDown() {
		if(Page.driver !=null) { //if browser is present, then quit it OR it will through exception when trying to quit the browser that doesn't exist)
		Page.quitBrowser();
		}
	}

}
