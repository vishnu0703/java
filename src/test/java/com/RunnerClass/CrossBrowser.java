package com.RunnerClass;

import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

public class CrossBrowser extends BaseClass {
	@Test(enabled = false)
	private void chrome() {
		browserLaunch("chrome");
		launchingUrl(driver, "https://www.google.co.in/");
		terminateBrowser(driver);
		
	}
	@Test(invocationCount = 3 )
	public void firefox() {
			browserLaunch("firefox");
			launchingUrl(driver, "https://www.google.co.in/");
			terminateBrowser(driver);
			
	}
	@Test(timeOut = 1000)
	public void edge() {
		browserLaunch("edge");
		launchingUrl(driver, "https://www.google.co.in/");
		terminateBrowser(driver);
	}
	

}
