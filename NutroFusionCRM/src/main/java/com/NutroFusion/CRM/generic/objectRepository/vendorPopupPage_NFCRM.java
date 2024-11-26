package com.NutroFusion.CRM.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vendorPopupPage_NFCRM {
	
	WebDriver driver;
	public vendorPopupPage_NFCRM(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_txt")
	private WebElement searchtxt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	
	public void searchVendor(String vendorname)
	{
		searchtxt.sendKeys(vendorname);
		searchBtn.click();
		
		
	}
	
	

}
