package com.NutroFusion.CRM.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage_NFCRM {
	
	WebDriver driver;

	public ProductsPage_NFCRM(WebDriver driver) // Rule-3: Object Initialization
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

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createNewProdBtn;
	
	public WebElement getCreateNewProdBtn() {
		return createNewProdBtn;
	}

}
