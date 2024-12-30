package pageUIs.admin;

public class AdminEditCustomerDetailsPageUI {
	public static final String ALERT_SUCCESS_MESSAGE = "CSS=div.alert-success";
	public static final String INFO_CUSTOMER_TEXTBOX_BY_NAME = "css=input#%s";
	public static final String SELECTED_GENDER_RADIO_BUTTON = "XPATH=//label[contains(text(),'gender')]/ancestor::div[@class='form-group row']//input[@checked='']";
	public static final String ACTIVE_CHECKBOX = "CSS=input#Active";
	public static final String ADMIN_COMMENT_TEXTAREA = "CSS=textarea#AdminComment";
	public static final String SELECTED_ROLE = "XPATH=//li[contains(@class,'choice')]";
	public static final String BACK_TO_LIST = "xpath=//a[contains(text(),'backtolist')]";
	public static final String SUBMIT_BUTTON_BY_NAME = "xpath=//button[@name='%s']";
	public static final String CARD_COLLAPSE_BUTTON = "xpath=//div[contains(text(),'%s')]//following-sibling::div//i";
	public static final String ADD_ADDRESS_BUTTON = "XPATH=//button[contains(text(),'addresses')]";
	public static final String COLUMN_INDEX_BY_NAME_AND_CARD_NAME = "xpath=//div[contains(text(),'%s')]/parent::div//following-sibling::div//th[contains(text(),'%s')]//preceding-sibling::th";
	public static final String VALUE_BY_COLUMN_INDEX_AND_CARD_NAME = "XPATH=//div[contains(text(),'%s')]/parent::div//following-sibling::div//tbody//tr[%s]//td[%s]";

}
