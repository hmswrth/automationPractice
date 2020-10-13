package com.automationpractice.qa.pages;

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

	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectSubjectHeading() {
		Select select = new Select(selectBox);
		select.selectByValue("2");
	}

	public void enterEmail(String testData) {
		email.sendKeys(testData);
	}

	public void enterOrderID(String testData) {
		orderID.sendKeys(testData);
	}

	public void uploadFile() {
		fileUpload.sendKeys(System.getProperty("user.dir") + "/com/automationpractice/qa/testdata/peterpan.jpg");
	}

	public void enterMessage(String testData) {
		message.sendKeys(testData);
	}

	public void submitButton() {
		submitBtn.click();
	}

	public String verifySentMessage() {
		return successMessage.getText();
	}

}
