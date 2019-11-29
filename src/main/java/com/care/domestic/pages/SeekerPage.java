package com.care.domestic.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeekerPage extends BasePage {

	public SeekerPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@FindBy(xpath = "//label[contains(text(),'Hire a caregiver')]")
	private WebElement seeker_radio_xpath;

	@FindBy(name =  "firstName")
	private WebElement firstName_text_name;

	@FindBy(name = "lastName")
	private WebElement lastName_text_name;

	@FindBy(name = "cityStateZIP")
	private WebElement zip_text_name;

	@FindBy(name = "email")
	private WebElement email_text_name;

	@FindBy(name = "password")
	private WebElement password_text_name;

	@FindBy(xpath = "//button[contains(text(),'Join now')]")
	private WebElement joinNow_button_xpath;
	
	//what type of care do you need page
	@FindBy(xpath = "//span[text()='Child care']")
	private WebElement childCare_button_xpath;
	
	@FindBy(xpath = "//span[text()='Nannies']")
	private WebElement nannies_button_xpath;
	
	//Our fastest way to find your perfect caregiver
	@FindBy(xpath = "//span[text()='SU']")
	private WebElement sunday_button_xpath;
	
	@FindBy(xpath = "//span[text()='M']")
	private WebElement monday_button_xpath;
	
	@FindBy(xpath = "//button[@data-operator='+']")//*[name()='svg']//*[name()='path'][1]
	private WebElement children_button_xpath;
	
	@FindBy(xpath = "//span[contains(text(), 'Light Housekeeping')]")
	private WebElement otherNeeds_checkbox_xpath;
	
	@FindBy(name ="_eventId_success") 
	private WebElement continue_button_name;
	
	@FindBy(xpath = "//span[text()='Please select number of children.']")
	private WebElement selectChild_text_xpath;
	
	//skip upgrade
	@FindBy(xpath = "//span[contains(text(), 'Skip and continue as a basic member')]")
	private WebElement skipUpgrade_anchor_xpath;
	
	//job details
	
	@FindBy(xpath = " //div[@class='face-tile']//h2")
	private WebElement oneProvider_anchor_xpath;
	
	@FindBy(name = "job-title")
	private WebElement jobTitle_text_name;
	
	@FindBy(name = "job-description")
	private WebElement jobDescription_text_name;
	
	@FindBy(xpath = "//span[text() = 'Save']/parent::button")
	private WebElement jobSave_button_xpath;
	
	@FindBy(xpath = "//span[text() = 'Continue']/parent::button")
	private WebElement jobContinue_button_xpath;
	
	
	//logout
	@FindBy(id = "nav_dd_trigger")
	private WebElement profile_button_id;
	
	@FindBy(xpath = "//button[text() = 'Log out']")
	private WebElement logout_button_xpath;
	
	
	public void createSeeker(String firstName, String lastName, String email, String pwd) {
		getWait().until(ExpectedConditions.visibilityOf(seeker_radio_xpath));
		seeker_radio_xpath.click();		
		firstName_text_name.sendKeys(firstName);
		lastName_text_name.sendKeys(lastName);
		email_text_name.sendKeys(email);
		password_text_name.sendKeys(pwd);
		joinNow_button_xpath.click();
	}

	public void selectChildcare() {
		getWait().until(ExpectedConditions.visibilityOf(childCare_button_xpath));
		childCare_button_xpath.click();
		getWait().until(ExpectedConditions.visibilityOf(nannies_button_xpath));
		nannies_button_xpath.click();
	}
	
	
	public void logout() {
		System.out.println("logout is clicking..");
		getWait().until(ExpectedConditions.visibilityOf(profile_button_id));
		profile_button_id.click();
		getWait().until(ExpectedConditions.visibilityOf(logout_button_xpath));
		logout_button_xpath.click();
	}

	public void seekerJobContinue() {
		getWait().until(ExpectedConditions.visibilityOf(sunday_button_xpath));
		sunday_button_xpath.click();
		monday_button_xpath.click();
		
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);", children_button_xpath);
		 
		/*
		 * Actions actionBuilder = new Actions(getDriver());
		 * //actionBuilder.moveToElement(children_button_xpath).build().perform();
		 * actionBuilder.click(children_button_xpath).build().perform();
		 */ 
		
		//children_button_xpath.click();
		/*
		 * try { Thread.sleep(10000); } catch (Exception e) { // TODO: handle exception
		 * }
		 */
		getWait().until(ExpectedConditions.elementToBeClickable(children_button_xpath));
		executor.executeScript("arguments[0].click();", children_button_xpath);
		otherNeeds_checkbox_xpath.click();
		continue_button_name.click();		
	}
	
	public void skipUpgrade() {
		try {
			getWait().until(ExpectedConditions.visibilityOf(skipUpgrade_anchor_xpath));
		} catch (Exception e) {
			if (selectChild_text_xpath.isDisplayed()) {
				JavascriptExecutor executor = (JavascriptExecutor)getDriver();
				executor.executeScript("arguments[0].scrollIntoView(true);", children_button_xpath);
				getWait().until(ExpectedConditions.elementToBeClickable(children_button_xpath));
				executor.executeScript("arguments[0].click();", children_button_xpath);
				continue_button_name.click();
			}
		}
		getWait().until(ExpectedConditions.visibilityOf(skipUpgrade_anchor_xpath));
		skipUpgrade_anchor_xpath.click();
	}
	
	public void createJob() {
		try {	
			try {
				getWait().until(ExpectedConditions.visibilityOf(oneProvider_anchor_xpath));
				getWait().until(ExpectedConditions.visibilityOf(jobTitle_text_name));				
			} catch (Exception e) {
				getDriver().navigate().refresh();
			}
			getWait().until(ExpectedConditions.visibilityOf(oneProvider_anchor_xpath));
			getWait().until(ExpectedConditions.visibilityOf(jobTitle_text_name));			
			jobTitle_text_name.sendKeys(". Hi this is Seshu.");			
			jobDescription_text_name.sendKeys(". Please contact for any requirement.");
			getWait().until(ExpectedConditions.elementToBeClickable(jobSave_button_xpath));
			jobSave_button_xpath.click();			
		} catch (Exception e) {
			e.printStackTrace();
			jobContinue_button_xpath.click();
		}
	}	

}
