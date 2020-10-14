package com.automationpractice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.automationpractice.qa.base.Main;
import com.automationpractice.qa.pages.ContactUsPage;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.utils.ReadFromExcel;

public class ContactUsPageTest extends Main {

	HomePage home;
	ContactUsPage contact;

	public ContactUsPageTest() {
		super();
	}

	@BeforeMethod
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
		contact.submitButton();
		Assert.assertEquals(contact.verifySentMessage(), "Your message has been successfully sent to our team.");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
