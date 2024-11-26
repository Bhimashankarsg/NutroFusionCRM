package com.NutroFusion.CRM.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class salesOrderListPage_NFCRM {
	WebDriver driver;

	public salesOrderListPage_NFCRM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Sales Order...']")
	private WebElement sOrderPlus;
	
	public void getSOrderPlus()
	{
		sOrderPlus.click();
	}
	
}
