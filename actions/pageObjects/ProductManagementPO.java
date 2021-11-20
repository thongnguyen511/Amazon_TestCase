package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constants;
import commons.PageGeneratorManager;
import pageUIs.AbstractPUI;
import pageUIs.CustomerManagementPUI;
import pageUIs.ProductManagementPUI;

public class ProductManagementPO extends AbstractPage {
	WebDriver driver;

	public ProductManagementPO(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public ProductInfoPO clickNewProduct() {
		waitForElementVisible(driver, ProductManagementPUI.ADDNEW_BUTTON);
		clickToElementByJS(driver, ProductManagementPUI.ADDNEW_BUTTON);
		switchToWindowByTitle(driver, "Hung Thinh Portal > Services > Products > Product Information");
		return PageGeneratorManager.getProductInfoPage(driver);

	}

	public HomePO returnToHomePage() {
		return returnToHomePage(driver);
	}

	public void clickSearchButton() {
		waitForElementVisible(driver, ProductManagementPUI.SEARCH_BUTTON);
		clickToElement(driver, ProductManagementPUI.SEARCH_BUTTON);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
	}

	public String getIdentificationIdFromSearchReult() {
		waitForElementVisible(driver, CustomerManagementPUI.IDENTIFICATION_ID_AT_FIRSTROW);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		return getTextElement(driver, CustomerManagementPUI.IDENTIFICATION_ID_AT_FIRSTROW);
	}

	public String getFullNameFromSearchReult() {
		waitForElementVisible(driver, CustomerManagementPUI.FULLNAME_AT_FIRSTROW);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		return getTextElement(driver, CustomerManagementPUI.FULLNAME_AT_FIRSTROW);
	}

	public void enterProductIDToSearch(String productID) {
		waitForElementVisible(driver, ProductManagementPUI.PRODUCT_ID_TEXTBOX);
		clearTextbox(driver, ProductManagementPUI.PRODUCT_ID_TEXTBOX);
		sendkeyToElement(driver, ProductManagementPUI.PRODUCT_ID_TEXTBOX, productID);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public String getProductInfoFromSearchReult(String productID, int i) {
		String productInfoNo = Integer.toString(i);
		
		if (i == 0) {
			waitForElementVisible(driver, ProductManagementPUI.PRODUCT_ID_SEARCH_RESULT, productID);
			return getTextInElement(driver, ProductManagementPUI.PRODUCT_ID_SEARCH_RESULT, productID);
		} 
		else {
			waitForElementVisible(driver, ProductManagementPUI.PRODUCT_INFO_SEARCH_RESULT, productID, productInfoNo);
			return getTextInElement(driver, ProductManagementPUI.PRODUCT_INFO_SEARCH_RESULT, productID, productInfoNo);
		}
	}


}