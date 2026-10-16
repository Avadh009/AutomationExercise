package test_Files;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils_Files.LoadDriver;
import base_Files.initBase;
import page_Files.loginPage;
import utils_Files.LogResults;

public class loginTest {

	WebDriver driver;

	LoadDriver loadDriver = new LoadDriver();
//	LogResults logResults = new LogResults();
	LogResults logResults = initBase.logResults;

	loginPage loginPage = new loginPage(driver);

	boolean emailAlreadyExists = false;

	@BeforeMethod
	@Parameters({ "device", "hubnodeip" })
	public void launchDriver(int device, @Optional String hubnodeip) {

		if (initBase.driver == null) {

			initBase.browser = "chrome";

			initBase.driver = loadDriver.getDriver(device, hubnodeip);

			initBase.driver.manage().window().maximize();
			initBase.driver.get("https://automationexercise.com/");
		}

		driver = initBase.driver; // local driver now points to the shared one

		loginPage = new loginPage(driver);

		logResults.setDriver(driver);
		logResults.setScenarioName("");
	}

	@Parameters({ "device", "hubnodeip" })
	@BeforeClass
	public void runOnce(int device, @Optional String hubnodeip) {

		logResults.createReport(device);

//		logResults.setTestMethodErrorCount(0);

	}

	@Test(priority = 1, enabled = true)
	public void Login_001() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);

		logResults.setScenarioName("Verify the Automation Exercise URL is accessible.");

		if (loginPage.verifyHomePageURL()) {
			logResults.createLogs("Y", "PASS", "URL verified successfully.");
		} else {
			logResults.createLogs("N", "FAIL", "URL verification failed.");
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 2, enabled = true)
	public void Login_002() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);

		logResults.setScenarioName("Verify the Signup / Login button is displayed on the home page.");

		if (loginPage.verifySignupLoginButton()) {
			logResults.createLogs("Y", "PASS", "Signup / Login button is displayed on the Home page.");

		} else {

			logResults.createLogs("N", "FAIL",
					"Signup / Login button is not displayed. " + loginPage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 3, enabled = true)
	public void Login_003() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);

		logResults.setScenarioName(
				"Verify user can navigate to the Signup/Login page by clicking the Signup / Login button.");

		if (loginPage.clickSignupLogin()) {

			logResults.createLogs("Y", "PASS", "Clicked on Signup / Login button successfully.");

		} else {

			logResults.createLogs("N", "FAIL",
					"Failed to click Signup / Login button. " + loginPage.getExceptionDesc());
		}

		if (loginPage.verifySignupLoginPage()) {

			logResults.createLogs("Y", "PASS", "User navigated to the Signup/Login page successfully.");

		} else {

			logResults.createLogs("N", "FAIL",
					"User was not navigated to the Signup/Login page. " + loginPage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 4, enabled = true)
	public void Login_004() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);

		logResults.setScenarioName("Verify user can enter a valid Name & Email in the Signup form.");

		ArrayList<String> data = initBase.loadExcelData("Login", currTC, "name,email");

		String name = data.get(0);
		String email = data.get(1);

		// Open Application
