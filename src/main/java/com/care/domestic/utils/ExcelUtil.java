package com.care.domestic.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtil {

	public static Object[][] read(String fileName, String sheetName) throws BiffException, IOException {

		String projectPath = System.getProperty("user.dir") + File.separator;
		String filePath = projectPath + "src" + File.separator + "main" + File.separator + "resources" + File.separator
				+ "data" + File.separator;
		FileInputStream fs = new FileInputStream(filePath + fileName);
		Workbook wb = Workbook.getWorkbook(fs);
		// TO get the access to the sheet
		Sheet sh = wb.getSheet(sheetName);
		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();
		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();
		Object[][] objects = new Object[totalNoOfRows-1][totalNoOfCols];

		for (int row = 1; row < totalNoOfRows; row++) {
			for (int col = 0; col < totalNoOfCols; col++) {
				System.out.print(sh.getCell(col, row).getContents() + "\t");
				objects[row-1][col] = sh.getCell(col, row).getContents();
			}
			System.out.println();
		}
		return objects;
	}
	
	/*
	 * public static void main(String[] args) throws BiffException, IOException {
	 * ExcelUtil.read("Enrolments.xls", "Seekers"); }
	 */
}
