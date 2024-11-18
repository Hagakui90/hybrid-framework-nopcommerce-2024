package pageUIs.admin;

public class AdminCatalogProductsPageUI {
	public static final String SEARCH_CATEGORY_DROPDOWN = "css=select#SearchCategoryId";
	public static final String SEARCH_BUTTON = "CSS=button#search-products";
	public static final String ALL_PAGES_LINK = "XPATH=//li[contains(@class,'paginate_button')]//a[not(contains(text(),'admin.dt.paginate'))]";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "XPATH=//div[text()='%s']/parent::th//preceding-sibling::th";
	public static final String ALL_VALUES_COLUMN_INDEX = "XPATH=//tr/td[%s]";
}
