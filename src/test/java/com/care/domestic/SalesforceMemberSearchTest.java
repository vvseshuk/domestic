package com.care.domestic;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.care.domestic.pages.SalesforcePage;
import com.care.domestic.utils.PropertiesUtility;

public class SalesforceMemberSearchTest extends BaseTest {

	private SalesforcePage salesforcePage;
	
	@Test
	public void memberSearch() throws Exception {
		// salesforce verification
		String sandbox = PropertiesUtility.getPopertyFromConfig("Salesforce", "SF_environment");
		getDriver().get("https://caredotcom--" + sandbox + ".my.salesforce.com/");
		salesforcePage = new SalesforcePage(getDriver(), getWait());
		salesforcePage.login();
		String currentUrl = getDriver().getCurrentUrl();
		if (currentUrl.contains("lightning")) {
			//move from lighting to classic mode
			salesforcePage.switchToClassic();			
		}
		String memberIds = PropertiesUtility.getPopertyFromConfig("Salesforce", "SF_members_to_seach");
		String members[] = memberIds.split(",");
		SoftAssert soft = new SoftAssert();
		for (String memberId : members) {
			String searchedMember="";
			try {
				searchedMember = salesforcePage.search_member(memberId);
			} catch (Exception e) {
				soft.assertFalse(true, "Failed to search the member, could be the member account not yet created: "+ memberId);
			}
			if (!searchedMember.equals("")) {
				soft.assertNotNull(searchedMember, "Failed with member not found: " + memberId);
				soft.assertEquals(searchedMember, memberId, "Failed with search member id and found member id are different: " + memberId);
			}
			Thread.sleep(6000);
		}
		salesforcePage.logout();
		soft.assertAll();		
	}

}
