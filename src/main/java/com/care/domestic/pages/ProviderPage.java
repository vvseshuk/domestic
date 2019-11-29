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

public class ProviderPage extends BasePage {

	public ProviderPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	@FindBy(xpath = "//input[@id='provider']/parent::div")
	private WebElement provider_radio_xpath;

	@FindBy(name = "sitterType")
	private WebElement sitterType_select_name;

	@FindBy(name = "sitterService")
	private WebElement sitterService_select_name;

	@FindBy(name = "firstName")
	private WebElement firstName_text_name;

	@FindBy(name = "lastName")
	private WebElement lastName_text_name;

	@FindBy(name = "addressLine1")
	private WebElement address_text_name;

	@FindBy(name = "email")
	private WebElement email_text_name;

	@FindBy(name = "password")
	private WebElement password_text_name;

	@FindBy(xpath = "//button[text()='Join now']")
	private WebElement join_button_xpath;

	// Tell us about yourself
	@FindBy(xpath = "//input[@id='gender1']/parent::label")
	private WebElement gender_radio_xpath;

	@FindBy(id = "dateOfBirth")
	private WebElement dob_text_id;

	@FindBy(id = "submitBtn")
	private WebElement next_button_id;

	@FindBy(linkText = "I don't have one")
	private WebElement middleName_anchor_linkText;

	// your location
	@FindBy(id = "addressFormSubmit")
	private WebElement saveAndContinue_button_id;

	// phone
	@FindBy(id = "phone_number")
	private WebElement phone_text_id;

	@FindBy(xpath = "//span[text()='Confirm']/parent::a")
	private WebElement confirm_button_xpath;

	@FindBy(xpath = "//span[text()='Text code']/parent::a")
	private WebElement otp_button_xpath;

	@FindBy(id = "verification-code-1")
	private WebElement otp1_text_id;

	@FindBy(id = "verification-code-2")
	private WebElement otp2_text_id;

	@FindBy(id = "verification-code-3")
	private WebElement otp3_text_id;

	@FindBy(id = "verification-code-4")
	private WebElement otp4_text_id;

	@FindBy(xpath = "//span[text()='Verify']/parent::a")
	private List<WebElement> verify_button_xpath;

	// security image
	@FindBy(xpath = "//div[@class='first-row']/div/div")
	private WebElement security_img_xpath;

	@FindBy(xpath = "//span[text()='Ok']")
	private WebElement ok_button_xpath;

	// optional screen
	// Your preferred job types	
	@FindBy(xpath = "//span[text()='One-time jobs']")
	private WebElement oneTimeJob_radio_xpath;
	
	@FindBy(id = "oneTimeJobsMinValue")
	private WebElement min_text_id;
	
	@FindBy(id = "oneTimeJobsMaxValue")
	private WebElement max_text_id;
	
	@FindBy(xpath = "//span[text()='Save & continue']")
	private WebElement jobTypesSave_button_xpath;
	
	@FindBy(xpath = "//span[text()='S']")
	private WebElement sunday_button_id;
	
	@FindBy(xpath = "//span[text()='M']")
	private WebElement monday_button_id;
	
	@FindBy(xpath = "//span[text()='Save & continue']")
	private WebElement availbltySave_button_id;

	// your availability
	@FindBy(xpath = "//button[text()='Full Time']")
	private WebElement fullTime_button_xpath;

	@FindBy(xpath = "//button[text()='Save & continue']")
	private WebElement save_button_xpath;

	// Your child care profile
	@FindBy(id = "educationLevel")
	private WebElement education_select_id;

	@FindBy(xpath = "//span[text()='Save & continue']")
	private WebElement educationSave_button_xpath;

	// Your bio
	@FindBy(id = "bioTitle")
	private WebElement bioTitle_text_id;

	@FindBy(id = "experienceSummary")
	private WebElement summary_text_id;

	@FindBy(xpath = "//span[text()='Save & continue']")
	private WebElement bioSave_button_xpath;

	// Why wait? Start applying now.
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement applySave_button_xpath;

	// pic
	@FindBy(xpath = "//span[text()='Skip for now']")
	private WebElement picSkip_anchor_xpath;

	// Screening
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement screeningNext_button_xpath;

	@FindBy(xpath = "//span[contains(text(), 'By checking this box')]")
	private WebElement authorization_check_xpath;

	@FindBy(xpath = "//span[@class='cont-btn']")
	private WebElement authContinue_button_xpath;

	// Is this your legal name?
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement legalName_button_xpath;
	
