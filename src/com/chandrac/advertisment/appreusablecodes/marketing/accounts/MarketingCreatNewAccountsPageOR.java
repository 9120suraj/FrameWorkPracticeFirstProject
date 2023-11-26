package com.chandrac.advertisment.appreusablecodes.marketing.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketingCreatNewAccountsPageOR {

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement accountNameTB;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement creatAccountSaveBT;
	
	
	public WebElement  getAccountNameTB() {
		return accountNameTB;
	}
	
	public  WebElement getCreatAccountSaveBT() {
		return creatAccountSaveBT;
	}
}
