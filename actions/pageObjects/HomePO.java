package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constants;
import commons.PageGeneratorManager;
import pageUIs.AbstractPUI;

public class HomePO extends AbstractPage {
	WebDriver driver;

	public HomePO(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public CustomerManagementPO selectMenuCustomerManagement() {
		waitForElementVisible(driver, AbstractPUI.TOPMENU_DICHVU_LINK);
		hoverMouseToElement(driver, AbstractPUI.TOPMENU_DICHVU_LINK);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		waitForElementVisible(driver, AbstractPUI.TOPMENU_DICHVU_QLKH_LINK);
		clickToElement(driver, AbstractPUI.TOPMENU_DICHVU_QLKH_LINK);

		return PageGeneratorManager.getCustomerManagementPage(driver);
	}

	public UserManagementPO selectMenuUserManagement() {
		waitForElementVisible(driver, AbstractPUI.TOPMENU_QUANTRI_LINK);
		hoverMouseToElement(driver, AbstractPUI.TOPMENU_QUANTRI_LINK);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		waitForElementVisible(driver, AbstractPUI.TOPMENU_QUANTRI_QTND_LINK);
		clickToElement(driver, AbstractPUI.TOPMENU_QUANTRI_QTND_LINK);

		return PageGeneratorManager.getUserManagementPage(driver);
	}

	public void selectLogout() {
		waitForElementVisible(driver, AbstractPUI.TOPMENU_PROFILE_ICON);
		hoverMouseToElement(driver, AbstractPUI.TOPMENU_PROFILE_ICON);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		waitForElementVisible(driver, AbstractPUI.TOPMENU_LOGOUT_LINK);
		clickToElement(driver, AbstractPUI.TOPMENU_LOGOUT_LINK);
		
	}

}