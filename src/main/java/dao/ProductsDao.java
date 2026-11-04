package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Products;

public class ProductsDao extends Dao {
	
	//	全件取得
	public List<Products> findAll() throws Exception {
		List<Products> list = new ArrayList<>();
		String sql = "select product_number, product_name, product_image, product_price from Products order by product_number";
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql);
			 ResultSet rs = st.executeQuery()) {
			
			while (rs.next()) {
				Products product = new Products();
				
				product.setProductNumber(rs.getInt("product_number"));
				product.setProductName(rs.getString("product_name"));
				product.setProductImage(rs.getString("product_image"));
				product.setProductPrice(rs.getInt("product_price"));
				
				list.add(product);
			}
		}
		
		return list;
	}
	
	//	詳細取得
	public Products findByNumber(int productNumber) throws Exception{
		Products product = null;
		String sql = "select product_number, product_name, product_image, product_description, product_price from Products where product_number = ?";
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setInt(1, productNumber);
			
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					product = new Products();
					
					product.setProductNumber(rs.getInt("product_number"));
					product.setProductName(rs.getString("product_name"));
					product.setProductImage(rs.getString("product_image"));
					product.setProductDescription(rs.getString("product_description"));
					product.setProductPrice(rs.getInt("product_price"));
				}
			}
		}
		
		return product;
	}
	
	//	保存(INSERT or UPDATE)
	public boolean save(Products products) throws Exception {
		int count = 0;
		
		try (Connection con = getConnection()) {
			
			Products old = findByNumber(products.getProductNumber());
			
			if (old == null) {
				String sql = "insert into Products(product_number, product_name, product_description, product_price, product_stock, product_image) values(?, ?, ?, ?, ?, ?)";
				
				try (PreparedStatement st = con.prepareStatement(sql)) {
					st.setInt(1, products.getProductNumber());
					st.setString(2, products.getProductName());
					st.setString(3, products.getProductDescription());
					st.setInt(4, products.getProductPrice());
					st.setInt(5, products.getProductStock());
					st.setString(6, products.getProductImage());
					
					count = st.executeUpdate();
				}
			} else {
				String sql = "update Products set product_number = ?, product_name = ?, product_description = ?, product_price = ?, product_stock = ?, product_image = ?";
				
				try (PreparedStatement st = con.prepareStatement(sql)) {
					st.setInt(1, products.getProductNumber());
					st.setString(2, products.getProductName());
					st.setString(3, products.getProductDescription());
					st.setInt(4, products.getProductPrice());
					st.setInt(5, products.getProductStock());
					st.setString(6, products.getProductImage());
					
					count = st.executeUpdate();
				}
			}
 		}
		
		return count > 0;
	}
	
	//	削除
	public boolean delete(Products products) throws Exception {
		String sql = "delete from Products where product_number = ?";
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setInt(1, products.getProductNumber());
			int line = st.executeUpdate();
            return line > 0;
		}
	}
}