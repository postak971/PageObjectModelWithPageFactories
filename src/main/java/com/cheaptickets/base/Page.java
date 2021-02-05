package com.cheaptickets.base;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.cheaptickets.listeners.Listeners;
import com.cheaptickets.pages.actions.TopNavigation;
import com.cheaptickets.utilities.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	public static WebDriver driver; // static will stop opening a new browser after each test)
	public WebDriverWait wait;
	//public static Properties config = new Properties();
	//public static Properties OR = new Properties();
	public static FileInputStream fis;
	// public static Logger log = Logger.getLogger("devpinoyLogger");
	public static Logger log = Logger.getLogger(Page.class.getName());
	public static ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
	public static SoftAssert softAssert;
	public static TopNavigation topNav; //Access top navigation elements from any other pages that extends Page.
	String browser;

	public static void initConfiguration() {
		if (driver == null) {
			PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");			
			log.info("Logger loaded");
		}
		if(Constants.browser.equalsIgnoreCase("firefox")) {
			//if(Constants.browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			log.info("Firefox launched!!!");

		}else if(Constants.browser.equalsIgnoreCase("chrome")) {
			//else if(Constants.browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\posta\\Drivers\\chromedriver.exe");

			// stop push notifications.
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-notifications");
			// browser set up
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			log.info("Chrome launched!!!");

		}
		driver.manage().window().maximize();
		driver.get(Constants.testsiteurl);
		topNav = new TopNavigation();
		
		
	}
	//recording click event in the log report.
	public static void click(WebElement element) {
		element.click();
		log.info("Clicked on the element: " + element);
		Listeners.testReport.get().log(Status.INFO, "Clicking on : " + element);
	}
	public void type(WebElement element, String value) {
		element.sendKeys(value);
		log.info("Typed in: " + element + " the value as " + value);
		Listeners.testReport.get().log(Status.INFO, "Typing in : " + element + " entered value as " + value);
	}
	
	public static void quitBrowser() {
	
		driver.quit();
		log.info("Browser quit!!!");

	}

}
