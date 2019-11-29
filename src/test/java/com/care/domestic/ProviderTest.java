package com.care.domestic;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.care.domestic.pages.ProviderPage;
import com.care.domestic.utils.ExcelUtil;
import com.care.domestic.utils.PropertiesUtility;

import jxl.read.biff.BiffException;

public class ProviderTest extends BaseTest {
	
	private ProviderPage providerPage; 
	
	@Test(dataProvider = "getProviders")
	public void createProvider(String mail, String password, String firstName, 
			String lastName, String address, String dob, String phone, String ssn) throws Exception {
		String stage = PropertiesUtility.getPopertyFromConfig("URLs", "stage_environment");		
        getDriver().get("https://www." + stage + ".carezen.net/enroll-care-seeker-p1042-q111082001.html");		
		providerPage = new ProviderPage(getDriver(), getWait());
		providerPage.join(firstName, lastName, address, mail, password);		
		providerPage.tellusAboutYou(dob, phone);
		providerPage.availability();
		providerPage.enterYourChildcareProfile();
		providerPage.screening(ssn);
		providerPage.upgrade();
		
	}
	
	@DataProvider
	public Object[][] getProviders() throws BiffException, IOException {
		return ExcelUtil.read("DomesticEnrolments.xls", "Providers");
	}

}
