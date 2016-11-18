package com.ebay.test;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;
import org.testng.annotations.Test;
import com.ebay.pages.PageObjectFactory;

public class SelectBookFromDropdownTest {
	SAssert sassert = new SAssert();
	@Test(dataProvider="XmlData")
	public void verifySelectBookFromEbayDropdown(IBrowserConf browserConf, IProperty prop) {
		PageObjectFactory pof = new PageObjectFactory(browserConf, prop);
		sassert.assertTrue(pof.homePage().loadUrl(prop.getValue("HomePage_url")), "Access url: " + prop.getValue("HomePage_url"));
		sassert.assertTrue(pof.homePage().selectCategory(prop.getValue("HomePage_category")), "Selecting product category");
		sassert.assertTrue(pof.homePage().searchProduct(prop.getValue("HomePage_productname")), "Searching for a product");
		sassert.assertTrue(pof.resultsPage().presenceOfFirstProductLink(), "Verify presence of first product link");
	}
}