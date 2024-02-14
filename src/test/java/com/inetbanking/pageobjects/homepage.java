package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
 
	public WebDriver driver;
	public homepage(WebDriver rdriver)
	{
		this.driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//marquee[@behavior='alternate']")
	WebElement welcometomgrpage;
	
	public boolean mgrpagedisplayed() {
		return welcometomgrpage.isDisplayed();
	}
	 
	@FindBy(xpath = "//a[.='Log out']")
	WebElement logoutbtn;
	
	public loginpage clicklogout() {
		logoutbtn.click();
		return new loginpage(driver);
	}
}
