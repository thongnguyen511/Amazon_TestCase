package atg.webportal.services;

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

public class Customer_Management extends AbstractTest {
	WebDriver driver;
	LoginPO loginPage;
	HomePO homePage;
	CustomerManagementPO customerManagementPage;
	CustomerInfoPO customerInfoPage;

	String customerID, identificationID, identificationDateIssue, identificationPlaceIssue;
	String fullName, birthDate, gender, phoneNumber, email, partnerUserId;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		homePage = loginToApp(driver);
	}

	@Test
	public void TC_01_CreateCustomer() {
		// Test Data
		String messageAfterSave;

		identificationID = randomNumeric(12);
		identificationDateIssue = "01/01/2020";
		identificationPlaceIssue = "Ho Chi Minh";
		fullName = "ATG Name " + randomNumeric(5);
		birthDate = "01/01/1990";
		phoneNumber = "090" + randomNumeric(7);
		email = "atg" + randomNumeric(5) + "@gmail.com";
		partnerUserId = randomAlphaNumeric(10);

		customerManagementPage = homePage.selectMenuCustomerManagement();
		customerInfoPage = customerManagementPage.clickNewCustomer();
		customerInfoPage.enterIdentificationId(identificationID);
		customerInfoPage.enterIdentificationDateIssue(identificationDateIssue);
		customerInfoPage.enterIdentificationPlaceIssue(identificationPlaceIssue);
		customerInfoPage.enterFullName(fullName);
		customerInfoPage.enterBirthDate(birthDate);
		customerInfoPage.enterPhoneNumber(phoneNumber);
		customerInfoPage.enterEmail(email);
		customerInfoPage.enterPartnerUserId(partnerUserId);
		customerInfoPage.clickSaveButton();
		messageAfterSave = customerInfoPage.getMessageAfterSave();
		verifyEquals(messageAfterSave, "Thêm mới thành công.");
		customerInfoPage.clickAcceptButtonAfterSave();
		customerManagementPage = customerInfoPage.returnToCustomerManagementPage();

	}

	@Test
	public void TC_02_SearchCustomerByIdentificationID() {
		String actualIdentificationId, actualFullName;

		customerManagementPage.enterIdentificationIdToSearch(identificationID);
		customerManagementPage.clickSearchButton();
		actualIdentificationId = customerManagementPage.getIdentificationIdFromSearchReult();
		verifyEquals(actualIdentificationId, identificationID);

		actualFullName = customerManagementPage.getFullNameFromSearchReult();
		verifyEquals(actualFullName, fullName);

		// Clear IdentificationId value from the textbox
		customerManagementPage.enterIdentificationIdToSearch("");
		customerManagementPage.clickSearchButton();
	}

	@Test
	public void TC_03_SearchCustomerByFullName() {
		String actualIdentificationId, actualFullName;

		customerManagementPage.enterFullNameToSearch(fullName);
		customerManagementPage.clickSearchButton();
		actualIdentificationId = customerManagementPage.getIdentificationIdFromSearchReult();
		verifyEquals(actualIdentificationId, identificationID);

		actualFullName = customerManagementPage.getFullNameFromSearchReult();
		verifyEquals(actualFullName, fullName);

		// Clear FullName value from the textbox
		customerManagementPage.enterFullNameToSearch("");
		customerManagementPage.clickSearchButton();
	}

	@Test
	public void TC_04_SearchCustomerByPhoneNumber() {
		String actualIdentificationId, actualFullName;

		customerManagementPage.enterPhoneNumberToSearch(phoneNumber);
		customerManagementPage.clickSearchButton();
		actualIdentificationId = customerManagementPage.getIdentificationIdFromSearchReult();
		verifyEquals(actualIdentificationId, identificationID);

		actualFullName = customerManagementPage.getFullNameFromSearchReult();
		verifyEquals(actualFullName, fullName);

		// Clear FullName value from the textbox
		customerManagementPage.enterPhoneNumberToSearch("");
		customerManagementPage.clickSearchButton();
	}

	@Test
	public void TC_05_UpdateCustomerInfo() throws Exception {
		String customerID;
		String raceInfo, religionInfo, homePhone, companyPhone;
		String countryName, stateName, wardName;
		String alter01CountryName, alter02CountryName;
		
		//Actual values
		String actualAlter01StateName = "", actualAlter02StateName = "";
		String messageAfterUpdate = "";
		
		raceInfo = "Kinh";
		religionInfo = "Phật Giáo";
		homePhone = "028" + randomNumeric(6);
		companyPhone = "028" + randomNumeric(6);
		countryName = "VN - VIET NAM";
		stateName = "79 - HO CHI MINH";
		wardName = "768 - PHU NHUAN";
		alter01CountryName = "VN - VIET NAM";
		alter02CountryName = "VN - VIET NAM";

		customerManagementPage.enterIdentificationIdToSearch(identificationID);
		customerManagementPage.clickSearchButton();
		customerID = customerManagementPage.getCustomerIdFromSearchReult();
		customerInfoPage = customerManagementPage.clickEditCustomerIcon(customerID);
		customerInfoPage.enterRace(raceInfo);
		customerInfoPage.enterReligion(religionInfo);
		customerInfoPage.enterHomePhone(homePhone);
		customerInfoPage.enterCompanyPhone(companyPhone);
		customerInfoPage.selectCountry(countryName);
		customerInfoPage.selectState(stateName);
		customerInfoPage.selectWard(wardName);
		
		//Alternative Address 1
		customerInfoPage.selectAlter01Country(alter01CountryName);
		//Alternative Address 2
		customerInfoPage.selectAlter02Country(alter02CountryName);
		
		customerInfoPage.clickUpdateButton();
		messageAfterUpdate = customerInfoPage.getMessageAfterUpdate();
		verifyEquals(messageAfterUpdate, "Cập nhật thành công.");
		customerManagementPage = customerInfoPage.returnToCustomerManagementPage();
		
		//Open Customer Information Page again to verify the Thành Phố/Tỉnh
		customerInfoPage = customerManagementPage.clickEditCustomerIcon(customerID);
		actualAlter01StateName = customerInfoPage.getValueofAlter01StateName();
		verifyEquals(actualAlter01StateName, "-- Vui lòng chọn Thành phố/Tỉnh");
		actualAlter02StateName = customerInfoPage.getValueofAlter02StateName();
		verifyEquals(actualAlter02StateName, "-- Vui lòng chọn Thành phố/Tỉnh");
		
		homePage = customerManagementPage.returnToHomePage();
	}

	@AfterClass
	public void afterClass() {
		homePage.selectLogout();
		closeBrowserAndDriver(driver);
	}
}
