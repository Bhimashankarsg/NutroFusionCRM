package com.NutroFusion.CRM.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage_NFCRM {

	WebDriver driver;

	public CreatingNewOrganizationPage_NFCRM(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdit;

	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industrydd;

	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createOrg(String orgName) {
		orgNameEdit.sendKeys(orgName);
		saveBtn.click();
	}

	public void createOrg(String ORGNAME, String INDUSTRY) {
		orgNameEdit.sendKeys(ORGNAME);
		Select sel = new Select(industrydd);
		sel.selectByVisibleText(INDUSTRY);
		saveBtn.click();

	}
	
	public void createOrg_phone(String orgName,String phone) {
		orgNameEdit.sendKeys(orgName);
		phoneEdit.sendKeys(phone);
		saveBtn.click();
	}
	
	@FindBy(name = "accounttype")
	private WebElement accounttype;
	@FindBy(id = "phone")
	private WebElement phoneEdit;
	
	public WebElement getphoneEdit() {
		return phoneEdit;
	}
	
	public void createOrg(String ORGNAME, String INDUSTRY, String ACCOUNTTYPE) {
		orgNameEdit.sendKeys(ORGNAME);
		Select selind = new Select(industrydd);
		selind.selectByVisibleText(INDUSTRY);
		Select selacc = new Select(accounttype);
		selacc.selectByVisibleText(ACCOUNTTYPE);
		saveBtn.click();

	}

}
