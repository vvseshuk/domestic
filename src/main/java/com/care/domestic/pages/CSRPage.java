package com.care.domestic.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.care.domestic.utils.PropertiesUtility;

public class CSRPage extends BasePage {

	public CSRPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	@FindBy(name = "userName")
	private WebElement userName_text_name;
	
	@FindBy(name = "password")
	private WebElement password_text_name;
	
	@FindBy(xpath = "//input[@value='Log In']")
	private WebElement login_button_xpath;
	
	//member search	
	@FindBy(name = "content")
	private WebElement memberSearch_frame_name;
	
	@FindBy(id = "memberId")
	private WebElement memberId_text_id;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement search_button_xpath;
	
	//select member
	@FindBy(xpath = "//div/table/tbody/tr[2]/td[2]/a")
	private WebElement selectMember_anchor_xpath;
	
	//change status - csr bucket rejection
	@FindBy(id = "newStatusReviewJob0")
	private WebElement rejectBucket_select_id;
	
	@FindBy(name = "jobForm[0].notes")
	private WebElement reason_text_name;
	
	@FindBy(xpath = "//input[contains(@value,'Submit and Continue')]")
	private WebElement continue_button_xpath;
	
	//logout
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement logout_anchor_xpath;
	
	public void login() {
		getWait().until(ExpectedConditions.visibilityOf(userName_text_name));
		String csrUser = PropertiesUtility.getPopertyFromConfig("URLs", "csr_username");
		String csrPwd = PropertiesUtility.getPopertyFromConfig("URLs", "csr_password");
		userName_text_name.sendKeys(csrUser);
		password_text_name.sendKeys(csrPwd);
		login_button_xpath.click();
	}
	
	public void searchMember(String memberId) {
		getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("content"));		
		getWait().until(ExpectedConditions.visibilityOf(memberId_text_id));
		memberId_text_id.sendKeys(memberId);
		search_button_xpath.click();
	}
	
	public void selectMember() {
		getWait().until(ExpectedConditions.visibilityOf(selectMember_anchor_xpath));
		selectMember_anchor_xpath.click();
	}
	
	public void rejectJob() {
		getWait().until(ExpectedConditions.visibilityOf(rejectBucket_select_id));
		Select reject = new Select(rejectBucket_select_id);
		reject.selectByVisibleText("Rejected-Fraud");
		getWait().until(ExpectedConditions.visibilityOf(reason_text_name));
		reason_text_name.sendKeys("Seems to be fraud..");
		getWait().until(ExpectedConditions.elementToBeClickable(continue_button_xpath));
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);", continue_button_xpath);
		executor.executeScript("arguments[0].click();", continue_button_xpath);				
	}
	
	public void logout() {
		getDriver().switchTo().defaultContent();
		getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("header"));
		getWait().until(ExpectedConditions.visibilityOf(logout_anchor_xpath));
		logout_anchor_xpath.click();
	}
	
	
	
	
	
	

}
