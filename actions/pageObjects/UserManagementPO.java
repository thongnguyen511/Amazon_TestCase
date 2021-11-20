package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constants;
import commons.PageGeneratorManager;
import pageUIs.AbstractPUI;
import pageUIs.UserManagementPUI;

public class UserManagementPO extends AbstractPage {
	WebDriver driver;

	public UserManagementPO(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public HomePO returnToHomePage() {
		return returnToHomePage(driver);
	}

	public UserInfoPO clickNewUser() {
		waitForElementVisible(driver, UserManagementPUI.ADDNEW_BUTTON);
		clickToElementByJS(driver, UserManagementPUI.ADDNEW_BUTTON);
		switchToWindowByTitle(driver,"Hung Thinh Portal > Administration > General Management > User Information");
		return PageGeneratorManager.getUserInfoPage(driver);
	}

	public void enterUserNameToSearch(String userName) {
		waitForElementVisible(driver, UserManagementPUI.USERNAME_TEXTBOX);
		clearTextbox(driver, UserManagementPUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, UserManagementPUI.USERNAME_TEXTBOX, userName);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}

	public void clickSearchButton() {
		waitForElementVisible(driver, UserManagementPUI.SEARCH_BUTTON);
		clickToElement(driver, UserManagementPUI.SEARCH_BUTTON);
		waitForElementPresence(driver, AbstractPUI.LOADING_ICON_UNDISP);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public UserInfoPO clickEditUserIcon(String userName) {
		waitForElementClickable(driver, UserManagementPUI.EDIT_USER_ICON, userName);
		clickToElement(driver, UserManagementPUI.EDIT_USER_ICON, userName);
		switchToWindowByTitle(driver, "Hung Thinh Portal > Administration > General Management > User Information");
		return PageGeneratorManager.getUserInfoPage(driver);
	}

	public String getUserStatus(String userName) {
		return getTextInElement(driver, UserManagementPUI.USER_STATUS_TEXT, userName);
	}


}