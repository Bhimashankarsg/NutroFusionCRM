package com.NutroFusion.CRM.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage_NFCRM {
	WebDriver driver;

	public OrganizationInfoPage_NFCRM(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	

	@FindBy(id = "dtlview_Industry")
	private WebElement headerindMsg;

	public WebElement getHeaderindMsg() {
		return headerindMsg;
	}
	
	@FindBy(id = "dtlview_Type")
	private WebElement headeraccMsg;

	public WebElement getHeaderaccMsg() {
		return headeraccMsg;
	}
	
	
	@FindBy(id = "dtlview_Phone")
	private WebElement headerphoneMsg;

	public WebElement getHeaderphoneMsg() {
		return headerphoneMsg;
	}
	
	

}
