package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constants;
import commons.PageGeneratorManager;
import pageUIs.AbstractPUI;
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

	public void enterProductIDToSearch(String productID) {
		waitForElementVisible(driver, ProductManagementPUI.PRODUCT_ID_TEXTBOX);
		clearTextbox(driver, ProductManagementPUI.PRODUCT_ID_TEXTBOX);
		sendkeyToElement(driver, ProductManagementPUI.PRODUCT_ID_TEXTBOX, productID);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public String getProductInfoByProductIDFromSearchResult(String productID, int i) {
		String productInfoNo = Integer.toString(i);
		
		if (i == 0) {
			waitForElementVisible(driver, ProductManagementPUI.PRODUCT_ID_FROM_SEARCH_RESULT, productID);
			return getTextInElement(driver, ProductManagementPUI.PRODUCT_ID_FROM_SEARCH_RESULT, productID);
		} 
		else {
			waitForElementVisible(driver, ProductManagementPUI.PRODUCT_INFO_SEARCH_BY_PRODUCT_ID, productID, productInfoNo);
			return getTextInElement(driver, ProductManagementPUI.PRODUCT_INFO_SEARCH_BY_PRODUCT_ID, productID, productInfoNo);
		}
	}

	public void enterProductNameToSearch(String productName) {
		waitForElementVisible(driver, ProductManagementPUI.PRODUCT_NAME_TEXTBOX);
		clearTextbox(driver, ProductManagementPUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, ProductManagementPUI.PRODUCT_NAME_TEXTBOX, productName);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public String getProductIDByProductNameFromSearchResult(String productName) {
		waitForElementVisible(driver, ProductManagementPUI.PRODUCT_ID_SEARCH_BY_PRODUCT_NAME, productName);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		return getTextInElement(driver, ProductManagementPUI.PRODUCT_ID_SEARCH_BY_PRODUCT_NAME, productName);
	}

	public ProductInfoPO clickEditProduct(String productID) {
		waitForElementClickable(driver, ProductManagementPUI.EDIT_PRODUCT_ICON, productID);
		clickToElement(driver, ProductManagementPUI.EDIT_PRODUCT_ICON, productID);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		switchToWindowByTitle(driver, "Hung Thinh Portal > Services > Products > Product Information");
		return PageGeneratorManager.getProductInfoPage(driver);
	}

	public void clickDeleteProduct(String productID) {
		waitForElementClickable(driver, ProductManagementPUI.DELETE_PRODUCT_ICON, productID);
		clickToElement(driver, ProductManagementPUI.DELETE_PRODUCT_ICON, productID);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void cancelToDeleteProduct() {
		waitForElementClickable(driver, ProductManagementPUI.DELETE_CANCEL_BUTTON);
		clickToElement(driver, ProductManagementPUI.DELETE_CANCEL_BUTTON);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void acceptToDeleteProduct() {
		waitForElementClickable(driver, ProductManagementPUI.DELETE_ACCEPT_BUTTON);
		clickToElement(driver, ProductManagementPUI.DELETE_ACCEPT_BUTTON);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
	}

	public String getMessageAfterDelete() {
		waitForElementVisible(driver, ProductManagementPUI.DELETE_SUCCESSFUL_MESSAGE);
		return getTextElement(driver, ProductManagementPUI.DELETE_SUCCESSFUL_MESSAGE);
	}


}