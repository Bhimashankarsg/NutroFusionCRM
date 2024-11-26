package com.NutroFusion.CRM.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage_NFCRM {
	WebDriver driver;

	public ProductInfoPage_NFCRM(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(className = "lvtHeaderText")
	private WebElement headerMsg;

	public WebElement getproductHeaderMsg() {
		return headerMsg;
	}
	
	

}
