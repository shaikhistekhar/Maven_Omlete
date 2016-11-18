package com.ebay.pages;


import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.driver.Driver;

import org.openqa.selenium.WebDriver;

public class PageObjectFactory {

	private WebDriver driver;
	private IProperty prop;

	AdvanceSearchPage advanceSearchPage;
	CartPage cartPage;
	HomePage homePage;
	LoginPage loginPage;
	MobileAccessoriesPage mobileAccessoriesPage;
	ProductDescription productDescription;
	ProductDetailsPage productDetailsPage;
	ProductFeedbackPage productFeedbackPage;
	ResultsPage resultsPage;

	public PageObjectFactory(IBrowserConf browserConf, IProperty prop) {
		this.driver = Driver.getDriver(browserConf);
		this.prop = prop;
	}

	public HomePage homePage() {
		if (homePage == null)
			homePage = new HomePage(driver);
		return homePage;
	}
	
	public LoginPage loginPage() {
		if (loginPage == null)
			loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public AdvanceSearchPage advanceSearchPage() {
		if (advanceSearchPage == null)
			advanceSearchPage = new AdvanceSearchPage(driver);
		return advanceSearchPage;
	}
	
	public CartPage cartPage() {
		if (cartPage == null)
			cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public MobileAccessoriesPage mobileAccessoriesPage() {
		if (mobileAccessoriesPage == null)
			mobileAccessoriesPage = new MobileAccessoriesPage(driver);
		return mobileAccessoriesPage;
	}
	
	public ProductFeedbackPage productFeedbackPage() {
		if (productFeedbackPage == null)
			productFeedbackPage = new ProductFeedbackPage(driver);
		return productFeedbackPage;
	}
	
	public ResultsPage resultsPage() {
		if (resultsPage == null)
			resultsPage = new ResultsPage(driver);
		return resultsPage;
	}
	
	public ProductDescription productDescription() {
		if (productDescription == null)
			productDescription = new ProductDescription(driver);
		return productDescription;
	}
	
	public ProductDetailsPage productDetailsPage() {
		if (productDetailsPage == null)
			productDetailsPage = new ProductDetailsPage(driver);
		return productDetailsPage;
	}

}
