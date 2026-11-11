package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import bean.CartDetails;
import bean.OrderDetails;
import bean.Orders;
import bean.Products;
import bean.Users;

public class OrdersDao extends Dao {
	//注文番号で取得
	public Orders get(int order_number) throws Exception {
		Orders orders = new Orders();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("select * from orders where order_number=?");
			statement.setInt(1, order_number);
			ResultSet rSet = statement.executeQuery();
			UsersDao uDao = new UsersDao();
			ReservationsDao rDao = new ReservationsDao();
			
			if (rSet.next()) {
				orders.setOrderNumber(order_number);
				orders.setUsers(uDao.get(rSet.getInt("user_number")));
				orders.setReservations(rDao.get(rSet.getInt("reservation_number")));
				orders.setTotalAmount(rSet.getInt("total_amount"));
				orders.setPaymentStatus(rSet.getString("payment_status"));
			} else {
				orders = null;
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
		return orders;
	}
	
	
	//個人番号で取得
		public Orders uGet(int user_number) throws Exception {
			Orders orders = new Orders();
			Connection connection = getConnection();
			PreparedStatement statement = null;
			
			try {
				statement = connection.prepareStatement("select * from orders where user_number=?");
				statement.setInt(1, user_number);
				ResultSet rSet = statement.executeQuery();
				UsersDao uDao = new UsersDao();
				ReservationsDao rDao = new ReservationsDao();
				
				if (rSet.next()) {
					orders.setOrderNumber(rSet.getInt("order_number"));
					orders.setUsers(uDao.get(rSet.getInt("user_number")));
					orders.setReservations(rDao.get(rSet.getInt("reservation_number")));
					orders.setTotalAmount(rSet.getInt("total_amount"));
					orders.setPaymentStatus(rSet.getString("payment_status"));
				} else {
					orders = null;
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
			return orders;
		}
		
		
	//全件取得
	public List<Orders> findAll() throws Exception {
		List<Orders> list = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;
		UsersDao uDao = new UsersDao();
		ReservationsDao rDao = new ReservationsDao();
		try {
			statement = connection.prepareStatement("select * from orders");
			rSet = statement.executeQuery();
			
			while(rSet.next()) {
				Orders orders = new Orders();
				orders.setOrderNumber(rSet.getInt(("order_number")));
				orders.setUsers(uDao.get(rSet.getInt("user_number")));
				orders.setReservations(rDao.get(rSet.getInt("reservation_number")));
				orders.setTotalAmount(rSet.getInt("total_amount"));
				orders.setPaymentStatus(rSet.getString("payment_status"));
				
				list.add(orders);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rSet != null) {
			    rSet.close();
			}
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
	
		return list;
	}
	//注文の作成
	public Orders createOrder(Users users) throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		int count = 0;
		Orders orders = new Orders();
		ReservationsDao rDao = new ReservationsDao();

		
		do {
			Random random = new Random();
			int orderNumber = random.nextInt(90000) + 10000;
			try {
				statement = connection.prepareStatement(
						"select order_number from orders where order_number=?");
				statement.setInt(1, orderNumber);
				ResultSet rSet = statement.executeQuery();
				
				if (rSet.next()) {
					System.out.print("ループ");
				} else { 
					statement.close();
					orders.setOrderNumber(orderNumber);;
					orders.setUsers(users);
					orders.setReservations(rDao.gFind(users.getGroups().getGroupNumber()));
					orders.setTotalAmount(0);
					orders.setPaymentStatus(null);
					
					
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
	
	//注文の合計金額
	public boolean total(int orderNumber) throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;
		int count = 0;
		int totalAmount = 0;
		try {
			statement = connection.prepareStatement("select order_subtotal from orderdetails where order_number=?");
			statement.setInt(1, orderNumber);
			rSet = statement.executeQuery();
			while(rSet.next()) {
				totalAmount += rSet.getInt("order_subtotal");
			}
			statement.close();
			Orders order = get(orderNumber);
			order.setTotalAmount(totalAmount);
			statement = connection.prepareStatement(
					"update orders set order_subtotal=? where order_number=?");
			statement.setInt(1, totalAmount);
			statement.setInt(2, orderNumber);
			count = statement.executeUpdate();
			
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
		 
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	//支払状況の更新 (変更する注文の番号,更新後の状況)
	public boolean updatePaymentStatus(int orderNumber,String status) throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(
					"update orders set payment_status=? where order_number=?");
					statement.setString(1, status);
					statement.setInt(2, orderNumber);
					
					count = statement.executeUpdate();
					
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
		 
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//削除（明細も込み）
	public boolean delete(int orderNumber) throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(
					"delete from order_details where order_number=?");
			statement.setInt(1, orderNumber);
			count = statement.executeUpdate();
			if (count > 0) {
				count = 0;
				statement.close();
				statement = connection.prepareStatement(
						"delete from orders where order_number=?");
				statement.setInt(1, orderNumber);
				count = statement.executeUpdate();
			} else {
				return false;
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
		 
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//カートから注文に移す処理
	public boolean torace(int userNumber) throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		List<CartDetails> list = new ArrayList<>();
		boolean check = true;
		try {
			UsersDao uDao = new UsersDao();
			Users users = uDao.get(userNumber);
			Orders order = createOrder(users);
			CartDetailsDao cDDao = new CartDetailsDao();
			int orderNumber = order.getOrderNumber();
			CartsDao cDao = new CartsDao();
			int cartNumber = cDao.findByUserNumber(userNumber).getCartNumber();
			list = cDDao.findByCartNumber(cartNumber);
			for (CartDetails cD : list) {
				Products products = cD.getProducts();
				int orderQuantity = cD.getQuantity();
				
				OrderDetailsDao oDDao = new OrderDetailsDao();
				OrderDetails oD = oDDao.createOD(orderNumber, products, orderQuantity);
				
				if (oD == null) {
					check = false;
				}
			}
			if (check == true) {
				//カートをクリアする処理
			} else {
				statement = connection.prepareStatement(
						"delete from orderdetails where order_number=?");
				statement.setInt(1, orderNumber);
				statement.execute();
				System.out.print("トレースエラー 全てのトレースを停止");
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
		return check;
	}
	
}