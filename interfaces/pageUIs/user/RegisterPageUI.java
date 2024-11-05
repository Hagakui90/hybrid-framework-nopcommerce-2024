package pageUIs.user;

public class RegisterPageUI {
	public static final String FIRSTNAME_TEXTBOX ="css=input#FirstName";
	public static final String LASTNAME_TEXTBOX ="css=input#LastName";
	public static final String EMAIL_TEXTBOX ="css=input#Email";
	public static final String PASSWORD_TEXTBOX ="css=input#Password";
	public static final String CONFIRM_PASSWORD_TEXTBOX ="xpath=//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON ="XPATH=//button[@id='register-button']";
	
	public static final String FRISTNAME_ERROR_MSG ="xpath=//span[@id='FirstName-error']";
	public static final String LASTNAME_ERROR_MSG ="xpath=//span[@id= 'LastName-error']";
	public static final String EMAIL_ERROR_MSG ="Xpath=//span[@id='Email-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MSG ="XPATH=//span[@id='ConfirmPassword-error']";
	public static final String PASSWORD_ERROR_MSG ="Xpath=//span[@id='Email-error']";
	
	public static final String REGISTRATION_COMPLETED_MSG ="css=div.result";
	public static final String EXISTING_EMAIL_ERROR_MSG ="xpath=//div[@class='message-error validation-summary-errors']";
	public static final String INVALID_PASSWORD_ERROR_MSG ="xpath=//span[@data-valmsg-for='Password']";
	
	public final static String MY_ACCOUNT_LINK = "css=a.ico-account";
	public final static String NOPCOMMERCE_LOGO = "css=div.header-logo";
}
