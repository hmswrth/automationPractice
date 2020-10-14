package com.automationpractice.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import com.automationpractice.qa.base.Main;
import com.automationpractice.qa.pages.ContactUsPage;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.utils.ReadFromExcel;

public class ContactUsPageTest extends Main {

	HomePage home;
	ContactUsPage contact;
	Logger log = Logger.getLogger(ContactUsPageTest.class);

	public ContactUsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("chrome driver : initializing...");
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
		log.info("START : select subject heading from contact us form test");
		contact.selectSubjectHeading();
		Assert.assertEquals(contact.verifySelectBoxOption(), "Customer service");
		log.info("END : select subject heading from contact us form test");
	}

	@Test(priority = 2, dataProvider = "getSearchDataFromExcel")
	public void fillOutTheForm(String emailData, String orderIDData, String messageData) {
		log.info("START : fill all other fields in contact us form test");
		contact.fillOutTheForm(emailData, orderIDData, messageData);
		contact.submitButton();
		Assert.assertEquals(contact.verifySentMessage(), "Your message has been successfully sent to our team.");
		log.info("END : fill all other fields in contact us form test");
	}

	@AfterMethod
	public void closeBrowser() {
		log.info("chrome driver : terminated!");
		driver.quit();
	}
}
