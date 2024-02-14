package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.homepage;
import com.inetbanking.pageobjects.loginpage;

public class logintest1 extends Baseclass {
	loginpage lp;
	homepage hp = new homepage(driver);

	@Test
	public void logintc() throws IOException {
		lp = new loginpage(Baseclass.driver);
		lp.setusername(username);
		lp.setpwd(pwd);
		 hp = lp.clickbtn();
		Assert.assertTrue(hp.mgrpagedisplayed(), "homepage is dispayed");
		
	 if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		 Assert.assertTrue(true);
	 }
	/* else {
		// captureScreenShot( driver, "logintc");
		 Assert.assertTrue(false);
	 }*/
}
	@Test(priority=2)
	public void logouttc() {
		hp.clicklogout();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(true);
	}
}

