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

	@Test
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
	public void TC_02_UpdateRoleForRootMerchantUser() {
		String messageAfterUpdate;
		
		userManagementPage = homePage.selectMenuUserManagement();
		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 1: Nhập user name muốn cập nhật");
		userManagementPage.enterUserNameToSearch(userName);

		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 2: Click button Tìm kiếm");
		userManagementPage.clickSearchButton();

		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 3: Click Edit Icon để mở cửa sổ Thông Tin Người Dùng");
		userInfoPage = userManagementPage.clickEditUserIcon(userName);

		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 4: Chọn tab Thông Tin Phân Quyền");
		userInfoPage.selectRoleInfoTab();

		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 5: Chọn Transaction Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Transaction Management");

		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 6: Chọn Card Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Card Management");

		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 7: Chọn Customer Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Customer Management");

		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 8: Chọn Product Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Product Management");

		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 9: Chọn Account Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Account Management");

		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 10: Chọn User Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("User Management");

		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 11: Chọn Marchant Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Merchant Management");

		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 12: Chọn MDR Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("MDR Management");
		
		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 13: Chọn Notification Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Notification Management");

		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 13: Chọn Mobile Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Mobile Management");
	
		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 14: Chọn Report Management Role Group");
		userInfoPage.selectRoleGroupCheckbox("Report Management");
		
		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 15: Chọn System Role Group");
		userInfoPage.selectRoleGroupCheckbox("System");
		
		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 16: Nhập Ghi Chú");
		userInfoPage.enterRoleRemark("Cập nhật Role Group");
		
		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 17: Click button Cập nhật");
		userInfoPage.clickUpdateButton();
		
		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 18: Verify câu thông báo sau khi update");
		messageAfterUpdate = userInfoPage.getMessageAfterUpdateOrDisableOrEnable();
		verifyEquals(messageAfterUpdate, "Cập nhật phân quyền người dùng thành công.");
		
		log.info("TC_02_UpdateRoleForRootMerchantUser - Step 19: Trở về cửa sổ Quản Trị Người Dùng và đóng cửa sổ Thông Tin Người Dùng");
		userManagementPage = userInfoPage.returnToUserManagementPage();

	}

	@Test
	public void TC_03_DisabledUser() {
		String messageAfterDisable, userStatus;
		
		log.info("TC_03_DisabledUser - Step 1: Nhập user name = " + userName + " muốn vô hiệu");
		userManagementPage.enterUserNameToSearch(userName);
		
		log.info("TC_03_DisabledUser - Step 2: Click button Tìm kiếm");
		userManagementPage.clickSearchButton();

		log.info("TC_03_DisabledUser - Step 3: Click Edit Icon để mở cửa sổ Thông Tin Người Dùng");
		userInfoPage = userManagementPage.clickEditUserIcon(userName);

		log.info("TC_03_DisabledUser - Step 4: Click Edit Icon để mở cửa sổ Thông Tin Người Dùng");
		userInfoPage.enterRemark("Vô hiệu Account");

		log.info("TC_03_DisabledUser - Step 5: Chọn button Disable");
		userInfoPage.clickDisableButton();
		
		log.info("TC_03_DisabledUser - Step 5: Chọn button Đồng ý để vô hiệu user");
		userInfoPage.clickAcceptButton();
		
		log.info("TC_03_DisabledUser - Step 6: Kiểm tra message 'Disable Account Success.");
		messageAfterDisable = userInfoPage.getMessageAfterUpdateOrDisableOrEnable();
		verifyEquals(messageAfterDisable, "Khóa tài khoản thành công.");
		
		log.info("TC_03_DisabledUser - Step 7: Trở về cửa sổ Quản Trị Người Dùng và đóng cửa sổ Thông Tin Người Dùng");
		userManagementPage = userInfoPage.returnToUserManagementPage();
		
		log.info("TC_03_DisabledUser - Step 8: Click button Tìm kiếm để làm mới lại thông user");
		userManagementPage.clickSearchButton();
	
		log.info("TC_03_DisabledUser - Step 9: Verify Tình Trạng của user đã bị vô hiệu");
		userStatus = userManagementPage.getUserStatus(userName);
		verifyEquals(userStatus,"ĐÃ KHOÁ");
	}

	@Test
	public void TC_04_EnableUser() {
		String messageAfterEnable, userStatus;
		
		log.info("TC_04_EnableUser - Step 1: Nhập user name = " + userName + " muốn vô hiệu");
		userManagementPage.enterUserNameToSearch(userName);
		
		log.info("TC_04_EnableUser - Step 2: Click button Tìm kiếm");
		userManagementPage.clickSearchButton();

		log.info("TC_04_EnableUser - Step 3: Click Edit Icon để mở cửa sổ Thông Tin Người Dùng");
		userInfoPage = userManagementPage.clickEditUserIcon(userName);

		log.info("TC_04_EnableUser - Step 4: Click Edit Icon để mở cửa sổ Thông Tin Người Dùng");
		userInfoPage.enterRemark("Kích hoạt Account");

		log.info("TC_04_EnableUser - Step 5: Chọn button Kích hoạt");
		userInfoPage.clickEnableButton();
		
		log.info("TC_04_EnableUser - Step 5: Chọn button Đồng ý để vô hiệu user");
		userInfoPage.clickAcceptButton();
		
		log.info("TC_04_EnableUser - Step 6: Kiểm tra message 'Enable Account Success.");
		messageAfterEnable = userInfoPage.getMessageAfterUpdateOrDisableOrEnable();
		verifyEquals(messageAfterEnable, "Kích hoạt tài khoản thành công.");
		
		log.info("TC_04_EnableUser - Step 7: Trở về cửa sổ Quản Trị Người Dùng và đóng cửa sổ Thông Tin Người Dùng");
		userManagementPage = userInfoPage.returnToUserManagementPage();
		
		log.info("TC_04_EnableUser - Step 8: Click button Tìm kiếm để làm mới lại thông user");
		userManagementPage.clickSearchButton();
	
		log.info("TC_04_EnableUser - Step 9: Verify Tình Trạng của user đã bị vô hiệu");
		userStatus = userManagementPage.getUserStatus(userName);
		verifyEquals(userStatus,"ĐANG HOẠT ĐỘNG");
	}
	
	@AfterClass
	public void afterClass() {
		log.info("Trở về HomePage");
		homePage = userManagementPage.returnToHomePage();
		
		log.info("Log out khỏi Webportal");
		homePage.Logout();
		
		log.info("Đóng cửa sổ browser");
		closeBrowserAndDriver(driver);
	}
}
