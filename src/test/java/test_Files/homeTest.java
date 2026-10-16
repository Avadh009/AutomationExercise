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
import page_Files.homePage;
import utils_Files.LoadDriver;
import utils_Files.LogResults;

public class homeTest {

	WebDriver driver;
	LogResults logResults = initBase.logResults; // shared instance, same as loginTest

	LoadDriver loadDriver = new LoadDriver();

	homePage homePage = new homePage(driver);

	@BeforeMethod
	@Parameters({ "device", "hubnodeip" })
	public void launchDriver(int device, @Optional String hubnodeip) {

		if (initBase.driver == null) {

			initBase.browser = "chrome";

			initBase.driver = loadDriver.getDriver(device, hubnodeip);

			initBase.driver.manage().window().maximize();
			initBase.driver.get("https://automationexercise.com/");
		}

		driver = initBase.driver; // reuse the SAME browser session loginTest already logged into

		homePage = new homePage(driver);

		logResults.setDriver(driver);
		logResults.setScenarioName("");
	}

	@Parameters({ "device", "hubnodeip" })
	@BeforeClass
	public void runOnce(int device, @Optional String hubnodeip) {

		// createReport() intentionally NOT called here —
		// it's already created once by loginTest's @BeforeClass since Login runs first
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 1, enabled = true)
	public void Home_001() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify user is redirected to the Home page after successful login.");

