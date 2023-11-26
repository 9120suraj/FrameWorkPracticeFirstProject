package com.chandrac.advertisment.appreusablecodes.marketing.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MarketingAccountsLandingPageOR {

	@FindBy(xpath = "//img[@title='Create Account...']")
	private WebElement getCreatAccountTBLK ;
	
	public WebElement getCreatAccountTBLK() {
		return getCreatAccountTBLK;
	}
	
}
