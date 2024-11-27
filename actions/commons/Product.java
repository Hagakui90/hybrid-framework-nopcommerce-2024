package commons;

import java.util.Date;

public class Product implements Comparable<Product>{
	private String titleOfProduct;
	public String getTitleOfProduct() {
		return titleOfProduct;
	}
	public void setTitleOfProduct(String titleOfProduct) {
		this.titleOfProduct = titleOfProduct;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	private Date createdOn;
	private String priceOfProduct;
	public String getPriceOfProduct() {
		return priceOfProduct;
	}
	public void setPriceOfProduct(String priceOfProduct) {
		this.priceOfProduct = priceOfProduct;
	}
	public Product(String titleOfProduct, Date createdOn) {
		this.titleOfProduct = titleOfProduct;
		this.createdOn = createdOn;
	}
	
	public Product(String titleOfProduct, String priceOfProduct) {
		this.titleOfProduct = titleOfProduct;
		this.priceOfProduct = priceOfProduct;
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
