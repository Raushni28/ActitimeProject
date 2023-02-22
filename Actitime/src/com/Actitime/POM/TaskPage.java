package com.Actitime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addnewbtn;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement addnewcust;
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custname;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdesc;
	
	@FindBy(xpath="//div[@class='dropdownButton']")
	private WebElement dropdown;
	
	@FindBy(xpath="//div[.='Our company']")
	private WebElement ourcust;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement createcustbtn;
	
	public TaskPage(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	public WebElement getAddnewbtn() {
		return addnewbtn;
	}


	public WebElement getAddnewcust() {
		return addnewcust;
	}


	public WebElement getCustname() {
		return custname;
	}


	public WebElement getCustdesc() {
		return custdesc;
	}


	public WebElement getDropdown() {
		return dropdown;
	}


	public WebElement getOurcust() {
		return ourcust;
	}


	public WebElement getCreatecustbtn() {
		return createcustbtn;
	}


	//bussiness logic generic method
	public void completeTask(String Customer,String Description) throws InterruptedException {
		addnewbtn.click();
		addnewcust.click();
		custname.sendKeys(Customer);
		custdesc.sendKeys(Description);
		Thread.sleep(5000);
		 dropdown.click();
		 ourcust.click();
		 createcustbtn.click();
		 
		 
	}
	
	

}
