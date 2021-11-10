package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constants;
import commons.PageGeneratorManager;
import pageUIs.LoginPUI;

public class LoginPO extends AbstractPage {
	WebDriver driver;

	public LoginPO(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public String getLoginPageUrl() {
		return getCurrentPageUrl(driver);
	}

	public void inputToUserNameTextbox(String username) {
		switchToFrame(driver, "iPopUp");
		waitForElementVisible(driver, LoginPUI.USER_NAME_TEXTBOX);
		sendkeyToElement(driver, LoginPUI.USER_NAME_TEXTBOX, username);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPUI.PASSWORD_TEXTBOX, password);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void clickLoginButton() {
		waitForElementVisible(driver, LoginPUI.LOGIN_BUTTON);
		clickToElementByJS(driver, LoginPUI.LOGIN_BUTTON);
	}

	public HomePO clickDangnhapButton() {
		waitForElementVisible(driver, LoginPUI.DANGNHAP_BUTTON);
		clickToElementByJS(driver, LoginPUI.DANGNHAP_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
}
