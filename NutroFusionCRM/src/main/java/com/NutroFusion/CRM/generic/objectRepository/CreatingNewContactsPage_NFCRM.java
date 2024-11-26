package com.NutroFusion.CRM.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewContactsPage_NFCRM {

	WebDriver driver;

	public CreatingNewContactsPage_NFCRM(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastNameEdit;

	@FindBy(name = "support_start_date")
	private WebElement support_start_date;

	@FindBy(name = "support_end_date")
	private WebElement support_end_date;

	@FindBy(name = "button")
	private WebElement saveBtn;
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgImgPlus;

	
	public WebElement getOrgNamePlus() {
		return orgImgPlus;
	}
	public WebElement getOrgNameEdit() {
		return lastNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createContact(String lastName) {
		lastNameEdit.sendKeys(lastName);
		saveBtn.click();
	}

	public void createContactOrg(String lastName) {
		lastNameEdit.sendKeys(lastName);

	}@FindBy(xpath = "//img[contains(@onclick, 'module=Accounts') and contains(@onclick, 'Popup')]")
	private WebElement orgPlus;

public WebElement getOrgPlus() {
		return orgPlus;
	}

	public void createContact(String lastName, String startdate, String enddate) {
		lastNameEdit.sendKeys(lastName);
		support_start_date.clear();
		support_start_date.sendKeys(startdate);
		support_end_date.clear();
		support_end_date.sendKeys(enddate);
		saveBtn.click();
	}

}
