package com.chandrac.advertisment.appreusablecodes.marketing.accounts;

import com.chandrac.advertisment.webutilies.WebUtil;

public class MarketingCreatNewAccountsPage extends MarketingCreatNewAccountsPageOR {

	public void creatNewAccountPage() {
	
		WebUtil.inputData(getAccountNameTB(), "Raam Mohan Rai Chaurasiya");
		WebUtil.Click(getCreatAccountSaveBT());
		
	}
	
}
