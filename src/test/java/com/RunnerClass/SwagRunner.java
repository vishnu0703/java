package com.RunnerClass;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.listner.ExtentReport_Test;
import com.listner.iTestListenerClass;
import com.pom.LoginPage;
import com.pom.ProductOne;
import com.pom.SwagLogin;
import com.pom.SwagProductFive;
import com.pom.SwagProductFour;
import com.pom.SwagProductOne;
import com.pom.SwagProductThree;
import com.pom.SwagProductTwo;

import junit.framework.Assert;
import properity.FileReaderManager;

@Listeners(iTestListenerClass.class)

public class SwagRunner extends BaseClass {

	@BeforeSuite
	public static void startTest() {
		extentReportStart("C:\\Users\\VISHNU\\eclipse-workspace\\AugIPT\\Reports");
	}

	@BeforeTest
	public void setUp() throws IOException {
		browserLaunch(FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getBrowser());
	}

	@Test(priority = -10)
	public void LoginTest() throws IOException {
		ExtentReport_Test.extenttest = extentReports
				.createTest("LoginTest" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid Emailid with Valid Password");

		SwagLogin ip = new SwagLogin();
		Assert.assertTrue(ip.validLogIn(ExtentReport_Test.extenttest));
	}

	@Test(priority = -9)
	public void emptyUserEmptyPassLogin() throws IOException {
		ExtentReport_Test.extenttest = extentReports
				.createTest(
						"EmptyLoginTest" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Empty Emailid with Empty Password");

		SwagLogin ip = new SwagLogin();
		ip.emptyUserEmptyPass();
	}

	@Test(priority = -8)
	public void validmailEmptyPass() throws IOException {
		ExtentReport_Test.extenttest = extentReports
				.createTest("ValidMailEmptyPass LoginTest" + " : "
						+ Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid Emailid with Empty Password");

		SwagLogin ip = new SwagLogin();
		ip.validMailEmptyPass();
	}

	@Test(priority = -7)
	public void validmailInvalidPass() throws IOException {
		ExtentReport_Test.extenttest = extentReports
				.createTest("ValidMailInvalidPass LoginTest" + " : "
						+ Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid Emailid with Invalid Password");

		SwagLogin ip = new SwagLogin();
		ip.validMailinvalidPass();
	}

	@Test(priority = -6)
	public void invaldMailinvalidPass() throws IOException {
		ExtentReport_Test.extenttest = extentReports
				.createTest("InvalidMailInvalidPass LoginTest" + " : "
						+ Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Invalid Emailid with Invalid Password");

		SwagLogin ip = new SwagLogin();
		ip.invalidMailInvalidPass();
	}

	@Test(priority = -5)
	public void productOneLogin() throws IOException {

		ExtentReport_Test.extenttest = extentReports.createTest(
				"Sauce Labs Backpack" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Login");

		SwagProductOne sp1 = new SwagProductOne();
		sp1.productOne();

	}

	@Test(priority = -4)
	public void productTwoLogin() throws IOException {

		ExtentReport_Test.extenttest = extentReports.createTest(
				"Sauce Labs Bike Light" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Login");

		SwagProductTwo sp2 = new SwagProductTwo();
		sp2.ProductTwo();
	}

	@Test(priority = -3)
	public void productThreeLogin() throws IOException {

		ExtentReport_Test.extenttest = extentReports.createTest("Sauce Labs Bolt T-Shirt" + " : "
				+ Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Login");

		SwagProductThree sp3 = new SwagProductThree();
		sp3.ProductThree();
	}

	@Test(priority = -2)
	public void productFourLogin() throws IOException {

		ExtentReport_Test.extenttest = extentReports.createTest("Sauce Labs Fleece Jacket" + " : "
				+ Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Login");

		SwagProductFour sp4 = new SwagProductFour();
		sp4.productFour();
	}

	@Test(priority = -1)
	public void productFiveLogin() throws IOException {

		ExtentReport_Test.extenttest = extentReports.createTest("Sauce Labs Fleece Jacket" + " : "
				+ Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Login");

		SwagProductFive sp5 = new SwagProductFive();
		sp5.productFive();

	}

	@AfterTest
	public void close() {
		terminateBrowser(driver);
	}

	@AfterSuite
	public static void endTest() throws IOException {
		extentReportTearDown("C:\\Users\\VISHNU\\eclipse-workspace\\AugIPT\\Reports\\index.html");
	}

}
