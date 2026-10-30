package bean;

public class CartDetails implements java.io.Serializable {
	
	private int cartDetailNumber;
	//カート明細からカートを参照することはないのでCartsbeanをもたせない
	private int cartNumber;
	private Products products;
	private int quantity;
	private int cartSubtotal;
	
	public int getCartDetailNumber() {
		return cartDetailNumber;
	}

	public int getCartNumber() {
		return cartNumber;
	}
	
	public Products getProducts() {
		return products;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getCartSubtotal() {
		return cartSubtotal;
	}
	
	public void setCartDetailNumber(int cartDetailNumber) {
		this.cartDetailNumber = cartDetailNumber;
	}
	
	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
	}
	
	public void setProducts(Products products) {
		this.products = products;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setCartSubtotal(int cartSubtotal) {
		this.cartSubtotal = cartSubtotal;
	}

}