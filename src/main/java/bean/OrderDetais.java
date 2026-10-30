package bean;

public class OrderDetais implements java.io.Serializable {
	
	private int orderDetailNumber;
	//注文明細から注文を参照することはないのでOrdersbeanをもたせない
	private int orderNumber;
	private Products products;
	private int orderQuantity;
	private int orderSubtotal;
	
	
	public int getOrderDetailNumber() {
		return orderDetailNumber;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}

	public Products getProducts() {
		return products;
	}
	
	public int getOrderQuantity() {
		return orderQuantity;
	}
	
	public int getOrderSubtotal() {
		return orderSubtotal;
	}
	
	public void setOrderDetailNumber(int  orderDetailNumber) {
		this.orderDetailNumber = orderDetailNumber;
	}
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public void setProducts(Products products) {
		this.products = products;
	}
	
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	public void setOrderSubtotal(int orderSubtotal) {
		this.orderSubtotal = orderSubtotal;
	}

}