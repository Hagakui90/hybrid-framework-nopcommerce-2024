package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.Order;
import pageUIs.user.CustomerOrderDetailPageUI;

public class CustomerOrderDetailsPageObject extends BasePage{
	WebDriver driver;

	public CustomerOrderDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitleText() {
		waitForElementVisible(driver, CustomerOrderDetailPageUI.PAGE_TITLE_TEXT);
		return getElementText(driver, CustomerOrderDetailPageUI.PAGE_TITLE_TEXT);
	}

	public String getOrderNumber() {
		waitForElementVisible(driver, CustomerOrderDetailPageUI.ORDER_NUMBER_TEXT);
		return getElementText(driver, CustomerOrderDetailPageUI.ORDER_NUMBER_TEXT);
	}
	
	public String getOrderOverviewTextByName(String nameOfOverview) {
		waitForElementVisible(driver, CustomerOrderDetailPageUI.ORDER_OVERVIEW_TEXT_BY_NAME, nameOfOverview);
		return getElementText(driver, CustomerOrderDetailPageUI.ORDER_OVERVIEW_TEXT_BY_NAME, nameOfOverview);
	}
	
	public String getTotalOrderOverview() {
		waitForElementVisible(driver, CustomerOrderDetailPageUI.TOTAL_ORDER_OVERVIEW_TEXT);
		return getElementText(driver, CustomerOrderDetailPageUI.TOTAL_ORDER_OVERVIEW_TEXT);
	}
	
	public String getInfoByName(String nameInfo, String nameSubInfo) {
		waitForElementVisible(driver, CustomerOrderDetailPageUI.INFO_BY_NAME, nameInfo, nameSubInfo);
		return getElementText(driver, CustomerOrderDetailPageUI.INFO_BY_NAME, nameInfo, nameSubInfo);
	}
	
	public String getGiftWrappingOption() {
		waitForElementVisible(driver, CustomerOrderDetailPageUI.GIFT_WRAPPING_OPTION_TEXT);
		return getElementText(driver, CustomerOrderDetailPageUI.GIFT_WRAPPING_OPTION_TEXT);
	}
	
	public String getOrderTotalItemByName(String nameItem) {
		waitForElementVisible(driver, CustomerOrderDetailPageUI.ORDER_TOTAL_ITEM_TEXT_BY_NAME, nameItem);
		return getElementText(driver, CustomerOrderDetailPageUI.ORDER_TOTAL_ITEM_TEXT_BY_NAME, nameItem);
	}
	
	public String getTotalOfOrder() {
		waitForElementVisible(driver, CustomerOrderDetailPageUI.ORDER_TOTAL_TEXT);
		return getElementText(driver, CustomerOrderDetailPageUI.ORDER_TOTAL_TEXT);
	}
	
	public boolean verifyOrderInfoAddress(String nameInfo, Order completedOrder) {
		boolean verifyNameAddress, verifyEmailAddress, verifyPhoneAddress, verifyCountryAddress, verifyProvinceAddress, verifyAddress1, verifyZippostalcodeAddress;
		if (nameInfo.contains("billing")) {
			verifyNameAddress = getInfoByName(nameInfo, "name").contains(completedOrder.getBillingAddress().getName());
			verifyEmailAddress = getInfoByName(nameInfo, "email").contains(completedOrder.getBillingAddress().getEmail());
			verifyPhoneAddress = getInfoByName(nameInfo, "phone").contains(completedOrder.getBillingAddress().getPhoneNumber());
			verifyCountryAddress = getInfoByName(nameInfo, "country").contains(completedOrder.getBillingAddress().getCountry());
			verifyProvinceAddress = getInfoByName(nameInfo, "stateprovince").contains(completedOrder.getBillingAddress().getProvince());
			verifyAddress1 = getInfoByName(nameInfo, "address1").contains(completedOrder.getBillingAddress().getAddress1());
			verifyZippostalcodeAddress = getInfoByName(nameInfo, "zippostalcode").contains(completedOrder.getBillingAddress().getZipPostalCode());
			System.out.println(getInfoByName(nameInfo, "name") + "\t" + completedOrder.getBillingAddress().getName());
		}
		else {
			verifyNameAddress = getInfoByName(nameInfo, "name").contains(completedOrder.getShippingAddress().getName());
			verifyEmailAddress = getInfoByName(nameInfo, "email").contains(completedOrder.getBillingAddress().getEmail());
			verifyPhoneAddress = getInfoByName(nameInfo, "phone").contains(completedOrder.getBillingAddress().getPhoneNumber());
			verifyCountryAddress = getInfoByName(nameInfo, "country").contains(completedOrder.getBillingAddress().getCountry());
			verifyProvinceAddress = getInfoByName(nameInfo, "stateprovince").contains(completedOrder.getBillingAddress().getProvince());
			verifyAddress1 = getInfoByName(nameInfo, "address1").contains(completedOrder.getBillingAddress().getAddress1());
			verifyZippostalcodeAddress = getInfoByName(nameInfo, "zippostalcode").contains(completedOrder.getBillingAddress().getZipPostalCode());
		}
		
		if (verifyNameAddress && verifyEmailAddress && verifyPhoneAddress && verifyCountryAddress && verifyProvinceAddress && verifyAddress1 && verifyZippostalcodeAddress) {
			return true;
		}
		return false;
	}
	
