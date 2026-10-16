package test_Files;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base_Files.initBase;
import page_Files.productPage;
import utils_Files.LoadDriver;
import utils_Files.LogResults;

public class productTest {

	WebDriver driver;
	LogResults logResults = initBase.logResults; // shared instance, same as loginTest/homeTest

	LoadDriver loadDriver = new LoadDriver();

	productPage productPage = new productPage(driver);

	@BeforeMethod
	@Parameters({ "device", "hubnodeip" })
	public void launchDriver(int device, @Optional String hubnodeip) {

		if (initBase.driver == null) {

			initBase.browser = "chrome";

			initBase.driver = loadDriver.getDriver(device, hubnodeip);

			initBase.driver.manage().window().maximize();
			initBase.driver.get("https://automationexercise.com/");
		}

		driver = initBase.driver; // reuse the SAME browser session from loginTest/homeTest

		productPage = new productPage(driver);

		logResults.setDriver(driver);
		logResults.setScenarioName("");
	}

	@Parameters({ "device", "hubnodeip" })
	@BeforeClass
	public void runOnce(int device, @Optional String hubnodeip) {
		// createReport() intentionally NOT called here — already created once by
		// loginTest's @BeforeClass
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 1, enabled = true)
	public void Product_001() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		ArrayList<String> data = initBase.loadExcelData("Product", currTC, "Product_Name");
		String productName = data.get(0);

		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Verify the Product Details page displays product name, category, price, availability, condition, and brand correctly.");

		if (productPage.verifyProductDetailsDisplayed(productName)) {
			logResults.createLogs("Y", "PASS", "Product details displayed correctly for : " + productName);
		} else {
			logResults.createLogs("N", "FAIL", "Product details not displayed correctly for : " + productName + ". "
					+ productPage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 2, enabled = true)
	public void Product_002() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the 'Write Your Review' section is displayed on the Product Details page.");

		if (productPage.verifyWriteReviewSectionDisplayed()) {
			logResults.createLogs("Y", "PASS", "'Write Your Review' section is displayed successfully.");
		} else {
			logResults.createLogs("N", "FAIL",
					"'Write Your Review' section is not displayed. " + productPage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 3, enabled = true)
	public void Product_003() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		ArrayList<String> data = initBase.loadExcelData("Product", currTC, "name,email,reviewText");
		String name = data.get(0);
		String email = data.get(1);
		String reviewText = data.get(2);

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify user can enter Name, Email, and Review text in the review form.");

		if (productPage.enterReviewDetails(name, email, reviewText)) {
			logResults.createLogs("Y", "PASS", "Review details entered and submitted successfully : " + name);
		} else {
			logResults.createLogs("N", "FAIL",
					"Failed to enter/submit review details. " + productPage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 4, enabled = true)
	public void Product_004() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Verify the 'Thank you for your review.' confirmation message is displayed after submitting a review.");

		if (productPage.verifyReviewSuccessMessageDisplayed()) {
			logResults.createLogs("Y", "PASS", "Review success message displayed correctly.");
		} else {
			logResults.createLogs("N", "FAIL",
					"Review success message not displayed. " + productPage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------------------

	@AfterMethod
	void Aftermethod() {
		if (driver != null) {
//			driver.quit();
		}
	}

	@AfterTest
	void cleanUp() {
		// flushReport() intentionally NOT called here — cartTest runs last, it owns the
		// flush
		if (driver != null) {
//			driver.quit();
		}
	}
}