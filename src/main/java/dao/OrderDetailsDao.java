package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import bean.OrderDetails;
import bean.Orders;
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
	
	public Orders createOD(Users users) throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		int count = 0;
		OrderDetails oD = new OrderDetails();
		ReservationsDao rDao = new ReservationsDao();
		OrdersDao oDao = new  OrdersDao();

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
					oD.setOrderDetailNumber(orderDetailNumber);
					oD.setOrderNumber(users.getUserNumber());
					oD.setReservations(rDao.gfind(users.getGroups().getGroupNumber()));
					oD.setTotalAmount(0);
					oD.setPaymentStatus(null);
					
					statement = connection.prepareStatement(
				"insert into Orders(order_number,user_number,reservation_number,total_amount,payment_status) values(?,?,?,?,?)");
					
					statement.setInt(1, orderNumber);
					statement.setInt(2, users.getUserNumber());
					statement.setInt(3, orders.getReservations().getReservationNumber());
					statement.setInt(4, orders.getTotalAmount());
					statement.setString(5, null);
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
			
		return orders;
	}
	
}