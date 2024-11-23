package commons;

import java.util.Date;

public class Product {
	private String titleOfBook;
	public String getTitleOfBook() {
		return titleOfBook;
	}
	public void setTitleOfBook(String titleOfBook) {
		this.titleOfBook = titleOfBook;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	private Date createdOn;
	public Product(String titleOfBook, Date createdOn) {
		this.titleOfBook = titleOfBook;
		this.createdOn = createdOn;
	}
	
}
