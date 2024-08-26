package com.RunnerClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.listner.ExtentReport_Test;
import com.listner.iTestListenerClass;
import com.pom.LoginPage;

import junit.framework.Assert;

@Listeners(iTestListenerClass.class)
public class AmazonRunnerClass extends BaseClass {
	
	@BeforeSuite
	public static void extendStratup() {
		extentReportStart("C:\\Users\\VISHNU\\eclipse-workspace\\AugIPT\\Reports");
		}
	
	public static WebDriver driver;
	
	@BeforeTest
	public static void setup() {
		driver = BaseClass.browserLaunch("chrome");
	}
	
	@Test(priority = -5)
	public static void validLoginTest() {
		ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + " : " + Thread.currentThread()
		.getStackTrace()[1].getMethodName().toString()).info("Valid Emailid with Valid Password");
		LoginPage ip = new LoginPage(driver);
		Assert.assertTrue(ip.validLogin(ExtentReport_Test.extenttest));
	}
	@Test(priority = 0)
	public static void invalidMailidLoginTest() {
		ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + " : " + Thread.currentThread()
		.getStackTrace()[1].getMethodName().toString()).info("Valid Emailid with Valid Password");
		LoginPage ip = new LoginPage(driver);
		ip.invalidEmailid();
		
	}
	@Test(priority = 1)
	public static void validMailidInvalidPasswordLoginTest() {
		ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + " : " + Thread.currentThread()
		.getStackTrace()[1].getMethodName().toString()).info("Valid Emailid with Valid Password");
		LoginPage ip = new LoginPage(driver);
		ip.validMailAndInvalidPassword();
		
	}
	@Test(priority = 2)
	public static void validMailidEmptyPasswordLoginTest() {
	ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + " : " + Thread.currentThread()
		.getStackTrace()[1].getMethodName().toString()).info("Valid Emailid with Valid Password");
		
		
		
		LoginPage ip = new LoginPage(driver);
		ip.validEmailWithEmptyPassword();
	}
	@Test(priority = 3)
	public static void emptyEmailLoginTest() {
		ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + " : " + Thread.currentThread()
		.getStackTrace()[1].getMethodName().toString()).info("Valid Emailid with Valid Password");
		LoginPage ip = new LoginPage(driver);
		ip.emailWithEmptyText();
		
	}
	
	@AfterTest
	public static void browserClose() {
		terminateBrowser(driver);
	}
	


	@AfterSuite
	public static void extendReportEnd() throws IOException {
		extentReportTearDown("C:\\Users\\VISHNU\\eclipse-workspace\\AugIPT\\Reports\\index.html");
	}
	
	}
	

