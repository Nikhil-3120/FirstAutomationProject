package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addcustomerpage {

	public WebDriver driver;
	public addcustomerpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//p[.='Add New Customer']")
	WebElement addnewcustomer;
	
	
	 public boolean newcustomerpagedisplayed() 
	 {
		 return addnewcustomer.isDisplayed();
	 }
	 
	 @FindBy(xpath = "//input[@name='name']")
	 WebElement custname;
	 
	 @FindBy(xpath ="//input[@value='m']")
		WebElement radiobtnmale;
	 
	 @FindBy(xpath ="//input[@value='f']")
		WebElement radiobtnfemale;
	 
	 @FindBy(xpath ="//input[@id='dob']")
		WebElement dob;
	 
	 @FindBy(xpath ="//textarea[@name='addr']")
		WebElement address;
	 
	 @FindBy(xpath = "//input[@name='city']")
	    WebElement city;
	 
	 @FindBy(xpath ="//input[@name='state']")
		WebElement state;
	 
	 @FindBy(xpath ="//input[@name='pinno']")
		WebElement pin;
	 
	 @FindBy(xpath ="//input[@name='telephoneno']")
		WebElement telephone;
	 
	 @FindBy(xpath ="//input[@name='emailid']")
		WebElement email;
	 
	 @FindBy(xpath ="//input[@name='password']")
		WebElement password;
	 
	 @FindBy(xpath ="//input[@name='sub']")
		WebElement submit;
	 
	 @FindBy(xpath ="//input[@name='res']")
		WebElement reset;
	 
	 @FindBy(xpath = "//div[@id='dismiss-button']")
	    WebElement adclose;
	 
	 public void custdetails()
	 {	 
		 try {
			adclose.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 custname.sendKeys("Nikhil K S");
		 radiobtnmale.click();
		 dob.click();
		 dob.sendKeys("03012000");
		 address.sendKeys("#200, church street, M.G. Road, Bengaluru");
		 city.sendKeys("Bengaluru");
		 state.sendKeys("Karnataka");
		 pin.sendKeys("560066");
		 telephone.sendKeys("987654332");
		 email.sendKeys("abc@gmail.com");
		 password.sendKeys("password");
		 submit.click();
	 }
}

