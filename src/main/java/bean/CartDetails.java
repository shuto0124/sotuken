package bean;

public class CartDetails implements java.io.Serializable {
	
	private int cart_detail_number;
	//カート明細からカートを参照することはないのでCartsbeanをもたせない
	private int cart_number;
	private Products products;
	private int quantity;
	private int cart_subtotal;
	
	public int getCartDetailNumber() {
		return cart_detail_number;
	}

	public int getCartNumber() {
		return cart_number;
	}
	
	public Products getProducts() {
		return products;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getCartSubtotal() {
		return cart_subtotal;
	}
	
	public void setCartDetailNumber(int cart_detail_number) {
		this.cart_detail_number = cart_detail_number;
	}
	
	public void setCartNumber(int cart_number) {
		this.cart_number = cart_number;
	}
	
	public void setProducts(Products products) {
		this.products = products;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setCartSubtotal(int cart_subtotal) {
		this.cart_subtotal = cart_subtotal;
	}

}