package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constants;
import commons.PageGeneratorManager;
import pageUIs.AbstractPUI;
import pageUIs.CustomerInfoPUI;
import pageUIs.ProductInfoPUI;
import pageUIs.UserInfoPUI;

public class ProductInfoPO extends AbstractPage {
	WebDriver driver;

	public ProductInfoPO(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void enterProductID(String productID) {
		waitForElementVisible(driver, ProductInfoPUI.PRODUCT_ID_TEXTBOX);
		sendkeyToElement(driver, ProductInfoPUI.PRODUCT_ID_TEXTBOX, productID);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void enterProductName(String productName) {
		waitForElementVisible(driver, ProductInfoPUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, ProductInfoPUI.PRODUCT_NAME_TEXTBOX, productName);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void enterRemark(String remark) {
		waitForElementVisible(driver, ProductInfoPUI.REMARK_TEXTAREA);
		sendkeyToElement(driver, ProductInfoPUI.REMARK_TEXTAREA, remark);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void clickSaveButton() {
		waitForElementClickable(driver, ProductInfoPUI.SAVE_BUTTON);
		clickToElement(driver, ProductInfoPUI.SAVE_BUTTON);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public String getMessageAfterSave() {
		waitForElementVisible(driver, ProductInfoPUI.MESSAGE_AFTER_SAVE);
		return getTextElement(driver, ProductInfoPUI.MESSAGE_AFTER_SAVE);

	}

	public void clickAcceptButtonAfterSave() {
		waitForElementVisible(driver, ProductInfoPUI.ACCEPT_BUTTON_AFTER_SAVE);
		clickToElement(driver, ProductInfoPUI.ACCEPT_BUTTON_AFTER_SAVE);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public String getMessageAfterUpdateOrDisableOrEnable() {
		waitForElementPresence(driver, UserInfoPUI.MESSAGE_AFTER_UPDATEORDISABLED);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		return getTextElement(driver, UserInfoPUI.MESSAGE_AFTER_UPDATEORDISABLED);
	}

	public ProductManagementPO returnToProductManagementPage() {
		String parentWindow;

		switchToWindowByTitle(driver, "Hung Thinh Portal > Services > Products > Product Management");
		parentWindow = driver.getWindowHandle();
		closeAllWindowWithoutParent(driver, parentWindow);
		return PageGeneratorManager.getProductManagementPage(driver);
	}

	public void enterProductLimitation(String productLimitation) {
		waitForElementVisible(driver, ProductInfoPUI.PRODUCT_LIMITATION_TEXTBOX);
		sendkeyToElement(driver, ProductInfoPUI.PRODUCT_LIMITATION_TEXTBOX, productLimitation);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void enterProductDailyLimitation(String productDailyLimitation) {
		waitForElementVisible(driver, ProductInfoPUI.PRODUCT_DAILY_LIMITATION_TEXTBOX);
		sendkeyToElement(driver, ProductInfoPUI.PRODUCT_DAILY_LIMITATION_TEXTBOX, productDailyLimitation);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void clearProductName() {
		waitForElementVisible(driver, ProductInfoPUI.PRODUCT_NAME_TEXTBOX);
		clearTextbox(driver, ProductInfoPUI.PRODUCT_NAME_TEXTBOX);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void clearProductLimitation() {
		waitForElementVisible(driver, ProductInfoPUI.PRODUCT_LIMITATION_TEXTBOX);
		clearTextbox(driver, ProductInfoPUI.PRODUCT_LIMITATION_TEXTBOX);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void clearProductDailyLimitation() {
		waitForElementVisible(driver, ProductInfoPUI.PRODUCT_DAILY_LIMITATION_TEXTBOX);
		clearTextbox(driver, ProductInfoPUI.PRODUCT_DAILY_LIMITATION_TEXTBOX);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void clearRemark() {
		waitForElementVisible(driver, ProductInfoPUI.REMARK_TEXTAREA);
		clearTextbox(driver, ProductInfoPUI.REMARK_TEXTAREA);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void clickUpdateButton() {
		waitForElementClickable(driver, ProductInfoPUI.UPDATE_BUTTON);
		clickToElement(driver, ProductInfoPUI.UPDATE_BUTTON);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
	}

	public String getMessageAfterUpdate() {
		waitForElementVisible(driver, ProductInfoPUI.NOTIFY_AFTER_UPDATE);
		return getTextElement(driver, CustomerInfoPUI.NOTIFY_AFTER_UPDATE);
	}

}