package com.NutroFusion.CRM.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_NFCRM {
	WebDriver driver;

	public HomePage_NFCRM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(name="Purchase Order")
	private WebElement purchaseOrder;
	
	@FindBy(name="Sales Order")
	private WebElement salesOrder;

	@FindBy(linkText = "Products")
	private WebElement prodLink;
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
public WebElement getProdLink() {
		return prodLink;
	}

public WebElement getOrgLink() {
		return orgLink;
	}

	/*
	 * public WebElement getMoreLink() { return moreLink; }
	 */
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutLink.click();
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	public WebElement getSignOut() {
		return signOut;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public void clickOnPurchaseOrder()
	{
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		purchaseOrder.click();
		
		
	}
	public void clickOnSalesOrder()
	{
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		salesOrder.click();
		
		
	}

	
	
	
}
