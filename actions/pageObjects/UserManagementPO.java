package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constants;
import commons.PageGeneratorManager;
import pageUIs.AbstractPUI;
import pageUIs.CustomerManagementPUI;

public class UserManagementPO extends AbstractPage {
	WebDriver driver;

	public UserManagementPO(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public CustomerInfoPO clickNewCustomer() {
		waitForElementVisible(driver, CustomerManagementPUI.ADDNEW_BUTTON);
		clickToElementByJS(driver, CustomerManagementPUI.ADDNEW_BUTTON);
		switchToWindowByTitle(driver, "Hung Thinh Portal > Services > Customers > Customer Information");
		return PageGeneratorManager.getCustomerInfoPage(driver);

	}

	public HomePO returnToHomePage() {
		return returnToHomePage(driver);
	}

	public void enterIdentificationIdToSearch(String identificationID) {
		waitForElementVisible(driver, CustomerManagementPUI.IDENTIFICATION_ID_TEXTBOX);
		clearTextbox(driver, CustomerManagementPUI.IDENTIFICATION_ID_TEXTBOX);
		sendkeyToElement(driver, CustomerManagementPUI.IDENTIFICATION_ID_TEXTBOX, identificationID);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void clickInquiryButton() {
		waitForElementVisible(driver, CustomerManagementPUI.INQUIRY_BUTTON);
		clickToElement(driver, CustomerManagementPUI.INQUIRY_BUTTON);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
//		sleepInSecond(driver, Constants.SHORT_SECOND);
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

	public void enterFullNameToSearch(String fullName) {
		waitForElementVisible(driver, CustomerManagementPUI.FULLNAME_TEXTBOX);
		clearTextbox(driver, CustomerManagementPUI.FULLNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerManagementPUI.FULLNAME_TEXTBOX, fullName);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void enterPhoneNumberToSearch(String phoneNumber) {
		waitForElementVisible(driver, CustomerManagementPUI.PHONENUMBER_TEXTBOX);
		clearTextbox(driver, CustomerManagementPUI.PHONENUMBER_TEXTBOX);
		sendkeyToElement(driver, CustomerManagementPUI.PHONENUMBER_TEXTBOX, phoneNumber);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
		
	}

	public String getCustomerIdFromSearchReult() {
		waitForElementVisible(driver, CustomerManagementPUI.CUSTOMER_ID_AT_FIRSTROW);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		return getTextElement(driver, CustomerManagementPUI.CUSTOMER_ID_AT_FIRSTROW);
	}

	public CustomerInfoPO clickEditCustomerIcon(String customerID) {
		waitForElementVisible(driver, CustomerManagementPUI.EDIT_CUSTOMER_ICON, customerID);
		clickToElement(driver, CustomerManagementPUI.EDIT_CUSTOMER_ICON, customerID);
		switchToWindowByTitle(driver, "Hung Thinh Portal > Services > Customers > Customer Information");
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}

	public UserInfoPO clickNewUser() {
		waitForElementVisible(driver, UserManagementPUI.ADDNEW_BUTTON);
		clickToElementByJS(driver, UserManagementPUI.ADDNEW_BUTTON);
		switchToWindowByTitle(driver, "Hung Thinh Portal > Services > Customers > Customer Information");
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}


}