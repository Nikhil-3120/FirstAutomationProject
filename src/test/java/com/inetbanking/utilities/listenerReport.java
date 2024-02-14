package com.inetbanking.utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetbanking.testcases.Baseclass;

public class listenerReport  implements ITestListener  {

	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "//Spark.html");
	ExtentTest extenttest;
   public static String ssname;

	public void onStart(ITestContext context) {
		String testname = context.getName();
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("automation project report");
		spark.config().setReportName("demo project");
		//	spark.config().setTimeStampFormat("dd/MM/yyy hh:mm:ss");
		extent.setSystemInfo("Operating System",System.getProperty("os.name"));
		extent.setSystemInfo("Java version",System.getProperty("java.version"));

	//	extenttest = extent.createTest(testname);
		//extenttest.log(Status.INFO,  "Test started");

	}

	public void onTestStart(ITestResult result) {
		String testname = result.getName();
		//extenttest = extent.createTest(testname);
		//extenttest.log(Status.INFO, testname + "Execution started");

	}

	public void onTestSuccess(ITestResult result) {
		String testname = result.getName();
		extenttest = extent.createTest(testname);
		extenttest.log(Status.PASS, testname + "test case passes");
	}

	public void onTestFailure(ITestResult result) {
	    String failtestname = result.getName();
	    ssname = failtestname;
		extenttest = extent.createTest(failtestname);
		Baseclass.captureScreenShot();
		extenttest.addScreenCaptureFromPath(".//screenshots//" + failtestname + ".png");
	/*	String screenshotpath = System.getProperty("user.dir" + "//screenshots//" + testname + ".png");
		File f1 = ((TakesScreenshot)Baseclass.driver).getScreenshotAs(OutputType.FILE);
		System.out.println("screenshot taken");
		try {
			FileUtils.copyFile(f1, new File(testname + "png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttest.fail("screenshot is below" + extenttest.addScreenCaptureFromPath(screenshotpath));*/
		
		/*   String screenshotpath = System.getProperty("user.dir"+"//screenshots/" + testname + ".png");
	    File f = new File(screenshotpath);
	    if(f.exists()){

	    extenttest.fail("screenshot is below" + extenttest.addScreenCaptureFromPath(screenshotpath));
	}*/
		extenttest.log(Status.INFO,result.getThrowable());
		extenttest.log(Status.FAIL, failtestname + "test case failed");
	}

	public void onTestSkipped(ITestResult result) {
		String testname = result.getName();
		extenttest = extent.createTest(testname);
		extenttest.log(Status.INFO,result.getThrowable());
		extenttest.log(Status.SKIP, testname + "test case skipped");

	}

	public void onFinish(ITestContext context) {
		extent.flush();
		try {
			Desktop.getDesktop().browse(new File("Spark.html").toURI());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}


