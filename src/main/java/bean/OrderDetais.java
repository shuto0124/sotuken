package bean;

public class OrderDetais implements java.io.Serializable {
	
	private int order_detail_number;
	//注文明細から注文を参照することはないのでOrdersbeanをもたせない
	private int order_number;
	private Products products;
	private int order_quantity;
	private int order_subtotal;
	
	
	public int getOrderDetailNumber() {
		return order_detail_number;
	}
	
	public int getOrderNumber() {
		return order_number;
	}

	public Products getProducts() {
		return products;
	}
	
	public int getOrderQuantity() {
		return order_quantity;
	}
	
	public int getOrderSubtotal() {
		return order_subtotal;
	}
	
	public void setOrderDetailNumber(int  order_detail_number) {
		this.order_detail_number = order_detail_number;
	}
	
	public void setOrderNumber(int order_number) {
		this.order_number = order_number;
	}
	
	public void setProducts(Products products) {
		this.products = products;
	}
	
	public void setOrderQuantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	
	public void setOrderSubtotal(int order_subtotal) {
		this.order_subtotal = order_subtotal;
	}

}