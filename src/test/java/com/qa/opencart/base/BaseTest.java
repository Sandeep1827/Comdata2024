package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MenuList;

public class BaseTest {
	public DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public LoginPage LoginPage;
	public AccountsPage accPage;
	public MenuList menuList;
	

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		LoginPage= new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
