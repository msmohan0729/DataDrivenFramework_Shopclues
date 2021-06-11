package com.shopclues.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopclues.qa.base.TestBase;

public class ProductPage extends TestBase{
	@FindBy(xpath = "//h1[@itemprop='name']")
	WebElement productName;
	
	@FindBy(xpath = "//span[@class='f_price']")
	WebElement productPrice;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void displayProductDetails() {
		System.out.println("Product Name : "+productName.getText());
		System.out.println("Product price : "+productPrice.getText());
		System.out.println();
		driver.close();
	}
}
