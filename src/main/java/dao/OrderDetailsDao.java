package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import bean.OrderDetails;
import bean.Products;
import bean.Users;


public class OrderDetailsDao extends Dao {
	//注文明細番号から取得
	public OrderDetails get(int orderDetailNumber) throws Exception {
		OrderDetails oD = new OrderDetails();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("select * from orderdetails where orderdetails=?");
			statement.setInt(1, orderDetailNumber);
			ResultSet rSet = statement.executeQuery();
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
	//注文明細の作成
	public OrderDetails createOD(Users users,int productNumber,int orderQuantity) throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		int count = 0;
		OrderDetails oD = new OrderDetails();
		OrdersDao oDao = new  OrdersDao();
		ProductsDao pDao = new ProductsDao();

		do {
			Random random = new Random();
			int orderDetailNumber = random.nextInt(90000) + 10000;
			try {
				statement = connection.prepareStatement(
						"select order_detail_number from orderdetails where order_detail_number=?");
				statement.setInt(1, orderDetailNumber);
				ResultSet rSet = statement.executeQuery();
				
				if (rSet.next()) {
					System.out.print("ループ");
				} else { 
					statement.close();
					Products products = pDao.findByNumber(productNumber);
					
					oD.setOrderDetailNumber(orderDetailNumber);
					oD.setOrderNumber(oDao.uGet(users.getUserNumber()).getOrderNumber());
					oD.setProducts(products);
					oD.setOrderQuantity(orderQuantity);
					oD.setOrderSubtotal(products.getProductPrice() * orderQuantity);
					
					statement = connection.prepareStatement(
				"insert into orderdetails(order_detail_number,order_number,product_number,order_quantity,order_subtotal) values(?,?,?,?,?)");
					
					statement.setInt(1, oD.getOrderDetailNumber());
					statement.setInt(2, oD.getOrderNumber());
					statement.setInt(3, oD.getProducts().getProductNumber());
					statement.setInt(4, oD.getOrderQuantity());
					statement.setInt(5, oD.getOrderSubtotal());
					count = statement.executeUpdate();
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
		} while (count > 0); 
			
		return oD;
	}
	
}