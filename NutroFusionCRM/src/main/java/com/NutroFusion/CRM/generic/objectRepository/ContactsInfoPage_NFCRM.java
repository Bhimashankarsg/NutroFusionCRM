package com.NutroFusion.CRM.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage_NFCRM {
	WebDriver driver;

	public ContactsInfoPage_NFCRM(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgcontactname;
	
	public WebElement getOrgnamecontactMsg() {
		return orgcontactname;
	}

	public WebElement getHeaderlstnameMsg() {
		return headerMsg;
	}
	
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement StartDate;

	public WebElement getHeaderstartdateMsg() {
		return StartDate;
	}
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement EndDate;

	public WebElement getHeaderenddateMsg() {
		return EndDate;
	}
	
	
	
	
	
	

}
