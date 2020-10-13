package com.automationpractice.qa.pages;

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
	
	public ContactUsPage contactUs() {
		contactUsBtn.click();
		return new ContactUsPage();
	}
	
	public SearchResultsPage search(String searchData) {
		searchBox.sendKeys(searchData);
		searchBtn.click();
		return new SearchResultsPage();
	}

}
