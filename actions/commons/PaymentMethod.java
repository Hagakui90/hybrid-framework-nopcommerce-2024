package commons;

public class PaymentMethod {
	public String getPaymentMethodType() {
		return paymentMethodType;
	}
	public void setPaymentMethodType(String paymentMethod) {
		this.paymentMethodType = paymentMethod;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public PaymentMethod(String paymentMethod, String status) {
		this.paymentMethodType = paymentMethod;
		this.status = status;
	}
	
	public PaymentMethod(String paymentMethod) {
		this.paymentMethodType = paymentMethod;
	}
	
	public String toString() {
		return getPaymentMethodType();
	}
	
	String paymentMethodType;
	String status;
	
}
