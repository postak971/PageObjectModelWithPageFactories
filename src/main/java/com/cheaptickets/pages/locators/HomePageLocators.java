package com.cheaptickets.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
	@FindBy(css="#tab-flight-tab-hp")
	public WebElement flightTab;
	
	@FindBy(css = "#tab-hotel-tab-hp")
	public WebElement hotelsTab;
	
	//Locators for flight booking.
	
	@FindBy(css = "#flight-origin-hp-flight")
	public WebElement fromCity;
	
	@FindBy(css = "#flight-destination-hp-flight")
	public WebElement toCity;
	
	@FindBy(css = "#flight-departing-hp-flight")
	public WebElement departDate;
	
	@FindBy(css = "#flight-returning-hp-flight")
	public WebElement returnDate;
	
	@FindBy(css = "#flight-adults-hp-flight")
	public WebElement numAdults;
	
	@FindBy(css = "	#flight-children-hp-flight")
	public WebElement numChild;
	
	@FindBy(css = "#flight-age-select-1-hp-flight")
	public WebElement ageChild1;
	
	@FindBy(css="div.cols-nested:nth-child(23) > label:nth-child(1) > button")
	public WebElement searchBtn;
	
	@FindBy(css = "li[role='presentation']")
	public List<WebElement> tabCount;
	
	//Locators for hotels booking.
	@FindBy(css = "#hotel-destination-hp-hotel")
	public WebElement goingTo;
	
	@FindBy(css = "#hotel-checkin-hp-hotel")
	public WebElement checkinDate;
	
	@FindBy(css = "#hotel-checkout-hp-hotel")
	public WebElement checkoutDate;
	
	@FindBy(css = "#hotel-rooms-hp-hotel")
	public WebElement roomCount;
	
	@FindBy(css = "#hotel-1-adults-hp-hotel")
	public WebElement adultsCount;
	
	@FindBy(css = "#hotel-1-children-hp-hotel")
	public WebElement childrenCount;
	
	@FindBy(css = "#hotel-1-age-select-1-hp-hotel")
	public WebElement child1Age;
	
	@FindBy(css = "#hotel-1-age-select-2-hp-hotel")
	public WebElement child2Age;
	
	@FindBy(css = "#gcw-hotel-form-hp-hotel > div:nth-child(11) > label:nth-child(1) > button")
	public WebElement hotelSearchBtn;
	
	
	
	

}
