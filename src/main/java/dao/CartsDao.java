package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Carts;

public class CartsDao extends Dao {
	
	//	個人番号で既存のカートを取得
	public Carts findByUserNumber(int userNumber) throws Exception {
		
		Carts cart = null;
		String sql = "select cart_number, user_number, cart_total from Carts where user_number = ?";
		
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
		String sql = "insert into Carts(user_number, cart_total) values(?, 0)";
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql)) {
			
		}
	}
}