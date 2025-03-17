package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetUp() {
		accPage = LoginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

//	@Test
//	public void LoginTest() {
//		LoginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
//	}
	@Test(priority = 1)
	public void HomePageTitleTest() {
		String actTitle = accPage.AccountPageTitle();
		System.out.println("HomePage title" + actTitle);
		// Assert.assertEquals(actTitle, Constants.LO);
		Assert.assertEquals(actTitle, Constants.COMDATA_HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void HomePageUrlTest() {
		String url = accPage.AccountPageURL();
		System.out.println("HomePage URL" + url);
		Assert.assertEquals(url, Constants.COMDATA_HOME_PAGE_URL);
	}

	@Test(priority = 4)
	public void AccountNumvalidationTest() {
		String unValidate = accPage.AccountNumberNameDisplay();
		System.out.println("User validation with Logged in or not" + unValidate);
		Assert.assertEquals(unValidate, Constants.COMDATA_HOME_PAGE_AN_VALIDATION);
	}

	@Test(priority = 3)
	public void BankNameTest() {
		String unValidatevalue = accPage.AccountBankName();
		System.out.println("User validation with username" + unValidatevalue);
		Assert.assertEquals(unValidatevalue, Constants.COMDATA_HOME_PAGE_BN_VALIDATION_VALUE);
	}

	@Test(priority = 5)
	public void HeaderTest() {
		String HeaderText = accPage.Header();
		System.out.println("Header value test" + HeaderText);
		Assert.assertEquals(HeaderText, Constants.COMDATA_HOME_PAGE_HEADER);
	}
	@Test(priority =6)
	public void MenuListValues() throws InterruptedException {
		accPage.MenuClick();
		
	}
}
