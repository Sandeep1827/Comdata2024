package com.qa.opencart.utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	WebDriver driver;
	public JavaScriptUtil(WebDriver driver) {
		this.driver=driver;
	}
	public void flash(WebElement element) {
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0; i<15;i++) {
//			changeColor("rgb(0,200,0)", element);
//			changeColor(bgcolor, element);
//			
			
		}
	}

}
