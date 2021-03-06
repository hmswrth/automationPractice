package com.automationpractice.qa.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.qa.base.Main;

public class ContactUsPage extends Main {
	// Object Repository
	@FindBy(xpath = "//select")
	WebElement selectBox;

	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='id_order']")
	WebElement orderID;

	@FindBy(xpath = "//input[@id='fileUpload']")
	WebElement fileUpload;

	@FindBy(xpath = "//textarea[@id='message']")
	WebElement message;

	@FindBy(xpath = "//button[@id='submitMessage']")
	WebElement submitBtn;

	@FindBy(xpath = "//*[@id='center_column']/p")
	WebElement successMessage;

	@FindBy(xpath = "//*[@id='uniform-id_contact']/span")
	WebElement selectBoxOption;

	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectSubjectHeading() {
		Select select = new Select(selectBox);
		select.selectByValue("2");
//		log.info("subject heading selected successfully");
	}

	public void enterEmail(String testData) {
		email.sendKeys(testData);
//		log.info("email id entered successfully");
	}

	public void enterOrderID(String testData) {
		double temp = Double.parseDouble(testData);
		int order = (int) temp;
		orderID.sendKeys(Integer.toString(order));
//		log.info("order ID entered successfully");
	}

	public void uploadFile() {
		fileUpload.sendKeys(System.getProperty("user.dir") + "/com/automationpractice/qa/testdata/peterpan.jpg");
//		log.info("file uploaded successfully");
	}

	public void enterMessage(String testData) {
		message.sendKeys(testData);
//		log.info("message entered successfully");
	}

	public void submitButton() {
		submitBtn.click();
//		log.info("Form submitted successfully");
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
	}

	public String verifySentMessage() {
		return successMessage.getText();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String verifySelectBoxOption() {
		return selectBoxOption.getText();

	}

	public void fillOutTheForm(String emailData, String orderIDData, String messageData) { // fills out all the input
																							// details in the form
		this.selectSubjectHeading();
		this.enterEmail(emailData);
		this.enterOrderID(orderIDData);
		this.enterMessage(messageData);
	}

}
