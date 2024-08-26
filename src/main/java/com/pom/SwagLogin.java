package com.pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.BaseClass.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import properity.FileReaderManager;

public class SwagLogin extends BaseClass implements SwagInterface {

	@FindBy(xpath = username_xpath)
	private WebElement username;

	@FindBy(xpath = password_xpath)
	private WebElement password;

	@FindBy(xpath = login_xpath)
	private WebElement login;

	@FindBy(xpath = emptyuseremptypass_xpath)
	private WebElement emptylogin;

	@FindBy(xpath = validmailemptypass_xpath)
	private WebElement validmailemptypass;

	@FindBy(xpath = validmailinvalidpass_xpath)
	private WebElement validmailinvalidpass;

	@FindBy(xpath = invalidmailinvalidpass_xpath)
	private WebElement invalidmailinvalidpass;

	public SwagLogin() {
		PageFactory.initElements(driver, this);
	}

	public boolean validLogIn(ExtentTest extenttest) throws IOException {

		try {
			launchingUrl(driver,
					FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getUrl());
			inputPassing(driver, username,
					FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getUsername());
			inputPassing(driver, password,
					FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getPassword());
			clickElement(driver, login);
			validation(driver,
					FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getHome());
			extenttest.log(Status.PASS, "Login SucessFull");
		} catch (IOException e) {

			extenttest.log(Status.FAIL, "LoginFailed" + e.getMessage());

			return false;
		}
		return true;

	}

	public void emptyUserEmptyPass() throws IOException {
		launchingUrl(driver,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getUrl());
		inputPassing(driver, null,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getUsername());
		inputPassing(driver, null,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getPassword());
		clickElement(driver, login);
		Assert.assertEquals(emptylogin.getText(), "Epic sadface: Username is required");

	}

	public void validMailEmptyPass() throws IOException {
		launchingUrl(driver,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getUrl());
		inputPassing(driver, username,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getUsername());
		inputPassing(driver, null,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getPassword());
		clickElement(driver, login);
		Assert.assertEquals(validmailemptypass.getText(), "Epic sadface: Password is required");
	}

	public void validMailinvalidPass() throws IOException {
		launchingUrl(driver,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getUrl());
		inputPassing(driver, username,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getUsername());
		inputPassing(driver, validmailinvalidpass,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getinvalidpass());
		clickElement(driver, login);
		Assert.assertEquals(validmailinvalidpass.getText(), "Epic sadface: Password is required");
	}

	public void invalidMailInvalidPass() throws IOException {
		launchingUrl(driver,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getUrl());
		inputPassing(driver, invalidmailinvalidpass,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getinvalidmail());
		inputPassing(driver, invalidmailinvalidpass,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getinvalidpass());
		clickElement(driver, login);
		Assert.assertEquals(invalidmailinvalidpass.getText(), "Epic sadface: Username is required");

	}

}
