package com.Actitime.GenericLibrary;//generic package an method and class are used for multiple time

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	FileLibrary f=new FileLibrary();
	
  public static WebDriver driver;
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected",true);
	}
	@AfterSuite
	public void databasedisconnection() {
		
		Reporter.log("database disconnected",true);
	}
@BeforeClass
public void launchbrowser() throws IOException {
	 driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String Url = f.readDataFromPropertyFile("url");
	driver.get(Url);
	Reporter.log("Browser launched succesfully",true);	 
}
@AfterClass
public void closeBrowser() {
	Reporter.log("browser closed successful",true);
}
@BeforeMethod
public void loginToActitime() throws IOException {
	String UN = f.readDataFromPropertyFile("username");
	String PW = f.readDataFromPropertyFile("password");
	driver.findElement(By.id("username")).sendKeys(UN);
	driver.findElement(By.name("pwd")).sendKeys(PW);
	driver.findElement(By.xpath("//div[.='Login ']")).click();
	Reporter.log("logged  successfully",true);
}
  @AfterMethod
  public void logoutFromActitime() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.findElement(By.id("logoutLink")).click();
	  driver.close();
	  Reporter.log("Loggout successfully",true);
  }
}
