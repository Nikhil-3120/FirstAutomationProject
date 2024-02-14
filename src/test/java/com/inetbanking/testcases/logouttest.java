package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.homepage;
import com.inetbanking.pageobjects.loginpage;

public class logouttest extends Baseclass {
  homepage	hp = new homepage(driver);
	
	@Test
	public void logouttc()  {
		hp.clicklogout();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(true);
	}
	
}
