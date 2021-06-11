package com.shopclues.qa.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.shopclues.qa.base.TestBase;


public class Scenario3_SearchAndCountUsingRobotClass extends TestBase{
	Robot robot;
	Actions actions;
	
	
	@Test
	public void searchTest() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		initialization("chrome", "https://www.shopclues.com/");
		driver.findElement(By.id("autocomplete")).sendKeys("Nike shoes");
		
		int xValue = driver.findElement(By.xpath("//a[@class='srch_action btn orange']")).getLocation().getX();
		int yValue = driver.findElement(By.xpath("//a[@class='srch_action btn orange']")).getLocation().getY();
		robot.mouseMove(xValue, yValue);
		robot.delay(2000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(6000);
		driver.findElement(By.xpath("//a[@class='srch_action btn orange']")).click();
		String totalResult = driver.findElement(By.id("instdcnt")).getText();
		System.out.println(totalResult);
	}
}
