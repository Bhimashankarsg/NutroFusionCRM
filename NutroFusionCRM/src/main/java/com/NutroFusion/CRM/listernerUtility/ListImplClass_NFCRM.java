package com.NutroFusion.CRM.listernerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.NutroFusion.CRM.generic.webdriverutility.UtilityClassObject_NFCRM;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImplClass_NFCRM implements ITestListener, ISuiteListener {

	public ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ISuite suite) {

		Reporter.log("Report configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		ExtentSparkReporter spark = new ExtentSparkReporter("./AdanceReport_NFCRM/report" + time + ".html");
		spark.config().setDocumentTitle("NFCRM Test Suite Results(Document Title)");
		spark.config().setReportName("NFCRM Report( Report Name)");
		String theme = "DARK";
		spark.config().setTheme(Theme.valueOf(theme));

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");

	}

	@Override
	public void onFinish(ISuite suite) {

		Reporter.log("Report Backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {

		Reporter.log("====>" + result.getMethod().getMethodName() + "<=======START=====");

		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject_NFCRM.setTest(test);
		test.log(Status.PASS, result.getMethod().getMethodName() + "===> STARTED <===");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		Reporter.log("====>" + result.getMethod().getMethodName() + "<=======END=====");
		test.log(Status.PASS, result.getMethod().getMethodName() + "===> COMPLETED <===");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject_NFCRM.getDriver();
		String filePAth = ts.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		test.addScreenCaptureFromBase64String(filePAth, testName + "_" + time);

		test.log(Status.FAIL, result.getMethod().getMethodName() + "===> FAILED <===");
		test.log(Status.FAIL, result.getThrowable());
	}

}
