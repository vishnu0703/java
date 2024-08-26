package com.RunnerClass;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

public class PriorityClass extends BaseClass {        // priority starts from negative --> zero --> positive
	@Test(priority = 0)
	private void browser() {
		browserLaunch("chrome");
		launchingUrl(driver, "https://www.amazon.in/");
	}

	@Test(priority = 1)
	private void search() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile");
	}
	@Test(priority = 2)
	private void close() {
		driver.quit();
		
	}
	
}
