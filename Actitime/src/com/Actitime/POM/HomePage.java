package com.Actitime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//declartions
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement tasks;
	
	@FindBy(id = "logoutLink")
	private WebElement logout;
	
	//initilizations
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//getters
	public WebElement getTasks() {
		return tasks;
	}

	public WebElement getLogout() {
		return logout;
	}

	
	
}
