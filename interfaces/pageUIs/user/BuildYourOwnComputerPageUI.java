package pageUIs.user;

public class BuildYourOwnComputerPageUI {
	public static final String PROCESSOR_DROPDOWN = "xpath=//label[contains(text(),'Processor')]/parent::dt//following-sibling::dd/select[contains(@id,'1')]";
	public static final String RAM_DROPDOWN = "xpath=//label[contains(text(),'RAM')]/parent::dt//following-sibling::dd/select[contains(@id,'2')]";
	public static final String CHECKBOX = "xpath=//label[contains(text(),'%s')]/parent::dt//following-sibling::dd[contains(@id,'%s')]//li[@data-attr-value='%s']/input";
	public static final String ADD_TO_CART_BUTTON = "xpath=//button[text()='shoppingcart.addtocart']";
	public static final String NOTIFICATION_BAR = "CSS=p.content";
	
}
