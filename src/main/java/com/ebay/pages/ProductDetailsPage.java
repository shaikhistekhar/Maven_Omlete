package com.ebay.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

WebDriver driver;
	
	@FindBy(id = "bidBtn_btn")  //remove 123 from xpath OR css=#bidBtn_btn[rel*='nofollow']
	private WebElement btnPlaceBid;
	
	@FindBy(id = "isCartBtn_btn")
	private WebElement addToCartButton;
	
	@FindBy(id = "smtBackToAnchor")
	private WebElement backToSearchResultListLink;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean presenceOfPlaceBidButton() {
		if (btnPlaceBid.isDisplayed()) {
			System.out.println("Place bid button is displayed");
		}
		else {
			System.out.println("Place bid button is not displayed");
		}
		return true;
	}
	
	public boolean clickAddToCartButton()
	{
		addToCartButton.click();
		return true;
	}
	
	public boolean clickBackToSearchResultListLink() {
		driver.manage().window().maximize();
		backToSearchResultListLink.click();
		return true;
	}
}