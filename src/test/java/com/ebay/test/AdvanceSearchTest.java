package com.ebay.test;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;

import org.testng.annotations.Test;

import com.ebay.pages.PageObjectFactory;

public class AdvanceSearchTest {

	SAssert sassert = new SAssert();
	@Test(dataProvider="XmlData")
	public void verifyAdvanceSearchFeature(IBrowserConf browserConf, IProperty prop) {
		
		PageObjectFactory pof = new PageObjectFactory(browserConf, prop);
		
		sassert.assertTrue(pof.homePage().loadUrl(prop.getValue("HomePage_url")), "Access URL: " + prop.getValue("HomePage_url"));
		sassert.assertTrue(pof.homePage().advanceSearchLink(), "Clicking on Advance search link");
		sassert.assertTrue(pof.advanceSearchPage().enterSearchKeyword(prop.getValue("AdvanceSearchPage_searchkeyword")), "Entering search keyword");
		sassert.assertTrue(pof.advanceSearchPage().selectAuctionCheckbox(), "Selecting Auction checkbox");
		sassert.assertTrue(pof.advanceSearchPage().selectUsedCheckbox(), "Selecting Used checkbox");
		sassert.assertTrue(pof.advanceSearchPage().selectResultsPerPage(prop.getValue("AdvanceSearchPage_numberofresults")), "Select number of results to be displayed");
		sassert.assertTrue(pof.advanceSearchPage().clickSearchButton(), "Clicking on Search button from Advance search");
		sassert.assertTrue(pof.resultsPage().verifyResultCount(), "Verifying results count");
	}
}