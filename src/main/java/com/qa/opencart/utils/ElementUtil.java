package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	public WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver=driver;
		
	}

	public By getBy(String locatorType, String locatorvalue) {
		By locator = null;
		switch (locatorType) {
		case "id":
			locator = By.id(locatorvalue);
			break;
		case "name":
			locator = By.name(locatorvalue);
			break;
		case "classname":
			locator = By.className(locatorvalue);
			break;
		case "xpath":
			locator = By.xpath(locatorvalue);
			break;
		case "cssselector":
			locator = By.cssSelector(locatorvalue);
			break;
		case "linktext":
			locator = By.linkText(locatorvalue);
			break;
		case "partialLinkText":
			locator = By.partialLinkText(locatorvalue);
			break;
		case "tagname":
			locator = By.tagName(locatorvalue);
			break;

		default:
			break;
		}
		return locator;
	}

	public WebElement getelement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getelements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendkeys(By locator, String value) {
		getelement(locator).sendKeys(value);

	}
	public boolean doisDisplayed(By locator) {
		return getelement(locator).isDisplayed();
	}

	public void doClick(By locator) {
		getelement(locator).click();
	}

	public String getElementText(By locator) {
		return getelement(locator).getText();
	}

	public boolean isElementPresent(By locator) {
		if (getelements(locator).size() > 0) {
			return true;
		}
		return false;
	}

	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getelement(locator), value).perform();
	}

	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getelement(locator)).perform();
	}

	public List<String> eleLinkText(By locator) {
		List<WebElement> eleList = getelements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	public void getEleAttributes(By locator, String attrvalue) {
		List<WebElement> elelist = getelements(locator);
		List<String> eleattList = new ArrayList<String>();
		for (WebElement e : elelist) {
			String attrval = e.getAttribute(attrvalue);
			System.out.println(attrval);
			eleattList.add(attrval);
		}
	}
	// ********************DROP DOWN UTILS********************

	public void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getelement(locator));
		select.selectByVisibleText(text);
	}

	public void doSelectByValue(By locator, String text) {
		Select select = new Select(getelement(locator));
		select.selectByValue(text);
	}

	public void doSelectByIndex(By locator, int text) {
		Select select = new Select(getelement(locator));
		select.selectByIndex(text);
	}

	public List<String> doGetDropDownOptions(By locator) {
		Select select = new Select(driver.findElement(locator));
		List<WebElement> optionslist = select.getOptions();
		List<String> optionsValList = new ArrayList<String>();
		System.out.println(optionslist.size());

		for (WebElement e : optionslist) {
			String text = e.getText();
			// System.out.println(text);
			optionsValList.add(text);
		}
		return optionsValList;
	}

	public void getSelectDropDOwnList(By locator, String value) {
		Select select = new Select(driver.findElement(locator));
		List<WebElement> Optionslist = select.getOptions();
		for (WebElement e : Optionslist) {
			String text = e.getText();
			if (text.equals("india")) {
				e.click();
				break;
			}
		}

	}
