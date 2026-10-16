package utils_Files;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogResults {

	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void createExtentReport(String tcName) {
		test = extent.createTest(tcName);
	}

	public void createLogs(String screenshot, String status, String message) {

		try {

			if (screenshot.equalsIgnoreCase("Y")) {

				String path = ScreenshotUtils.captureScreenshot(driver, "IMG_" + status + "_" + System.nanoTime());

				if (status.equalsIgnoreCase("PASS")) {
					test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
				} else {
					test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
				}

			} else {

				if (status.equalsIgnoreCase("PASS")) {
					test.pass(message);
				} else {
					test.fail(message);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setScenarioName(String scenario) {
		System.out.println(scenario);
	}

	// Nested class must be static since it contains static members
	public static class ScreenshotUtils {

		public static String captureScreenshot(WebDriver driver, String screenshotName) {

			String relativePath = "";

			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);

				// Must sit UNDER "Reports/" since Report.html lives there —
				// relative paths in ExtentReports resolve against the report file's location
				String dirPath = System.getProperty("user.dir") + "/Reports/Screenshots/";
				File destDir = new File(dirPath);
				if (!destDir.exists()) {
					destDir.mkdirs();
				}

				String fileName = screenshotName + ".png";
				File destination = new File(dirPath + fileName);
				FileUtils.copyFile(source, destination);

				relativePath = "Screenshots/" + fileName;

			} catch (Exception e) {
				e.printStackTrace();
			}

			return relativePath;
		}
	}

	public void createReport(int device) {

		ExtentSparkReporter spark = new ExtentSparkReporter("Reports/Report.html");

		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	public void flushReport() {
		extent.flush();
	}
}