package com.ebay.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;

	@FindBy(xpath = "//li[3]/div/a")
	private List<WebElement> productsInCart;

	@FindBy(xpath = "(//li[3]/div/a)[1]")
	private WebElement firstProductLink;

	@FindBy(xpath = "(//li[3]/div/a)[2]")
	private WebElement secondProductLink;

	ResultsPage resultspage = new ResultsPage(driver);
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean backToProductDetailsPage() {
		driver.navigate().back();
		return true;
	}

	public boolean verifyProductsInCart() {
		int productCountInCart = productsInCart.size();
		System.out.println("Total products in cart:" + productCountInCart);
		System.out.println("From cart page" + ResultsPage.firstProductName);
		System.out.println("From cart page" + ResultsPage.secondProductName);
		
		for (WebElement eachProduct : productsInCart) {
			String productName = eachProduct.getText();
			System.out.println(productName);
			//ResultsPage resultspage = new ResultsPage(driver);
			if (ResultsPage.firstProductName.equals(productName))
				System.out.println("Product name in Cart matches with results list page");
			else
				System.out.println("Product names are different between Cart and results list page");
		}
		return true;
	}

}
