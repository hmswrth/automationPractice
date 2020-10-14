package com.automationpractice.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationpractice.qa.utils.BrowserSetup;

public class Main {
	public static WebDriver driver;
	public static Properties prop;
	public static JavascriptExecutor js;
	public static long PAGE_LOAD_TIMEOUT = 30;  //default value for page loadout
	public static long IMPLICIT_WAIT = 10;  //default implicit wait 
	public static WebDriverWait wait;
	public static  Actions actions;
	
	public Main() {
		
		try {
			//loading from config file
			prop = new Properties();
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/automationpractice/qa/config/config.properties");
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void init() {
		driver = BrowserSetup.setBrower(); //instantiate webdriver specified in the config file
		driver.manage().window().maximize(); //maximize the windows	
		driver.manage().deleteAllCookies(); //clear cookies
		
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); //wait for the page to load
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url")); //get url from the config file and pass it to the browser 
	
		js = (JavascriptExecutor) driver; //instantiate js executor which can be used later
		
		wait = new WebDriverWait(driver, IMPLICIT_WAIT);
		
		actions = new Actions(driver);
	}

}
