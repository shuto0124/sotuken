package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Products;

public class ProductsDao extends Dao {
	
	//	一覧取得
	public List<Products> findAll() throws Exception {
		List<Products> list = new ArrayList<>();
		String sql = "SELECT product_number, product_name, product_image, product_price FROM Products ORDER BY product_number";
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
	public {
		
	}
	
	//	保存(INSERT or UPDATE)
	public {
		
	}
	
	//	削除
	public {
		
	}
}