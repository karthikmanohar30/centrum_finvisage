package com.CentrumFinvisage.utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SampleExcel {

	public static void main(String[] args) {

		try {
			File f = new File("C:\\Users\\karthik\\eclipse-workspace\\Centrum_Finvisage1.0\\src\\test\\java\\com\\CecntrumFinvisage\\testData\\TestData.xlsx");

			FileInputStream fis = new  FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheetAt(0);
			XSSFRow row=sheet.getRow(1);
			XSSFCell cell=row.getCell(0);
			int rowcount=sheet.getLastRowNum();
			for(int i=1; i<=rowcount ; i++)
			{
				for(int j=0; j<2; j++)
				{
					String data =sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.print(data);
					System.out.print(" ");
				}
				System.out.println();
			}
		} catch (Exception e) {

			e.getMessage();
			e.getCause();
		}



	}

}
