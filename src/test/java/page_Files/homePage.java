package page_Files;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils_Files.Utils;

public class homePage {

	WebDriver driver;
	Utils utils;
	String exceptionDesc;

	public homePage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(driver);
		PageFactory.initElements(driver, this);
	}

	public String getExceptionDesc() {
		return exceptionDesc;
	}

	// ===========================
	// Home_001
	// Verify user is redirected to the Home page after successful login.
	// ===========================

	@FindBy(xpath = "//a[contains(text(),'Logged in as')]")
	private WebElement lnkLoggedInAs;

	public boolean verifyRedirectedToHomePage() {
		try {
			utils.waitForEle(lnkLoggedInAs, "visible", 10);

			if (driver.getCurrentUrl().equalsIgnoreCase("https://automationexercise.com/")) {
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
	// Home_002
	// Verify the Automation Exercise logo is displayed on the Home page.
	// ===========================

	@FindBy(xpath = "//div[@class='logo pull-left']//img")
	private WebElement imgLogo;

	public boolean verifyLogoDisplayed() {
		try {
			utils.waitForEle(imgLogo, "visible", 10);

			if (imgLogo.isDisplayed()) {
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
	// Home_003
	// Verify the home-page banner/carousel is displayed correctly.
	// ===========================

	@FindBy(id = "slider-carousel")
	private WebElement carousel;

	public boolean verifyCarouselDisplayed() {
		try {
			utils.waitForEle(carousel, "visible", 10);

			if (carousel.isDisplayed()) {
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
	// Home_004
	// Verify the user can move to the next banner in the carousel.
	// ===========================

	@FindBy(xpath = "//a[@href='#slider-carousel' and contains(@class,'right')]")
	private WebElement btnCarouselNext;

	public boolean clickCarouselNext() {
		try {
			utils.waitForEle(btnCarouselNext, "enabled", 10);
			btnCarouselNext.click();
			return true;

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Home_005
	// Verify the user can move to the previous banner in the carousel.
	// ===========================

	@FindBy(xpath = "//a[@href='#slider-carousel' and contains(@class,'left')]")
	private WebElement btnCarouselPrev;

	public boolean clickCarouselPrev() {
		try {
			utils.waitForEle(btnCarouselPrev, "enabled", 10);
			btnCarouselPrev.click();
			return true;

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Home_006
	// Verify the Category section (Women, Men, Kids) is displayed on the Home page.
	// ===========================

	@FindBy(id = "accordian")
	private WebElement categoryAccordion;

	@FindBy(xpath = "//div[@id='accordian']//div[@class='panel-heading']")
	private List<WebElement> lstCategoryNames;

	public boolean verifyCategorySectionDisplayed() {
		try {
			utils.waitForEle(categoryAccordion, "visible", 10);

			if (categoryAccordion.isDisplayed() && lstCategoryNames.size() >= 3) {
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
	// Home_007
	// Verify the Women category can be expanded and subcategories (Dress, Tops &
	// Shirts) are displayed.
	// ===========================

//	@FindBy(xpath = "//div[@id='accordian']//a[contains(text(),'Women')]")
	@FindBy(xpath = "//h4[@class='panel-title']/a[@href='#Women']")
	private WebElement lnkWomenCategory;

	@FindBy(xpath = "//div[@id='Women']//a")
	private List<WebElement> lstWomenSubCategories;

	public boolean expandWomenCategory() {
		try {
			utils.waitForEle(lnkWomenCategory, "enabled", 10);
			lnkWomenCategory.click();
			utils.waitForEle(lstWomenSubCategories.get(0), "visible", 10);

			if (lstWomenSubCategories.size() > 0) {
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
	// Home_008
	// Verify the Men category can be expanded and subcategories are displayed.
	// ===========================

//	@FindBy(xpath = "//div[@id='accordian']//a[contains(text(),'Men')]")
	@FindBy(xpath = "//h4[@class='panel-title']/a[@href='#Men']")
	private WebElement lnkMenCategory;

	@FindBy(xpath = "//div[@id='Men']//a")
	private List<WebElement> lstMenSubCategories;

	public boolean expandMenCategory() {
		try {
			utils.waitForEle(lnkMenCategory, "enabled", 10);
			lnkMenCategory.click();
			utils.waitForEle(lstMenSubCategories.get(0), "visible", 10);

			if (lstMenSubCategories.size() > 0) {
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
	// Home_009
	// Verify the Kids category can be expanded and subcategories are displayed.
	// ===========================

//	@FindBy(xpath = "//div[@id='accordian']//a[contains(text(),'Kids')]")
	@FindBy(xpath = "//h4[@class='panel-title']/a[@href='#Kids']")
	private WebElement lnkKidsCategory;

	@FindBy(xpath = "//div[@id='Kids']//a")
	private List<WebElement> lstKidsSubCategories;

	public boolean expandKidsCategory() {
		try {
			utils.waitForEle(lnkKidsCategory, "enabled", 10);
			lnkKidsCategory.click();
			utils.waitForEle(lstKidsSubCategories.get(0), "visible", 10);

			if (lstKidsSubCategories.size() > 0) {
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
	// Home_010
	// Verify the Brands section is displayed with brand names and product counts.
	// ===========================

	@FindBy(xpath = "//div[contains(@class,'brands_products')]")
	private WebElement brandsSection;

	@FindBy(xpath = "//div[@class='brands_products']//ul[contains(@class,'nav-stacked')]//a")
	private List<WebElement> lstBrandNames;

	public boolean verifyBrandsSectionDisplayed() {
		try {
			utils.waitForEle(brandsSection, "visible", 10);

			if (brandsSection.isDisplayed() && lstBrandNames.size() > 0) {
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
	// Home_011
	// Verify user can click a Brand and navigate to the filtered brand page.
	// ===========================

	@FindBy(xpath = "//h2[@class='title text-center']")
	private WebElement lblBrandPageTitle;

	public boolean clickBrandByName(String Brand_Name) {
		try {
			for (WebElement brand : lstBrandNames) {
				if (brand.getText().trim().toLowerCase().contains(Brand_Name.toLowerCase())) {

					utils.waitForEle(brand, "enabled", 10);
					brand.click();

					utils.waitForEle(lblBrandPageTitle, "visible", 10);
					String pageTitle = lblBrandPageTitle.getText().trim();

					if (pageTitle.toLowerCase().contains(Brand_Name.toLowerCase())) {
						return true;
					} else {
						return false;
					}
				}
			}
			return false;

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Home_012
	// Verify the Featured Items section is displayed on the Home page.
	// ===========================

	@FindBy(xpath = "//div[contains(@class,'features_items')]")
	private WebElement featuredItemsSection;

	@FindBy(xpath = "//div[contains(@class,'features_items')]//div[contains(@class,'product-image-wrapper')]")
	private List<WebElement> lstProductTiles;

	public boolean verifyFeaturedItemsSectionDisplayed() {
		try {
			utils.waitForEle(featuredItemsSection, "visible", 10);

			if (featuredItemsSection.isDisplayed() && lstProductTiles.size() > 0) {
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
	// Home_013
	// Verify product images are displayed in the Featured Items section.
	// ===========================

	public boolean verifyProductImagesDisplayed() {
		try {
			for (WebElement tile : lstProductTiles) {
				WebElement img = tile.findElement(By.tagName("img"));
				if (!img.isDisplayed()) {
					return false;
				}
			}
			return true;

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Home_014
	// Verify a specific product name is displayed correctly in the Featured Items
	// section.
	// ===========================

	public boolean verifyProductNameDisplayed(String expectedName) {
		try {
			for (WebElement tile : lstProductTiles) {
				WebElement nameEle = tile.findElement(By.xpath(".//p"));

				if (nameEle.getText().trim().equalsIgnoreCase(expectedName)) {
					return true;
				}
			}
			return false;

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Home_015
	// Verify a specific product price is displayed correctly in the Featured Items
	// section.
	// ===========================

	public boolean verifyProductPriceDisplayed(String expectedName, String expectedPrice) {
		try {
			for (WebElement tile : lstProductTiles) {
				WebElement nameEle = tile.findElement(By.xpath(".//p"));

				if (nameEle.getText().trim().equalsIgnoreCase(expectedName)) {
					WebElement priceEle = tile.findElement(By.xpath(".//h2"));

					if (priceEle.getText().trim().equalsIgnoreCase(expectedPrice)) {
						return true;
					} else {
						return false;
					}
				}
			}
			return false;

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Home_016
	// Verify hovering over a product image displays the overlay with "Add to cart"
	// button.
	// ===========================

	public boolean verifyHoverShowsAddToCart() {
		try {
			WebElement firstTile = lstProductTiles.get(0);
			Actions actions = new Actions(driver);
			actions.moveToElement(firstTile).perform();

			WebElement addToCartBtn = firstTile.findElement(By.xpath(".//a[contains(@class,'add-to-cart')]"));
			utils.waitForEle(addToCartBtn, "visible", 10);

			if (addToCartBtn.isDisplayed()) {
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
	// Home_017
	// Verify hovering over a product image displays the "View Product" link in the
	// overlay.
	// ===========================

	public boolean verifyHoverShowsViewProduct() {
		try {
			WebElement firstTile = lstProductTiles.get(0);
			Actions actions = new Actions(driver);
			actions.moveToElement(firstTile).perform();

			WebElement viewProductLink = firstTile.findElement(By.xpath(".//a[contains(@href,'/product_details/')]"));
			utils.waitForEle(viewProductLink, "visible", 10);

			if (viewProductLink.isDisplayed()) {
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
	// Home_018
	// Verify the hover overlay is displayed consistently for every product in the
	// Featured Items section.
	// ===========================

	public boolean verifyHoverOverlayForAllProducts() {
		try {
			Actions actions = new Actions(driver);

			for (WebElement tile : lstProductTiles) {
				actions.moveToElement(tile).perform();

				WebElement addToCartBtn = tile.findElement(By.xpath(".//a[contains(@class,'add-to-cart')]"));
				WebElement viewProductLink = tile.findElement(By.xpath(".//a[contains(@href,'/product_details/')]"));

				utils.waitForEle(addToCartBtn, "visible", 5);
				utils.waitForEle(viewProductLink, "visible", 5);

				if (!addToCartBtn.isDisplayed() || !viewProductLink.isDisplayed()) {
					return false;
				}
			}
			return true;

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Home_019
	// Verify user can click a specific Featured Item and navigate to its Product
	// Details page.
	// ===========================

	@FindBy(xpath = "//div[@class='product-information']//h2")
	private WebElement lblProductDetailsHeader;

	public boolean clickProductAndVerifyDetailsPage(String Product_Name) {
		try {
			for (WebElement tile : lstProductTiles) {
				WebElement nameEle = tile.findElement(By.xpath(".//p"));

				if (nameEle.getText().trim().equalsIgnoreCase(Product_Name)) {

					Actions actions = new Actions(driver);
					actions.moveToElement(tile).perform();

					WebElement viewProductLink = tile
							.findElement(By.xpath(".//a[contains(@href,'/product_details/')]"));
					utils.waitForEle(viewProductLink, "enabled", 10);
					viewProductLink.click();

					utils.waitForEle(lblProductDetailsHeader, "visible", 10);

					if (driver.getCurrentUrl().contains("/product_details/")) {
						return true;
					} else {
						return false;
					}
				}
			}
			return false;

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	// ===========================
	// Home_020
	// Verify the product price displayed on the Home page matches the Product
	// Details page.
	// ===========================

	@FindBy(xpath = "//div[@class='product-information']//span")
	private WebElement lblProductDetailsPrice;

	public boolean verifyPriceMatchesOnDetailsPage(String Product_Price) {
		try {
			utils.waitForEle(lblProductDetailsPrice, "visible", 10);
			String detailsPrice = lblProductDetailsPrice.getText().trim();

			String detailsDigits = detailsPrice.replaceAll("[^0-9]", "");
			String homeDigits = Product_Price.replaceAll("[^0-9]", "");

			if (detailsDigits.equals(homeDigits)) {
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