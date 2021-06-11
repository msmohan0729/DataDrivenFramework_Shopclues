package com.shopclues.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.shopclues.qa.base.TestBase;
import com.shopclues.qa.utility.TestUtil;

public class HomePage extends TestBase{
	TestUtil testUtil;
	
	@FindBy(linkText = "Sign In")
	WebElement signInLink;
	
	@FindBy(id = "autocomplete")
	WebElement searchBox;
	
	@FindBy(xpath = "//a[@class='srch_action btn orange']")
	WebElement searchButton;
	
	@FindBy(xpath = "(//h2)[1]")
	WebElement firstItem;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		
	}
	
	public LoginPage clickOnSignInLink() {
		signInLink.click();
		return new LoginPage();
	}
	
	public void searchItems(String itemName) {
		searchBox.sendKeys(itemName);
		searchButton.click();
	}
	
	public ProductPage selectFirstItem() {
		firstItem.click();
		testUtil.switchToChildWindows();
		return new ProductPage();
	}
	
	public void clearSearchText() {
		searchBox.clear();
	}
}
