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
		String actualProductId, actualProductName, actualProductLimitation, actualProductDailyLimitation,
				actualProductRemark, actualProductState;

		log.info("TC_02_SearchProductByProductID - Step 1: Nhập mã sản phẩm cần tìm");
		productManagementPage.enterProductIDToSearch(productID);

		log.info("TC_02_SearchProductByProductID - Step 2: Nhấn button Tìm kiếm");
		productManagementPage.clickSearchButton();

		log.info("TC_02_SearchProductByProductID - Step 3: Kiểm tra product code trả về");
		actualProductId = productManagementPage.getProductInfoByProductIDFromSearchResult(productID, 0);
		verifyEquals(actualProductId, productID);

		log.info("TC_02_SearchProductByProductID - Step 4: Kiểm tra product name trả về");
		actualProductName = productManagementPage.getProductInfoByProductIDFromSearchResult(productID, 1);
		verifyEquals(actualProductName, productName);

		log.info("TC_02_SearchProductByProductID - Step 5: Kiểm tra hạn mức của sản phẩm");
		actualProductLimitation = productManagementPage.getProductInfoByProductIDFromSearchResult(productID, 3);
		verifyEquals(actualProductLimitation, "1,000,000,000.0");

		log.info("TC_02_SearchProductByProductID - Step 6: Kiểm tra hạn mức trong ngày của sản phẩm");
		actualProductDailyLimitation = productManagementPage.getProductInfoByProductIDFromSearchResult(productID, 4);
		verifyEquals(actualProductDailyLimitation, "50,000,000.0");

		log.info("TC_02_SearchProductByProductID - Step 7: Kiểm tra ghi chú của sản phẩm");
		actualProductRemark = productManagementPage.getProductInfoByProductIDFromSearchResult(productID, 5);
		verifyEquals(actualProductRemark, remark);

		log.info("TC_02_SearchProductByProductID - Step 8: Kiểm tra trạng thái của sản phẩm");
		actualProductState = productManagementPage.getProductInfoByProductIDFromSearchResult(productID, 6);
		verifyEquals(actualProductState, "Có");

		// Clear product id value from the text box
		log.info("TC_02_SearchProductByProductID - Step 9: Xoá giá trị product id khỏi ô Mã sản phẩm");
		productManagementPage.enterProductIDToSearch("");
		log.info("TC_02_SearchProductByProductID - Step 10: Nhất nút tìm kiếm");
		productManagementPage.clickSearchButton();

	}

	@Test
	public void TC_03_SearchProductByProductName() {
		String actualProductId, actualProductLimitation, actualProductDailyLimitation, actualProductRemark,
				actualProductState;

		log.info("TC_03_SearchProductByProductName - Step 1: Nhập tên sản phẩm cần tìm");
		productManagementPage.enterProductNameToSearch(productName);

		log.info("TC_03_SearchProductByProductName - Step 2: Nhấn button Tìm kiếm");
		productManagementPage.clickSearchButton();

		log.info("TC_03_SearchProductByProductName - Step 3: Kiểm tra product code trả về");
		actualProductId = productManagementPage.getProductIDByProductNameFromSearchResult(productName);
		verifyEquals(actualProductId, productID);

		log.info("TC_03_SearchProductByProductName - Step 4: Kiểm tra hạn mức của sản phẩm");
		actualProductLimitation = productManagementPage.getProductInfoByProductIDFromSearchResult(actualProductId, 3);
		verifyEquals(actualProductLimitation, "1,000,000,000.0");

		log.info("TC_03_SearchProductByProductName - Step 5: Kiểm tra hạn mức trong ngày của sản phẩm");
		actualProductDailyLimitation = productManagementPage.getProductInfoByProductIDFromSearchResult(actualProductId,
				4);
		verifyEquals(actualProductDailyLimitation, "50,000,000.0");

		log.info("TC_03_SearchProductByProductName - Step 6: Kiểm tra ghi chú của sản phẩm");
		actualProductRemark = productManagementPage.getProductInfoByProductIDFromSearchResult(actualProductId, 5);
		verifyEquals(actualProductRemark, remark);

		log.info("TC_03_SearchProductByProductName - Step 7: Kiểm tra trạng thái của sản phẩm");
		actualProductState = productManagementPage.getProductInfoByProductIDFromSearchResult(actualProductId, 6);
		verifyEquals(actualProductState, "Có");

		// Clear product id value from the text box
		log.info("TC_03_SearchProductByProductName - Step 8: Xoá giá trị product name khỏi ô Tên sản phẩm");
		productManagementPage.enterProductNameToSearch("");
		log.info("TC_03_SearchProductByProductName - Step 9: Nhất nút tìm kiếm");
	}

	@Test
	public void TC_04_EditProductByProductID() {
		String messageAfterUpdate;
		String actualProductId, actualProductName, actualProductLimitation, actualProductDailyLimitation,
		actualProductRemark, actualProductState;
		
		productName = productName + " Edit";
		productLimitation = "2000000000";
		productDailyLimitation = "500000000";
		remark = remark + " Edit";
		
		log.info("TC_04_EditProductByProductID - Step 1: Nhập mã sản phẩm muốn chỉnh sửa");
		productManagementPage.enterProductIDToSearch(productID);

		log.info("TC_04_EditProductByProductID - Step 2: Nhấn button Tìm kiếm");
		productManagementPage.clickSearchButton();
		
		log.info("TC_04_EditProductByProductID - Step 3: Nhấn button Edit product of the productID");
		productInfoPage = productManagementPage.clickEditProduct(productID);
		
		log.info("TC_04_EditProductByProductID - Step 4: Nhập tên sản phẩm mới");
		productInfoPage.clearProductName();
		productInfoPage.enterProductName(productName);

		log.info("TC_04_EditProductByProductID - Step 5: Nhập hạn mức sản phẩm mới");
		productInfoPage.clearProductLimitation();
		productInfoPage.enterProductLimitation(productLimitation);
		
		log.info("TC_04_EditProductByProductID - Step 6: Nhập hạn mức trong ngày mới");
		productInfoPage.clearProductDailyLimitation();
		productInfoPage.enterProductDailyLimitation(productDailyLimitation);
		
		log.info("TC_04_EditProductByProductID - Step 7: Nhập ghi chú mới");
		productInfoPage.clearRemark();
		productInfoPage.enterRemark(remark);
		
		log.info("TC_04_EditProductByProductID - Step 8: Nhấn nút cập nhật");
		productInfoPage.clickUpdateButton();

		log.info("TC_04_EditProductByProductID - Step 9: Kiểm tra thông báo cập nhật thành công hiển thị");
		messageAfterUpdate = productInfoPage.getMessageAfterUpdate();
		verifyEquals(messageAfterUpdate, "Cập nhật thành công.");

		log.info("TC_04_EditProductByProductID - Step 10: Quay về trang Quản lý sản phẩm");
		productManagementPage = productInfoPage.returnToProductManagementPage();
		
		log.info("TC_04_EditProductByProductID - Step 11: Nhập mã sản phẩm cần tìm");
		productManagementPage.enterProductIDToSearch(productID);

		log.info("TC_04_EditProductByProductID - Step 12: Nhấn button Tìm kiếm");
		productManagementPage.clickSearchButton();

		log.info("TC_04_EditProductByProductID - Step 13: Kiểm tra product code trả về");
		actualProductId = productManagementPage.getProductInfoByProductIDFromSearchResult(productID, 0);
		verifyEquals(actualProductId, productID);

		log.info("TC_04_EditProductByProductID - Step 14: Kiểm tra product name trả về");
		actualProductName = productManagementPage.getProductInfoByProductIDFromSearchResult(productID, 1);
		verifyEquals(actualProductName, productName);

		log.info("TC_04_EditProductByProductID - Step 15: Kiểm tra hạn mức của sản phẩm");
		actualProductLimitation = productManagementPage.getProductInfoByProductIDFromSearchResult(productID, 3);
		verifyEquals(actualProductLimitation, "2,000,000,000.0");

		log.info("TC_04_EditProductByProductID - Step 16: Kiểm tra hạn mức trong ngày của sản phẩm");
		actualProductDailyLimitation = productManagementPage.getProductInfoByProductIDFromSearchResult(productID, 4);
		verifyEquals(actualProductDailyLimitation, "500,000,000.0");

		log.info("TC_04_EditProductByProductID - Step 17: Kiểm tra ghi chú của sản phẩm");
		actualProductRemark = productManagementPage.getProductInfoByProductIDFromSearchResult(productID, 5);
		verifyEquals(actualProductRemark, remark);

		log.info("TC_04_EditProductByProductID - Step 18: Kiểm tra trạng thái của sản phẩm");
		actualProductState = productManagementPage.getProductInfoByProductIDFromSearchResult(productID, 6);
		verifyEquals(actualProductState, "Có");
		
		
	}
	

	@Test
	public void TC_05_DeleteProduct() {
		String deleteSuccessfulMessage;
		
		log.info("TC_05_DeleteProduct - Step 1: Nhấn icon delete sản phẩm");
		productManagementPage.clickDeleteProduct(productID);
		log.info("TC_05_DeleteProduct - Step 2: Nhấn button Huỷ");
		productManagementPage.cancelToDeleteProduct();
		log.info("TC_05_DeleteProduct - Step 3: Nhấn icon delete sản phẩm");
		productManagementPage.clickDeleteProduct(productID);
		log.info("TC_05_DeleteProduct - Step 4: Nhấn button Đồng ý");
		productManagementPage.acceptToDeleteProduct();
		log.info("TC_05_DeleteProduct - Step 5: Kiểm tra câu thông báo sau khi đồng ý delete");
		deleteSuccessfulMessage = productManagementPage.getMessageAfterDelete();
		verifyEquals(deleteSuccessfulMessage, "Xóa thành công.");
		
		log.info("TC_05_DeleteProduct - Step 6: Quay về home page");
		homePage = productManagementPage.returnToHomePage();
	}

	@AfterClass
	public void afterClass() {
		homePage.Logout();
		closeBrowserAndDriver(driver);
	}
}
