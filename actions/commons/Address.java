package commons;

public class Address {
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getZipPostalCode() {
		return zipPostalCode;
	}
	public void setZipPostalCode(String zipPostalCode) {
		this.zipPostalCode = zipPostalCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	
	public Address(String firstName, String lastName, String email, String company, String country, String province, String county,
			String city, String address1, String address2, String zipPostalCode, String phoneNumber, String faxNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.company = company;
		this.country = country;
		this.province = province;
		this.county = county;
		this.city = city;
		this.address1 = address1;
		this.address2 = address2;
		this.zipPostalCode = zipPostalCode;
		this.phoneNumber = phoneNumber;
		this.faxNumber = faxNumber;
	}
	
	public Address(String firstName, String lastName, String email, String country, String province, String city, String address1, String zipPostalCode, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.country = country;
		this.province = province;
		this.city = city;
		this.address1 = address1;
		this.zipPostalCode = zipPostalCode;
		this.phoneNumber = phoneNumber;
	}
	
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String company;
	protected String country;
	protected String province;
	protected String county;
	protected String city;
	protected String address1;
	protected String address2;
	protected String zipPostalCode;
	protected String phoneNumber;
	protected String faxNumber;
	
	
}
