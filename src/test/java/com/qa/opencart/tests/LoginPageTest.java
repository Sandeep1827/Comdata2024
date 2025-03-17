package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority=1, groups= {"Samples"})
	public void PageTitleTest() {
		String actTitle = LoginPage.getLoginPageTitle();
		System.out.println("page title" + actTitle);
		// Assert.assertEquals(actTitle, Constants.LO);
		Assert.assertEquals(actTitle, Constants.COMDATA_LOGIN_PAGE_TITLE);
	}

	@Test(priority=2, groups= {"Samples"})
	public void PageUrlTest() {
		String url = LoginPage.getLoginPageURL();
		System.out.println("Page URL" + url);
		Assert.assertTrue(url.contains(Constants.COMDATA_LOGIN_PAGE_URL));
	}

	@Test(priority=3, groups= {"Samples"})
	public void PageForgotPwdTest() {
		Assert.assertTrue(LoginPage.getisForgotPwdLink());
	}

	@Test(priority=4, groups= {"Samples"})
	public void LoginTest() {
		accPage=LoginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		//accPage.AccountPageTitle();
	}
//	@Test
//	public void PageRegLinkTest() {
//		Assert.assertTrue(LoginPage.RegLinkExist());
//	}
	//public void 

}
