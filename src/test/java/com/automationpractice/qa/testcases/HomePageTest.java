package com.automationpractice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.automationpractice.qa.base.Main;
import com.automationpractice.qa.pages.ContactUsPage;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.pages.SearchResultsPage;
import com.automationpractice.qa.utils.ReadFromExcel;

public class HomePageTest extends Main {
	static HomePage home;
	static SearchResultsPage searchResultsPage;
	static ContactUsPage contactUs;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod	
	public void setUp() {
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
		searchResultsPage = home.search(testData);	 
		Assert.assertEquals(searchResultsPage.getTitle(), "Search - My Store","Successfully navigated to the search results us page");
	}
	
	@Test(priority = 2)
	public void contactUsTest() {
		contactUs = home.clickOnContactUsBtn();
		Assert.assertEquals(contactUs.getTitle(), "Contact us - My Store", "Successfully navigated to the contact us page");	
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
