package page_Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils_Files.Utils;

public class productPage {

	WebDriver driver;
	Utils utils = new Utils(driver);
	String exceptionDesc;

	public productPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getExceptionDesc() {
		return exceptionDesc;
	}

	// ===========================
	// Product_001
	// Verify the Product Details page displays product name, category, price,
	// availability, condition, and brand correctly.
	// ===========================

	@FindBy(xpath = "//div[@class='product-information']/h2")
	private WebElement lblProductName;

	@FindBy(xpath = "//div[@class='product-information']/p[contains(text(),'Category')]")
	private WebElement lblProductCategory;

	@FindBy(xpath = "//div[@class='product-information']/span/span")
	private WebElement lblProductPrice;

	@FindBy(xpath = "//div[@class='product-information']/p[contains(text(),'Availability')]")
	private WebElement lblProductAvailability;

	@FindBy(xpath = "//div[@class='product-information']/p[contains(text(),'Condition')]")
	private WebElement lblProductCondition;

	@FindBy(xpath = "//div[@class='product-information']/p[contains(text(),'Brand')]")
	private WebElement lblProductBrand;

	public boolean verifyProductDetailsDisplayed(String expectedName) {
		try {
			utils.waitForEle(lblProductName, "visible", 10);

			String actualName = lblProductName.getText().trim();

			if (actualName.equalsIgnoreCase(expectedName) && lblProductCategory.isDisplayed()
					&& lblProductPrice.isDisplayed() && lblProductAvailability.isDisplayed()
					&& lblProductCondition.isDisplayed() && lblProductBrand.isDisplayed()) {
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
	// Product_002
	// Verify the "Write Your Review" section is displayed on the Product Details
	// page.
	// ===========================

	@FindBy(id = "review-form")
	private WebElement reviewFormSection;

	public boolean verifyWriteReviewSectionDisplayed() {
		try {
			utils.waitForEle(reviewFormSection, "visible", 10);

			if (reviewFormSection.isDisplayed()) {
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
	// Product_003
	// Verify user can enter Name, Email, and Review text in the review form.
	// ===========================

	@FindBy(id = "name")
	private WebElement txtReviewerName;

	@FindBy(id = "email")
	private WebElement txtReviewerEmail;

	@FindBy(id = "review")
	private WebElement txtReviewMessage;

	@FindBy(id = "button-review")
	private WebElement btnSubmitReview;

	public boolean enterReviewDetails(String name, String email, String reviewText) {
		try {
			utils.waitForEle(txtReviewerName, "enabled", 10);
			txtReviewerName.clear();
			txtReviewerName.sendKeys(name);

			utils.waitForEle(txtReviewerEmail, "enabled", 10);
			txtReviewerEmail.clear();
			txtReviewerEmail.sendKeys(email);

			utils.waitForEle(txtReviewMessage, "enabled", 10);
			txtReviewMessage.clear();
			txtReviewMessage.sendKeys(reviewText);

			utils.waitForEle(btnSubmitReview, "enabled", 10);
			btnSubmitReview.click();

			return true;

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Product_004
	// Verify the "Thank you for your review." confirmation message is displayed
	// after submitting a review.
	// ===========================

	@FindBy(xpath = "//div[@class='alert-success alert']")
	private WebElement lblReviewSuccessMessage;

	public boolean verifyReviewSuccessMessageDisplayed() {
		try {
			utils.waitForEle(lblReviewSuccessMessage, "visible", 10);

			String actualText = lblReviewSuccessMessage.getText().trim();

			if (actualText.equalsIgnoreCase("Thank you for your review.")) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}
}