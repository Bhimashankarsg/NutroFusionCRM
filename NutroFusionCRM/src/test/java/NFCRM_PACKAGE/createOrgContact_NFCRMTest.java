package NFCRM_PACKAGE;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NutroFusion.CRM.basetest.BaseClass_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.ContactsPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.CreatingNewContactsPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.CreatingNewOrganizationPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.HomePage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.OrganizationInfoPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.OrganizationsPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.orgPopupPage_NFCRM;
import com.NutroFusion.CRM.generic.webdriverutility.UtilityClassObject_NFCRM;
import com.aventstack.extentreports.Status;



public class createOrgContact_NFCRMTest extends BaseClass_NFCRM {

	@Test
	public void createOrgCustomerTest() throws IOException, Throwable {

		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Read data from excel");
		
		String ORGNAME = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 1, 3);
		String type = eLib.getDataFromExcel("org", 1, 4);
		
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Navigate to Org Page");
		HomePage_NFCRM hp = new HomePage_NFCRM(driver);

		hp.getOrgLink().click();
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Navigate to create Org Page");
		OrganizationsPage_NFCRM cnp = new OrganizationsPage_NFCRM(driver);
		cnp.getCreateNewOrgBtn().click();

		
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "create new Org ");
		CreatingNewOrganizationPage_NFCRM cnop = new CreatingNewOrganizationPage_NFCRM(driver);

		cnop.createOrg(ORGNAME, industry, type);
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, ORGNAME + "====>new Org ");
		OrganizationInfoPage_NFCRM oip = new OrganizationInfoPage_NFCRM(driver);

		String actindustries = oip.getHeaderindMsg().getText();

		Reporter.log(actindustries);
		assertObj.softAssert(actindustries, industry);

		hp.getOrgLink().click();
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Navigate to create Contact Page");

		cnp.searchOrg(ORGNAME);
		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "'and @title='Organizations']/../../td[8]/a[text()='del']")).click();
		
		driver.switchTo().alert().accept();
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Read data from excel");
		String LASTNAME = eLib.getDataFromExcel("contact", 1, 2);

		

		hp.getContactLink().click();

		
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Read data from excel");
		ContactsPage_NFCRM cnpn = new ContactsPage_NFCRM(driver);
		cnpn.getCreateNewContactBtn().click();

		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Creating new contact page");
		
		CreatingNewContactsPage_NFCRM cnopa = new CreatingNewContactsPage_NFCRM(driver);

		cnopa.createContactOrg(LASTNAME);

		cnopa.getOrgPlus().click();
		wLib.switchToTabOnTitle(driver, "module=Accounts");
		orgPopupPage_NFCRM orgpopup = new orgPopupPage_NFCRM(driver);
		orgpopup.searchOrg(ORGNAME);
		
		//String orgn=driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).getText();
		
		wLib.switchToTabOnTitle(driver, "module=Contacts");
//		System.out.println(orgn);
//		assertObj.softAssert(ORGNAME, orgn);
//		
	}

}
