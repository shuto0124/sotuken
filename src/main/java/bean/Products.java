package bean;

public class Products implements java.io.Serializable {
	
	private int product_number;
	private String product_name;
	private String product_description;
	private int product_price;
	private int product_stock;
	private String product_image;
	
	public int getProductNumber() {
		return product_number;
	}

	public String getProductName() {
		return product_name;
	}
	
	public String getProductDescription() {
		return product_description;
	}
	
	public int getProductPrice() {
		return product_price;
	}
	
	public int getProductStock() {
		return product_stock;
	}
	
	public String getProductImage() {
		return product_image;
	}
	
	public void setProductNumber(int product_number) {
		this.product_number = product_number;
	}
	
	public void setProductName(String product_name) {
		this.product_name = product_name;
	}
	
	public void setProductDescription(String product_description) {
		this.product_description = product_description;
	}
	
	public void setProductPrice(int product_price) {
		this.product_price = product_price;
	}
	
	public void setProductStock(int product_stock) {
		this.product_stock = product_stock;
	}
	
	public void setProductImage(String product_image) {
		this.product_image = product_image;
	}

}