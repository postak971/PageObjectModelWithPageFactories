package com.cheaptickets.rough;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SigninTestWithMainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.cheaptickets.com/");
		
		String mainWindow = driver.getWindowHandle();
		
		driver.findElement(By.cssSelector("#header-account-menu")).click();	
		driver.findElement(By.cssSelector("#account-signin")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String>it = windowHandles.iterator();
		
		while(it.hasNext()) {
			String childWindow = it.next();
			if(!mainWindow.equalsIgnoreCase(childWindow)){
				driver.switchTo().window(childWindow);				
			}
		}
		driver.findElement(By.cssSelector("#gss-signin-email")).sendKeys("test@gmail.com");
		driver.findElement(By.cssSelector("#gss-signin-password")).sendKeys("abcdefgs");
		driver.findElement(By.cssSelector("#gss-signin-submit")).click();

	}

}
