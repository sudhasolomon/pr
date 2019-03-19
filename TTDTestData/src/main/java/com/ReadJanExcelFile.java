package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadJanExcelFile {
	
	public static void main(String[] args) {
		String FILE_NAME = "C:\\Projects\\HRMS\\TTD\\20052018\\jan_18.xlsx";
		try {
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(2);
			Iterator<Row> rowIterator = datatypeSheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row currentRow = rowIterator.next();
				String gpfno=celltype(currentRow.getCell(1));
				System.out.println("gpf ::: "+gpfno);
				String amount=celltype(currentRow.getCell(2));
				System.out.println("Amount ::: "+amount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public static String celltype(Cell currentCell) {
		String cellValue = "";
		if (currentCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			cellValue = String.valueOf(((Double) currentCell.getNumericCellValue()).intValue());
		} else if (currentCell.getCellType() == Cell.CELL_TYPE_STRING) {
			cellValue = currentCell.getStringCellValue();
		} else if (currentCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			cellValue = String.valueOf(currentCell.getBooleanCellValue());
		}
		return cellValue;

	}
}
