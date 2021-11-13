package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.UserInfoPO;
import pageObjects.UserManagementPO;
import pageObjects.CustomerInfoPO;
import pageObjects.CustomerManagementPO;

public class PageGeneratorManager {
	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}

	public static HomePO getHomePage(WebDriver driver) {
		return new HomePO(driver);
	}

	public static CustomerManagementPO getCustomerManagementPage(WebDriver driver) {
		return new CustomerManagementPO(driver);
	}

	public static CustomerInfoPO getCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPO(driver);
	}

	public static UserManagementPO getUserManagementPage(WebDriver driver) {
		return new UserManagementPO(driver);
	}

	public static UserInfoPO getUserInfoPage(WebDriver driver) {
		return new UserInfoPO(driver);
	}
}
