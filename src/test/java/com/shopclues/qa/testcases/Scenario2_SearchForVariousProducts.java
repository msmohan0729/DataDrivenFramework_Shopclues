package com.shopclues.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopclues.qa.base.TestBase;
import com.shopclues.qa.pages.HomePage;
import com.shopclues.qa.pages.ProductPage;
import com.shopclues.qa.utility.TestUtil;
import com.shopclues.qa.utility.Xls_Reader;

public class Scenario2_SearchForVariousProducts extends TestBase {
	HomePage homePage;
	ProductPage productPage;
	Xls_Reader reader;
	int rowCount;
	TestUtil testUtil;
	
	@BeforeMethod
	public void setUp() {
		reader = new Xls_Reader("src\\main\\java\\com\\shopclues\\qa\\testdata\\testdata.xlsx");
		rowCount = reader.getRowCount("credentials");
	}
	
	@Test
	public void searchProductsTest() {
		for(int row=2; row<=rowCount; row++) {
			initialization("chrome", "https://www.shopclues.com/");
			homePage = new HomePage();
			testUtil = new TestUtil();
			System.out.println("Search Product : "+reader.getCellData("productstosearch", "products name", row) );
			homePage.searchItems(reader.getCellData("productstosearch", "products name", row));
			productPage = homePage.selectFirstItem();
			productPage.displayProductDetails();
			driver.quit();
		}
	}
	
}
