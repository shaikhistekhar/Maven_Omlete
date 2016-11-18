package com.ebay.test;

import java.io.IOException;
import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;
import org.testng.annotations.Test;
import com.ebay.pages.PageObjectFactory;

public class LoginTest {
	
	SAssert sassert = new SAssert();
	@Test(dataProvider = "XmlData")
	public void verifyLogin(IBrowserConf browserConf, IProperty prop) throws IOException {

		PageObjectFactory pof = new PageObjectFactory(browserConf, prop);
		
		sassert.assertTrue(pof.homePage().loadUrl(prop.getValue("HomePage_url")), "Access URL: " + prop.getValue("HomePage_url"));
		sassert.assertTrue(pof.homePage().clickSigninLink(), "Click on Sign in link");
		sassert.assertTrue(pof.loginPage().login(prop.getValue("LoginPage_userid"),prop.getValue("LoginPage_pwd")), "Login as: " + prop.getValue("LoginPage_userid"));
		sassert.assertEquals(pof.loginPage().getLoginErrorMsg(), prop.getValue("LoginPage_errormsg"), "Verify login feature");
	}
}