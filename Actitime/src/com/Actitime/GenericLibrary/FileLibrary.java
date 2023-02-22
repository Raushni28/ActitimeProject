package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {
	//by notepad commondata.property
	String path="./TestData/commondata.property";
	public String readDataFromPropertyFile(String key) throws IOException{
		FileInputStream fis=new FileInputStream(path);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	
		
	}
	//by excel 
	public String readDataFromExcelFile(String Sheetname,int row,int cell) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis =new FileInputStream("./TestData/TestData.xlxs");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
	return data;

	}
	

}