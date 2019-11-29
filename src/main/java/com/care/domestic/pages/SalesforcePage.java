package com.care.domestic.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.care.domestic.utils.PropertiesUtility;

public class SalesforcePage extends BasePage {

	public SalesforcePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	@FindBy(id = "username")
	private WebElement userName_text_id;
	
	@FindBy(id = "password")
	private WebElement password_text_id;
	
	@FindBy(id = "Login")
	private WebElement login_button_id;
	
	//logout
	@FindBy(id = "userNavButton")
	private WebElement user_menu_id;
	
	@FindBy(linkText = "Logout")
	private WebElement logout_menu_linkText;
	
	//search member
	@FindBy(id = "phSearchInput")
	private WebElement search_text_id;
	
	@FindBy(id = "phSearchButton")
	private WebElement search_button_id;
	
	@FindBy(xpath = "//div[@id='Account_body']/table/tbody/tr")
	private List<WebElement> member_text_xpath;
	
	//lighting to classic
	@FindBy(xpath = "//span[@class='uiImage']")
	private WebElement profile_button_xpath;
	
	@FindBy(linkText = "Switch to Salesforce Classic")
	private WebElement classic_anchor_linkText;
	
	public void login() {
		getWait().until(ExpectedConditions.visibilityOf(userName_text_id));
		String salesforceUser = PropertiesUtility.getPopertyFromConfig("Salesforce", "SF_username");
		String salesforcePwd = PropertiesUtility.getPopertyFromConfig("Salesforce", "SF_password");
		userName_text_id.sendKeys(salesforceUser);
		password_text_id.sendKeys(salesforcePwd);
		login_button_id.click();
	}
	
	public void switchToClassic() {
		try {
			getWait().until(ExpectedConditions.visibilityOf(profile_button_xpath));
			profile_button_xpath.click();
		} catch (Exception e) {
			getDriver().navigate().refresh();
		}
		getWait().until(ExpectedConditions.visibilityOf(profile_button_xpath));
		profile_button_xpath.click();
		getWait().until(ExpectedConditions.elementToBeClickable(classic_anchor_linkText));
		Actions actions = new Actions(getDriver());
		actions.moveToElement(classic_anchor_linkText).click().build().perform();
		//classic_anchor_linkText.click();
		try {
			getWait().until(ExpectedConditions.visibilityOf(search_text_id));
			search_button_id.click();
		} catch (Exception e) {
			getDriver().navigate().refresh();
		}
	}
	
	public void logout() {
		getWait().until(ExpectedConditions.visibilityOf(user_menu_id));
		user_menu_id.click();
		getWait().until(ExpectedConditions.visibilityOf(logout_menu_linkText));
		logout_menu_linkText.click();
	}
	
	public String search_member(String memberId) throws Exception {
		getWait().until(ExpectedConditions.visibilityOf(search_text_id));
		search_text_id.clear();
		search_text_id.sendKeys(memberId);
		search_button_id.click();
		String searchedMember = null;
		try {
			List<WebElement> trs = getWait().until(ExpectedConditions.visibilityOfAllElements(member_text_xpath));
			//System.out.println("total members found: " + trs.size());
			boolean firstTime = true;
			for (WebElement tr : trs) {
				//System.out.println("the current tr:" + tr.getText());
				if (firstTime) {
					firstTime = false;
					continue;					
				} else {
					List<WebElement> tds = tr.findElements(By.tagName("td"));
					//System.out.println("found the text:" + tds.get(3).getText());
					String temp = tds.get(3).getText();
					if (temp.equals(memberId)) {
						searchedMember = temp;
						break;
					}
				}				
			}			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw e;
		}
		return searchedMember;		
	}

}
