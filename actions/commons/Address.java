package commons;

public class Address {
	public Address(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Address(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
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
	
	public String getAddress(String typeOfAddress) {
		if (typeOfAddress.contains("billing")) {
			return this.billingAddress.getFirstName() + this.billingAddress.getLastName();
		}else
			return this.shippingAddress.getFirstName() + this.shippingAddress.getLastName();
		
	}
	
	private BillingAddress billingAddress;
	private ShippingAddress shippingAddress;
	
}
