package com.shopclues.qa.utility;

import java.util.Iterator;
import java.util.Set;

import com.shopclues.qa.base.TestBase;

public class TestUtil extends TestBase {
	public String parent;

	public static long PAGE_LOAD_TIMEOUT = 90;
	public static long IMPLICIT_WAIT = 90;

	public void switchToChildWindows() {
		parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
			}
		}
	}
	
	public void closeChildWindow() {
		driver.quit();
	}
	
	public void switchToParentWindow() {
		driver.switchTo().window(parent);
	}
}
