package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePO;
import pageObjects.SignInPO;

public class PageGeneratorManager {
	public static SignInPO getLoginPage(WebDriver driver) {
		return new SignInPO(driver);
	}

	public static HomePO getHomePage(WebDriver driver) {
		return new HomePO(driver);
	}

	public static HomePO getUserHomePage(WebDriver driver) {
		return new HomePO(driver);
	}

	public static SignInPO getSignInPage(WebDriver driver) {
		return new SignInPO(driver);
	}
}
