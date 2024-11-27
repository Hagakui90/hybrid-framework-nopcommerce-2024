package pageUIs.user;


public class WishlistPageUI {
	public static final String PRODUCT_NAME_IN_WISHLIST_TABLE = "xpath=//tr//a[text()=\"%s\"]";
	public static final String PRICE_PRODUCT_IN_WISHLIST_TABLE_BY_NAME = "xpath=//a[text()=\"%s\"]//ancestor::tr//span[@class='product-unit-price']";
	public static final String REMOVE_PRODUCT_IN_WISHLIST_TABLE_BY_NAME = "xpath=//a[text()=\"%s\"]//ancestor::tr//button[@class='remove-btn']";
	public static final String WISHLIST_LINKTEXT = "CSS=a.share-link";
	public static final String TITLE_SHARING_LINK = "CSS=div.page-title>h1";
	public static final String ADD_TO_CART_CHECKBOX = "XPATH=//a[text()=\"%s\"]//ancestor::tr//input[@name='addtocart']";
	public static final String ADD_TO_CART_BUTTON = "CSS=button.wishlist-add-to-cart-button";
	public static final String LOGO_LINK_TEXT = "css=div.header-logo";
	
	
}
