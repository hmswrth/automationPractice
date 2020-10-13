package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.Main;

public class SearchResultsPage extends Main {

	@FindBy(xpath = "//a[@title='Add to cart'])[1]")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "(//h2)[1]")
	WebElement successMessage;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement proceedToCartBtn;
	
	@FindBy(xpath="//a[@title='Add']")
	WebElement increaseCartItemBtn;
	
	@FindBy(xpath="(//input[@type='hidden'])[4]")
	WebElement cartItemCount;

	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickAddToCart() {
		addToCartBtn.click();
	}
	
	public String verifyProductAddedToCart() {
		return successMessage.getText();
	}
	
	public void proceedToCart() {
		proceedToCartBtn.click();
	}
	
	public void increaseCartItemQuantity() {
		increaseCartItemBtn.click();
	}
	
	public String verifyWhetherCartItemValueIncreased() {
		return cartItemCount.getAttribute("value");
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

}
