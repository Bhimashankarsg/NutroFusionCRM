package com.NutroFusion.CRM.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtility_NFCRM {

	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptdata_task.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
	

	

	

}
