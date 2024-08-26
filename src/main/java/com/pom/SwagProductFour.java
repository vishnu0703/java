package com.pom;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.BaseClass.BaseClass;

import properity.FileReaderManager;

public class SwagProductFour extends BaseClass implements SwagInterface {

	@FindBy(xpath = username_xpath)
	private WebElement username;

	@FindBy(xpath = password_xpath)
	private WebElement password;

	@FindBy(xpath = login_xpath)
	private WebElement login;

	@FindBy(xpath = addtocard4_xpath)
	private WebElement addtocard4;

	@FindBy(xpath = shoppingcard_xpath)
	private WebElement shoppingcard;

	@FindBy(xpath = checkout_xpath)
	private WebElement checkout;

	@FindBy(xpath = firstname_xpath)
	private WebElement firstname;

	@FindBy(xpath = lastname_xpath)
	private WebElement lastname;

	@FindBy(xpath = zipcode_xpath)
	private WebElement zipcode;

	@FindBy(xpath = contin_xpath)
	private WebElement contin;

	@FindBy(xpath = finish_xpath)
	private WebElement finish;

	@FindBy(xpath = backpack_xpath)
	private WebElement productone;

	@FindBy(xpath = thankyou_xpath)
	private WebElement thankyou;

	@FindBy(xpath = threedot_xpath)
	private WebElement threedot;

	@FindBy(xpath = logout_xpath)
	private WebElement logout;

	@FindBy(xpath = thankyou_xpath)
	private WebElement thankyou3;

	@FindBy(xpath = flceecejacket_xpath)
	private WebElement jack;

	public SwagProductFour() {
		PageFactory.initElements(driver, this);
	}

	public void productFour() throws IOException {

		inputPassing(driver, username,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getUsername());
		inputPassing(driver, password,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getPassword());
		clickElement(driver, login);

		Assert.assertEquals(getText(driver, jack), "Sauce Labs Fleece Jacket");

		clickElement(driver, addtocard4);
		clickElement(driver, shoppingcard);
		clickElement(driver, checkout);
		inputPassing(driver, firstname,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getfirstname4());
		inputPassing(driver, lastname,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getlastname4());
		inputPassing(driver, zipcode,
				FileReaderManager.getInstanceFileReaderManager().getInstanceConfigurationReader().getzipcode4());
		clickElement(driver, contin);
		clickElement(driver, finish);
		Assert.assertEquals(getText(driver, thankyou3), "Thank you for your order!");
		clickElement(driver, threedot);
		clickElement(driver, logout);

	}
}
