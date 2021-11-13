package atg.webportal.administration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
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

	String userName, displayName, gender, phoneNumber, phoneExtension, merchantName, remark;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		homePage = loginToApp(driver);
	}

	
	public void TC_01_CreateRootMerchantUser() throws Exception {
		// Test Data
		userName = "atg" + randomNumeric(5) + "@gmail.com";
		displayName = "ATG Display Name" + randomNumeric(3);
		gender = "Nam";
		phoneNumber = "090" + randomNumeric(7);
		phoneExtension = randomNumeric(4);
		merchantName = "1 - Hung Thinh";
		remark = "Tạo mới người dùng";

		String messageAfterSave;

		log.info("TC_01_CreateRootMerchantUser - Step 1: Chọn Menu Quản Trị > Quản Trị Người Dùng");
		userManagementPage = homePage.selectMenuUserManagement();

		log.info("TC_01_CreateRootMerchantUser - Step 2: Click button Tạo Mới để mở cửa sổ Thông Tin Người Dùng");
		userInfoPage = userManagementPage.clickNewUser();

		log.info("TC_01_CreateRootMerchantUser - Step 3: Nhập username");
		userInfoPage.enterUserName(userName);

		log.info("TC_01_CreateRootMerchantUser - Step 4: Nhập display name");
		userInfoPage.enterDisplayName(displayName);

		log.info("TC_01_CreateRootMerchantUser - Step 5: Chọn giới tính");
		userInfoPage.selectGender(gender);

		log.info("TC_01_CreateRootMerchantUser - Step 6: Nhập số điện thoại");
		userInfoPage.enterPhoneNumber(phoneNumber);

		log.info("TC_01_CreateRootMerchantUser - Step 7: Nhập số extension");
		userInfoPage.enterPhoneExtension(phoneExtension);

		log.info("TC_01_CreateRootMerchantUser - Step 8: Chọn Đại Lý Root");
		userInfoPage.selectMerchantName(merchantName);

		log.info("TC_01_CreateRootMerchantUser - Step 9: Nhập ghi chú");
		userInfoPage.enterRemark(remark);

		log.info("TC_01_CreateRootMerchantUser - Step 10: Chọn button Lưu");
		userInfoPage.clickSaveButton();

		log.info("TC_01_CreateRootMerchantUser - Step 11: Kiểm tra message 'Thêm mới thành công:' hiển thị");
		messageAfterSave = userInfoPage.getMessageAfterSave();
		verifyEquals(messageAfterSave, "Thêm mới thành công.");

		log.info("TC_01_CreateRootMerchantUser - Step 13: Nhấn button Đồng ý");
		userInfoPage.clickAcceptButtonAfterSave();

		log.info("TC_01_CreateRootMerchantUser - Step 14: Về lại cửa sổ Quản Lý Người Dùng");
		userManagementPage = userInfoPage.returnToUserManagementPage();
	}

	@Test
	public void TC_02_UpdateRoleForRootMarchantUser() {
		String messageAfterUpdate;
		userManagementPage = homePage.selectMenuUserManagement();
		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 1: Nhập user name muốn cập nhật");
		userManagementPage.enterUserNameToSearch("atg14421@gmail.com");

		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 2: Click button Tìm kiếm");
		userManagementPage.clickSearchButton();

		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 3: Click Edit Icon để mở cửa sổ Thông Tin Người Dùng");
		userInfoPage = userManagementPage.clickEditUserIcon("atg14421@gmail.com");

		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 4: Chọn tab Thông Tin Phân Quyền");
		userInfoPage.selectRoleInfoTab();

		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 5: Chọn Transaction Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Transaction Management");

		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 6: Chọn Card Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Card Management");

		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 7: Chọn Customer Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Customer Management");

		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 8: Chọn Product Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Product Management");

		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 9: Chọn Account Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Account Management");

		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 10: Chọn User Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("User Management");

		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 11: Chọn Marchant Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Merchant Management");

		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 12: Chọn MDR Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("MDR Management");
		
		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 13: Chọn Notification Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Notification Management");

		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 13: Chọn Mobile Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Mobile Management");
	
		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 14: Chọn Report Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Report Management");
		
		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 15: Chọn System Role Group");
		userInfoPage.selectRoleGroupCheckbox("System");
		
		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 16: Nhập Ghi Chú");
		userInfoPage.enterRoleRemark("Cập nhật Role Group");
		
		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 17: Click button Cập nhật");
		userInfoPage.clickUpdateButton();
		
		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 18: Verify câu thông báo sau khi update");
		messageAfterUpdate = userInfoPage.getMessageAfterUpdate();
		verifyEquals(messageAfterUpdate, "Save User Information Success.");
		
		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 19: Trở về cửa sổ Quản Trị Người Dùng và đóng cửa sổ Thông Tin Người Dùng");
		userManagementPage = userInfoPage.returnToUserManagementPage();

		log.info("TC_02_UpdateRoleForRootMarchantUser - Step 19: Trở về cửa sổ Quản Trị Người Dùng và đóng cửa sổ Thông Tin Người Dùng");
		homePage = userManagementPage.returnToHomePage();
	}

	@Test
	public void TC_03_ModifyUserInfo() {

	}

	@AfterClass
	public void afterClass() {
		homePage.selectLogout();
		closeBrowserAndDriver(driver);
	}
}
