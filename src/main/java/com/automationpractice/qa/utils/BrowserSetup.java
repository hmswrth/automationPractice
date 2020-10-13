package com.automationpractice.qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetup {
	static String driverPath = System.getProperty("user.dir") + "/Drivers/";

	public static WebDriver setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", driverPath + "chormedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;

	}

}
