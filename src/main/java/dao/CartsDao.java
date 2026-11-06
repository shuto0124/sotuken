package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Carts;

public class CartsDao extends Dao {
	
	//	個人番号で既存のカートを取得
	public Carts findByUserNumber(int userNumber) throws Exception {
		
		Carts cart = null;
		String sql = "SELECT cart_number, user_number, cart_total FROM CARTS WHERE user_number = ?";
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setInt(1, userNumber);
			
			try(ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					cart = new Carts();
					
					cart.setCartNumber(rs.getInt("cart_number"));
					cart.setUserNumber(rs.getInt("user_number"));
					cart.setCartTotal(rs.getInt("cart_total"));
				}
			}
		}
		
		return cart;
	}
	
	//	個人番号に対してカートを作成
	public boolean createCart(int userNumber) throws Exception {
		String sql = "INSERT INTO CARTS(user_number, cart_total) VALUES(?, 0)";
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setInt(1, userNumber);
			
			int line = st.executeUpdate();
			return line > 0;
		}
	}
	
	//	カートが存在していれば取得し、なかったら自動で作成
	public Carts getOrCreateCart(int userNumber) throws Exception {
		Carts cart = findByUserNumber(userNumber);
		
		if (cart == null) {
			createCart(userNumber);
			cart = findByUserNumber(userNumber);
		}
		
		return cart;
	}
	
	//	カート明細と商品から小計を計算し、合計を更新する
	public boolean updateTotal(int cartNumber) throws Exception {
		String sql = """
						UPDATE CARTS 
					    SET cart_total = COALESCE((
					        SELECT SUM(p.product_price * cd.quantity) 
					        FROM CARTDETAILS cd 
					        JOIN PRODUCTS p ON cd.product_number = p.product_number 
					        WHERE cd.cart_number = ? 
					    ), 0) 
					    WHERE cart_number = ?
					""";
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setInt(1, cartNumber);
			st.setInt(2, cartNumber);
			
			int line = st.executeUpdate();
			return line > 0;
		}
	}
}