	@FindBy(linkText = "I don't have one")
	private WebElement skipMName_anchor_linkText;
	
	// Is this your primary address?
	@FindBy(xpath = "//span[text()='Next']")
	private WebElement addressNext_button_xpath;
	
	//ssn
	@FindBy(id = "ssn")
	private WebElement ssn_text_id;

	@FindBy(id = "confirm_ssn")
	private WebElement confirmSSN_text_id;

	@FindBy(xpath = "//span[contains(text(), 'By checking this box')]")
	private WebElement ssn_check_xpath;
	
	@FindBy(xpath = "//span[text() = 'Submit']")
	private WebElement ssnSubmit_button_xpath;
	
	@FindBy(xpath = "//span[text() = 'OK']")
	private WebElement okSubmit_button_xpath;
	
	//upgrade
	@FindBy(linkText = "Skip for now")
	private WebElement skipUpgrade_anchor_linkText;
	
	//add bgc
	@FindBy(linkText = "Skip for now")
	private WebElement skipBgc_anchor_linkText;
	
	@FindBy(xpath = "//span[text() = 'Go to homepage']")
	private WebElement homePage_anchor_xpath;
	
	public void join(String firstName, String lastName, String address, String email, String pwd) {
		getWait().until(ExpectedConditions.visibilityOf(provider_radio_xpath));
		provider_radio_xpath.click();
		Select sitterType = new Select(sitterType_select_name);
		sitterType.selectByVisibleText("Individual");
		Select sitterService = new Select(sitterService_select_name);
		sitterService.selectByVisibleText("Babysitter");
		firstName_text_name.sendKeys(firstName);
		lastName_text_name.sendKeys(lastName);
		address_text_name.sendKeys(address);
		email_text_name.sendKeys(email);
		password_text_name.sendKeys(pwd);
		join_button_xpath.click();
	}

	public void tellusAboutYou(String dob, String phone) {
		getWait().until(ExpectedConditions.visibilityOf(gender_radio_xpath));
		gender_radio_xpath.click();
		dob_text_id.sendKeys(dob);
		next_button_id.click();
		try {
			getWait().until(ExpectedConditions.elementToBeClickable(middleName_anchor_linkText));
		} catch (Exception e) {
			next_button_id.click();
			getWait().until(ExpectedConditions.elementToBeClickable(middleName_anchor_linkText));
		}		
		//middleName_anchor_linkText.click();//some time failing to click and no errro is there
		Actions move = new Actions(getDriver());
		move.moveToElement(middleName_anchor_linkText).click().build().perform();
		boolean gotException = false;
		try {
			WebDriverWait littleWait = new WebDriverWait(getDriver(), 5);
			littleWait.until(ExpectedConditions.elementToBeClickable(saveAndContinue_button_id));
		} catch (Exception e) {
			gotException = true;
			middleName_anchor_linkText.click();
		}
		if (gotException) {
			getWait().until(ExpectedConditions.elementToBeClickable(saveAndContinue_button_id));
		}
		saveAndContinue_button_id.click();
		// phone number and sms
		getWait().until(ExpectedConditions.elementToBeClickable(phone_text_id));
		enterNumbersOneByOne(phone, phone_text_id);
		confirm_button_xpath.click();
		getWait().until(ExpectedConditions.elementToBeClickable(otp_button_xpath));
		otp_button_xpath.click();
		getWait().until(ExpectedConditions.elementToBeClickable(otp1_text_id));
		otp1_text_id.sendKeys("0");
		otp2_text_id.sendKeys("7");
		otp3_text_id.sendKeys("0");
		otp4_text_id.sendKeys("3");
		getWait().until(ExpectedConditions.elementToBeClickable(verify_button_xpath.get(1)));
		verify_button_xpath.get(1).click();
		// security image
		getWait().until(ExpectedConditions.elementToBeClickable(security_img_xpath));
		security_img_xpath.click();
		ok_button_xpath.click();

	}

	private void enterNumbersOneByOne(String numbers, WebElement elementToEnter) {
		for (int i = 0; i < numbers.length(); i++) {
			elementToEnter.sendKeys("" + numbers.charAt(i));
		}
	}

	public void availability() {
		// your availability
		boolean flowChange = false;
		try {
			WebDriverWait littleWait = new WebDriverWait(getDriver(), 5);
			littleWait.until(ExpectedConditions.elementToBeClickable(fullTime_button_xpath));
		} catch(TimeoutException e) {
			flowChange = true;
			differentFlow();
		}		
		if (!flowChange) {
			fullTime_button_xpath.click();
			save_button_xpath.click();
		}
	}

