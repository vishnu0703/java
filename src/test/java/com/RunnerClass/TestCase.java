package com.RunnerClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

public class TestCase extends BaseClass {

	@BeforeTest
	private void beforeTest() {
		browserLaunch("chrome");
		launchingUrl(driver, "https://www.google.co.in/");
	}
	@AfterTest
	private void afterTest() {
		terminateBrowser(driver);
	}
	@Test(retryAnalyzer = ReTest.class)
	private void testMethod() {
		
		String title = driver.getTitle();
		assertEquals(title, "google");
	}

}
