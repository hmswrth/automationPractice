package com.automationpractice.qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automationpractice.qa.base.Main;

public class BrowserSetup extends Main {
	static String driverPath = System.getProperty("user.dir") + "/Drivers/";

	public static WebDriver setBrower() {
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;

	}

}
