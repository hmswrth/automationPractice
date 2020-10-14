package com.automationpractice.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.Main;

public class HomePage extends Main {
	//object repository
	
	@FindBy(xpath="//a[@title='Contact Us']")
	WebElement contactUsBtn;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement searchBtn;
	
	public HomePage() { //initializing object rep
		PageFactory.initElements(driver, this);
	}
	
	public ContactUsPage clickOnContactUsBtn() {
		contactUsBtn.click();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return new ContactUsPage();
	}
	
	public SearchResultsPage search(String searchData) {
		searchBox.sendKeys(searchData);
		searchBtn.click();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return new SearchResultsPage();
	}

}
