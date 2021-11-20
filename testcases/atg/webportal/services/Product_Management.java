package atg.webportal.services;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.ProductInfoPO;
import pageObjects.ProductManagementPO;

public class Product_Management extends AbstractTest {
	WebDriver driver;
	LoginPO loginPage;
	HomePO homePage;
	ProductManagementPO productManagementPage;
	ProductInfoPO productInfoPage;

	String productID, productName, productLimitation, productDailyLimitation, remark;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		homePage = loginToApp(driver);
	}

	@Test
	public void TC_01_CreateProduct() {
		// Test Data
		String messageAfterSave;

		productID = randomNumeric(6);
		productName = "Auto Product Name " + productID;
		productLimitation = "1000000000";
		productDailyLimitation = "50000000";
		remark = "Create Name Product";
		
		log.info("TC_01_CreateProduct - Step 1: Chọn Menu Dịch Vụ > Quản Lý Sản Phẩm");
		productManagementPage = homePage.selectMenuProductManagement();

		log.info("TC_01_CreateProduct - Step 2: Chọn button Thêm mới");
		productInfoPage = productManagementPage.clickNewProduct();
		
		log.info("TC_01_CreateProduct - Step 3: Nhập mã sản phẩm");
		productInfoPage.enterProductID(productID);
		
		log.info("TC_01_CreateProduct - Step 4: Nhập tên sản phẩm");
		productInfoPage.enterProductName(productName);
		
		log.info("TC_01_CreateProduct - Step 5: Nhập hạn mức sản phẩm");
		productInfoPage.enterProductLimitation(productLimitation);
		
		log.info("TC_01_CreateProduct - Step 6: Nhập hạn mức trong ngày");
		productInfoPage.enterProductDailyLimitation(productDailyLimitation);
		
		log.info("TC_01_CreateProduct - Step 7: Nhập ghi chú");
		productInfoPage.enterRemark(remark);
		
		log.info("TC_01_CreateProduct - Step 8: Chọn button Lưu");
		productInfoPage.clickSaveButton();
		
		log.info("TC_01_CreateProduct - Step 9: Verify thông báo trả về sau khi lưu");
		messageAfterSave = productInfoPage.getMessageAfterSave();
		verifyEquals(messageAfterSave, "Thêm mới thành công.");
		
		log.info("TC_01_CreateProduct - Step 10: Chọn button Đồng ý");
		productInfoPage.clickAcceptButtonAfterSave();
		
		log.info("TC_01_CreateProduct - Step 11: Quay về trang quản lý sản phẩm");
		productManagementPage = productInfoPage.returnToProductManagementPage();

	}

	@Test
	public void TC_02_SearchProductByProductID() {
		String actualProductId, actualProductName, actualProductLimitation, actualProductDailyLimitation, actualProductRemark, actualProductState;

		productManagementPage.enterProductIDToSearch(productID);
		productManagementPage.clickSearchButton();
		actualProductId = productManagementPage.getProductInfoFromSearchReult(productID,0);
		verifyEquals(actualProductId, productID);

		actualProductName = productManagementPage.getProductInfoFromSearchReult(productID,1);
		verifyEquals(actualProductName, productName);
		
		actualProductLimitation = productManagementPage.getProductInfoFromSearchReult(productID,3);
		verifyEquals(actualProductLimitation, "1,000,000,000.0");

		actualProductDailyLimitation = productManagementPage.getProductInfoFromSearchReult(productID,4);
		verifyEquals(actualProductDailyLimitation, "50,000,000.0");

		actualProductRemark = productManagementPage.getProductInfoFromSearchReult(productID,5);
		verifyEquals(actualProductRemark, remark);
		
		actualProductState = productManagementPage.getProductInfoFromSearchReult(productID,6);
		verifyEquals(actualProductState, "Có");
		
		// Clear IdentificationId value from the text box
		productManagementPage.enterProductIDToSearch("");
		productManagementPage.clickSearchButton();
		homePage = productManagementPage.returnToHomePage();
	}

	@Test
	public void TC_03_SearchProductByProductName() {
		
	}

	@Test
	public void TC_04_SearchCustomerByPhoneNumber() {

	}

	@Test
	public void TC_05_UpdateCustomerInfo()	 {

	}

	@AfterClass
	public void afterClass() {
		homePage.Logout();
		closeBrowserAndDriver(driver);
	}
}
