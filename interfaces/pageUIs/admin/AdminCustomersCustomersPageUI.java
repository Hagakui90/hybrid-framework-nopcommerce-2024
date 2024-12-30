package pageUIs.admin;

public class AdminCustomersCustomersPageUI {
	public static final String ADD_NEW_BUTTON = "XPATH=//a[contains(.,'addnew')]";
	public static final String CUSTOMER_ROLE_TEXTBOX = "css=select#SelectedCustomerRoleIds+span ul";
	public static final String CUSTOMER_ROLE_CUSTOM_DROPDOWN = "css=ul#select2-SelectedCustomerRoleIds-results";
	public static final String CUSTOMER_ROLE = "css=ul#select2-SelectedCustomerRoleIds-results>li";
	public static final String SEARCH_BUTTON = "css=button#search-customers";
	public static final String COLUMN_INDEX_BY_NAME = "XPATH=//th[contains(text(),'%s')]//preceding-sibling::th";
	public static final String VALUE_BY_COLUMN_INDEX = "XPATH=//tbody//tr[%s]//td[%s]";
	public static final String LIST_CUSTOMER_RESULT = "CSS=tbody tr";
	public static final String ACTIVE_PAGE_LINK = "xpath=//li[contains(@class,'active')]/a";
	public static final String NEXT_PAGE_LINK_TEXT = "XPATH=//li[contains(@class,'paginate_button page-item next')]";
	public static final String INFO_SEARCH_TEXTBOX = "css=input#%s";
	public static final String ALERT_SUCCESS_MESSAGE = "CSS=div.alert-success";
}
