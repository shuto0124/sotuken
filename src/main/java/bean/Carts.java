package bean;

public class Carts implements java.io.Serializable {
	
	private int cartNumber;
	//カートからユーザーを参照することはないのでUsersbeanをもたせない
	private int userNumber;
	private int cartTotal;

	
	public int getCartNumber() {
		return cartNumber;
	}

	public int getUserNumber() {
		return userNumber;
	}
	
	public int getCartTotal() {
		return cartTotal;
	}
	
	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
	}
	
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
	public void setCartTotal(int cartTotal) {
		this.cartTotal = cartTotal;
	}
	
}