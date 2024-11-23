package pageUIs.admin;

public class AdminDashboardSideBarPageUI {
	public static final String DYNAMIC_ADMIN_SIDEBAR_LINK_TEXT = "xpath=//nav[@class='mt-2']//i[@class='nav-icon fas fa-book']//following-sibling::p[contains(text(),'%s')]";
	public static final String DYNAMIC_SUBMENU_ADMIN_SIDEBAR_LINK_TEXT = "xpath=//p[contains(text(),'%s')]//ancestor::a//p[contains(text(),'%s')]";
}
