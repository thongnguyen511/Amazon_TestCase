package pageUIs;

public class ProductManagementPUI {
	public static final String PRODUCT_ID_TEXTBOX = "//input[@id='dnn_ctr1480_ProductInquiry_txtProductCode']";
	public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='dnn_ctr1480_ProductInquiry_txtProductName']";
	public static final String SEARCH_BUTTON = "//a[@id='dnn_ctr1480_ProductInquiry_btnSearch']";
	public static final String ADDNEW_BUTTON = "//a[@id='dnn_ctr1480_ProductInquiry_btnAdd']";
	
	//Product list
	public static final String EDIT_PRODUCT_ICON = "//td[text()='%s']/preceding-sibling::td[2]/div/a";
	public static final String DELETE_PRODUCT_ICON = "//td[text()='%s']/preceding-sibling::td[1]/div/a";
	public static final String DELETE_ACCEPT_BUTTON = "//button[@class = 'btn btn-primary ui-button ui-corner-all ui-widget']";
	public static final String DELETE_CANCEL_BUTTON = "//button[@class = 'btn btn-default ui-button ui-corner-all ui-widget dnnConfirmCancel']";
	public static final String DELETE_SUCCESSFUL_MESSAGE = "//span[@id='dnn_ctr1480_ProductInquiry_ctl02_lblMessage']";

	public static final String PRODUCT_ID_FROM_SEARCH_RESULT = "//td[text()='%s']";
	public static final String PRODUCT_INFO_SEARCH_BY_PRODUCT_ID = "//td[text()='%s']/following-sibling::td[%s]";
	public static final String PRODUCT_NAME_FROM_SEARCH_RESULT = "//td[text()='%s']";
	public static final String PRODUCT_ID_SEARCH_BY_PRODUCT_NAME = "//td[text()='%s']/preceding-sibling::td[1]";
	

}
