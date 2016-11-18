package com.ebay.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath = "//span/input[@placeholder='Email or username']")
	private WebElement useridTxtBox;
	
	@FindBy(xpath = "//span/input[@placeholder='Password']")//correct this xpath by removing '234'
	private WebElement passwordTxtBox;
	
	@FindBy(id = "sgnBt")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//span[@id='errf']")
	private WebElement loginErrorMsg;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean login(String userId, String pwd) {
		useridTxtBox.sendKeys(userId);
		passwordTxtBox.sendKeys(pwd);
		signInBtn.click();
		return true;
	}
	
	public String getLoginErrorMsg() {
		return loginErrorMsg.getText();
	}
}
