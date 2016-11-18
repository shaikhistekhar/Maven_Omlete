package com.ebay.pages;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDescription {
	WebDriver driver;

	@FindBy(id = "subCat2")
	private WebElement productDescription;
	
	@FindBy(linkText = "Tell us what you think")
	private WebElement feedbackLink;
	
	public ProductDescription(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickProductDescriptionLink() {
		productDescription.click();
		return true;
	}
	
	public boolean clickTellUsWhatYouThinkLink() {
		feedbackLink.click();
		
		Set<String> strIds = driver.getWindowHandles();
		Iterator<String> itr = strIds.iterator();
		String mainWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		System.out.println("Survey URL: " + driver.getCurrentUrl());
		return true;
	}
	
}