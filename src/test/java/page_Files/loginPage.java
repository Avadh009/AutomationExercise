package page_Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base_Files.initBase;
import utils_Files.Utils;

public class loginPage extends initBase {

	private WebDriver driver;
	private String exceptionDesc;
	Utils utils;

	public loginPage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(driver);
		PageFactory.initElements(driver, this);
	}

	// ===========================
	// Web Elements
	// ===========================

	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	private WebElement btnSignupLogin;

//	Text Element
	@FindBy(xpath = "//h2[text()='New User Signup!']")
	private WebElement lblNewUserSignup;

	@FindBy(name = "name")
	private WebElement txtName;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement txtSignupEmail;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	private WebElement btnSignup;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement txtLoginEmail;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement txtLoginPassword;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement btnLogin;

	@FindBy(xpath = "//b[text()='Enter Account Information']")
	private WebElement lblEnterAccountInformation;

//	Signup Page
	@FindBy(xpath = "//p[contains(text(),'Email Address already exist!')]")
	private WebElement lblEmailAlreadyExist;

//	Account Information details [Register Page]

	@FindBy(id = "id_gender1")
	private WebElement rdoTitleMr;
	@FindBy(id = "id_gender2")
	private WebElement rdoTitleMrs;
	@FindBy(id = "password")
	private WebElement txtPassword;
	@FindBy(id = "days")
	private WebElement ddDay;
	@FindBy(id = "months")
	private WebElement ddMonth;
	@FindBy(id = "years")
	private WebElement ddYear;
	@FindBy(id = "newsletter")
	private WebElement chkNewsletter;
	@FindBy(id = "optin")
	private WebElement chkSpecialOffers;
	@FindBy(id = "first_name")
	private WebElement txtFirstName;
	@FindBy(id = "last_name")
	private WebElement txtLastName;
	@FindBy(id = "company")
	private WebElement txtCompany;
	@FindBy(id = "address1")
	private WebElement txtAddress;
	@FindBy(id = "address2")
	private WebElement txtAddress2;
	@FindBy(id = "country")
	private WebElement ddCountry;
	@FindBy(id = "state")
	private WebElement txtState;
	@FindBy(id = "city")
	private WebElement txtCity;
	@FindBy(id = "zipcode")
	private WebElement txtZipcode;
	@FindBy(id = "mobile_number")
	private WebElement txtMobileNumber;
	@FindBy(xpath = "//button[normalize-space()='Create Account']")
	private WebElement btnCreateAccount;

	@FindBy(css = "h2[data-qa='account-created']")
	private WebElement lblAccountCreated;
	@FindBy(css = "a[data-qa='continue-button']")
	private WebElement btnContinue;

	@FindBy(css = "li a[href='/logout']")
	private WebElement lnkLogout;
	
	@FindBy(css = "li a b")
	private WebElement lblLoggedInAsUsername;
