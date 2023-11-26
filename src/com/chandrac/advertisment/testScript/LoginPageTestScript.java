package com.chandrac.advertisment.testScript;


import com.chandrac.advertisment.appreusablecodes.common.CommonReusableCodes;
import com.chandrac.advertisment.appreusablecodes.loginpage.LoginLandingPage;
import com.chandrac.advertisment.webutilies.WebUtil;

public class LoginPageTestScript {

	
	public void vt001VerifyLoginPage() {
		System.out.println("----Verifying Login Page with Valid and Invalid Cradential----");
		//CommonReusableCodes crc=	PageFactory.initElements(WebUtil.driver, CommonReusableCodes.class);
		WebUtil.launchBrowser();
		CommonReusableCodes crc= new CommonReusableCodes();
		crc.hitUrl();
	    LoginLandingPage llp=    new LoginLandingPage();
	    llp.loginWithInvalidUserName();
	    llp.loginWithInvalidUserPassword();
	    llp.loginWithValidCredential();
	    
//		CommonReusableCodes crc= new CommonReusableCodes();
//		crc.hitUrl();
		//crc.loginWithValidCredencial();
		
	
	}
}