	public boolean verifyInfoMethod(String nameMethod, Order completedOrder) {
		boolean verifyTypeOfMethod, verifyStatusOfMethod;
		if (nameMethod.contains("payment")) {
			System.out.println("Verify payment method");
			waitForElementVisible(driver, CustomerOrderDetailPageUI.METHOD_BY_NAME, "payment-method");
			verifyTypeOfMethod = getElementText(driver, CustomerOrderDetailPageUI.METHOD_BY_NAME, "payment-method").contains(completedOrder.getPaymentMethod().getPaymentMethodType());
			verifyStatusOfMethod = !getElementText(driver, CustomerOrderDetailPageUI.METHOD_BY_NAME, "payment-method-status").isBlank();
			System.out.println(verifyTypeOfMethod + "\t" + verifyStatusOfMethod);
		}else {
			System.out.println("Verify shipping method");
			waitForElementVisible(driver, CustomerOrderDetailPageUI.METHOD_BY_NAME, "shipping-method");
			verifyTypeOfMethod = getElementText(driver, CustomerOrderDetailPageUI.METHOD_BY_NAME, "shipping-method").contains(completedOrder.getShippingMethod().getShippingMethodType());
			verifyStatusOfMethod = !getElementText(driver, CustomerOrderDetailPageUI.METHOD_BY_NAME, "shipping-status").isBlank();
			System.out.println(verifyTypeOfMethod + "\t" + verifyStatusOfMethod);
		}
		if (verifyTypeOfMethod && verifyStatusOfMethod) {
			return true;
		}
		return false;
	}
	
	public boolean verifyOrderProduct(Order completedOrder) {
		waitForElementVisible(driver, CustomerOrderDetailPageUI.PRODUCT_INFO_TEXT);
		boolean verifySku, verifyNameProduct, verifyUnitPrice, verifyQuantityProduct, verifyTotalItemPrice;
		verifySku = getElementText(driver, CustomerOrderDetailPageUI.PRODUCT_INFO_ITEM_TEXT_BY_NAME, "sku").equals(completedOrder.getSkuOfProduct());
		verifyNameProduct = getElementText(driver, CustomerOrderDetailPageUI.NAME_OF_PRODUCT_INFO_TEXT).equals(completedOrder.getTitleOfProduct());
		verifyUnitPrice = getElementText(driver, CustomerOrderDetailPageUI.PRODUCT_INFO_ITEM_TEXT_BY_NAME, "unit-price").equals(completedOrder.getUnitPrice());
		verifyQuantityProduct = getElementText(driver, CustomerOrderDetailPageUI.PRODUCT_INFO_ITEM_TEXT_BY_NAME, "quantity").equals(completedOrder.getQuantityOfOrder());
		verifyTotalItemPrice = getElementText(driver, CustomerOrderDetailPageUI.PRODUCT_INFO_ITEM_TEXT_BY_NAME, "total").equals(completedOrder.getTotalItemPrice());
		//System.out.println(getElementText(driver, CustomerOrderDetailPageUI.PRODUCT_INFO_ITEM_TEXT_BY_NAME, "total") + "\t" + completedOrder.getTotalItemPrice());
		System.out.println(verifySku);
		System.out.println(verifyNameProduct);
		System.out.println(verifyQuantityProduct);
		System.out.println(completedOrder.getQuantityOfOrder());
		System.out.println(getElementText(driver, CustomerOrderDetailPageUI.PRODUCT_INFO_ITEM_TEXT_BY_NAME, "quantity"));
		System.out.println(verifyTotalItemPrice);
		if (verifySku && verifyNameProduct && verifyUnitPrice && verifyQuantityProduct && verifyTotalItemPrice) {
			
			return true;
		}
		return false;
	}
	
	public boolean verifyTotalOrder(Order completedOrder) {
		boolean verifyOrderSubTotal = getOrderTotalItemByName("subtotal").equals(completedOrder.getSubTotalOfOrder());
		boolean verifyOrderShippingTotal = getOrderTotalItemByName("shipping").equals(completedOrder.getTotalShippingMethod());
		boolean verifyTotalOfOrder = getTotalOfOrder().equals(completedOrder.getTotalOfOrder());
		if (verifyOrderSubTotal && verifyOrderShippingTotal && verifyTotalOfOrder) {
			return true;
		}
		return false;
	}
	
	public boolean verifyOrderDetail(Order completedOrder) {
		boolean verifyOrderNumber = getOrderNumber().contains(completedOrder.getOrderNumber());
		boolean verifyOrderDate = getOrderOverviewTextByName("order-date").contains(completedOrder.getOrderDate());
		boolean verifyOrderStatus = getOrderOverviewTextByName("order-status").contains(completedOrder.getStatusOfOrder());
		boolean verifyOrderTotalOverview = getTotalOrderOverview().contains(completedOrder.getTotalOfOrder());
		
		boolean verifyOrderBillingAddress = verifyOrderInfoAddress("billing", completedOrder);
		boolean verifyOrderShippingAddress = verifyOrderInfoAddress("shipping", completedOrder);
		boolean verifyOrderPaymentMethod = verifyInfoMethod("payment", completedOrder);
		boolean verifyOrderShippingMethod = verifyInfoMethod("shipping", completedOrder);
		boolean verifyOrderProduct = verifyOrderProduct(completedOrder);
		boolean verifyGiftWrappingOption = getGiftWrappingOption().contains(completedOrder.getGiftWrapping());
		boolean verifyTotalOrder = verifyTotalOrder(completedOrder);
		
		if (verifyOrderNumber && verifyOrderDate && verifyOrderStatus && verifyOrderTotalOverview
				&& verifyOrderBillingAddress && verifyOrderShippingAddress && verifyOrderPaymentMethod && verifyOrderShippingMethod
				&& verifyOrderProduct && verifyGiftWrappingOption && verifyTotalOrder) {
			return true;
		}
		return false;
	}
	
}
