package utils_Files;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	WebDriver driver;

	public Utils(WebDriver driver) {

		this.driver = driver;
	}

	public void waitForEle(WebElement ele, String condition, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		if (condition.equalsIgnoreCase("enabled")) {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}

		if (condition.equalsIgnoreCase("visible")) {
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
	}

	public void click(WebElement ele) {

		waitForEle(ele, "enabled", 10);
		ele.click();
	}

	public void enterText(WebElement ele, String text) {

		waitForEle(ele, "enabled", 10);
		ele.clear();
		ele.sendKeys(text);
	}

	public String getText(WebElement ele) {

		waitForEle(ele, "visible", 10);
		return ele.getText();
	}

	public String captureScreenshot(WebDriver driver, String screenshotName) {
		String destPath = "";
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);

			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String fileName = screenshotName + "_" + timestamp + ".png";

			// Store relative to your report folder so ExtentReports can find it
			String dirPath = System.getProperty("user.dir") + "/test-output/Screenshots/";
			File destDir = new File(dirPath);
			if (!destDir.exists()) {
				destDir.mkdirs();
			}

			destPath = dirPath + fileName;
			File destination = new File(destPath);
			FileUtils.copyFile(source, destination);

			// Return path relative to the extent report html so image link works
			return "Screenshots/" + fileName;

		} catch (Exception e) {
			destPath = "";
		}
		return destPath;
	}

}