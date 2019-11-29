package com.care.domestic;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.care.domestic.pages.CSRPage;
import com.care.domestic.pages.SalesforcePage;
import com.care.domestic.pages.SeekerPage;
import com.care.domestic.utils.ExcelUtil;
import com.care.domestic.utils.PropertiesUtility;

import jxl.read.biff.BiffException;

public class SeekerTest extends BaseTest {

	private SeekerPage seekerPage;
	private CSRPage csrPage;	

	@Test(dataProvider = "getSeekers")
	public void createSeekerWithSafetyCase(String mail, String password, String firstName, String lastName) throws Exception {
		String stage = PropertiesUtility.getPopertyFromConfig("URLs", "stage_environment");		
        getDriver().get("https://www." + stage + ".carezen.net/enroll-care-seeker-p1042-q111082001.html");
		seekerPage = new SeekerPage(getDriver(), getWait());
		seekerPage.createSeeker(firstName, lastName, mail, password);
		seekerPage.selectChildcare();
		seekerPage.seekerJobContinue();
		seekerPage.skipUpgrade();
		seekerPage.createJob();
		Thread.sleep(5000);
		// print member id...
		String pageSource = getDriver().getPageSource();
		int memberidIndx = pageSource.indexOf("memberId");
		String memberId = pageSource.substring(memberidIndx + 12, memberidIndx + 20);
		System.out.println("MemberId:" + memberId);
		seekerPage.logout();
		// csr rejections		
		getDriver().get("https://www." + stage + ".carezen.net/csr/login.do");
		csrPage = new CSRPage(getDriver(), getWait());
		csrPage.login();
		csrPage.searchMember(memberId);
		csrPage.selectMember();
		csrPage.rejectJob();
		csrPage.logout();		

	}

	@DataProvider
	public Object[][] getSeekers() throws BiffException, IOException {
		return ExcelUtil.read("DomesticEnrolments.xls", "Seekers");
	}
}
