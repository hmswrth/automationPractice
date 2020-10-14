package com.automationpractice.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.automationpractice.qa.base.Main;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.pages.SearchResultsPage;
import com.automationpractice.qa.utils.ReadFromExcel;

public class SearchResultsPageTest extends Main {
	HomePage home;
	SearchResultsPage search;
	
	Logger log = Logger.getLogger(SearchResultsPageTest.class);

	public SearchResultsPageTest() {
		super();
	}

	@BeforeClass
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

	@Test(priority = 1, dataProvider = "getSearchDataFromExcel")
	public void searchForDress(String testData) {
		log.info("START : search box test");
		search = home.search(testData);
		log.info("END : search box test");
	}

	@Test(priority = 2)
	public void addToCart() {
		log.info("START : add an item to cart test");
		search.clickAddToCart();		
		Assert.assertEquals(search.verifyProductAddedToCart(), "Product successfully added to your shopping cart");
		log.info("END : add an item to cart test");
	}

	@Test(priority = 3)
	public void clickProceedToCart() {
		log.info("START : proceed to cart test");
		search.proceedToCart();
		log.info("END : proceed to cart test");
	}

	@Test(priority = 4)
	public void increaseTheCartQuantity() {
		log.info("START : increasing the item quantity during checkout test");
		search.increaseCartItemQuantity();
		Assert.assertEquals(search.verifyWhetherCartItemValueIncreased(), "2");
		log.info("END : increasing the item quantity during checkout test");
	}
	
	@AfterClass
	public void closeBrowser() {
		log.info("chrome driver : terminated!");
		driver.quit();
	}
}
