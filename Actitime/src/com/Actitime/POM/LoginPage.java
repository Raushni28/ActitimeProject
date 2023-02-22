package com.Actitime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declartions
	@FindBy(id = "username")
	private WebElement untbox;
	
	@FindBy(name= "pwd")
	private WebElement pwtbox;
	
	@FindBy(xpath= "//div [.='Login ']")
	private WebElement lgnbtn;
	
	//intilizations
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//gettter method
	public WebElement getUntbox() {
		return untbox;
	}

	public WebElement getPwtbox() {
		return pwtbox;
	}

	public WebElement getLgnbtn() {
		return lgnbtn;
	}
	
	public void login( String username,String password) {
		untbox.sendKeys(username);
		pwtbox.sendKeys(password);
		lgnbtn.click();
	}
	
}
