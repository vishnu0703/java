package com.pom;

public interface SwagInterface {

	String username_xpath = "//input[@id='user-name']";
	String password_xpath = "//input[@id='password']";
	String login_xpath = "//input[@id='login-button']";
	String emptyuseremptypass_xpath = "//h3[@data-test='error']";
	String validmailemptypass_xpath = "//div[@class='error-message-container error']";
	String validmailinvalidpass_xpath = "//div[@class='error-message-container error']";
	String invalidmailinvalidpass_xpath = "//h3[@data-test='error']";
    String addtocard_xpath = "//button[@id='add-to-cart-sauce-labs-backpack']";
	String shoppingcard_xpath = "//a[@class='shopping_cart_link']";
	String checkout_xpath = "//button[@id='checkout']";
	String firstname_xpath = "//input[@name='firstName']";
	String lastname_xpath = "//input[@id='last-name']";
	String zipcode_xpath = "//input[@id='postal-code']";
	String contin_xpath = "//input[@id='continue']";
	String finish_xpath = "//button[@id='finish']";
    String thankyou_xpath = "//h2[@class='complete-header']";
    String adtocard2_xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']";
	String addtocard3_xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']";
	String addtocard4_xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']";
	String addtocard5_xpath = "//button[@id='add-to-cart-sauce-labs-onesie']";
	String threedot_xpath = "//button[@type='button']";
	String logout_xpath = "//a[@id='logout_sidebar_link']";
    String backpack_xpath = "(//div[@class='inventory_item_name '])[1]";
	String bikelight_xpath = "(//div[@class='inventory_item_name '])[2]";
	String tshirt_xpath = "(//div[@class='inventory_item_name '])[3]";
	String flceecejacket_xpath = "(//div[@class='inventory_item_name '])[4]";
	String labsonesie_xpath = "(//div[@class='inventory_item_name '])[5]";
}
