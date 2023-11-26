package com.chandrac.advertisment.appreusablecodes.loginpage;

import com.chandrac.advertisment.webutilies.WebUtil;

public class LoginLandingPage extends  LoginLandingPageOR {

	
	public void loginWithInvalidUserName() {
		WebUtil.inputData(getUserName(), "123Admin");
		WebUtil.inputData(getUserPassword(), "admin");
		WebUtil.Click(getLoginBT());
		
	String actualText=	WebUtil.myGetText(getHintMessage());
	String axpectedText="You must specify a valid username and password.";
	if (actualText.contains(axpectedText)) {
		System.out.println("Pass--With the invalid UserName it is not able to login");
	}else {
		System.out.println("Failed--With the invalid UserName it is able to login");
	}
	}
	public void loginWithInvalidUserPassword() {
		WebUtil.inputData(getUserName(), "admin");
		WebUtil.inputData(getUserPassword(), "1234admin");
		WebUtil.Click(getLoginBT());
	
		String actualText=	WebUtil.myGetText(getHintMessage());
		String axpectedText="You must specify a valid username and password.";
		if (actualText.contains(axpectedText)) {
			System.out.println("Pass--With the invalid UserPassword it is not able to login");
			System.out.println("our atual text is ---"+actualText+" and expected text is---"+axpectedText+"both are matched");
		}else {
			System.out.println("Failed--With the invalid UserPassword it is able to login");
			System.out.println("our atual text is ---"+actualText+" and expected text is---"+axpectedText+"both are not matched");
		}
		}
		
	public void loginWithValidCredential() {
		WebUtil.inputData(getUserName(), "admin");
		WebUtil.inputData(getUserPassword(), "admin");
		WebUtil.Click(getLoginBT());
		
		String actualText=	WebUtil.myGetTitle();
		String axpectedText="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		if (actualText.contains(axpectedText)) {
			System.out.println("Pass--With the valid Credential it is able to login");
			System.out.println("our atual text is ---"+actualText+" and expected text is---"+axpectedText+"both are matched");
		}else {
			System.out.println("Failed--With the valid Credential it is able to login");
			System.out.println("our atual text is ---"+actualText+" and expected text is---"+axpectedText+"both are not matched");
		}
		
		
		
		
		
		
		
	}
		
	}
	

