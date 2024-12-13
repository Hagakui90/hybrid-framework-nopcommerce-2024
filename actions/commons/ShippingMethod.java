package commons;

public class ShippingMethod {
	public String getShippingMethodType() {
		return shippingMethodType;
	}
	public void setShippingMethodType(String shippingMethod) {
		this.shippingMethodType = shippingMethod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public ShippingMethod(String shippingMethod, String status) {
		this.shippingMethodType = shippingMethod;
		this.status = status;
	}
	
	public ShippingMethod(String shippingMethod) {
		this.shippingMethodType = shippingMethod;
	}
	
	public String toString() {
		return getShippingMethodType();
	}
	
	String shippingMethodType;
	String status;
}
