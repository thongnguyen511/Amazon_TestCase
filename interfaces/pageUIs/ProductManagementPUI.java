package pageUIs;

public class ProductManagementPUI {
	public static final String PRODUCT_ID_TEXTBOX = "//input[@id='dnn_ctr1480_ProductInquiry_txtProductCode']";
	public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='dnn_ctr1480_ProductInquiry_txtProductName']";
	public static final String SEARCH_BUTTON = "//a[@id='dnn_ctr1480_ProductInquiry_btnSearch']";
	public static final String ADDNEW_BUTTON = "//a[@id='dnn_ctr1480_ProductInquiry_btnAdd']";
	
	//Product list
	public static final String EDIT_PRODUCT_ICON = "//td[text()='%s']/preceding-sibling::td/div/a";
	public static final String PRODUCT_ID_SEARCH_RESULT = "//td[text()='%s']";
	public static final String PRODUCT_INFO_SEARCH_RESULT = "//td[text()='%s']/following-sibling::td[%s]";
	

}
