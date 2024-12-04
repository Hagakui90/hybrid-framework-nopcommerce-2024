package pageUIs.user;

public class CustomerSearchPageUI {
	public static final String SEARCH_TEXTBOX = "css=input.search-text";
	public static final String SEARCH_BUTTON = "css=button.search-button";
	public static final String WARNING_MESSAGE_TEXT = "CSS=div.warning";
	public static final String NO_RESULT_SEARCH_TEXT = "CSS=div.search-results div.no-result";
	public static final String LIST_SEARCH_RESULT_TEXT = "css=div.search-results div.product-item h2 a";
	public static final String SEARCH_CHECKBOX = "xpath=//label[contains(text(),'%s')]/preceding-sibling::input";
	public static final String ADVANCED_SEARCH_DROPDOWN = "xpath=//label[contains(text(),'%s')]/parent::div//select";
	public static final String ADD_TO_CART_BUTTON_BY_NAME = "XPATH=//a[contains(text(),'%s')]/parent::h2//following-sibling::div[@class='add-info']//button[text()='shoppingcart.addtocart']";
	public static final String NOTIFICATION_BAR = "CSS=p.content";
}
