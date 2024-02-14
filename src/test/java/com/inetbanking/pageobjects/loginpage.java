package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	public WebDriver driver;

	public loginpage(WebDriver rdriver)
	{
		this.driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//input[@name='uid']")
	WebElement txtusername;

	@FindBy(xpath="//input[@name='password']")
	WebElement txtpassword;

	@FindBy(name="btnLogin")
	WebElement loginbtn;

	


	public void setusername(String username) {
		txtusername.sendKeys(username);
	}	
	public void setpwd(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public homepage clickbtn() {
		loginbtn.click();
		return new homepage(driver);
	}
	

}
