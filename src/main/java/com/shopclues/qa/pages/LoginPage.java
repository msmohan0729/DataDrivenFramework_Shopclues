package com.shopclues.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.shopclues.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id = "main_user_login")
	WebElement loginUserName;
	
	@FindBy(xpath = "(//*[@class='label_jump password_txt'])[1]")
	WebElement loginPassword;
	
	@FindBy(id = "login_button")
	WebElement loginButton;
	
	@FindBy(xpath = "//*[@class='error_span_text user_login_err']")
	WebElement userNameErrorMessage;
	
	@FindBy(xpath = "//*[@class='error_span_text password_err']")
	WebElement passwordErrorMessage;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage signInUser(String userName, String password) {
		loginUserName.sendKeys(userName);
		loginPassword.sendKeys(password);
		loginButton.click();
		return new HomePage();
	}
	
	public void verifyErrorMessage() {
		if(userNameErrorMessage.isDisplayed() && passwordErrorMessage.isDisplayed()){
			System.out.println(userNameErrorMessage.getText());
			System.out.println(passwordErrorMessage.getText());
		}else if(userNameErrorMessage.isDisplayed()) System.out.println(userNameErrorMessage.getText());
		else if(passwordErrorMessage.isDisplayed()) System.out.println(passwordErrorMessage.getText());
		else System.out.println();
	}
}
