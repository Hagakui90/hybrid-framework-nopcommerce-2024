package pageUIs.guest;

public class CategoriesSideBarPageUI {
	public static final String DYNAMIC_SUBMENU_SIDEBAR_LINK_TEXT = "XPATH=//div[@id='main']//a[contains(text(),'%s')]/following-sibling::ul//a[contains(text(),'%s')]";
	public static final String DYNAMIC_CATEGORY_SIDEBAR_LINK_TEXT = "XPATH=//div[@id='main']//a[contains(text(),'%s')]";
	public static final String PAGE_TITLE_TEXT = "css=div.page-title"; 
	public static final String SORT_DROPDOWN = "css=select#products-orderby";
	public static final String PRODUCT_TITLE_LIST_TEXT = "XPATH=//div[@class='products-container']//h2";
	public static final String PRODUCT_PRICE_LIST_TEXT = "XPATH=//div[@class='products-container']//span";
	public static final String PAGE_SIZE_DROPDOWN = "CSS=select#products-pagesize";
	public static final String PRODUCT_LIST = "CSS=div.products-container div.item-box";
	public static final String PAGE_LINK_BY_NUMBER = "XPATH=//div[@class='pager']//span[text()='%s']";
	public static final String PAGE_LINK_CURRENT_BY_NUMBER = "xpath=//li[@class='current-page']/span[text()='%s']";
	public static final String NEXT_PAGE_BUTTON_BY_NAME = "xpath=//span[text()='%s']/parent::li//following-sibling::li[@class='next-page']";
	public static final String PAGE_LINK_CURRENT = "xpath=//li[@class='current-page']/span";
}
