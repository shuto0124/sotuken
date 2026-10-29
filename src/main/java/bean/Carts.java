package bean;

public class Carts implements java.io.Serializable {
	
	private int cart_number;
	//カートからユーザーを参照することはないのでUsersbeanをもたせない
	private int user_number;
	private int cart_total;

	
	public int getCartNumber() {
		return cart_number;
	}

	public int getUserNumber() {
		return user_number;
	}
	
	public int getCartTotal() {
		return cart_total;
	}
	
	public void setCartNumber(int cart_number) {
		this.cart_number = cart_number;
	}
	
	public void setUserNumber(int user_number) {
		this.user_number = user_number;
	}
	
	public void setCartTotal(int cart_total) {
		this.cart_total = cart_total;
	}
	
}