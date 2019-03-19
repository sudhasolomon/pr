package com;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) {
		StringBuilder builder=new StringBuilder();
		try {

			String FILE_NAME = "C:\\Projects\\NIPHM\\HRMS\\paymatrix.xlsx";
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			for(int cellCnt=1; cellCnt<=18; cellCnt++){
				int count=1;
				String previousValue="";
				builder=new StringBuilder();
				//builder.append(System.getProperty("line.separator"));
				Sheet datatypeSheet = workbook.getSheetAt(0);
				Iterator<Row> rowIterator = datatypeSheet.iterator(); 
				rowIterator.next();
				rowIterator.next();
				rowIterator.next();
			while (rowIterator.hasNext()) {
				Row currentRow = rowIterator.next();
				if(null!=currentRow.getCell(cellCnt)){
				String cellValue=celltype(currentRow.getCell(cellCnt));
				
				if(StringUtils.isNotBlank(previousValue)){
					int diffValue=Integer.parseInt(cellValue)-Integer.parseInt(previousValue);
					if(count==1){
					builder=builder.append("-"+String.valueOf(diffValue)+"-"+cellValue);
					}
					else{
						builder=builder.append("-"+String.valueOf(diffValue)+"-"+cellValue);
					}
					count=count+1;
					
					
				}
				previousValue=cellValue;
				builder=builder.append(previousValue);
				
				}
			}
			System.out.println(builder.toString());
			
			}
		} catch (Exception e) {
			System.out.println(builder.toString());
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
