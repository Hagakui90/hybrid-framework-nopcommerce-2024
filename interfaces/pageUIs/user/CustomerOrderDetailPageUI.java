package pageUIs.user;

public class CustomerOrderDetailPageUI {
	public static final String PAGE_TITLE_TEXT = "CSS=div.page-title h1";
	public static final String ORDER_NUMBER_TEXT = "CSS=div.order-number>strong";
	public static final String ORDER_OVERVIEW_TEXT_BY_NAME = "CSS=ul.order-overview-content>li.%s";
	public static final String TOTAL_ORDER_OVERVIEW_TEXT = "CSS=ul.order-overview-content>li.order-total>strong";
	public static final String BILLING_INFO_AREA = "css=div.billing-info-wrap";
	public static final String SHIPPING_INFO_AREA = "css=div.shipping-info-wrap";
	public static final String INFO_BY_NAME = "CSS=div.%s-info li.%s";
	public static final String METHOD_BY_NAME = "CSS=li.%s span.value";
	public static final String PRODUCT_INFO_TEXT = "CSS=table.data-table tbody tr";
	public static final String PRODUCT_INFO_ITEM_TEXT_BY_NAME = "CSS=table.data-table td.%s span";
	public static final String NAME_OF_PRODUCT_INFO_TEXT = "CSS=table.data-table td.product a";
	public static final String GIFT_WRAPPING_OPTION_TEXT = "xpath=//div[@class='section options']";
	public static final String ORDER_TOTAL_AREA = "CSS=table.cart-total";
	public static final String ORDER_TOTAL_ITEM_TEXT_BY_NAME = "xpath=//label[contains(text(),'%s')]//parent::td//following-sibling::td/span";
	public static final String ORDER_TOTAL_TEXT = "CSS=table.cart-total td.cart-total-right span strong";
}
