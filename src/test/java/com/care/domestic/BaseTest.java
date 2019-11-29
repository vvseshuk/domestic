package com.care.domestic;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.care.domestic.utils.PropertiesUtility;

public class BaseTest {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver webDriver) {
		this.driver = webDriver;
	}
	public WebDriverWait getWait() {
		return wait;
	}
	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}
	
	@BeforeMethod
    public void setup () {
        //Create a Chrome driver. All test classes use this.
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "test" + File.separator + "resources" + File.separator + "drivers" + 
				File.separator + "chromedriver.exe");
		
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver(options);   
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\browsers\\geckodriver.exe"); driver = new FirefoxDriver();
		 */
        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver, 10);
 
        //Maximize Window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);        
    }
 
    @AfterMethod
    public void teardown () {
        //driver.quit();
    }
	
	

}
