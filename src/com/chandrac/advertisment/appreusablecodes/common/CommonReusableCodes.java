package com.chandrac.advertisment.appreusablecodes.common;

import com.chandrac.advertisment.webutilies.WebUtil;

public class CommonReusableCodes extends CommonReusableCodesOR{
//
	public  void hitUrl() {
		WebUtil.openUrl("http://localhost:8888/");
	}
	public void loginWithValidCredencial() {
	
		WebUtil.inputData(getUserName(), "admin");
		WebUtil.inputData(getUserPassword(), "admin");
		WebUtil.Click(getLoginBT());
	}
	
	public void goToMarketingAccountsPage() {
		WebUtil.mouseOvermouseOverToThetElement(getMarketingLK());
		WebUtil.myClick(getMarketingAccountSubLK());
	}
  
}
