package NFCRM_PACKAGE;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NutroFusion.CRM.basetest.BaseClass_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.HomePage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.creatingNewSalesOrder_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.orgPopupPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.productPopupPage_NFCRM;
import com.NutroFusion.CRM.generic.objectRepository.salesOrderListPage_NFCRM;
import com.NutroFusion.CRM.generic.webdriverutility.UtilityClassObject_NFCRM;
import com.aventstack.extentreports.Status;

public class create_sales_order_NFCRMTest extends BaseClass_NFCRM {

	@Test
	public void createsales() throws IOException, Throwable {
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Open sales order page");


		HomePage_NFCRM hp = new HomePage_NFCRM(driver);
		hp.clickOnSalesOrder();
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "create sales order page");
		
		salesOrderListPage_NFCRM solist = new salesOrderListPage_NFCRM(driver);

		solist.getSOrderPlus();

		creatingNewSalesOrder_NFCRM newpur = new creatingNewSalesOrder_NFCRM(driver);
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Read data from excel");
		
		String subject_name = eLib.getDataFromExcel("salesorder", 1, 2);
		String org_name = eLib.getDataFromExcel("salesorder", 1, 3);
		String billAddress = eLib.getDataFromExcel("salesorder", 1, 5);
		String shipAddress = eLib.getDataFromExcel("salesorder", 1, 6);
		String product_name = eLib.getDataFromExcel("salesorder", 1, 7);
		String Qty = eLib.getDataFromExcel("salesorder", 1, 8);
		//String price = eLib.getDataFromExcel("salesorder", 1, 9);
		String discPrice = eLib.getDataFromExcel("salesorder", 1, 10);
		
		newpur.setSubject(subject_name);
		newpur.getOrgPlus().click();
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Open org Page and select vendor");
		
		
		wLib.switchToTabOnTitle(driver, "module=Accounts");
		orgPopupPage_NFCRM orgpopup = new orgPopupPage_NFCRM(driver);
		orgpopup.searchOrg(org_name);
		
		Thread.sleep(10);
		driver.findElement(By.xpath("//a[text()='" + org_name + "']")).click();
		driver.switchTo().alert().accept();
		wLib.switchToTabOnTitle(driver, "module=SalesOrder");
		
		newpur.setBillAddress(billAddress);
		newpur.setShipAddress(shipAddress);
		newpur.getProductPlus().click();
		wLib.switchToTabOnTitle(driver, "module=Products");
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "Open product page and select product");
		
		productPopupPage_NFCRM prodSelect=new productPopupPage_NFCRM(driver);
		prodSelect.searchProduct(product_name);
		driver.findElement(By.xpath("//a[text()='" + product_name + "']")).click();
		
	
		wLib.switchToTabOnTitle(driver, "module=SalesOrder");
		
		

		
		newpur.setqty(Qty);
	//	newpur.setprice(price);
		
		newpur.getDiscLink().click();
		WebElement radioButton = driver.findElement(By.xpath("(//input[@name='discount1'])[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);
		
		
		WebElement percentageField = driver.findElement(By.xpath("//input[@id='discount_percentage1']"));

		
		((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='visible';", percentageField);

		// Optionally, focus on the element
		((JavascriptExecutor) driver).executeScript("arguments[0].focus();", percentageField);
		percentageField.clear();
		percentageField.sendKeys(discPrice); 
		
		
		newpur.getSaveBtn().click();
		UtilityClassObject_NFCRM.getTest().log(Status.INFO, "created Sales order");
		
		
	}
}
