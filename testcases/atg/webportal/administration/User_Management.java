package atg.webportal.administration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.CustomerInfoPO;
import pageObjects.CustomerManagementPO;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.UserInfoPO;
import pageObjects.UserManagementPO;

public class User_Management extends AbstractTest {
	WebDriver driver;
	LoginPO loginPage;
	HomePO homePage;
	UserManagementPO userManagementPage;
	UserInfoPO userInfoPage;
	
	String customerID, identificationID, identificationDateIssue, identificationPlaceIssue;
	String fullName, birthDate, gender, phoneNumber, email, partnerUserId;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		homePage = loginToApp(driver);
	}

	@Test
	public void TC_01_CreateRootMerchantUser() {
		// Test Data
		String messageAfterSave;

		userManagementPage = homePage.selectMenuUserManagement();
		userInfoPage = userManagementPage.clickNewUser();
	}

	@Test
	public void TC_02_CreateMerchantUser() {
		
	}

	
	@Test
	public void TC_03_ModifyUserInfo() {
		
		
		homePage = userManagementPage.returnToHomePage();
	}

	@AfterClass
	public void afterClass() {
		homePage.clickToLogout();
		closeBrowserAndDriver(driver);
	}
}
