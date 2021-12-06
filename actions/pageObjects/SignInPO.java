package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.Constants;
import commons.PageGeneratorManager;
import pageUIs.SignInPUI;

public class SignInPO extends AbstractPage {
	WebDriver driver;

	public SignInPO(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public String getLoginPageUrl() {
		return getCurrentPageUrl(driver);
	}

	public void enterUserName(String username) {
		waitForElementVisible(driver, SignInPUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, SignInPUI.EMAIL_TEXTBOX, username);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void enterPassword(String password) {
		waitForElementVisible(driver, SignInPUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, SignInPUI.PASSWORD_TEXTBOX, password);
		sleepInSecond(driver, Constants.SHORT_SECOND);
	}

	public void clickContinueButton() {
		waitForElementVisible(driver, SignInPUI.CONTINUE_BUTTON);
		clickToElementByJS(driver, SignInPUI.CONTINUE_BUTTON);
	}

	public HomePO clickSignInButton() {
		waitForElementVisible(driver, SignInPUI.SIGNIN_BUTTON);
		clickToElementByJS(driver, SignInPUI.SIGNIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public void clickSignInLink() {
		waitForElementVisible(driver, SignInPUI.SIGNIN_LINK);
		clickToElementByJS(driver, SignInPUI.SIGNIN_LINK);
		sleepInSecond(driver, Constants.SHORT_SECOND);
		
	}
}
