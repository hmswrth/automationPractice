package com.automationpractice.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automationpractice.qa.base.Main;

public class SearchResultsPage extends Main {

	@FindBy(xpath = "(//a[@title='Printed Summer Dress'])[2]")
	WebElement searchListing;

	@FindBy(xpath = "//a[@title='Add to cart'])[1]")
	WebElement addToCartBtn;

	@FindBy(xpath = "(//h2)[1]")
	WebElement successMessage;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement proceedToCartBtn;

	@FindBy(xpath = "//a[@title='Add']")
	WebElement increaseCartItemBtn;

	@FindBy(xpath = "(//input[@type='hidden'])[4]")
	WebElement cartItemCount;

	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickAddToCart() {
		js.executeScript("arguments[0].scrollIntoView(true)", searchListing);
		actions.moveToElement(searchListing).perform();
		// wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
		// addToCartBtn.click();
		driver.findElement(By.xpath("(//a[@title='Add to cart'])[1]")).click();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

	public String verifyProductAddedToCart() {
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		return successMessage.getText();
	}

	public void proceedToCart() {
		wait.until(ExpectedConditions.visibilityOf(proceedToCartBtn));
		proceedToCartBtn.click();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

	public void increaseCartItemQuantity() {
		js.executeScript("arguments[0].scrollIntoView(true)", increaseCartItemBtn);
		wait.until(ExpectedConditions.visibilityOf(increaseCartItemBtn));
		increaseCartItemBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String verifyWhetherCartItemValueIncreased() {
		return cartItemCount.getAttribute("value");
	}

	public String getTitle() {
		return driver.getTitle();
	}

}
