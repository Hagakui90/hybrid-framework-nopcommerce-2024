package pageUIs.admin;

public class AdminCatalogProductsPageUI {
	public static final String SEARCH_INFO_TEXTBOX_BY_NAME = "css=input#%s";
	public static final String SEARCH_CATEGORY_DROPDOWN = "css=select#SearchCategoryId";
	public static final String SEARCH_BUTTON = "CSS=button#search-products";
	public static final String ALL_PAGES_LINK = "XPATH=//li[contains(@class,'paginate_button')]//a[not(contains(text(),'admin.dt.paginate'))]";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "XPATH=//div[text()='%s']/parent::th//preceding-sibling::th";
	public static final String ALL_VALUES_BY_COLUMN_INDEX = "XPATH=//tr/td[%s]";
	public static final String EDIT_BUTTON_BY_NO_NAME = "XPATH=//tr[%s]/td[%s]";
	public static final String NEXT_PAGE_LINK_TEXT = "XPATH=//li[contains(@class,'paginate_button page-item next')]";
	public static final String ACTIVE_PAGE_LINK = "xpath=//li[contains(@class,'active')]/a";
	public static final String LIST_PRODUCT_SEARCH = "CSS=tbody>tr";
	public static final String VALUE_BY_ROW_INDEX_COLUMN_INDEX = "XPATH=//tbody//tr[%s]//td[%s]";
	public static final String PUBLISH_ICON_BY_ROW_INDEX_COLUMN_INDEX = "XPATH=//tbody//tr[%s]//td[%s]/i";
	public static final String EMPTY_TABLE_TEXT = "CSS=tbody>tr>td";
	public static final String SUB_CATEGORIES_CHECKBOX = "CSS=input.check-box";
}
