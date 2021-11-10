package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constants;
import commons.PageGeneratorManager;
import pageUIs.AbstractPUI;
import pageUIs.CustomerInfoPUI;

public class CustomerInfoPO extends AbstractPage {
	WebDriver driver;

	public CustomerInfoPO(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void enterIdentificationId(String identificationID) {
		waitForElementVisible(driver, CustomerInfoPUI.IDENTIFICATION_ID_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPUI.IDENTIFICATION_ID_TEXTBOX, identificationID);
		sleepInSecond(driver, Constants.SHORT_SECOND);

	}

	public void enterIdentificationDateIssue(String identificationDateIssue) {
		waitForElementVisible(driver, CustomerInfoPUI.IDENTIFICATION_DATE_ISSUE_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPUI.IDENTIFICATION_DATE_ISSUE_TEXTBOX, identificationDateIssue);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void enterIdentificationPlaceIssue(String identificationPlaceIssue) {
		waitForElementVisible(driver, CustomerInfoPUI.IDENTIFICATION_PLACE_ISSUE_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPUI.IDENTIFICATION_PLACE_ISSUE_TEXTBOX, identificationPlaceIssue);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void enterFullName(String fullname) {
		waitForElementVisible(driver, CustomerInfoPUI.FULLNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPUI.FULLNAME_TEXTBOX, fullname);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void enterBirthDate(String birthDate) {
		waitForElementVisible(driver, CustomerInfoPUI.BIRTHDAY_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPUI.BIRTHDAY_TEXTBOX, birthDate);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void enterPhoneNumber(String phoneNumber) {
		waitForElementVisible(driver, CustomerInfoPUI.PHONENUMBER_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPUI.PHONENUMBER_TEXTBOX, phoneNumber);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void enterEmail(String email) {
		waitForElementVisible(driver, CustomerInfoPUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPUI.EMAIL_TEXTBOX, email);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void clickSaveButton() {
//		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
		waitForElementClickable(driver, CustomerInfoPUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoPUI.SAVE_BUTTON);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
	}

	public String getMessageAfterSave() {
		waitForElementVisible(driver, CustomerInfoPUI.MESSAGE_AFTER_SAVE);
		return getTextElement(driver, CustomerInfoPUI.MESSAGE_AFTER_SAVE);

	}

	public void clickAcceptButtonAfterSave() {
		waitForElementVisible(driver, CustomerInfoPUI.ACCEPT_BUTTON_AFTER_SAVE);
		clickToElement(driver, CustomerInfoPUI.ACCEPT_BUTTON_AFTER_SAVE);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public CustomerManagementPO returnToCustomerManagementPage() {
		String parentWindow;

		switchToWindowByTitle(driver, "Hung Thinh Portal > Services > Customers > Customer Management");
		parentWindow = driver.getWindowHandle();
		closeAllWindowWithoutParent(driver, parentWindow);
		return PageGeneratorManager.getCustomerManagementPage(driver);
	}

	public void selectState(String stateName) throws Exception {
		waitForElementVisible(driver, CustomerInfoPUI.STATECODE_TEXTBOX);
		selectItemInDropdown(driver, CustomerInfoPUI.STATECODE_TEXTBOX, CustomerInfoPUI.STATECODE_DROPDOWN_ITEMS, stateName);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
	}

	public void enterPartnerUserId(String partnerUserId) {
		waitForElementVisible(driver, CustomerInfoPUI.PARTNER_USER_ID_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPUI.PARTNER_USER_ID_TEXTBOX, partnerUserId);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void enterRace(String raceInfo) {
		waitForElementVisible(driver, CustomerInfoPUI.RACE_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPUI.RACE_TEXTBOX, raceInfo);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void enterReligion(String religionInfo) {
		waitForElementVisible(driver, CustomerInfoPUI.RELIGION_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPUI.RELIGION_TEXTBOX, religionInfo);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void enterHomePhone(String homePhone) {
		waitForElementVisible(driver, CustomerInfoPUI.HOME_PHONE_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPUI.HOME_PHONE_TEXTBOX, homePhone);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void enterCompanyPhone(String companyPhone) {
		waitForElementVisible(driver, CustomerInfoPUI.COMPANY_PHONE_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPUI.COMPANY_PHONE_TEXTBOX, companyPhone);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void selectWard(String wardName) throws Exception {
		waitForElementVisible(driver, CustomerInfoPUI.CITYCODE_TEXTBOX);
		selectItemInDropdown(driver, CustomerInfoPUI.CITYCODE_TEXTBOX, CustomerInfoPUI.CITYCODE_DROPDOWN_ITEMS, wardName);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
	}

	public void clickUpdateButton() {
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
		waitForElementClickable(driver, CustomerInfoPUI.UPDATE_BUTTON);
		clickToElement(driver, CustomerInfoPUI.UPDATE_BUTTON);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
	}

	public String getMessageAfterUpdate() {
		waitForElementVisible(driver, CustomerInfoPUI.NOTIFY_AFTER_UPDATE);
		return getTextElement(driver, CustomerInfoPUI.NOTIFY_AFTER_UPDATE);

	}

	public void selectCountry(String countryName) throws Exception {
		waitForElementVisible(driver, CustomerInfoPUI.COUNTRY_TEXTBOX);
		selectItemInDropdown(driver, CustomerInfoPUI.COUNTRY_TEXTBOX, CustomerInfoPUI.COUNTRY_DROPDOWN_ITEMS,countryName);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
	}

	public void selectAlter01Country(String alter01_CountryName) throws Exception {
		waitForElementVisible(driver, CustomerInfoPUI.ALTER_01_COUNTRY_TEXTBOX);
		selectItemInDropdown(driver, CustomerInfoPUI.ALTER_01_COUNTRY_TEXTBOX, CustomerInfoPUI.ALTER_01_COUNTRY_DROPDOWN_ITEMS,alter01_CountryName);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
		
	}

	public void selectAlter02Country(String alter01_CountryName) throws Exception {
		waitForElementVisible(driver, CustomerInfoPUI.ALTER_02_COUNTRY_TEXTBOX);
		selectItemInDropdown(driver, CustomerInfoPUI.ALTER_02_COUNTRY_TEXTBOX, CustomerInfoPUI.ALTER_02_COUNTRY_DROPDOWN_ITEMS,alter01_CountryName);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);

		
	}

	public String getValueofAlter01StateName() {
		waitForElementVisible(driver,CustomerInfoPUI.ALTER_01_STATECODE_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPUI.ALTER_01_STATECODE_TEXTBOX, "value");
	}

	public String getValueofAlter02StateName() {
		waitForElementVisible(driver,CustomerInfoPUI.ALTER_02_STATECODE_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPUI.ALTER_02_STATECODE_TEXTBOX, "value");
	}

}