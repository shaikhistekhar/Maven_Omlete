package com.ebay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdvanceSearchPage {
	WebDriver driver;

	@FindBy(id = "_nkw")
	private WebElement searchKeywordTextbox;

	@FindBy(id = "LH_Auction")
	private WebElement auction_Checkbox;

	@FindBy(id = "LH_ItemConditionUsed")
	private WebElement usedCheckbox;

	@FindBy(id = "LH_IPP")
	private WebElement resultsPerPageDropdown;

	@FindBy(id = "searchBtnLowerLnk")
	private WebElement searchButton;

	public AdvanceSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean enterSearchKeyword(String searchKeyword) {
		searchKeywordTextbox.sendKeys(searchKeyword);
		return true;
	}

	public boolean selectAuctionCheckbox() {
		if (!auction_Checkbox.isSelected()) {
			auction_Checkbox.click();
		}
		return true;
	}

	public boolean selectUsedCheckbox() {
		if (!usedCheckbox.isSelected()) {
			usedCheckbox.click();
		}
		return true;
	}

	public boolean selectResultsPerPage(String numberOfResults) {
		Select options = new Select(resultsPerPageDropdown);
		options.selectByVisibleText(numberOfResults);
		return true;
	}

	public boolean clickSearchButton() {
		searchButton.click();
		return true;
	}

}
