package com.NutroFusion.CRM.generic.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_NFCRM {
	WebDriver driver;
	public LoginPage_NFCRM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement userpassword;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	public void loginPage(String url,String un,String pwd)
	{
		driver.get(url);
		username.sendKeys(un);
		userpassword.sendKeys(pwd);
		submitButton.click();
	}

}
