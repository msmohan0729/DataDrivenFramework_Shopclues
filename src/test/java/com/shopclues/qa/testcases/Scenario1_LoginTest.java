package com.shopclues.qa.testcases;

import org.testng.annotations.Test;
import com.shopclues.qa.base.TestBase;
import com.shopclues.qa.pages.HomePage;
import com.shopclues.qa.pages.LoginPage;
import com.shopclues.qa.utility.Xls_Reader;

public class Scenario1_LoginTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	Xls_Reader reader;
	static int rowCount;
	
	@Test
	public void newTest() {
		reader = new Xls_Reader("src\\main\\java\\com\\shopclues\\qa\\testdata\\testdata.xlsx");
		rowCount = reader.getRowCount("credentials");
		
		for(int row = 2, index=1; row <= rowCount; row++, index++) {
			initialization("chrome", "https://www.shopclues.com/");
			homePage = new HomePage();
			loginPage = homePage.clickOnSignInLink();
			System.out.println("Credentials "+index);
			System.out.println("Email or PhoneNumber :"+reader.getCellData("credentials", "username", row));
			System.out.println("password :"+reader.getCellData("credentials", "password", row));
			loginPage.signInUser(reader.getCellData("credentials", "username", row), reader.getCellData("credentials", "password", row));
			loginPage.verifyErrorMessage();
			System.out.println();
			driver.quit();
		}	
	}
}
