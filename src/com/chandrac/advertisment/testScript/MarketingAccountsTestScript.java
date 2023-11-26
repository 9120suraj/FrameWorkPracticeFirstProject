package com.chandrac.advertisment.testScript;

import com.chandrac.advertisment.appreusablecodes.common.CommonReusableCodes;
import com.chandrac.advertisment.appreusablecodes.marketing.accounts.MarketingAccountsLandingPage;
import com.chandrac.advertisment.appreusablecodes.marketing.accounts.MarketingCreatNewAccountsPage;
import com.chandrac.advertisment.webutilies.WebUtil;

public class MarketingAccountsTestScript {
 
	public  void vT001VerifyCreatccount() {
		
		//WebUtil.launchBrowser();
		WebUtil.launchBrowserAndHitUrl("http://localhost:8888/");
		CommonReusableCodes crc=	new CommonReusableCodes();
		crc.loginWithValidCredencial();
		crc.goToMarketingAccountsPage();
		
		MarketingAccountsLandingPage malp=	new MarketingAccountsLandingPage();
		malp.clickCreatAccountButton();
		
		MarketingCreatNewAccountsPage mcna=   new	MarketingCreatNewAccountsPage();
		mcna.creatNewAccountPage();
	}
}
