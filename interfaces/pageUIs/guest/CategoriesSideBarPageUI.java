package pageUIs.guest;

public class CategoriesSideBarPageUI {
	public static final String DYNAMIC_SUBMENU_SIDEBAR_LINK_TEXT = "XPATH=//div[@id='main']//a[contains(text(),'%s')]/following-sibling::ul//a[contains(text(),'%s')]";
	public static final String DYNAMIC_CATEGORY_SIDEBAR_LINK_TEXT = "XPATH=//div[@id='main']//a[contains(text(),'%s')]";
	public static final String PAGE_TITLE_TEXT = "css=div.page-title"; 
	public static final String SORT_DROPDOWN = "css=select#products-orderby";
	public static final String PRODUCT_TITLE_LIST_TEXT = "XPATH=//div[@class='products-container']//h2";
	public static final String PRODUCT_PRICE_LIST_TEXT = "XPATH=//div[@class='products-container']//span";
}