//	-----------------------------------------------------------------------------------------

	// ===========================
	// Verifying URL
	// ===========================

	public boolean verifyHomePageURL() {

		try {

			String expectedURL = "https://automationexercise.com/";
			String actualURL = driver.getCurrentUrl();

			return actualURL.equals(expectedURL);

		} catch (Exception e) {

			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Login_002
	// Verify Signup / Login Button is Displayed
	// ===========================

	public boolean verifySignupLoginButton() {

		try {

			utils.waitForEle(btnSignupLogin, "visible", 5);

			if (btnSignupLogin.isDisplayed()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {

			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Click Signup/Login
	// Login_003
	// ===========================

	public boolean clickSignupLogin() {

		try {

			utils.waitForEle(btnSignupLogin, "visible", 5);
			btnSignupLogin.click();
			return true;

		} catch (Exception e) {

			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Verify Signup/Login Page is Displayed
	// ===========================

	public boolean verifySignupLoginPage() {

		try {

			utils.waitForEle(lblNewUserSignup, "visible", 5);
			return lblNewUserSignup.isDisplayed();

		} catch (Exception e) {

			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Login_004
	// Enter Name
	// ===========================

	public boolean enterName(String name) {

		try {

			utils.waitForEle(txtName, "enabled", 10);
			txtName.clear();
			txtName.sendKeys(name);
			return true;

		} catch (Exception e) {

			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Enter Signup Email
	// ===========================

	public boolean enterSignupEmail(String email) {

		try {

			utils.waitForEle(txtSignupEmail, "enabled", 10);
			txtSignupEmail.clear();
			txtSignupEmail.sendKeys(email);
			return true;

		} catch (Exception e) {

			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Click Signup
	// ===========================

	public boolean clickSignupButton() {

		try {

			utils.waitForEle(btnSignup, "visible", 5);
			btnSignup.click();
			return true;

		} catch (Exception e) {

			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Verify Enter Account Information Page
	// Login_005
	// ===========================

	// ===========================
	// Verify Email Already Exists
	// ===========================

	public boolean isEmailAlreadyExists() {

		try {

			utils.waitForEle(lblEmailAlreadyExist, "visible", 3);

			lblEmailAlreadyExist.isDisplayed();
			return true;

		} catch (Exception e) {

			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Verify Enter Account Information Page
	// ===========================
	public boolean verifyEnterAccountInformationPage() {

		try {

			utils.waitForEle(lblEnterAccountInformation, "visible", 5);

			lblEnterAccountInformation.isDisplayed();
			driver.navigate().refresh();
			return true;

		} catch (Exception e) {

			exceptionDesc = e.getMessage();
			return false;
		}
	}
	// ===========================
	// LOGIN_001
	// Enter Login Email
	// ===========================

	public boolean enterLoginEmail(String email, String password) {

		try {

			utils.waitForEle(txtLoginEmail, "visible", 10);
			txtLoginEmail.click();
			txtLoginEmail.clear();
			txtLoginEmail.sendKeys(email);

			utils.waitForEle(txtLoginPassword, "visible", 10);
			txtLoginPassword.click();
			txtLoginPassword.clear();
			txtLoginPassword.sendKeys(password);

			utils.waitForEle(btnLogin, "visible", 5);
			btnLogin.click();

			return true;

		} catch (Exception e) {

			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Enter Account Information Page - Field Methods
	// ===========================

	// ---- Title ----
	public boolean selectTitleMr() {
		try {
			utils.waitForEle(rdoTitleMr, "enabled", 10);
			rdoTitleMr.click();
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean selectTitleMrs() {
		try {
			utils.waitForEle(rdoTitleMrs, "enabled", 10);
			rdoTitleMrs.click();
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ---- Password ----
	public boolean enterPassword(String password) {
		try {
			utils.waitForEle(txtPassword, "enabled", 10);
			txtPassword.clear();
			txtPassword.sendKeys(password);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ---- Date of Birth ----
	public boolean selectDOBDay() {
		try {

			String day = "10";
			utils.waitForEle(ddDay, "enabled", 10);
			Select sel = new Select(ddDay);
			sel.selectByVisibleText(day);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean selectDOBMonth() {
		try {

			String month = "January";
			utils.waitForEle(ddMonth, "enabled", 10);
			Select sel = new Select(ddMonth);
			sel.selectByVisibleText(month);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean selectDOBYear() {
		try {

			String year = "2000";
			utils.waitForEle(ddYear, "enabled", 10);
			Select sel = new Select(ddYear);
			sel.selectByVisibleText(year);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ---- Newsletter / Offers checkboxes ----
	public boolean checkNewsletter() {
		try {
			utils.waitForEle(chkNewsletter, "enabled", 10);
			if (!chkNewsletter.isSelected()) {
				chkNewsletter.click();
			}
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean checkSpecialOffers() {
		try {
			utils.waitForEle(chkSpecialOffers, "enabled", 10);
			if (!chkSpecialOffers.isSelected()) {
				chkSpecialOffers.click();
			}
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ---- Address Information ----
	public boolean enterFirstName() {
		try {

			String firstName = "ABCD";
			utils.waitForEle(txtFirstName, "enabled", 10);
			txtFirstName.clear();
			txtFirstName.sendKeys(firstName);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean enterLastName() {
		try {

			String lastName = "XYZ";
			utils.waitForEle(txtLastName, "enabled", 10);
			txtLastName.clear();
			txtLastName.sendKeys(lastName);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean enterCompany() {
		try {

			String company = "AimVision";
			utils.waitForEle(txtCompany, "enabled", 10);
			txtCompany.clear();
			txtCompany.sendKeys(company);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean enterAddress() {
		try {

			String address = "Iskon";
			utils.waitForEle(txtAddress, "enabled", 10);
			txtAddress.clear();
			txtAddress.sendKeys(address);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

//	public boolean enterAddress2(String address2) {
//		try {
//			utils.waitForEle(txtAddress2, "enabled", 10);
//			txtAddress2.clear();
//			txtAddress2.sendKeys(address2);
//			return true;
//		} catch (Exception e) {
//			exceptionDesc = e.getMessage();
//			return false;
//		}
//	}

	public boolean selectCountry() {
		try {
			String country = "India";
			utils.waitForEle(ddCountry, "enabled", 10);
			Select sel = new Select(ddCountry);
			sel.selectByVisibleText(country);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean enterState() {
		try {

			String state = "Gujarat";
			utils.waitForEle(txtState, "enabled", 10);
			txtState.clear();
			txtState.sendKeys(state);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean enterCity() {
		try {

			String city = "Ahemdabad";
			utils.waitForEle(txtCity, "enabled", 10);
			txtCity.clear();
			txtCity.sendKeys(city);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean enterZipcode() {
		try {
			String zipcode = "123456";
			utils.waitForEle(txtZipcode, "enabled", 10);
			txtZipcode.clear();
			txtZipcode.sendKeys(zipcode);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean enterMobileNumber() {
		try {

			String mobileNumber = "9876543210";
			utils.waitForEle(txtMobileNumber, "enabled", 10);
			txtMobileNumber.clear();
			txtMobileNumber.sendKeys(mobileNumber);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ---- Create Account button ----
	public boolean clickCreateAccount() {
		try {
			utils.waitForEle(btnCreateAccount, "enabled", 10);
			btnCreateAccount.click();
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean verifyAccountCreatedPage() {
		try {
			utils.waitForEle(lblAccountCreated, "visible", 10);
			String actualText = lblAccountCreated.getText().trim();
			return actualText.equalsIgnoreCase("ACCOUNT CREATED!");
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean clickContinue() {
		try {
			utils.waitForEle(btnContinue, "enabled", 10);
			btnContinue.click();
			return true;

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

//	-------------------------------------------------------------------------------

	// ===========================
	// Home Page After Login - Verification Methods
	// ===========================

	public boolean verifyHomePageAfterSignup() {
		try {
			utils.waitForEle(lnkLogout, "visible", 10);
			driver.getCurrentUrl().equalsIgnoreCase("https://automationexercise.com/");
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean verifyLoggedInAsDisplayed() {
		try {
			utils.waitForEle(lblLoggedInAsUsername, "visible", 10);
			lblLoggedInAsUsername.getText().toLowerCase().contains("logged in as");
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean verifyLoggedInUsername(String expectedName) {
		try {
			utils.waitForEle(lblLoggedInAsUsername, "visible", 10);
			String actualText = lblLoggedInAsUsername.getText().trim();
			actualText.equalsIgnoreCase("Logged in as " + expectedName);
			return true;
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// Add this at the bottom of the class
	public String getExceptionDesc() {
		return exceptionDesc;
	}

}
