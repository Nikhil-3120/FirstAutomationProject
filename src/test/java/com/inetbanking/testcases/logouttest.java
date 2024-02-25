package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.homepage;
import com.inetbanking.pageobjects.loginpage;

public class logouttest extends Baseclass {
  
	
	@Test
	public void logouttc()  {
		homepage	hp = new homepage(driver);
		hp.clicklogout();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(true);
	}
	
}
