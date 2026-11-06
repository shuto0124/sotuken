package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.OrderDetails;
import bean.Orders;


public class OrderDetailsDao extends Dao {
	//注文明細番号から取得
	public OrderDetails get(int orderDetailNumber) throws Exception {
		Orders orders = new Orders();
		OrderDetails oD = new OrderDetails();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("select * from orderdetails where orderdetails=?");
			statement.setInt(1, orderDetailNumber);
			ResultSet rSet = statement.executeQuery();
			UsersDao uDao = new UsersDao();
			ProductsDao pDao = new ProductsDao();
			
			if (rSet.next()) {
				oD.setOrderDetailNumber(rSet.getInt("order_detail_number"));
				oD.setOrderNumber(rSet.getInt("order_number"));
				oD.setProducts(pDao.findByNumber(rSet.getInt("product_number")));
				oD.setOrderQuantity(rSet.getInt("order_quantity"));
				oD.setOrderSubtotal(rSet.getInt("order_subtotal"));
			} else {
				oD = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}  
		return oD;
	}
	
	
	
}