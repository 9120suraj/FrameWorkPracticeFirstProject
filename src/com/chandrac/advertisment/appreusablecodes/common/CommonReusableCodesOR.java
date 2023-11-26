package com.chandrac.advertisment.appreusablecodes.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.chandrac.advertisment.webutilies.WebUtil;

public class CommonReusableCodesOR {

	public CommonReusableCodesOR() {
		PageFactory.initElements(WebUtil.driver, this);
	}
	 @FindBy(xpath="//input[@name='user_name']")
	 private WebElement userNameTB;

	 @FindBy(xpath="//input[@name='user_password']")
	 private WebElement  userPasswordTB;

	 @FindBy(xpath="//input[@name='Login']")
	 private WebElement loginBT;
	 
	 @FindBy(xpath="//a[text()='Marketing']")
	 private WebElement marketingLK;
	 
	 @FindBy(xpath="//div[@id='Marketing_sub']//a[text()='Accounts']")
	 private WebElement marketingAccountSubLK;
	 
	 
	    public WebElement getUserName() {
	    	 return userNameTB;
	     }
	     public WebElement getUserPassword() {
	    	 return userPasswordTB;
	     }
	     public WebElement getLoginBT() {
	    	 return loginBT;
	     }
	     
	     public WebElement getMarketingLK() {
	    	 return marketingLK;
	     }
	     
	     public WebElement getMarketingAccountSubLK() {
	    	 return marketingAccountSubLK;
	     }
	 
}
