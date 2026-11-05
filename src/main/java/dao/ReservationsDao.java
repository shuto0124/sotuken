package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Reservations;

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
	
	
	
	
	
	
	
	
	
	
	
	
}
