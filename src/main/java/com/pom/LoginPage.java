package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.BaseClass.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPage extends BaseClass {
	
	public WebDriver logindriver;
	
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	private WebElement siginbtn;
	
	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailid;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continbtn;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement signinbtn1;
	
	@FindBy(xpath = "(//div[@class='a-alert-content'])[3]")
	private WebElement emailError;
	
	@FindBy(xpath = "//div[@class='a-box-inner a-alert-container']")
	private WebElement passwordError;
	
	@FindBy(xpath = "(//div[@class='a-alert-content'])[3]")
	private WebElement emptyPass;
	
	@FindBy(xpath = "(//div[@class='a-alert-content'])[1]")
	private WebElement emptyEmail;
	
	@FindBy(xpath = "//*[@id='nav-link-accountList-nav-line-1']")
	private WebElement textLogin;
	
	public LoginPage(WebDriver driver) {
		logindriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	    public boolean validLogin(ExtentTest extendtest) {
		try {
//    	implicityWait(driver, 30);
		launchingUrl(driver, "https://www.amazon.in/");
		clickElement(driver, siginbtn);
		inputPassing(driver, emailid, "vishnupriyanr16@gmail.com");
		clickElement(driver, continbtn);
		inputPassing(driver, password, "vishnu88");
		clickElement(driver, signinbtn1);
		String title = textLogin.getText();
		Assert.assertEquals(title, "Hello, Vishnu");
		extendtest.log(Status.PASS, "Login Sucessfull");
		} catch(AssertionError e) {
			extendtest.log(Status.FAIL, "Login Failed: " + e.getMessage());
			return false;
		}
		return true;
		
	}
	    public void invalidEmailid() {
	    	launchingUrl(driver, "https://www.amazon.in/");
			clickElement(driver, siginbtn);
			inputPassing(driver, emailid, "vishnupriyan16@");
			clickElement(driver, continbtn);
			Assert.assertEquals(emailError.getText(), "Invalid email address.");
	    	
	    }
	    
	    public void validMailAndInvalidPassword() {
	    	launchingUrl(driver, "https://www.amazon.in/");
			clickElement(driver, siginbtn);
			inputPassing(driver, emailid, "vishnupriyanr16@gmail.com");
			clickElement(driver, continbtn);
			inputPassing(driver, password, "vishnu");
			clickElement(driver, signinbtn1);
			Assert.assertEquals(passwordError.getText(), "Your password is incorrect");
			
	    }
	    public void emailWithEmptyText() {
	    	launchingUrl(driver, "https://www.amazon.in/");
			clickElement(driver, siginbtn);
			inputPassing(driver, emailid, "");
			clickElement(driver, continbtn);
			Assert.assertEquals(emptyEmail.getText(), "Enter your mobile number or email");
	    	 }
	    
	    public void validEmailWithEmptyPassword() {
	    	launchingUrl(driver, "https://www.amazon.in/");
			clickElement(driver, siginbtn);
			inputPassing(driver, emailid, "vishnupriyanr16@gmail.com");
			clickElement(driver, continbtn);
			inputPassing(driver, password, "");
			clickElement(driver, signinbtn1);
			Assert.assertEquals(emptyPass.getText(), "Enter your password");
	    	
	    }
	
	

}
