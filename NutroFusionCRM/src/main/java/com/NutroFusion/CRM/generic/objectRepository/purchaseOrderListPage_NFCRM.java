package com.NutroFusion.CRM.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class purchaseOrderListPage_NFCRM {
	WebDriver driver;

	public purchaseOrderListPage_NFCRM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Purchase Order...']")
	private WebElement pOrderPlus;
	
	public void getPOrderPlus()
	{
		pOrderPlus.click();
	}
	
}