		if (homePage.verifyRedirectedToHomePage()) {
			logResults.createLogs("Y", "PASS", "User redirected to Home page successfully.");
		} else {
			logResults.createLogs("N", "FAIL", "User was not redirected to Home page. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 2, enabled = true)
	public void Home_002() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the Automation Exercise logo is displayed on the Home page.");

		if (homePage.verifyLogoDisplayed()) {
			logResults.createLogs("Y", "PASS", "Logo is displayed successfully.");
		} else {
			logResults.createLogs("N", "FAIL", "Logo is not displayed. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 3, enabled = true)
	public void Home_003() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the home-page banner/carousel is displayed correctly.");

		if (homePage.verifyCarouselDisplayed()) {
			logResults.createLogs("Y", "PASS", "Carousel is displayed successfully.");
		} else {
			logResults.createLogs("N", "FAIL", "Carousel is not displayed. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 4, enabled = true)
	public void Home_004() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the user can move to the next banner in the carousel.");

		if (homePage.clickCarouselNext()) {
			logResults.createLogs("Y", "PASS", "Moved to next banner successfully.");
		} else {
			logResults.createLogs("N", "FAIL", "Failed to move to next banner. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 5, enabled = true)
	public void Home_005() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the user can move to the previous banner in the carousel.");

		if (homePage.clickCarouselPrev()) {
			logResults.createLogs("Y", "PASS", "Moved to previous banner successfully.");
		} else {
			logResults.createLogs("N", "FAIL", "Failed to move to previous banner. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 6, enabled = true)
	public void Home_006() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the Category section (Women, Men, Kids) is displayed on the Home page.");

		if (homePage.verifyCategorySectionDisplayed()) {
			logResults.createLogs("Y", "PASS", "Category section is displayed successfully.");
		} else {
			logResults.createLogs("N", "FAIL", "Category section is not displayed. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 7, enabled = true)
	public void Home_007() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the Women category can be expanded and subcategories are displayed.");

		if (homePage.expandWomenCategory()) {
			logResults.createLogs("Y", "PASS", "Women category expanded, subcategories displayed.");
		} else {
			logResults.createLogs("N", "FAIL", "Failed to expand Women category. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 8, enabled = true)
	public void Home_008() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the Men category can be expanded and subcategories are displayed.");

		if (homePage.expandMenCategory()) {
			logResults.createLogs("Y", "PASS", "Men category expanded, subcategories displayed.");
		} else {
			logResults.createLogs("N", "FAIL", "Failed to expand Men category. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 9, enabled = true)
	public void Home_009() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the Kids category can be expanded and subcategories are displayed.");

		if (homePage.expandKidsCategory()) {
			logResults.createLogs("Y", "PASS", "Kids category expanded, subcategories displayed.");
		} else {
			logResults.createLogs("N", "FAIL", "Failed to expand Kids category. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 10, enabled = true)
	public void Home_010() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the Brands section is displayed with brand names and product counts.");

		if (homePage.verifyBrandsSectionDisplayed()) {
			logResults.createLogs("Y", "PASS", "Brands section is displayed successfully.");
		} else {
			logResults.createLogs("N", "FAIL", "Brands section is not displayed. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------
	@Test(priority = 11, enabled = true)
	public void Home_011() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		ArrayList<String> data = initBase.loadExcelData("Home", currTC, "Brand_Name");
		String Brand_Name = data.get(0);

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify user can click a Brand and navigate to the filtered brand page.");

		if (homePage.clickBrandByName(Brand_Name)) {
			logResults.createLogs("Y", "PASS", "Navigated to filtered brand page for : " + Brand_Name);
		} else {
			logResults.createLogs("N", "FAIL",
					"Failed to navigate to brand page for : " + Brand_Name + ". " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 12, enabled = true)
	public void Home_012() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the Featured Items section is displayed on the Home page.");

		if (homePage.verifyFeaturedItemsSectionDisplayed()) {
			logResults.createLogs("Y", "PASS", "Featured Items section is displayed successfully.");
		} else {
			logResults.createLogs("N", "FAIL",
					"Featured Items section is not displayed. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 13, enabled = true)
	public void Home_013() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify product images are displayed in the Featured Items section.");

		if (homePage.verifyProductImagesDisplayed()) {
			logResults.createLogs("Y", "PASS", "Product images are displayed successfully.");
		} else {
			logResults.createLogs("N", "FAIL", "Product images are not displayed. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 14, enabled = true)
	public void Home_014() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		ArrayList<String> data = initBase.loadExcelData("Home", currTC, "Product_Name");
		String productName = data.get(0);

		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Verify a specific product name is displayed correctly in the Featured Items section.");

		if (homePage.verifyProductNameDisplayed(productName)) {
			logResults.createLogs("Y", "PASS", "Product name displayed correctly : " + productName);
		} else {
			logResults.createLogs("N", "FAIL",
					"Product name not found : " + productName + ". " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 15, enabled = true)
	public void Home_015() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		ArrayList<String> data = initBase.loadExcelData("Home", currTC, "Product_Name,Product_Price");
		String productName = data.get(0);
		String productPrice = data.get(1);

		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Verify a specific product price is displayed correctly in the Featured Items section.");

		if (homePage.verifyProductPriceDisplayed(productName, productPrice)) {
			logResults.createLogs("Y", "PASS", "Product price displayed correctly : " + productPrice);
		} else {
			logResults.createLogs("N", "FAIL",
					"Product price mismatch for : " + productName + ". " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 16, enabled = true)
	public void Home_016() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Verify hovering over a product image displays the overlay with 'Add to cart' button.");

		if (homePage.verifyHoverShowsAddToCart()) {
			logResults.createLogs("Y", "PASS", "'Add to cart' button displayed on hover.");
		} else {
			logResults.createLogs("N", "FAIL",
					"'Add to cart' button not displayed on hover. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 17, enabled = true)
	public void Home_017() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Verify hovering over a product image displays the 'View Product' link in the overlay.");

		if (homePage.verifyHoverShowsViewProduct()) {
			logResults.createLogs("Y", "PASS", "'View Product' link displayed on hover.");
		} else {
			logResults.createLogs("N", "FAIL",
					"'View Product' link not displayed on hover. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 18, enabled = true)
	public void Home_018() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Verify the hover overlay is displayed consistently for every product in the Featured Items section.");

		if (homePage.verifyHoverOverlayForAllProducts()) {
			logResults.createLogs("Y", "PASS", "Hover overlay displayed consistently for all products.");
		} else {
			logResults.createLogs("N", "FAIL",
					"Hover overlay inconsistent across products. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 19, enabled = true)
	public void Home_019() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		ArrayList<String> data = initBase.loadExcelData("Home", currTC, "Product_Name");
		String Product_Name = data.get(0);

		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Verify user can click a specific Featured Item and navigate to its Product Details page.");

		if (homePage.clickProductAndVerifyDetailsPage(Product_Name)) {
			logResults.createLogs("Y", "PASS", "Navigated to Product Details page for : " + Product_Name);
		} else {
			logResults.createLogs("N", "FAIL",
					"Failed to navigate to Product Details page. " + homePage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 20, enabled = true)
	public void Home_020() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		ArrayList<String> data = initBase.loadExcelData("Home", currTC, "Product_Price");
		String Product_Price = data.get(0);

		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Verify the product price displayed on the Home page matches the Product Details page.");

		if (homePage.verifyPriceMatchesOnDetailsPage(Product_Price)) {
			logResults.createLogs("Y", "PASS", "Price matches between Home page and Product Details page.");
		} else {
			logResults.createLogs("N", "FAIL",
					"Price mismatch between Home page and Product Details page. " + homePage.getExceptionDesc());
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
		logResults.flushReport(); // flushed ONCE here, since Home runs last in the suite
		if (driver != null) {
//			driver.quit();
		}
	}
}