package com.ebay.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductFeedbackPage {

	WebDriver driver;
	
	@FindBy(xpath = "//textarea[@id='584508421']")
	private WebElement commentTextBox;

	public ProductFeedbackPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPresenceOfCommentTextBox() {
		commentTextBox.isDisplayed();
		return true;
	}
	
	public boolean enterFeedbackComment(String commentText) {
		commentTextBox.sendKeys(commentText);
		return true;
	}
}
