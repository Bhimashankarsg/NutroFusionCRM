package com.NutroFusion.CRM.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class creatingNewPurchaseOrder_NFCRM {

	WebDriver driver;

	public creatingNewPurchaseOrder_NFCRM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "subject")
	private WebElement subject;

	@FindBy(xpath = "//img[contains(@onclick, 'module=Vendors') and contains(@onclick, 'Popup')]")
	private WebElement vendorPlus;

	@FindBy(xpath = "//img[@title='Products']")
	private WebElement productPlus;

	@FindBy(name = "bill_street")
	private WebElement billAddress;

	@FindBy(name = "ship_street")
	private WebElement shipAddress;

	public WebElement getBillAddress() {
		return billAddress;
	}

	public WebElement getShipAddress() {
		return shipAddress;
	}

	@FindBy(id = "qty1")
	private WebElement qty1;

	@FindBy(id = "listPrice1")
	private WebElement listPrice1;

	@FindBy(xpath = "//a[text()='Discount']")
	private WebElement discLink;
	
	@FindBy(id="discount_percentage_final")
	private WebElement discPrice;
	
	public WebElement getdiscPrice() {
		return discPrice;
	}
	public WebElement getDiscLink() {
		return discLink;
	}



	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name="discount_final")
	private WebElement discRadio;
	
	
	  public WebElement getDiscRadio() { return discRadio; }
	 
	
	
	public WebElement getQty1() {
		return qty1;
	}

	public WebElement getListPrice1() {
		return listPrice1;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setqty(String qty) {

		qty1.sendKeys(qty);
	}
	/*
	 * public void setprice(String price) { listPrice1.sendKeys(price); }
	 */

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getVendorPlus() {
		return vendorPlus;
	}

	public void setSubject(String subname) {
		subject.sendKeys(subname);
	}

	public void setBillAddress(String billAdd) {
		billAddress.sendKeys(billAdd);
	}

	public void setShipAddress(String shipAdd) {
		shipAddress.sendKeys(shipAdd);
	}

	public WebElement getProductPlus() {
		return productPlus;
	}

}
