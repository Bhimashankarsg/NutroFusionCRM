package NFCRM_PACKAGE;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NutroFusion.CRM.basetest.BaseClass_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.CreatingNewProductPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.HomePage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.ProductsPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.creatingNewPurchaseOrder_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.vendorPopupPage_NFCRM;
import com.NutroFusion.CRM.generic.webdriverutility.UtilityClassObject_NFCRM;
import com.aventstack.extentreports.Status;

public class create_product_supplier_NFCRMTest extends BaseClass_NFCRM {
@Test
public void createprod_supp() throws IOException, Throwable
{
	UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Read data from excel");
	String PRODNAME = eLib.getDataFromExcel("products", 1, 2);
	UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Open prod link");
	HomePage_NFCRM hp = new HomePage_NFCRM(driver);

	hp.getProdLink().click();

	UtilityClassObject_NFCRM.getTest().log(Status.INFO, "create new prod");
	ProductsPage_NFCRM prodpage = new ProductsPage_NFCRM(driver);
	prodpage.getCreateNewProdBtn().click();

		CreatingNewProductPage_NFCRM cnpp = new CreatingNewProductPage_NFCRM(driver);
	cnpp.createProd_Sup(PRODNAME);
	creatingNewPurchaseOrder_NFCRM newpur = new creatingNewPurchaseOrder_NFCRM(driver);
	
	newpur.getVendorPlus().click();
	UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Open Vendor Page and select vendor1");
	wLib.switchToTabOnTitle(driver, "module=Vendors");
	vendorPopupPage_NFCRM venpopup = new vendorPopupPage_NFCRM(driver);
	String vendor_name = eLib.getDataFromExcel("multiplesupplier", 1, 2);
	
	venpopup.searchVendor(vendor_name);
	driver.findElement(By.xpath("//a[text()='" + vendor_name + "']")).click();

	wLib.switchToTabOnTitle(driver, "module=Products");
	newpur.getVendorPlus().click();
	UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Open Vendor Page and select vendor2");
	wLib.switchToTabOnTitle(driver, "module=Vendors");
	vendorPopupPage_NFCRM venpopup2 = new vendorPopupPage_NFCRM(driver);
	String vendor_name2 = eLib.getDataFromExcel("multiplesupplier", 1, 3);
	
	venpopup2.searchVendor(vendor_name2);
	driver.findElement(By.xpath("//a[text()='" + vendor_name2 + "']")).click();

	wLib.switchToTabOnTitle(driver, "module=Products");
	String venname=driver.findElement(By.xpath("//input[@name='vendor_name']")).getText();
	
	System.out.println("Second"+vendor_name2);
	System.out.println("First"+vendor_name);
	assertObj.softAssert(vendor_name, vendor_name2);
	
}
}
