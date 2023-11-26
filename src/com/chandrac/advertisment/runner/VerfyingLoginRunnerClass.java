package com.chandrac.advertisment.runner;

import com.chandrac.advertisment.testScript.LoginPageTestScript;
import com.chandrac.advertisment.testScript.MarketingAccountsTestScript;


public class VerfyingLoginRunnerClass {
	
	
public static void main(String[] args) {
	
	LoginPageTestScript lpts=new LoginPageTestScript();
	lpts.vt001VerifyLoginPage();
	MarketingAccountsTestScript mats=new	MarketingAccountsTestScript();
	mats.vT001VerifyCreatccount();
}
}
