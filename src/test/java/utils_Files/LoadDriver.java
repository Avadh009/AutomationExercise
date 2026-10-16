package utils_Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import base_Files.initBase;

public class LoadDriver {

	public WebDriver getDriver(int device, String hubnodeip) {

		WebDriver driver = null;

		try {

			if (initBase.browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} 
			else if (initBase.browser.equalsIgnoreCase("edge")) {

				driver = new EdgeDriver();
			}

			driver.manage().window().maximize();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return driver;
	}
}