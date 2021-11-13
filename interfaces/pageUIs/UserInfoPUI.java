package pageUIs;

public class UserInfoPUI {
	// User Information
	public static final String USERNAME_TEXTBOX = "//input[@id='dnn_ctr392_UserDetail_txtUserName']";
	public static final String DISPLAYNAME_TEXTBOX = "//input[@id='dnn_ctr392_UserDetail_txtDisplayName']";
	public static final String GENDER_TEXTBOX = "//input[@id='dnn_ctr392_UserDetail_cboGender_Input']";
	public static final String GENDER_DROPDOWN_LIST = "//div[@id='dnn_ctr392_UserDetail_cboGender_DropDown']//ul/li";
	public static final String PHONENUMBER_TEXTBOX = "//input[@id='dnn_ctr392_UserDetail_txtMobile']";
	public static final String PHONEEXTENSION_TEXTBOX = "//input[@id='dnn_ctr392_UserDetail_txtPhoneExtension']";
	public static final String MARCHANT_TEXTBOX = "//input[@id='dnn_ctr392_UserDetail_ddlMerchant_Input']";
	public static final String MARCHANT_DROPDOWN_LIST = "//div[@id='dnn_ctr392_UserDetail_ddlMerchant_DropDown']//ul/li";
	public static final String REMARK_TEXTAREA = "//textarea[@id='dnn_ctr392_UserDetail_txtRemark']";
	public static final String ROLE_REMARK_TEXTAREA = "//textarea[@id='dnn_ctr392_UserDetail_txtRoleRemark']";
	public static final String SAVE_BUTTON = "//a[@id='dnn_ctr392_UserDetail_btnSaveProfile']";
	public static final String UPDATE_BUTTON = "//a[@id='dnn_ctr392_UserDetail_btnUpdateRole']";
	public static final String MESSAGE_AFTER_SAVE = "//span[contains(text(),'Thêm mới thành công.')]";
	public static final String MESSAGE_AFTER_UPDATE = "//span[@id='dnn_ctr392_UserDetail_ctl01_lblMessage']";

	public static final String ROLE_INFO_TAB = "//a[contains(text(),'Thông tin phân quyền')]";
	public static final String ROLE_GROUP_CHECKBOX = "//a[text()='%s']/parent::h2/following-sibling::fieldset//tr//th[text()='Hiện tại']/preceding-sibling::th//input";
	

}
