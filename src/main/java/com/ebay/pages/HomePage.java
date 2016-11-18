package com.ebay.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath = ".//*[@id='gh-ac']")
	private WebElement textBox;
	
	@FindBy(xpath = ".//*[@id='gh-btn']")
	private WebElement btnSearch;
	
	@FindBy(xpath = ".//*[@id='gh-cat']")
	private WebElement ddl;
	
	@FindBy(linkText = "Sign in")
	private WebElement signInLink;
	
	@FindBy(linkText = "Mobile & Accessories")
	private WebElement productAreaLink;
	
	@FindBy(id = "gh-as-a")
	private WebElement advanceSearchLink;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean loadUrl(String url) {
		driver.get(url);
		return true;
	}

	public boolean searchProduct(String productName) {
		textBox.sendKeys(productName);
		btnSearch.click();
		return true;
	}

	public boolean selectCategory(String category) {
		Select options = new Select(ddl);
		options.selectByVisibleText(category);
		return true;
	}

	public boolean clickSigninLink() {
		signInLink.click();
		return true;
	}
	
	public boolean clickProductAreaFromTab() {
		productAreaLink.click();
		return true;
	}
	
	public boolean advanceSearchLink() {
		advanceSearchLink.click();
		return true;
	}
}