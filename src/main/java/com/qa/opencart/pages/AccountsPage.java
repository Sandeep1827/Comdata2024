package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	By AccountNumberName = By.id("flxAccountListItem_lblAccountNumber");
	By AccountBankName = By.id("flxAccountListItem_lblAccountName");
	By header = By.id("frmAccountsLanding_accountList_lblAccountsHeader");
	private By MenuClick1 = By.cssSelector("#frmAccountsLanding_customheader_topmenu_imgMenu");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil =new ElementUtil(driver);
	}

	public String AccountPageTitle() {

		return eleUtil.waitForTitle(Constants.COMDATA_DEFAULT_WAIT, Constants.COMDATA_HOME_PAGE_TITLE);
	}

	public String AccountPageURL() {
		
		return eleUtil.waitForURL(Constants.COMDATA_DEFAULT_WAIT, Constants.COMDATA_HOME_PAGE_URL);
				}

	public String AccountNumberNameDisplay()  {
		
		return eleUtil.getElementText(AccountBankName);
	}

	public String AccountBankName() {
		return driver.findElement(AccountBankName).getText();
	}

	public String Header() {
		return driver.findElement(header).getText();
	}

	public String getLoginPageTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	public void MenuClick() throws InterruptedException {
        Thread.sleep(9000);
        eleUtil = new ElementUtil(driver);
	      eleUtil.doClick(MenuClick1);
	}
}
