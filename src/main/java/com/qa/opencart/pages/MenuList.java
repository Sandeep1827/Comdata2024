package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;



public class MenuList {
	
	//private WebDriver driver;
	private  ElementUtil eleUtil;
    By MenuClick = By.cssSelector("#frmAccountsLanding_customheader_topmenu_imgMenutest");
	By AccountBankName = By.id("flxAccountListItem_lblAccountName");
	private WebDriver driver;

	
	  public MenuList(WebDriver driver) 
	  { 
		  this.driver=driver; 
	  eleUtil = new ElementUtil(driver); 
	  }
	 
//
//	public String AccountPageURL() {
//
//		return eleUtil.waitForURL(Constants.COMDATA_DEFAULT_WAIT, Constants.COMDATA_HOME_PAGE_URL);
//	}
//	public String AccountBankName() {
//		return driver.findElement(AccountBankName).getText();
//	}

	public void MenuClick() throws InterruptedException {
		Thread.sleep(9000);
		eleUtil.doClick(MenuClick);
		
		
   /* public void MenuClick() throws InterruptedException {
	          Thread.sleep(9000);
	          eleUtil = new ElementUtil(driver);
		      eleUtil.doClick(MenuClick);*/
			
		
		 //return new MenuClick(driver);
		// return driver.findElement(MenuList);
		 
	//}
	}
}
