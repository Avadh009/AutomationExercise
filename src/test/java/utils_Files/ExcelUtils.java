package utils_Files;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static final String EXCEL_PATH = System.getProperty("user.dir")
			+ "/src/test/resources/Test Data/Automation_Testing.xlsx";

	@SuppressWarnings("resource")
	public static HashMap<String, String> getData(String sheetName, String tcID) {

		HashMap<String, String> data = new HashMap<String, String>();

		try {

			FileInputStream fis = new FileInputStream(EXCEL_PATH);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			int rowNum = -1;

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				Cell tcCell = sheet.getRow(i).getCell(0);
				if (tcCell == null) {
					continue;
				}

				String currentTCID = tcCell.getStringCellValue();
				if (currentTCID.equalsIgnoreCase(tcID)) {
					rowNum = i;
					break;
				}
			}

			if (rowNum == -1) {

				throw new Exception("TC_ID Not Found : " + tcID);
			}

			Row dataRow = sheet.getRow(rowNum);
			for (int j = 0; j < headerRow.getLastCellNum(); j++) {

				Cell headerCell = headerRow.getCell(j);
				if (headerCell == null) {
					continue;
				}
				String key = headerCell.getStringCellValue();

				Cell valueCell = dataRow.getCell(j);
				String value = (valueCell == null) ? "" : valueCell.toString();

				data.put(key, value);
			}

			workbook.close();
			fis.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return data;
	}
}