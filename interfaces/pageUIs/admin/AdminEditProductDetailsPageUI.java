package pageUIs.admin;

public class AdminEditProductDetailsPageUI {
	public static final String CARD_COLLAPSE_BUTTON = "//div[contains(text(),'%s')]//following-sibling::div//i";
	public static final String ALL_PAGES_LINK_EACH_CARD = "XPATH=//p[contains(text(),'%s')]/parent::div//li/a[not(contains(text(),'admin.dt.paginate'))]";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "XPATH=//p[contains(text(),'%s')]/parent::div//th[contains(text(),'%s')]//preceding-sibling::th";
	public static final String ALL_VALUES_COLUMN_INDEX = "XPATH=//p[contains(text(),'%s')]/parent::div//tr/td[%s]";
	public static final String NEXT_BUTTON_EACH_CARD_BY_NUMBER_PAGE = "XPATH=//p[contains(text(),'%s')]/parent::div//a[text()='%s']//parent::li/following-sibling::li/a";
	public static final String ACTIVE_PAGE_LINK_EACH_CARD = "XPATH=//p[contains(text(),'%s')]/parent::div//li[contains(@class,'active')]/a";
}
