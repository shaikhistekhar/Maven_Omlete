package com.ebay.pages;


import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ResultsPage {
	public static String firstProductName;
	public static String secondProductName;

	WebDriver driver;
	
	@FindBy(xpath = "(//label/span[@class='rbx'])[2]")
	private WebElement auctionRadioBtn;
	
	@FindBy(xpath = "(//li/h3/a)[1]")   //  (.//h3/a)[1]
	private WebElement firstProductLink;
	
	@FindBy(xpath = "(//li/h3/a)[2]")
	private WebElement secondProductLink;
	
	@FindBy(xpath = "(.//h3/a)[1]")
	private WebElement productLinkElement;
	
	@FindBy(css = "#bidBtn_btn[rel*='nofollow']")
	private WebElement btnPlaceBid;
	
	@FindBy(xpath = "//div[@id='ResultSetItems']/ul[@id='ListViewInner']/li")
	private List<WebElement> advanceResultProductLinks;
	
	@FindBy(xpath = "//div[@class='bclt']/span[1]")
	private WebElement resultCountLabel;
	
	@FindBy(linkText = "Best Match")
	private WebElement mainMenu;
	
	@FindBy(xpath = "//a[contains(text(),'Price: lowest first')]")
	private WebElement subMenu;
	
	@FindBy(linkText = "Price: lowest first")
	private WebElement afterSelection;
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean clickOnAuction() {
		if (!auctionRadioBtn.isSelected()) {
			System.out.println("Clicking Radio button");
			auctionRadioBtn.click();
		} else {
			System.out.println("Radio button already selected");
		}
		return true;
	}

	public boolean clickOnFirstProduct() {
		firstProductName = firstProductLink.getText();
		System.out.println("While clicking on first link from results page: " + firstProductName);
		firstProductLink.click();
		return true;
	}
	
	public boolean clickOnSecondProduct() {
		String secondProductName = secondProductLink.getText();
		System.out.println("While clicking on second link from results page: " + secondProductName);
		secondProductLink.click();
		return true;
	}

	public boolean presenceOfFirstProductLink() {
		if (productLinkElement.isDisplayed()) {
			System.out.println("First link is present");
		} else {
			System.out.println("First link is not present");
		}
		return true;
	}
	
	public void presenceOfPlaceBidButton() {
		if (btnPlaceBid.isDisplayed()) {
			System.out.println("Place bid button is displayed");
		}
		else {
			System.out.println("Place bid button is not displayed");
		}
	}
	
	public boolean verifyResultCount() {
		int searchResultsCount = advanceResultProductLinks.size();
		System.out.println("Result rows returned are: " + searchResultsCount);
		String countInLabel = resultCountLabel.getText().replaceAll("[^0-9]","");
		int countInLabelAsInt = Integer.parseInt(countInLabel);
		
		Assert.assertEquals(searchResultsCount, countInLabelAsInt, "Count of results returned is different from count in label");
		
		if(searchResultsCount==countInLabelAsInt)
			System.out.println("Both the counts are same");
		else
			System.out.println("Both the counts are different");
		
		return true;
	}
	
	public boolean selectSubMenu() {
		Actions actions = new Actions(driver);
		System.out.println("Is 'Best Match' displayed? " + mainMenu.isDisplayed());
		actions.moveToElement(mainMenu).click().build().perform();
		actions.moveToElement(subMenu).click().build().perform();
		System.out.println("Is 'Price: lowest first' displayed after selection? " + afterSelection.isDisplayed());
		return true;
	}

}