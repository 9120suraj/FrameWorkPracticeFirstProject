package com.chandrac.advertisment.appreusablecodes.loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.chandrac.advertisment.webutilies.WebUtil;

public class LoginLandingPageOR {

	
	public LoginLandingPageOR() {
		PageFactory.initElements(WebUtil.driver, this);
	}
	 @FindBy(xpath="//input[@name='user_name']")
	 private WebElement userNameTB;

	 @FindBy(xpath="//input[@name='user_password']")
	 private WebElement  userPasswordTB;

	 @FindBy(xpath="//input[@name='Login']")
	 private WebElement loginBT;
	 
	 @FindBy(xpath="//font[@color='Brown']")
	 private WebElement hintMessage;
	 
	    public WebElement getUserName() {
	    	 return userNameTB;
	     }
	     public WebElement getUserPassword() {
	    	 return userPasswordTB;
	     }
	     public WebElement getLoginBT() {
	    	 return loginBT;
	    	 }
	     public WebElement getHintMessage() {
	    	 return hintMessage;
	     }
	     
}
