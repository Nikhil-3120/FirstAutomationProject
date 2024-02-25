package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageobjects.addcustomerpage;
import com.inetbanking.pageobjects.homepage;

public class newcustomer extends Baseclass {

	
	logintest1 lg = new logintest1();
	logouttest lt = new logouttest();
	
	@Test(priority = 1)
	public void login() throws IOException
	{
		
		lg.logintc();
	}
	@Test(priority = 2)
	public void clickcust()
	{
		homepage hp = new homepage(driver);
		hp.clicknewcust();
	}
	
	@Test(priority = 3)
	public void entercustdetails()
	{
		addcustomerpage cp = new addcustomerpage(driver);
		cp.newcustomerpagedisplayed();
		cp.custdetails();
	}
	
	@Test(priority = 3)
	public void logout()
	{
		
		lt.logouttc();
	}
}