//		driver.get("https://automationexercise.com/");

		if (loginPage.enterName(name)) {
			logResults.createLogs("Y", "PASS", "Entered Name : " + name);
		} else {
			logResults.createLogs("N", "FAIL", "Failed to enter Name : " + loginPage.getExceptionDesc());
		}

		if (loginPage.enterSignupEmail(email)) {
			logResults.createLogs("Y", "PASS", "Entered Email : " + email);
		} else {
			logResults.createLogs("N", "FAIL", "Failed to enter Email : " + loginPage.getExceptionDesc());
		}

		if (loginPage.clickSignupButton()) {
			logResults.createLogs("Y", "PASS", "Clicked on Signup button.");
		} else {
			logResults.createLogs("N", "FAIL", "Failed to click Signup button : " + loginPage.getExceptionDesc());
		}

	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 5, enabled = true)
	public void Login_005() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the Enter Account Information page is displayed.");

		ArrayList<String> data = initBase.loadExcelData("Login", currTC, "email,password");

		String email = data.get(0);
		String password = data.get(1);

		if (loginPage.isEmailAlreadyExists()) {

			// Email already exists -> go to Login box instead of proceeding
			logResults.createLogs("Y", "PASS", "Email already exists validation is displayed.");

			loginPage.enterLoginEmail(email, password); // add this method in your Page class
			logResults.createLogs("Y", "PASS", "Clicked on Login box.");

			emailAlreadyExists = true;

		} else {

			emailAlreadyExists = false;

			// Email does not exist -> should redirect to Enter Account Information page
			if (loginPage.verifyEnterAccountInformationPage()) {
				logResults.createLogs("Y", "PASS", "Enter Account Information page is displayed successfully.");
			} else {
				logResults.createLogs("N", "FAIL",
						"Enter Account Information page is not displayed. " + loginPage.getExceptionDesc());
			}
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 6, enabled = true)
	public void Login_006() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify user can enter valid Account Information.");

		if (!emailAlreadyExists) {

			// Fill Account Information section
			if (loginPage.selectTitleMr()) {
				logResults.createLogs("Y", "PASS", "Title 'Mr.' selected.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to select Title. " + loginPage.getExceptionDesc());
			}

			if (loginPage.enterPassword("Test@1234")) {
				logResults.createLogs("Y", "PASS", "Password entered.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to enter Password. " + loginPage.getExceptionDesc());
			}

			if (loginPage.selectDOBDay()) {
				logResults.createLogs("Y", "PASS", "DOB Day selected.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to select DOB Day. " + loginPage.getExceptionDesc());
			}

			if (loginPage.selectDOBMonth()) {
				logResults.createLogs("Y", "PASS", "DOB Month selected.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to select DOB Month. " + loginPage.getExceptionDesc());
			}

			if (loginPage.selectDOBYear()) {
				logResults.createLogs("Y", "PASS", "DOB Year selected.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to select DOB Year. " + loginPage.getExceptionDesc());
			}

			if (loginPage.checkNewsletter()) {
				logResults.createLogs("Y", "PASS", "Newsletter checkbox checked.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to check Newsletter. " + loginPage.getExceptionDesc());
			}

			if (loginPage.checkSpecialOffers()) {
				logResults.createLogs("Y", "PASS", "Special offers checkbox checked.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to check Special Offers. " + loginPage.getExceptionDesc());
			}

			// Fill Address Information section
			if (loginPage.enterFirstName()) {
				logResults.createLogs("Y", "PASS", "First name entered.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to enter First name. " + loginPage.getExceptionDesc());
			}

			if (loginPage.enterLastName()) {
				logResults.createLogs("Y", "PASS", "Last name entered.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to enter Last name. " + loginPage.getExceptionDesc());
			}

			if (loginPage.enterCompany()) {
				logResults.createLogs("Y", "PASS", "Company entered.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to enter Company. " + loginPage.getExceptionDesc());
			}

			if (loginPage.enterAddress()) {
				logResults.createLogs("Y", "PASS", "Address entered.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to enter Address. " + loginPage.getExceptionDesc());
			}

			if (loginPage.selectCountry()) {
				logResults.createLogs("Y", "PASS", "Country selected.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to select Country. " + loginPage.getExceptionDesc());
			}

			if (loginPage.enterState()) {
				logResults.createLogs("Y", "PASS", "State entered.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to enter State. " + loginPage.getExceptionDesc());
			}

			if (loginPage.enterCity()) {
				logResults.createLogs("Y", "PASS", "City entered.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to enter City. " + loginPage.getExceptionDesc());
			}

			if (loginPage.enterZipcode()) {
				logResults.createLogs("Y", "PASS", "Zipcode entered.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to enter Zipcode. " + loginPage.getExceptionDesc());
			}

			if (loginPage.enterMobileNumber()) {
				logResults.createLogs("Y", "PASS", "Mobile number entered.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to enter Mobile number. " + loginPage.getExceptionDesc());
			}
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 7, enabled = true)
	public void Login_007() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify user can click the Create Account button.");

		if (!emailAlreadyExists) {

			// Submit
			if (loginPage.clickCreateAccount()) {
				logResults.createLogs("Y", "PASS", "Create Account button clicked.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to click Create Account. " + loginPage.getExceptionDesc());
			}
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 8, enabled = true)
	public void Login_008() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the ACCOUNT CREATED! message is displayed.");

		if (!emailAlreadyExists) {

			// Verify Account Created page
			if (loginPage.verifyAccountCreatedPage()) {
				logResults.createLogs("Y", "PASS", "Account Created page is displayed successfully.");
			} else {
				logResults.createLogs("N", "FAIL",
						"Account Created page is not displayed. " + loginPage.getExceptionDesc());
			}
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 9, enabled = true)
	public void Login_009() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify user can click the Continue button after account creation.");

		if (!emailAlreadyExists) {

			// Click Continue
			if (loginPage.clickContinue()) {
				logResults.createLogs("Y", "PASS", "Continue button clicked successfully.");
			} else {
				logResults.createLogs("N", "FAIL", "Failed to click Continue button. " + loginPage.getExceptionDesc());
			}
		}
	}

//	--------------------------------------------------------------------------------------

//	-----------------------------------------------------------------------------------------

	@Test(priority = 10, enabled = true)
	public void Login_010() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify user is navigated to the Home page after clicking the Continue button.");

//		if (emailAlreadyExists) {
//			logResults.createLogs("N", "SKIP", "Skipped - email already exists, account was not created.");
//			throw new SkipException("Email already exists - skipping.");
//		}

		if (loginPage.verifyHomePageAfterSignup()) {
			logResults.createLogs("Y", "PASS", "User navigated to Home page successfully.");
		} else {
			logResults.createLogs("N", "FAIL", "User was not navigated to Home page. " + loginPage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 11, enabled = true)
	public void Login_011() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify 'Logged in as [username]' is displayed on the Home page.");

//		if (emailAlreadyExists) {
//			logResults.createLogs("N", "SKIP", "Skipped - email already exists, account was not created.");
//			throw new SkipException("Email already exists - skipping.");
//		}

		if (loginPage.verifyLoggedInAsDisplayed()) {
			logResults.createLogs("Y", "PASS", "'Logged in as' text is displayed successfully.");
		} else {
			logResults.createLogs("N", "FAIL", "'Logged in as' text is not displayed. " + loginPage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------

	@Test(priority = 12, enabled = true)
	public void Login_012() {

		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();

		ArrayList<String> data = initBase.loadExcelData("Login", currTC, "name");

		String name = data.get(0);

		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Verify the displayed username matches the registered name.");

//		if (emailAlreadyExists) {
//			logResults.createLogs("N", "SKIP", "Skipped - email already exists, account was not created.");
//			throw new SkipException("Email already exists - skipping.");
//		}

		if (loginPage.verifyLoggedInUsername(name)) {
			logResults.createLogs("Y", "PASS", "Logged in username matches registered name.");
		} else {
			logResults.createLogs("N", "FAIL", "Logged in username does not match. " + loginPage.getExceptionDesc());
		}
	}

//	-----------------------------------------------------------------------------------------------------

	@AfterMethod
	void Aftermethod() {

//		logResults.onlyLog();
		if (driver != null) {
//			driver.quit();
		}
	}

	@AfterTest
	void cleanUp() {

		logResults.flushReport();
		if (driver != null) {
//			driver.quit();
		}
	}

}