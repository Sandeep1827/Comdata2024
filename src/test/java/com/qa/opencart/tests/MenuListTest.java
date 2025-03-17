package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.MenuList;


public class MenuListTest extends BaseTest {
	
	
	
	@BeforeClass
	public void accPageSetUp() {
		accPage = LoginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test 
	public void MenuListValues() throws InterruptedException {
    menuList.MenuClick();
	}
}
