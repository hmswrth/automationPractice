package com.automationpractice.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.automationpractice.qa.base.Main;
import com.automationpractice.qa.pages.ContactUsPage;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.pages.SearchResultsPage;
import com.automationpractice.qa.utils.ReadFromExcel;

public class HomePageTest extends Main {
	HomePage home;
	SearchResultsPage searchResultsPage;
	ContactUsPage contactUs;
	
	Logger log = Logger.getLogger(HomePageTest.class);
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod	
	public void setUp() {
		log.info("chrome driver : initializing...");
		init();
		home = new HomePage();
	}
	
	@DataProvider
	public Object[][] getSearchDataFromExcel() {
		Object[][] data = ReadFromExcel.getTestData("Search");
		return data;
	}
	
	@Test(priority = 0, dataProvider = "getSearchDataFromExcel" )
	public void searchBoxTest(String testData) {
		log.info("START : search box test");
		searchResultsPage = home.search(testData);	 
		Assert.assertEquals(searchResultsPage.getTitle(), "Search - My Store","Successfully navigated to the search results us page");
		log.info("END : search box test");
	}
	
	@Test(priority = 2)
	public void contactUsTest() {
		log.info("START : contact us button test");
		contactUs = home.clickOnContactUsBtn();
		Assert.assertEquals(contactUs.getTitle(), "Contact us - My Store", "Successfully navigated to the contact us page");	
		log.info("END : contact us button test");
	}
	
	@AfterMethod
	public void closeBrowser() {
		log.info("chrome driver : terminated!");
		driver.quit();
	}

}
