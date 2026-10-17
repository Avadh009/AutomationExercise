package base_Files;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils_Files.ExcelUtils;
import utils_Files.LogResults;

public class initBase {

	public static WebDriver driver;
	public static String browser = "chrome";
	public static LogResults logResults = new LogResults(); // shared across all test classes

//    // Open Application
	public static void launchApplication() {

		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://automationexercise.com/");
		}
	}

	// Close Browser
	public static void closeApplication() {

		if (driver != null) {
			driver.quit();
		}
	}

	// Read Excel Data
	public static HashMap<String, String> loadExcelData(String sheetName, String tcID) {

		return ExcelUtils.getData(sheetName, tcID);
	}

	public static ArrayList<String> loadExcelData(String sheetName, String tcID, String columns) {

		HashMap<String, String> map = ExcelUtils.getData(sheetName, tcID);
		ArrayList<String> data = new ArrayList<>();
		String[] columnNames = columns.split(",");

		for (String column : columnNames) {

			data.add(map.get(column.trim()));

		}

		return data;
	}
}