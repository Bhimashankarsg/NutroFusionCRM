package com.NutroFusion.CRM.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.NutroFusion.CRM.assertUtility.assertUtility_NFCRM;
import com.NutroFusion.CRM.generic.databaseutility.DataBaseUtility_NFCRM;
import com.NutroFusion.CRM.generic.fileutility.ExcelUtility_NFCRM;
import com.NutroFusion.CRM.generic.fileutility.FileUtility_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.HomePage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.LoginPage_NFCRM;
import com.NutroFusion.CRM.generic.webdriverutility.JavaUtility_NFCRM;
import com.NutroFusion.CRM.generic.webdriverutility.UtilityClassObject_NFCRM;
import com.NutroFusion.CRM.generic.webdriverutility.WebDriverUtility_NFCRM;

public class BaseClass_NFCRM  {

	// Create object
	public FileUtility_NFCRM fLib = new FileUtility_NFCRM();
	public ExcelUtility_NFCRM eLib = new ExcelUtility_NFCRM();
	public JavaUtility_NFCRM jLib = new JavaUtility_NFCRM();
	public WebDriverUtility_NFCRM wLib = new WebDriverUtility_NFCRM();

	public DataBaseUtility_NFCRM dbLib = new DataBaseUtility_NFCRM();

	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public assertUtility_NFCRM assertObj = new assertUtility_NFCRM();

	@BeforeSuite(groups = { "smoketest", "regressiontest" })
	public void configBS() throws SQLException {
		Reporter.log("=== connect to DB , report config  BS ===", true);
		dbLib.getDbconnection();

	}

	// For Cross Browser Testing

	
	@BeforeClass(groups = { "smoketest", "regressiontest" })
	//@BeforeClass(alwaysRun=false)
	public void configBC() throws Throwable {
		Reporter.log("=====Launch Browser BC=======");

		String BROWSER = System.getProperty("browser",fLib.getDataFromPropertiesFile("browser"));;
		driver = wLib.launchbrowser(BROWSER);
		sdriver = driver;
		UtilityClassObject_NFCRM.setDriver(driver);
	}

	@BeforeMethod(groups = { "smoketest", "regressiontest" })
	//@BeforeClass(alwaysRun=false)
	public void configBM() throws IOException {
		Reporter.log("=== Login to application BM=====");
		String URL = System.getProperty("url",fLib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username",fLib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password",fLib.getDataFromPropertiesFile("password"));
		
//		String URL = System.getProperty("url");
//		String USERNAME = System.getProperty("username");
//		String PASSWORD = System.getProperty("password");

		LoginPage_NFCRM lp = new LoginPage_NFCRM(driver);
		lp.loginPage(URL, USERNAME, PASSWORD);
		wLib.waitForPageToLoad(driver);
		wLib.maximizewindow(driver);
	}

	@AfterMethod(groups = { "smoketest", "regressiontest" })
	public void configAM() {
		Reporter.log("==== Logout AM =====");
		HomePage_NFCRM hp = new HomePage_NFCRM(driver);
		hp.logout();
	}

	@AfterClass(groups = { "smoketest", "regressiontest" })
	public void configAC() {
		Reporter.log("==== close the Browser AC======");
		wLib.quitwindow(driver);
	}

	@AfterSuite(groups = { "smoketest", "regressiontest" })
	public void configAS() throws SQLException {
		Reporter.log("=== close DB, Report Backup AS ====");
		dbLib.closeDbConnection();

	}
}

