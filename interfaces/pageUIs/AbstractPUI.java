package pageUIs;

public class AbstractPUI {
	public static final String LOGO_TO_HOMEPAGE = "//a[@class='c-logo']";
	public static final String TOPMENU_DICHVU_LINK = "//li//a[contains(text(),'Dịch vụ')]";
	public static final String TOPMENU_DICHVU_QLKH_LINK = "//a[contains(text(),'Quản lý khách hàng')]";
	public static final String TOPMENU_DICHVU_QLSP_LINK = "//a[contains(text(),'Quản lý sản phẩm')]";
	
	public static final String TOPMENU_QUANTRI_LINK = "//li//a[contains(text(),'Quản trị')]/span/parent::a";
	public static final String TOPMENU_QUANTRI_QTND_LINK = "//a[contains(text(),'Quản trị người dùng')]";
	
	public static final String TOPMENU_PROFILE_ICON = "//li//a/i[@class='fa fa-user']";
	public static final String TOPMENU_LOGOUT_LINK = "//a[@id='GlobalSignOutLink']";
	public static final String LOGOUT_ACCEPT_BUTTON = "//div[@class='ui-dialog-buttonset']/button[@class='btn btn-primary ui-button ui-corner-all ui-widget']";
	public static final String LOGOUT_CANCEL_BUTTON = "//div[@class='ui-dialog-buttonset']/button[@class='btn btn-default ui-button ui-corner-all ui-widget dnnConfirmCancel']";
	
	public static final String LOADING_ICON_UNDISP = "//div[@class='dnnPanelLoading' and @style='display: none;']";
}
