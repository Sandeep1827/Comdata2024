package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public Properties prop;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is used for initialize the webdriver w.r.t to given browsername
	 * this method will take care of local and remote execution
	 * @param browsername
	 * @return
	 */
	
	public WebDriver init_driver(Properties prep) {
		
		String browsername=prep.getProperty("browser");
		System.out.println("Browser name"+browsername);
		
		if(browsername.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--remote-allow-origins=*");
			// adding new line
			WebDriverManager.chromedriver().clearDriverCache().setup();
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}else {
			System.out.println("please pass the correct browser"+browsername);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get(prep.getProperty("url"));
		return driver;
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * this method is used for intialise the properties on the basis of given environment
	 * environment:-QA/DEV/Prod
	 * @return
	 */
	
	public Properties init_prop(){
		
		FileInputStream ip=null;
		//mvn clean install  -Denv="qa"
		//mvn clean install 
		String envName=System.getProperty("env");
		System.out.println("Running tests on environment" + envName);
		prop = new Properties();
		if (envName==null) {
			System.out.println("no env is given hence it is running in a QA");
			try {
			 ip =new FileInputStream("./src/test/resources/config/qa.config.properties"); 
		}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
			else {
				try {
				switch (envName.toLowerCase()) {
				case "qa":
					ip =new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "dev":
					ip =new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
				case "uat":
					ip =new FileInputStream("./src/test/resources/config/uat.config.properties");
					break;
				case "prod":
					ip =new FileInputStream("./src/test/resources/config/prod.config.properties");
					break;

				default:
					System.out.println("please pass the correct environment" + envName);
					break;
				}
			}
				catch(Exception e) {
			
				}
			}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path ;

	}

}
