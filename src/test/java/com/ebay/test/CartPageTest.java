package com.ebay.test;

import java.io.IOException;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;
import org.testng.annotations.Test;
import com.ebay.pages.PageObjectFactory;

public class CartPageTest {
	
	SAssert sassert = new SAssert();
	@Test(dataProvider = "XmlData", groups={"smoke"})
	public void verifyProductInCart(IBrowserConf browserConf, IProperty prop) throws IOException {
		
		PageObjectFactory pof = new PageObjectFactory(browserConf, prop);
		
		sassert.assertTrue(pof.homePage().loadUrl(prop.getValue("HomePage_url")), "Access URL: " + prop.getValue("HomePage_url"));
		sassert.assertTrue(pof.homePage().searchProduct(prop.getValue("HomePage_productname")), "Search for product: " + prop.getValue("HomePage_productname"));
		sassert.assertTrue(pof.resultsPage().clickOnFirstProduct(), "Clicking on first product from results page");
		sassert.assertTrue(pof.productDetailsPage().clickAddToCartButton(), "Click on Add to Cart button");
		sassert.assertTrue(pof.cartPage().backToProductDetailsPage(), "Navigating back to Product details page");
		sassert.assertTrue(pof.productDetailsPage().clickBackToSearchResultListLink(), "Navigating back to search results page");
		sassert.assertTrue(pof.resultsPage().clickOnSecondProduct(), "Clicking on first product from results page");
		sassert.assertTrue(pof.productDetailsPage().clickAddToCartButton(), "Click on Add to Cart button");
		sassert.assertTrue(pof.cartPage().verifyProductsInCart(), "Verify products in cart");
	
	}
}