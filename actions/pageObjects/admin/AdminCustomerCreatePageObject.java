package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.Customer;

public class AdminCustomerCreatePageObject extends AdminDashboardSideBarPageObject{
	WebDriver driver;

	public AdminCustomerCreatePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public Customer createCustomerInfo(String email, String password, String firstName, String lastName, String sex, String company, String role, boolean active, String adminComment) {
		return new Customer(email, password, firstName, lastName, sex, company, role, active, adminComment);
	}

	public void inputToAddNewForm(Customer newCustomer) {
		
	}
}
