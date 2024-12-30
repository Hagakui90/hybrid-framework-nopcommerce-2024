package commons;

public class ShippingAddress extends Address{
	
	public ShippingAddress(String firstName, String lastName, String email, String country, String province, String city, 
			String address1, String zipPostalCode, String phoneNumber) {
		super(firstName, lastName, email, country, province, city, address1, zipPostalCode, phoneNumber);
	}
}
