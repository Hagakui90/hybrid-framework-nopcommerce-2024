package commons;

public class Order {

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getSkuOfProduct() {
		return skuOfProduct;
	}

	public void setSkuOfProduct(String skuOfProduct) {
		this.skuOfProduct = skuOfProduct;
	}

	public String getTitleOfProduct() {
		return titleOfProduct;
	}

	public void setTitleOfProduct(String titleOfProduct) {
		this.titleOfProduct = titleOfProduct;
	}

	public String getStatusOfOrder() {
		return statusOfOrder;
	}

	public void setStatusOfOrder(String statusOfOrder) {
		this.statusOfOrder = statusOfOrder;
	}

	public String getTotalOfOrder() {
		return totalOfOrder;
	}

	public void setTotalOfOrder(String totalOfOrder) {
		this.totalOfOrder = totalOfOrder;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getQuantityOfOrder() {
		return quantityOfOrder;
	}

	public void setQuantityOfOrder(String quantityOfOrder) {
		this.quantityOfOrder = quantityOfOrder;
	}

	public String getGiftWrapping() {
		return giftWrapping;
	}

	public void setGiftWrapping(String giftWrapping) {
		this.giftWrapping = giftWrapping;
	}

	public String getSubTotalOfOrder() {
		return subTotalOfOrder;
	}

	public void setSubTotalOfOrder(String subTotalOfOrder) {
		this.subTotalOfOrder = subTotalOfOrder;
	}

	public String getTotalShippingMethod() {
		return totalShippingMethod;
	}

	public void setTotalShippingMethod(String totalShippingMethod) {
		this.totalShippingMethod = totalShippingMethod;
	}

	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public String getTotalItemPrice() {
		return totalItemPrice;
	}

	public void setTotalItemPrice(String totalItemPrice) {
		this.totalItemPrice = totalItemPrice;
	}

	public Order(String orderNumber, String orderDate, String skuOfProduct, String titleOfProduct, String statusOfOrder, String totalOfOrder, BillingAddress billingAddress, ShippingAddress shippingAddress, PaymentMethod paymentMethod,
			ShippingMethod shippingMethod, String unitPrice, String quantityOfOrder, String totalItemPrice, String giftWrapping, String subTotalOfOrder, String totalShippingMethod) {
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.skuOfProduct = skuOfProduct;
		this.titleOfProduct = titleOfProduct;
		this.statusOfOrder = statusOfOrder;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
		this.shippingMethod = shippingMethod;
		this.unitPrice = unitPrice;
		this.quantityOfOrder = quantityOfOrder;
		this.totalItemPrice = totalItemPrice;
		this.giftWrapping = giftWrapping;
		this.subTotalOfOrder = subTotalOfOrder;
		this.totalShippingMethod = totalShippingMethod;
		this.totalOfOrder = totalOfOrder;
	}

	public Order(String skuOfProduct, String titleOfProduct, String totalOfOrder, BillingAddress billingAddress, ShippingAddress shippingAddress, 
			PaymentMethod paymentMethod, ShippingMethod shippingMethod, String unitPrice, String quantityOfOrder, String totalItemPrice, 
			String giftWrapping, String subTotalOfOrder, String totalShippingMethod) {
		this.skuOfProduct = skuOfProduct;
		this.titleOfProduct = titleOfProduct;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
		this.shippingMethod = shippingMethod;
		this.unitPrice = unitPrice;
		this.quantityOfOrder = quantityOfOrder;
		this.totalItemPrice = totalItemPrice;
		this.giftWrapping = giftWrapping;
		this.subTotalOfOrder = subTotalOfOrder;
		this.totalShippingMethod = totalShippingMethod;
		this.totalOfOrder = totalOfOrder;
	}

	public Order(String skuOfProduct, String titleOfProduct, String unitPrice, String quantityOfOrder, String totalItemPrice, String giftWrapping) {
		this.skuOfProduct = skuOfProduct;
		this.titleOfProduct = titleOfProduct;
		this.unitPrice = unitPrice;
		this.quantityOfOrder = quantityOfOrder;
		this.totalItemPrice = totalItemPrice;
		this.giftWrapping = giftWrapping;
	}

	private String orderNumber;
	private String orderDate;
	private String skuOfProduct;
	private String titleOfProduct;
	private String statusOfOrder;
	private BillingAddress billingAddress;
	private ShippingAddress shippingAddress;
	private String unitPrice;
	private String quantityOfOrder;
	private String totalItemPrice;
	private String giftWrapping;
	private String subTotalOfOrder;
	private String totalShippingMethod;
	private ShippingMethod shippingMethod;
	private PaymentMethod paymentMethod;
	private String totalOfOrder;

}
