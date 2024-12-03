package pageUIs.user;

public class HomePageUI {
	public static final String REGISTER_LINK ="xpath=//a[@class='ico-register']";
	public static final String LOGIN_LINK ="xpath=//a[@class='ico-login']";
	public static final String MYACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String LIST_PRODUCT_NAME_ITEM = "xpath=//div[contains(@class,'home-page-product-grid')]//div[@class='item-box']//h2/a";
	public static final String PRODUCT_NAME_TEXT = "XPATH=//a[text()='%s']";
	public static final String PRODUCT_PRICE_TEXT_BY_NAME = "XPATH=//a[text()='%s']//ancestor::div[@class='details']//span[contains(@class,'actual-price')]";
	public static final String ADD_TO_COMPARE_LIST_BUTTON_BY_NAME = "XPATH=//a[text()='%s']//ancestor::div[@class='details']//button[@title='shoppingcart.addtocomparelist']";
	public static final String DYNAMIC_HOME_FOOTER_LINK_TEXT = "xpath=//div[contains(@class,'%s')]//a[text()='%s']";
	public static final String DYNAMIC_HOME_HEADER_MENU_LINK_TEXT = "XPATH=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String DYNAMIC_SUB_MENU_LINK_TEXT = "XPATH=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]//parent::li//a[contains(text(),'%s')]";
	public static final String DYNAMIC_MENU_LINK_TEXT = "XPATH=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String NOTIFICATION_BAR = "CSS=p.content";
	public static final String SHOPPING_CART_LINK_TEXT = "XPATH=//span[text()='shoppingcart']";
	
}
