package bean;

public class Orders implements java.io.Serializable {
	
	private int order_number;
	private Users users;
	private Reservations reservations;
	private int total_amount;
	private String payment_status;
	
	public int getOrderNumber() {
		return order_number;
	}

	public Users getUsers() {
		return users;
	}
	
	public Reservations getReservations() {
		return reservations;
	}
	
	public int getTotalAmount() {
		return total_amount;
	}
	
	public String getPaymentStatus() {
		return payment_status;
	}
	
	public void setOrderNumber(int order_number) {
		this.order_number = order_number;
	}
	
	public void setUsers(Users users) {
		this.users = users;
	}
	
	public void setReservations(Reservations reservations) {
		this.reservations = reservations;
	}
	
	public void setTotalAmount(int total_amount) {
		this.total_amount = total_amount;
	}
	
	public void setPaymentStatus(String payment_status) {
		this.payment_status = payment_status;
	}

}