package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	// 1:-private by locators

	private WebDriver driver;
	private ElementUtil eleUtil;  
	private By emialID = By.id("frmLogin_main_tbxUserName");
	private By Paswrd = By.id("frmLogin_main_tbxPassword");
	private By Login = By.id("frmLogin_main_btnLogin");
	private By frgtpwd = By.id("frmLogin_main_btnForgotPwd");
	//private By RegLink = By.linkText("Register");

	// 2:-public login page const

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	eleUtil =	new ElementUtil(driver);
		
	}

	//3:- public page actions

	public String getLoginPageTitle() {
		return eleUtil.waitForTitle(Constants.COMDATA_DEFAULT_WAIT, Constants.COMDATA_LOGIN_PAGE_TITLE);
	}

	public String getLoginPageURL() {
		return eleUtil.waitForURL(Constants.COMDATA_DEFAULT_WAIT, Constants.COMDATA_LOGIN_PAGE_URL);
	}

	public boolean getisForgotPwdLink() {
		return eleUtil.doisDisplayed(frgtpwd);
	}
	
	
	public AccountsPage doLogin(String un, String pwd) {
		eleUtil.waitForElementVisible(emialID, Constants.COMDATA_DEFAULT_WAIT).sendKeys(un);
		eleUtil.waitForElementVisible(Paswrd, Constants.COMDATA_DEFAULT_WAIT).sendKeys(pwd);
		eleUtil.doClick(Login);
		return new AccountsPage(driver);
	}
//	public boolean RegLinkExist() {
//	return driver.findElement(RegLink).isDisplayed();
//	}
//	public void NavToRegPage() {
//		if(RegLinkExist()) {
//			driver.findElement(RegLink).click();
//		}
//	}

}
