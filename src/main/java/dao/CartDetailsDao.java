package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.CartDetails;
import bean.Products;

public class CartDetailsDao extends Dao {
	
	//	一覧取得
	public List<CartDetails> findByCartNumber(int cartNumber) throws Exception {
		List<CartDetails> list = new ArrayList<>();
		
		String sql = """
						SELECT 
							cd.cart_detail_number,
							cd.cart_number,
							cd.product_number,
							cd.quantity,
							COALESCE(cd.cart_subtotal, (p.product_price * cd.quantity)) AS 	subtotal,
							p.product_name,
							p.product_price,
						FROM CARTDETAILS cd
						JOIN PRODUCTS p ON cd.product_number = p.product_number
						WHERE cd.cart_number = ?
						ORDER BY cd.cart_detail_number ASC
					 """;
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setInt(1, cartNumber);
			
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					CartDetails detail = new CartDetails();
					detail.setCartDetailNumber(rs.getInt("cart_detail_number"));
					detail.setCartNumber(rs.getInt("cart_number"));
					detail.setQuantity(rs.getInt("quantity"));
					detail.setCartSubtotal(rs.getInt("cart_subtotal"));
					
					Products product = new Products();
					product.setProductNumber(rs.getInt("product_number"));
					product.setProductName(rs.getString("product_name"));
					product.setProductPrice(rs.getInt("product_price"));
					
					detail.setProducts(product);
					
					list.add(detail);
				}
			}
		}
		
		return list;
	}
	
	//	保存
	public boolean save(int cartNumber, int productNumber, int count) throws Exception {
		String checkSql = "SELECT cart_detail_number, quantity FROM CARTDETAILS WHERE cart_number = ? AND product_number = ?";
		
		try (Connection con = getConnection();
			 PreparedStatement checkSt = con.prepareStatement(checkSql)) {
			
			checkSt.setInt(1, cartNumber);
			checkSt.setInt(2, productNumber);
			
			try (ResultSet rs = checkSt.executeQuery()) {
				if (rs.next()) {
					int detailNumber = rs.getInt("cart_detail_number");
					int newQuantity = rs.getInt("quantity") + count;
					return updateQuantity(detailNumber, newQuantity);
				} else {
					String insertSql = """
											INSERT INTO CARTDETAILS (cart_number, product_number, quantity, cart_subtotal)
											VALUES (?, ?, ?, (SELECT product_price FROM PRODUCTS WHERE product_number - ?) * ?)
									   """;
					try (PreparedStatement insertSt = con.prepareStatement(insertSql)) {
						insertSt.setInt(1, cartNumber);
						insertSt.setInt(2, productNumber);
						insertSt.setInt(3, count);
						insertSt.setInt(4, productNumber);
						insertSt.setInt(5, count);
						
						return insertSt.executeUpdate() > 0;
					}
				}
			}
		}
	}
	
	//	数量の変更
	public boolean updateQuantity(int cartDetailNumber, int newQuantity) throws Exception {
		String sql = """
						UPDATE CARTDETAILS cd
						SET quantity = ?,
							cart_subtotal = (
								SELECT p.product_prce * ?
								FROM PRODUCTS p
								WHERE p.product_number = cd.product_number
							)
						WHERE cd.cart_detail_number = ?
					 """;
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setInt(1, newQuantity);
			st.setInt(2, newQuantity);
			st.setInt(3, cartDetailNumber);
			
			return st.executeUpdate() > 0;
		}
	}
	
	//	削除(単一)
	public boolean delete(int cartDetialNumber) throws Exception {
		String sql = "DELETE FROM CARTDETAILS WHERE cart_detail_number = ?";
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setInt(1, cartDetialNumber);
			
			return st.executeUpdate() > 0;
		}
	}
	
	//	削除(全体)
	public boolean deleteAllByCartNumber(int cartNumber) throws Exception {
		String sql = "DELETE FROM CARTDETAILS WHERE cart_number = ?";
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setInt(1, cartNumber);
			
			return st.executeUpdate() > 0;
		}
	}
}