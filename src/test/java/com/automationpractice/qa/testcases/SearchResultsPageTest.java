package com.automationpractice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.automationpractice.qa.base.Main;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.pages.SearchResultsPage;
import com.automationpractice.qa.utils.ReadFromExcel;

public class SearchResultsPageTest extends Main {
	HomePage home;
	SearchResultsPage search;

	public SearchResultsPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
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
		search = home.search(testData);
	}

	@Test(priority = 2)
	public void addToCart() {
		search.clickAddToCart();		
		Assert.assertEquals(search.verifyProductAddedToCart(), "Product successfully added to your shopping cart");
	}

	@Test(priority = 3)
	public void clickProceedToCart() {
		search.proceedToCart();
	}

	@Test(priority = 4)
	public void increaseTheCartQuantity() {
		search.increaseCartItemQuantity();
		Assert.assertEquals(search.verifyWhetherCartItemValueIncreased(), "2");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
