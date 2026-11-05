package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import bean.Groups;
import bean.Reservations;
import bean.Tables;

public class ReservationsDao extends Dao {
	public Reservations get(int reservation_number) throws Exception {
		Reservations rv = new Reservations();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("select * from reservations where reservation_number=?");
			statement.setInt(1, reservation_number);
			ResultSet rSet = statement.executeQuery();
			GroupsDao gDao = new GroupsDao();
			TablesDao tDao = new TablesDao();
			
			if (rSet.next()) {
				rv.setReservationNumber(rSet.getInt("reservation_number"));
				rv.setGroups(gDao.get(rSet.getInt("group_number")));
				rv.setTables(tDao.findByNumber(rSet.getInt("table_number")));
				rv.setTimeLimit(null);

			} else {
				rv = null;
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
		return rv;
	}
	
	public List<Reservations> findAll() throws Exception {
		List<Reservations> list = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;
		try {
			statement = connection.prepareStatement("select * from reservations");
			
			rSet = statement.executeQuery();
			
			Reservations rv = new Reservations();
			GroupsDao gDao = new GroupsDao();
			TablesDao tDao = new TablesDao();
			
			while(rSet.next()) {
				rv.setReservationNumber(rSet.getInt("reservation_number"));
				rv.setGroups(gDao.get(rSet.getInt("group_number")));
				rv.setTables(tDao.findByNumber(rSet.getInt("table_number")));
				rv.setTimeLimit(null);
				
				list.add(rv);
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
	
	public Reservations createReservations(Groups groups,Tables tables) throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		int count = 0;
		Reservations rv = new Reservations();
		do {
			Random random = new Random();
			int rvNumber = random.nextInt(90000) + 10000;
			try {
				statement = connection.prepareStatement(
						"select reservation_number from reservations where reservation_number=?");
				statement.setInt(1, rvNumber);
				ResultSet rSet = statement.executeQuery();
				
				if (rSet.next()) {
					System.out.print("ループ");
				} else { 
					statement.close();
					rv.setReservationNumber(rvNumber);
					rv.setGroups(groups);
					rv.setTables(tables);
					rv.setTimeLimit(null);
					
					statement = connection.prepareStatement(
				"insert into  reservations(reservation_number,group_number,table_number,time_limit) values(?,?,?,?)");
					statement.setInt(1, rvNumber);
					statement.setInt(2, groups.getGroupNumber());
					statement.setInt(3, tables.getTableNumber());
					statement.setTime(4, null);
					
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
			
		return rv;
	}
	
	
	
	
	
	
	
	
}
