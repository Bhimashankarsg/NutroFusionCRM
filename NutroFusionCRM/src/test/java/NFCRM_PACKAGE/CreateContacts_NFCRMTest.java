package NFCRM_PACKAGE;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NutroFusion.CRM.basetest.BaseClass_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.ContactsInfoPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.ContactsPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.CreatingNewContactsPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.HomePage_NFCRM;
import com.NutroFusion.CRM.generic.webdriverutility.UtilityClassObject_NFCRM;
import com.aventstack.extentreports.Status;


public class CreateContacts_NFCRMTest extends BaseClass_NFCRM {

	
	@Test
	public void createContact1Test() throws IOException, Throwable {
			UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Read the data from excel");
		String LASTNAME = eLib.getDataFromExcel("contact", 1, 2);

		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "open contacgt link");
		HomePage_NFCRM hp = new HomePage_NFCRM(driver);
		hp.getContactLink().click();

				UtilityClassObject_NFCRM.getTest().log(Status.INFO, "create contact ");
		ContactsPage_NFCRM cnp = new ContactsPage_NFCRM(driver);
		cnp.getCreateNewContactBtn().click();

		
		CreatingNewContactsPage_NFCRM cnop = new CreatingNewContactsPage_NFCRM(driver);

		cnop.createContact(LASTNAME);
		
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Open contact info page");
		ContactsInfoPage_NFCRM oip = new ContactsInfoPage_NFCRM(driver);

		String actLastname = oip.getHeaderlstnameMsg().getText();
		System.out.println(actLastname);

		
		assertObj.softAssert(actLastname, LASTNAME);
		hp.getContactLink().click();
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Search for contact");
		ContactsPage_NFCRM cp=new ContactsPage_NFCRM(driver);
		cp.searchContact(LASTNAME);
		String ln=driver.findElement(By.xpath("//a[text()='"+LASTNAME+"']")).getText();
		System.out.println(ln);
		assertObj.softAssert(LASTNAME, ln);
	}

	@Test
	public void createContact2Test() throws IOException, Throwable {
		
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Read the data from excel");
		String LASTNAME = eLib.getDataFromExcel("contact", 1, 2);

		
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "open contact ");
		HomePage_NFCRM hp = new HomePage_NFCRM(driver);
		hp.getContactLink().click();
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "search contact");
		ContactsPage_NFCRM cp=new ContactsPage_NFCRM(driver);
		cp.searchContact(LASTNAME);
		
		String ln=driver.findElement(By.xpath("//a[text()='"+LASTNAME+"']")).getText();
		System.out.println(ln);
		assertObj.softAssert(LASTNAME, ln);

	}
	
	

}
