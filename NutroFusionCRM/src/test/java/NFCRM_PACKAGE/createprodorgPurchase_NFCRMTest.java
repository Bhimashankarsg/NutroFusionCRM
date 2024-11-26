package NFCRM_PACKAGE;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NutroFusion.CRM.basetest.BaseClass_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.CreatingNewOrganizationPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.CreatingNewProductPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.HomePage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.OrganizationInfoPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.OrganizationsPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.ProductInfoPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.ProductsPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.creatingNewPurchaseOrder_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.productPopupPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.purchaseOrderListPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.vendorPopupPage_NFCRM;
import com.NutroFusion.CRM.generic.webdriverutility.UtilityClassObject_NFCRM;
import com.aventstack.extentreports.Status;




public class createprodorgPurchase_NFCRMTest extends BaseClass_NFCRM {

	@Test
	public void practice_createprodorgPurchaseTest() throws IOException, Throwable {
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Read data from excel");
		String PRODNAME = eLib.getDataFromExcel("products", 1, 2);
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Open prod link");
		HomePage_NFCRM hp = new HomePage_NFCRM(driver);

		hp.getProdLink().click();

		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "create new prod");
		ProductsPage_NFCRM prodpage = new ProductsPage_NFCRM(driver);
		prodpage.getCreateNewProdBtn().click();

			CreatingNewProductPage_NFCRM cnpp = new CreatingNewProductPage_NFCRM(driver);
		cnpp.createProd(PRODNAME);
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "product info page");
		ProductInfoPage_NFCRM pinfop = new ProductInfoPage_NFCRM(driver);
		String headerInfo = pinfop.getproductHeaderMsg().getText();

		System.out.println(headerInfo);
		System.out.println(PRODNAME);
		
		assertObj.softAssert(headerInfo, PRODNAME);
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Read data from excel");
		String ORGNAME = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 1, 3);
		String type = eLib.getDataFromExcel("org", 1, 4);

		
		hp.getOrgLink().click();
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "create new org ");
			OrganizationsPage_NFCRM cnp = new OrganizationsPage_NFCRM(driver);
		cnp.getCreateNewOrgBtn().click();

			CreatingNewOrganizationPage_NFCRM cnop = new CreatingNewOrganizationPage_NFCRM(driver);

		cnop.createOrg(ORGNAME, industry, type);

		OrganizationInfoPage_NFCRM oip = new OrganizationInfoPage_NFCRM(driver);

		String actindustries = oip.getHeaderindMsg().getText();

		Reporter.log(actindustries);
		assertObj.softAssert(actindustries, industry);
		
		hp.clickOnPurchaseOrder();
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "crate purchase order ");
		purchaseOrderListPage_NFCRM polist = new purchaseOrderListPage_NFCRM(driver);

		polist.getPOrderPlus();

		creatingNewPurchaseOrder_NFCRM newpur = new creatingNewPurchaseOrder_NFCRM(driver);
		
		String subject_name = eLib.getDataFromExcel("purchaseorder", 1, 2);
		String vendor_name = eLib.getDataFromExcel("purchaseorder", 1, 3);
		String billAddress = eLib.getDataFromExcel("purchaseorder", 1, 5);
		String shipAddress = eLib.getDataFromExcel("purchaseorder", 1, 6);
		String product_name = PRODNAME;
		String Qty = eLib.getDataFromExcel("purchaseorder", 1, 8);
		//String price = eLib.getDataFromExcel("purchaseorder", 1, 9);
		String discPrice = eLib.getDataFromExcel("purchaseorder", 1, 10);
		
		newpur.setSubject(subject_name);
		newpur.getVendorPlus().click();
		wLib.switchToTabOnTitle(driver, "module=Vendors");
		vendorPopupPage_NFCRM venpopup = new vendorPopupPage_NFCRM(driver);
		venpopup.searchVendor(vendor_name);
		driver.findElement(By.xpath("//a[text()='" + vendor_name + "']")).click();
		
		wLib.switchToTabOnTitle(driver, "module=PurchaseOrder");
		
		newpur.setBillAddress(billAddress);
		newpur.setShipAddress(shipAddress);
		newpur.getProductPlus().click();
		wLib.switchToTabOnTitle(driver, "module=Products");
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "search for product");
		productPopupPage_NFCRM prodSelect=new productPopupPage_NFCRM(driver);
		prodSelect.searchProduct(product_name);
		driver.findElement(By.xpath("//a[text()='" + product_name + "']")).click();
		
	
		wLib.switchToTabOnTitle(driver, "module=PurchaseOrder");
		
		

		
		newpur.setqty(Qty);
	
		
		newpur.getDiscLink().click();
		WebElement radioButton = driver.findElement(By.xpath("(//input[@name='discount1'])[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);
			
		WebElement percentageField = driver.findElement(By.xpath("//input[@id='discount_percentage1']"));

		// Force visibility
		((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", percentageField);

		// Optionally, focus on the element
		((JavascriptExecutor) driver).executeScript("arguments[0].focus();", percentageField);
		percentageField.clear();
		percentageField.sendKeys("15"); 
		newpur.getSaveBtn().click();
		

	}

}
