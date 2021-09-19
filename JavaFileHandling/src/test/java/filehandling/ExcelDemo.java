package filehandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class ExcelUtils {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String filePath;

	public ExcelUtils(String filePath) {
		this.filePath = filePath;
		try {
			workbook = new XSSFWorkbook(new FileInputStream(filePath));
			sheet = workbook.getSheetAt(0); // First Sheet default
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ExcelUtils(String filePath, String sheetName) {
		this(filePath);
		sheet = workbook.getSheet(sheetName);
	}

	public String getCellValue(int row, int column) {
		return sheet.getRow(row).getCell(column).getStringCellValue();
	}

	public void setCellValue(int row, int column, String value) {
		if (sheet.getRow(row) == null) {
			sheet.createRow(row).createCell(column).setCellValue(value);
		} else {
			sheet.getRow(row).createCell(column).setCellValue(value);
		}
		try {
			workbook.write(new FileOutputStream(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void display() {
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + "\t\t");
			}
			System.out.println();
		}
	}
}

public class ExcelDemo {

	public static void main(String[] args) {

		ExcelUtils excel = new ExcelUtils("src/test/resources/excelfile.xlsx");
		excel.setCellValue(0, 0, "ID");
		excel.setCellValue(0, 1, "Name");
		excel.setCellValue(1, 0, "ID001");
		excel.setCellValue(1, 1, "Vishwa");
		excel.setCellValue(2, 0, "ID002");
		excel.setCellValue(2, 1, "Vijetha");
		excel.display();
		excel.close();
	}

}
