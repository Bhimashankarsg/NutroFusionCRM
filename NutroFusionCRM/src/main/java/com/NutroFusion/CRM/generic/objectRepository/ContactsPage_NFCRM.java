package com.NutroFusion.CRM.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage_NFCRM {
	
	WebDriver driver;

	public ContactsPage_NFCRM(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="search_text")
	private WebElement searchEdit;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchBtn;

	
	public void searchContact(String contact)
	{
		searchEdit.sendKeys(contact);
		Select s=new Select(searchDD);
		s.selectByVisibleText("Last Name");
		searchBtn.click();
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createNewContactBtn;
	
	public WebElement getCreateNewContactBtn() {
		return createNewContactBtn;
	}

}
