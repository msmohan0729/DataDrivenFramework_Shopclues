package com.shopclues.qa.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.shopclues.qa.utility.TestUtil;

public class TestBase {
	public static WebDriver driver;

	public static void initialization(String browserName, String url) {
		Map prefs = new HashMap(); 
		prefs.put("profile.default_content_setting_values.notifications", 2); 
		ChromeOptions options = new ChromeOptions(); 
		options.setExperimentalOption("prefs", prefs);

		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(url);
	}
}