//***************************** Actions class Methods************************

	public void selectSubMenu(By ParentMenu, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getelement(ParentMenu)).perform();
		Thread.sleep(2000);
		getelement(childMenu).click();
		;

	}

	public void selectSubMenu(By ParentMenu, By childMenu, By childmenu2) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getelement(ParentMenu)).perform();
		Thread.sleep(2000);
		act.moveToElement(getelement(childMenu)).perform();
		Thread.sleep(2000);
		getelement(childmenu2).click();

	}

	public void selectSubMenu(By ParentMenu, By childMenu, By childmenu2, By childmenu3) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getelement(ParentMenu)).perform();
		Thread.sleep(2000);
		act.moveToElement(getelement(childMenu)).perform();
		Thread.sleep(2000);
		act.moveToElement(getelement(childmenu2)).perform();
		Thread.sleep(2000);
		getelement(childmenu3).click();

	}

	public void doContextClick(By locator) {
		Actions act = new Actions(driver);
		act.contextClick(getelement(locator)).perform();
	}

	public int getRightClickCount(By RightClick, By RightClickOptions) {
		return SelectRightClickMenu(RightClick, RightClickOptions).size();
	}

	public List<String> SelectRightClickMenu(By RightClick, By RightClickOptions) {

		List<String> rightClickItems = new ArrayList<String>();
		doContextClick(RightClick);
		List<WebElement> RightClickList = getelements(RightClickOptions);
		System.out.println(RightClickList.size());

		for (WebElement e : RightClickList) {
			String text = e.getText();
			// System.out.println(text);
			rightClickItems.add(text);
		}
		return rightClickItems;
	}

	public void SelectRightClickValue(By RightClick, By RightClickOptions, String value) {
		doContextClick(RightClick);
		List<WebElement> RightClickList = getelements(RightClickOptions);
		System.out.println(RightClickList.size());
		for (WebElement e : RightClickList) {
			String text = e.getText();
			// System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	public void doActionClick(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getelement(locator)).perform();
	}

	public void doActionSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getelement(locator), value).perform();

	}

	// *****************Wait-utils********************//
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param Timeout
	 * @return
	 */
	public WebElement waitForElementPresent(By locator, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible.Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0. Parameters:locator used to
	 * find the elementReturns:the WebElement once it is located and visible
	 * 
	 * @param locator
	 * @param Timeout
	 * @return
	 */
	public WebElement waitForElementVisible(By locator, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @polling time 500ms default time
	 * @param locator
	 * @param Timeout
	 * @return
	 */
	public WebElement waitForElementPresent(By locator, int Timeout, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout), Duration.ofMillis(pollingTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * 
	 * 
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible.Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0. Parameters:locator used to
	 * find the elementReturns:the WebElement once it is located and visible
	 * 
	 * @polling time 500ms default time
	 * @param locator
	 * @param Timeout
	 * @return
	 */
	public WebElement waitForElementVisible(By locator, int Timeout, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout), Duration.ofMillis(pollingTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public Alert wiatForAlert(int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void AcceptAlert(int Timeout) {
		wiatForAlert(Timeout).accept();
	}

	public void DismissAlert(int Timeout) {
		wiatForAlert(Timeout).dismiss();
	}

	public void GetTextAlert(int Timeout) {
		wiatForAlert(Timeout).getText();
	}

	public String waitForURL(int TiemOut, String urlVal) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (wait.until(ExpectedConditions.urlContains(urlVal))) {
			return driver.getCurrentUrl();
		}
		return null;

	}

	public String waitForURLToBe(int TiemOut, String urlFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}

		return null;

	}

	public String waitForTitle(int TiemOut, String TitleFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (wait.until(ExpectedConditions.titleContains(TitleFraction))) {
			return driver.getTitle();
		}
		else {
			System.out.println("title is not correct.....");
		}
		return null;
	}

	public WebDriver wiatforByLocator(By framelocator, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framelocator));
	}

	public WebDriver wiatforByIndex(int frameindex, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameindex));
	}

	public WebDriver wiatforByString(int Timeout, String framelocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framelocator));
	}

	public WebDriver wiatforByWebElement(WebElement frameelement, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameelement));
	}

	public void wiatforByLocatorWhenReady(By locator, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(getelement(locator))).click();
	}

	public void printAllElements(By locator, int Timeout) {
		List<WebElement> values = waitforElementstoVisible(locator, Timeout);
		for (WebElement e : values) {
			System.out.println(e.getText());
		}
	}

	public List<String> printAllElementswithWait(By locator, int Timeout) {
		List<WebElement> values = waitforElementstoVisible(locator, Timeout);
		List<String> eleList = new ArrayList<>();
		for (WebElement e : values) {
			String text = e.getText();
			eleList.add(text);
		}
		return eleList;
	}

	public List<WebElement> waitforElementstoVisible(By locator, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void waitForPageLoad(int Timeout) {
		Long endTime = System.currentTimeMillis() + Timeout;
		while (System.currentTimeMillis() > endTime) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String state = js.executeScript("return document.readystate").toString();
			if (state.equals("complete")) {
				break;
			}
		}
	}

	public WebElement waitForElementVisibleWithFluentWait(int Timeout, int polling, By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Timeout))
				.pollingEvery(Duration.ofSeconds(polling)).ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementPresentWithFluentWait(int Timeout, int polling, By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Timeout))
				.pollingEvery(Duration.ofSeconds(polling)).ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
