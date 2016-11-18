package com.ebay.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileAccessoriesPage {
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Samsung']")
	private WebElement mobileNameLink;
	
	@FindBy(xpath = "//span[text()='Rs. 25001 - Rs. 35000']")
	private WebElement priceRange;
	
	@FindBy(xpath = "//div[@id='itmCont']/div")
	private List<WebElement> productDisplaySection;
	
	@FindBy(xpath = "(//div[@id='itmCont']/div)[2]")
	private WebElement productLinkFromSubCategorySection;

	public MobileAccessoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickMobileComNameLink() {
		mobileNameLink.click();
		return true;
	}
	
	public boolean selectPriceRange() {
		priceRange.click();
		return true;
	}
	
	public boolean getCountOfProductsInSelectedSubCategory() {
		for(WebElement link: productDisplaySection) {
			System.out.println("Following are the products found:\n" + link.getText());
		}
		return true;
	}
	
	public boolean clickOnProduct() {
		productLinkFromSubCategorySection.click();
		return true;
	}

}
