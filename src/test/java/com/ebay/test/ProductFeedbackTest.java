package com.ebay.test;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;
import org.testng.annotations.Test;
import com.ebay.pages.PageObjectFactory;

public class ProductFeedbackTest {
	SAssert sassert = new SAssert();
	@Test(dataProvider="XmlData")
	public void verifyProductFeedback(IBrowserConf browserConf, IProperty prop) {
		PageObjectFactory pof = new PageObjectFactory(browserConf, prop);
		
		sassert.assertTrue(pof.homePage().loadUrl(prop.getValue("HomePage_url")), "Access URL: " + prop.getValue("HomePage_url"));
		sassert.assertTrue(pof.homePage().clickProductAreaFromTab(), "Clicking onProduct area from tabs");
		sassert.assertTrue(pof.mobileAccessoriesPage().clickMobileComNameLink(), "Clicking on mobile company name");
		sassert.assertTrue(pof.mobileAccessoriesPage().selectPriceRange(), "Selecting price range for the product");
		sassert.assertTrue(pof.mobileAccessoriesPage().getCountOfProductsInSelectedSubCategory(), "Fetching count of products in selected sub category");
		sassert.assertTrue(pof.mobileAccessoriesPage().clickOnProduct(), "Click on a product");
		sassert.assertTrue(pof.productDescription().clickProductDescriptionLink(), "Click on 'Product Description' label");
		sassert.assertTrue(pof.productDescription().clickTellUsWhatYouThinkLink(), "Click on 'Tell us what you think' link");
		sassert.assertTrue(pof.productFeedbackPage().verifyPresenceOfCommentTextBox(), "Verify if Comment textbox is displayed");
		sassert.assertTrue(pof.productFeedbackPage().enterFeedbackComment(prop.getValue("ProductFeedbackPage_commenttext")), "Enter comment");
	}
}