package bean;

public class Products implements java.io.Serializable {
	
	private int productNumber;
	private String productName;
	private String productDescription;
	private int productPrice;
	private int productStock;
	private String productImage;
	
	public int getProductNumber() {
		return productNumber;
	}

	public String getProductName() {
		return productName;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	
	public int getProductPrice() {
		return productPrice;
	}
	
	public int getProductStock() {
		return productStock;
	}
	
	public String getProductImage() {
		return productImage;
	}
	
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

}