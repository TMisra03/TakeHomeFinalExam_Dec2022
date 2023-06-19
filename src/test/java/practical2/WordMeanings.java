package practical2;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;


public class WordMeanings {

	public String pathToFile;
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	
	
	public WordMeanings(String pathToFile) {
		
		this.pathToFile = pathToFile;
		
		try {
			fis = new FileInputStream(pathToFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(1);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	// Method to call the value
	public String getCellData(String sheetName, String colName, int rowNum) {
		// For Sheet
		int index = workbook.getSheetIndex(sheetName);
		int col_Num = 0;
		sheet = workbook.getSheetAt(index);

		// For Row
		row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				col_Num = i;
			}
		}

		// For Column
		row = sheet.getRow(rowNum - 1);
		cell = row.getCell(col_Num);
		return cell.getStringCellValue();
	}
	
	@Test
	public void printWordsAndMeanings() {
		WordMeanings word = new WordMeanings("testData\\Practical2_TestData.xlsx");
		
		String apple = word.getCellData("WordMeaning", "Apple", 1);
		String appleMeaning1 = word.getCellData("WordMeaning", "Apple", 2);
		String appleMeaning2 = word.getCellData("WordMeaning", "Apple", 3);
		
		System.out.println(apple);
		System.out.println(appleMeaning1);
		System.out.println(appleMeaning2);
		
		String table = word.getCellData("WordMeaning", "Table", 1);
		String tableMeaning1 = word.getCellData("WordMeaning", "Table", 2);
		String tableMeaning2 = word.getCellData("WordMeaning", "Table", 3);
		
		System.out.println(table);
		System.out.println(tableMeaning1);
		System.out.println(tableMeaning2);
		
		String orange = word.getCellData("WordMeaning", "Orange", 1);
		String orangeMeaning1 = word.getCellData("WordMeaning", "Orange", 2);
		
		System.out.println(orange);
		System.out.println(orangeMeaning1);
	}
}
