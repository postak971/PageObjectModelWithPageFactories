package com.cheaptickets.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.cheaptickets.base.Page;
import com.cheaptickets.pages.locators.HomePageLocators;

public class HomePage extends Page {
	
	public HomePageLocators home;
	
	public HomePage() {
		this.home = new HomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);//Explicitwait.
		PageFactory.initElements(factory, this.home);
		
		
	}
	public HomePage goToFlights() {
		//home.flightTab.click(); //use when not implementing log report.
		click(home.flightTab); //use when implementing log report.
		
		return this;
		
	}

	public void bookFlights(String from, String to, String departing, String returning,String adultsCount, String childCount) {
		type(home.fromCity, from); //used when implementing log report with type method in the base page.
		//home.fromCity.sendKeys(from);
		
		type(home.toCity, to);
		//home.toCity.sendKeys(to);
		
		type(home.departDate, departing);
		//home.departDate.sendKeys(departing);
		
		type(home.returnDate, returning);
		//home.returnDate.sendKeys(returning);
		
		type(home.numAdults, adultsCount);
		//home.numAdults.sendKeys(adults);
		
		type(home.numChild, childCount);
		//home.numChild.sendKeys("1");
		
		type(home.ageChild1, "10");
		//home.ageChild1.sendKeys("10");
		
		//home.searchBtn.click(); used when log report is not implemented.
		click(home.searchBtn); //used when log report is implemented.
	}
	public HomePage goToHotels() {
		click(home.hotelsTab);
		return this;
		
		
	}
	public void bookHotels(String city, String checkIn, String checkOut, String noOfRooms, String noOfAdults, String noOfChildren) {
		type(home.goingTo, city);
		type(home.checkinDate, checkIn);
		type(home.checkoutDate, checkOut);
		type(home.roomCount, noOfRooms);
		type(home.adultsCount, noOfAdults);
		type(home.childrenCount, noOfChildren);
		type(home.child1Age, "7");
		type(home.child2Age, "5");
		click(home.hotelSearchBtn);
		
	}
	public void goToCars() {
		
	}
	public int findTabCount() {
		return home.tabCount.size();
	}
}
