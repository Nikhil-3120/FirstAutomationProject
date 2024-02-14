package com.inetbanking.testcases;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.listenerReport;
import com.inetbanking.utilities.readconfig;

public class Baseclass {

	readconfig readconfig = new readconfig();
	
	public String baseurl = readconfig.getapplicationurl();
	public String username = readconfig.getusername();
	public String pwd = readconfig.getpassword();
	public static  WebDriver driver;
	
	
	//public static logger logger;
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");  // readconfig.getchromepath());
		driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getfirefoxpath()); // ".//drivers//geckodriver.exe"
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("bowser driver not available");
		}
		driver.manage().window().maximize();
		driver.get(baseurl);
		
		
	 // PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	public  static void captureScreenShot()  {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Screenshotname =listenerReport.ssname;
		File target = new File(".//screenshots//" + Screenshotname + ".png");
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//FileHandler.copy(src, target);
		System.out.println("screenshot isss taken");
	}	
}
	

