package com.automationpractice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.automationpractice.qa.base.Main;
import com.automationpractice.qa.pages.ContactUsPage;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.utils.ReadFromExcel;

public class ContactUsPageTest extends Main {

	static HomePage home;
	static ContactUsPage contact;

	public ContactUsPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		init();
		home = new HomePage();
		contact = home.clickOnContactUsBtn();
	}

	@DataProvider
	public Object[][] getSearchDataFromExcel() {
		Object[][] data = ReadFromExcel.getTestData("ContactUs");
		return data;
	}

	@Test(priority = 1)
	public void selectSubjectHeading() {
		contact.selectSubjectHeading();
		Assert.assertEquals(contact.verifySelectBoxOption(), "Customer service");
	}

	@Test(priority = 2, dataProvider = "getSearchDataFromExcel")
	public void fillOutTheForm(String emailData, String orderIDData, String messageData) {
		contact.fillOutTheForm(emailData, orderIDData, messageData);
	}

	@Test(priority = 3)
	public void submitBtnClick() {
		contact.submitButton();
		Assert.assertEquals(contact.verifySentMessage(), "");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
