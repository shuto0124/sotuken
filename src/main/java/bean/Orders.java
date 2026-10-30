package bean;

public class Orders implements java.io.Serializable {
	
	private int orderNumber;
	private Users users;
	private Reservations reservations;
	private int totalAmount;
	private String paymentStatus;
	
	public int getOrderNumber() {
		return orderNumber;
	}

	public Users getUsers() {
		return users;
	}
	
	public Reservations getReservations() {
		return reservations;
	}
	
	public int getTotalAmount() {
		return totalAmount;
	}
	
	public String getPaymentStatus() {
		return paymentStatus;
	}
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public void setUsers(Users users) {
		this.users = users;
	}
	
	public void setReservations(Reservations reservations) {
		this.reservations = reservations;
	}
	
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}