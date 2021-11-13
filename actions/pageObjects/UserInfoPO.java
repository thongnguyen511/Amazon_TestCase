package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constants;
import commons.PageGeneratorManager;
import pageUIs.AbstractPUI;
import pageUIs.CustomerInfoPUI;
import pageUIs.UserInfoPUI;

public class UserInfoPO extends AbstractPage {
	WebDriver driver;

	public UserInfoPO(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void enterUserName(String userName) {
		waitForElementVisible(driver, UserInfoPUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, UserInfoPUI.USERNAME_TEXTBOX, userName);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void enterDisplayName(String displayName) {
		waitForElementVisible(driver, UserInfoPUI.DISPLAYNAME_TEXTBOX);
		sendkeyToElement(driver, UserInfoPUI.DISPLAYNAME_TEXTBOX, displayName);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void enterRemark(String remark) {
		waitForElementVisible(driver, UserInfoPUI.REMARK_TEXTAREA);
		sendkeyToElement(driver, UserInfoPUI.REMARK_TEXTAREA, remark);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void enterPhoneNumber(String phoneNumber) {
		waitForElementVisible(driver, UserInfoPUI.PHONENUMBER_TEXTBOX);
		sendkeyToElement(driver, UserInfoPUI.PHONENUMBER_TEXTBOX, phoneNumber);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void enterPhoneExtension(String phoneExtension) {
		waitForElementVisible(driver, UserInfoPUI.PHONEEXTENSION_TEXTBOX);
		sendkeyToElement(driver, UserInfoPUI.PHONEEXTENSION_TEXTBOX, phoneExtension);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void selectGender(String gender) throws Exception {
		waitForElementVisible(driver, UserInfoPUI.GENDER_TEXTBOX);
		selectItemInDropdown(driver, UserInfoPUI.GENDER_TEXTBOX, UserInfoPUI.GENDER_DROPDOWN_LIST, gender);
		
	}

	public void selectMerchantName(String merchantName) throws Exception {
		waitForElementVisible(driver, UserInfoPUI.MARCHANT_TEXTBOX);
		selectItemInDropdown(driver, UserInfoPUI.MARCHANT_TEXTBOX, UserInfoPUI.MARCHANT_DROPDOWN_LIST, merchantName);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
		
	}

	public void clickSaveButton() {
		waitForElementClickable(driver, UserInfoPUI.SAVE_BUTTON);
		clickToElement(driver, UserInfoPUI.SAVE_BUTTON);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
		
	}

	public String getMessageAfterSave() {
		waitForElementVisible(driver, UserInfoPUI.MESSAGE_AFTER_SAVE);
		return getTextElement(driver, UserInfoPUI.MESSAGE_AFTER_SAVE);

	}

	public void clickAcceptButtonAfterSave() {
		waitForElementVisible(driver, CustomerInfoPUI.ACCEPT_BUTTON_AFTER_SAVE);
		clickToElement(driver, CustomerInfoPUI.ACCEPT_BUTTON_AFTER_SAVE);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public UserManagementPO returnToUserManagementPage() {
		String parentWindow;

		switchToWindowByTitle(driver, "Hung Thinh Portal > Administration > General Management > User Management");
		parentWindow = driver.getWindowHandle();
		closeAllWindowWithoutParent(driver, parentWindow);
		return PageGeneratorManager.getUserManagementPage(driver);
	}

	public void selectRoleGroupCheckbox(String roleGroupName) {
//		waitForElementClickable(driver, UserInfoPUI.ROLE_GROUP_CHECKBOX, roleGroupName);
		clickToElementByJS(driver, UserInfoPUI.ROLE_GROUP_CHECKBOX, roleGroupName);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void clickUpdateButton() {
		waitForElementClickable(driver, UserInfoPUI.UPDATE_BUTTON);
		clickToElement(driver, UserInfoPUI.UPDATE_BUTTON);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
	}

	public String getMessageAfterUpdate() {
		waitForElementPresence(driver, UserInfoPUI.MESSAGE_AFTER_UPDATE);
		return getTextElement(driver, UserInfoPUI.MESSAGE_AFTER_UPDATE);
	}

	public void selectRoleInfoTab() {
		waitForElementVisible(driver, UserInfoPUI.ROLE_INFO_TAB);
		clickToElementByJS(driver, UserInfoPUI.ROLE_INFO_TAB);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void enterRoleRemark(String string) {
		waitForElementVisible(driver, UserInfoPUI.ROLE_REMARK_TEXTAREA);
		sendkeyToElement(driver, UserInfoPUI.ROLE_REMARK_TEXTAREA, string);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}



}