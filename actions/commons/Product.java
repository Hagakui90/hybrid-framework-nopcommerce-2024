package commons;

import java.util.Date;

public class Product implements Comparable<Product>{
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
	@Override
	public int compareTo(Product product) {
		if (createdOn.compareTo(product.createdOn)==0) {
			return 0;
		}else if(createdOn.compareTo(product.createdOn) > 1) {
			return 1;
		}
		return -1;
	}
	
}