	private void differentFlow() {
		oneTimeJob_radio_xpath.click();
		min_text_id.sendKeys("1");
		max_text_id.sendKeys("2");
		jobTypesSave_button_xpath.click();
		try {
			getWait().until(ExpectedConditions.elementToBeClickable(sunday_button_id));
		} catch (Exception e) {
			getDriver().navigate().refresh();
		}
		getWait().until(ExpectedConditions.elementToBeClickable(sunday_button_id));
		sunday_button_id.click();
		monday_button_id.click();
		Actions move = new Actions(getDriver());
		move.moveToElement(availbltySave_button_id).click().build().perform();
		//availbltySave_button_id.click();		
	}

	// Your child care profile
	public void enterYourChildcareProfile() {
		boolean gotException = false;
		try {
			getWait().until(ExpectedConditions.elementToBeClickable(education_select_id));
		} catch (Exception e) {
			gotException = true;
			availbltySave_button_id.click();
		}
		if (gotException) {
			getWait().until(ExpectedConditions.elementToBeClickable(education_select_id));
		}		
		Select education = new Select(education_select_id);
		education.selectByVisibleText("Some college");
		educationSave_button_xpath.click();

		// bio data
		getWait().until(ExpectedConditions.elementToBeClickable(bioTitle_text_id));
		bioTitle_text_id.sendKeys("Fun sitter and smile creator");
		summary_text_id.sendKeys("I am Seshu, experienced over 10 years in baby care sitting. "
				+ "Can handle the child even suffering from fever.");
		bioSave_button_xpath.click();

		// apply jobs
		getWait().until(ExpectedConditions.elementToBeClickable(applySave_button_xpath));
		applySave_button_xpath.click();

		// pic
		getWait().until(ExpectedConditions.elementToBeClickable(picSkip_anchor_xpath));
		picSkip_anchor_xpath.click();

	}

	// Screening
	public void screening(String ssn) {
		getWait().until(ExpectedConditions.elementToBeClickable(screeningNext_button_xpath));
		screeningNext_button_xpath.click();

		// authorization
		getWait().until(ExpectedConditions.elementToBeClickable(authorization_check_xpath));
		authorization_check_xpath.click();
		authContinue_button_xpath.click();

		// Is this your legal name?
		getWait().until(ExpectedConditions.elementToBeClickable(legalName_button_xpath));
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].click();", legalName_button_xpath);
		WebDriverWait littleWait = new WebDriverWait(getDriver(), 5);
		boolean gotException = false;
		try {
			littleWait.until(ExpectedConditions.elementToBeClickable(skipMName_anchor_linkText));
		} catch (Exception e) {
			gotException = true;
			executor.executeScript("arguments[0].click();", legalName_button_xpath);
		}
		if (gotException) {
			getWait().until(ExpectedConditions.elementToBeClickable(skipMName_anchor_linkText));
		}
		skipMName_anchor_linkText.click();
		getWait().until(ExpectedConditions.elementToBeClickable(addressNext_button_xpath));
		executor.executeScript("arguments[0].click();", addressNext_button_xpath);
		
		//ssn
		try {
			littleWait.until(ExpectedConditions.visibilityOf(ssn_text_id));
		} catch (Exception e) {
			executor.executeScript("arguments[0].click();", addressNext_button_xpath);
		}
		littleWait.until(ExpectedConditions.visibilityOf(ssn_text_id));
		enterNumbersOneByOne(ssn, ssn_text_id);
		enterNumbersOneByOne(ssn, confirmSSN_text_id);
		ssn_check_xpath.click();
		getWait().until(ExpectedConditions.elementToBeClickable(ssnSubmit_button_xpath));
		ssnSubmit_button_xpath.click();
		getWait().until(ExpectedConditions.elementToBeClickable(okSubmit_button_xpath));
		okSubmit_button_xpath.click();		
	}
	
	public void upgrade() {
		// Upgrade
		getWait().until(ExpectedConditions.elementToBeClickable(skipUpgrade_anchor_linkText));
		skipUpgrade_anchor_linkText.click();
		getWait().until(ExpectedConditions.elementToBeClickable(skipBgc_anchor_linkText));
		skipBgc_anchor_linkText.click();
		getWait().until(ExpectedConditions.elementToBeClickable(homePage_anchor_xpath));
		homePage_anchor_xpath.click();
		

	}

}
