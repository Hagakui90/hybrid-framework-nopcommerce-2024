package pageUIs.user;

public class CustomerPageUI {
	public final static String GENDER_RADIOBUTTON = "xpath=//div[@class='gender']//input[contains(@id,'%s')]";
	public final static String INFO_TEXTBOX = "Xpath=//label[contains(text(),'%s')]/following-sibling::input";
	public final static String SAVE_BUTTON = "CSS=button#save-info-button";
	public final static String UPDATED_NOTIFICATION_BAR = "CSS=div.bar-notification";
	
	public final static String LOGOUT_LINK = "Xpath=//a[@class='ico-logout']";
}
