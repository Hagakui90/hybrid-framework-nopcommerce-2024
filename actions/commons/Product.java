package commons;

import java.util.Date;

public class Product implements Comparable<Product>{
	
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
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getPriceOfProduct() {
		return priceOfProduct;
	}
	public void setPriceOfProduct(String priceOfProduct) {
		this.priceOfProduct = priceOfProduct;
	}
	
	public String getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(String stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public boolean getStatusOfPublished() {
		return statusOfPublished;
	}
	public void setStatusOfPublished(boolean statusOfPublished) {
		this.statusOfPublished = statusOfPublished;
	}
	public Product(String titleOfProduct, Date createdOn) {
		this.titleOfProduct = titleOfProduct;
		this.createdOn = createdOn;
	}
	
	public Product(String titleOfProduct, String priceOfProduct) {
		this.titleOfProduct = titleOfProduct;
		this.priceOfProduct = priceOfProduct;
	}
	
	public Product(String skuOfProduct, String titleOfProduct, String priceOfProduct, String stockQuantity, boolean statusOfPublished) {
		this.skuOfProduct = skuOfProduct;
		this.titleOfProduct = titleOfProduct;
		this.priceOfProduct = priceOfProduct;
		this.stockQuantity = stockQuantity;
		this.statusOfPublished = statusOfPublished;
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

	
	private String skuOfProduct;
	private String titleOfProduct;
	private String stockQuantity;
	private boolean statusOfPublished;
	private Date createdOn;
	private String priceOfProduct;
	
	
}
