package pageUIs.user;

public class BuildYourOwnComputerPageUI {
	public static final String PROCESSOR_DROPDOWN = "xpath=//label[contains(text(),'Processor')]/parent::dt//following-sibling::dd/select[contains(@id,'1')]";
	public static final String RAM_DROPDOWN = "xpath=//label[contains(text(),'RAM')]/parent::dt//following-sibling::dd/select[contains(@id,'2')]";
	public static final String CHECKBOX = "xpath=//label[contains(text(),'%s')]/parent::dt//following-sibling::dd[contains(@id,'%s')]//li[@data-attr-value='%s']/input";
	public static final String ADD_TO_CART_BUTTON = "xpath=//button[text()='shoppingcart.addtocart']";
	public static final String NOTIFICATION_BAR = "CSS=p.content";
	public static final String SHOPPING_CART_LINKTEXT = "XPATH=//span[text()='shoppingcart']";
	public static final String QUANTITY_CART_TIP_TEXT = "XPATH=//span[text()='shoppingcart.headerquantity']";
	public static final String MINI_SHOPPING_CART_FORM = "css=div#flyout-cart";
	public static final String PRODUCT_NAME_IN_MINI_SHOPPING_CART = "css=div#flyout-cart div.product a";
	public static final String PRODUCT_ATTRIBUTES_IN_MINI_SHOPPING_CART = "css=div#flyout-cart div.product div.attributes";
	public static final String PRODUCT_SUBTOTAL_IN_MINI_SHOPPING_CART = "css=div#flyout-cart div.totals strong";
	public static final String QUANTITY_CART_TEXT_IN_MINI_SHOPPING_CART ="css=div.count";
	public static final String PRODUCT_PRICE = "CSS=div.product-price span";
	
}
