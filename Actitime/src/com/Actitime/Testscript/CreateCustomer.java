  package com.Actitime.Testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.POM.HomePage;
import com.Actitime.POM.TaskPage;

public class CreateCustomer  extends BaseClass {
	FileLibrary fl=new FileLibrary();
	@Test
   public void createcustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp=new HomePage(driver);
		Thread.sleep(5000);
		hp.getTasks().click();
		TaskPage tp=new TaskPage(driver);
		String customer = fl.readDataFromExcelFile("Sheet1",1,1);
		String description = fl.readDataFromExcelFile("Sheet1", 1, 2);
		tp.completeTask(customer, description);	
		String expected=customer;
		System.out.println(expected);
		String Actualdata = driver.findElement(By.xpath("//div[@title='"+customer+"']")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(expected, Actualdata);
		Reporter.log("assertion pass",true);
		s.assertAll();
   }
}
