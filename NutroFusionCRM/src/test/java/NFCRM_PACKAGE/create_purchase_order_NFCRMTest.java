package NFCRM_PACKAGE;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NutroFusion.CRM.basetest.BaseClass_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.HomePage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.creatingNewPurchaseOrder_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.productPopupPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.purchaseOrderListPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.vendorPopupPage_NFCRM;
import com.NutroFusion.CRM.generic.webdriverutility.UtilityClassObject_NFCRM;
import com.aventstack.extentreports.Status;

public class create_purchase_order_NFCRMTest extends BaseClass_NFCRM {

	@Test
	public void createpurchase() throws IOException, Throwable {
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Open purchase order page");

		HomePage_NFCRM hp = new HomePage_NFCRM(driver);
		hp.clickOnPurchaseOrder();
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "create purchase order page");
		purchaseOrderListPage_NFCRM polist = new purchaseOrderListPage_NFCRM(driver);

		polist.getPOrderPlus();

		creatingNewPurchaseOrder_NFCRM newpur = new creatingNewPurchaseOrder_NFCRM(driver);
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Read data from excel");
		String subject_name = eLib.getDataFromExcel("purchaseorder", 1, 2);
		String vendor_name = eLib.getDataFromExcel("purchaseorder", 1, 3);
		String billAddress = eLib.getDataFromExcel("purchaseorder", 1, 5);
		String shipAddress = eLib.getDataFromExcel("purchaseorder", 1, 6);
		String product_name = eLib.getDataFromExcel("purchaseorder", 1, 7);
		String Qty = eLib.getDataFromExcel("purchaseorder", 1, 8);
		// String price = eLib.getDataFromExcel("purchaseorder", 1, 9);
		String discPrice = eLib.getDataFromExcel("purchaseorder", 1, 10);

		newpur.setSubject(subject_name);
		newpur.getVendorPlus().click();
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Open Vendor Page and select vendor");
		wLib.switchToTabOnTitle(driver, "module=Vendors");
		vendorPopupPage_NFCRM venpopup = new vendorPopupPage_NFCRM(driver);
		venpopup.searchVendor(vendor_name);
		driver.findElement(By.xpath("//a[text()='" + vendor_name + "']")).click();

		wLib.switchToTabOnTitle(driver, "module=PurchaseOrder");

		newpur.setBillAddress(billAddress);
		newpur.setShipAddress(shipAddress);
		newpur.getProductPlus().click();
		wLib.switchToTabOnTitle(driver, "module=Products");

		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Open product page and select product");
		productPopupPage_NFCRM prodSelect = new productPopupPage_NFCRM(driver);
		prodSelect.searchProduct(product_name);
		Thread.sleep(5);
		driver.findElement(By.xpath("//a[text()='"+product_name+"']")).click();

		// a[text()='LG Mobile']
		wLib.switchToTabOnTitle(driver, "module=PurchaseOrder");

		newpur.setqty(Qty);
		// newpur.setprice(price);

		newpur.getDiscLink().click();
		WebElement radioButton = driver.findElement(By.xpath("(//input[@name='discount1'])[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);
			WebElement percentageField = driver.findElement(By.xpath("//input[@id='discount_percentage1']"));

		
		((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", percentageField);

		
		((JavascriptExecutor) driver).executeScript("arguments[0].focus();", percentageField);
		percentageField.clear();
		percentageField.sendKeys("15");
		newpur.getSaveBtn().click();
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "created purchase order");
	}
}
