package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import bean.Tables;

public class TablesDao extends Dao {
	
	//	全件取得
	public List<Tables> findAll() throws Exception {
		List<Tables> list = new ArrayList<>();
		String sql = "SELECT table_number, table_type, table_status, temporary_end_time FROM TABLES ORDER BY table_number";
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql);
			 ResultSet rs = st.executeQuery()) {
			
			while (rs.next()) {
				Tables table = new Tables();
				
				table.setTableNumber(rs.getInt("table_number"));
				table.setTableType(rs.getString("table_type"));
				table.setTableStatus(rs.getString("table_status"));
				Timestamp timestamp = rs.getTimestamp("temporary_end_time");

				if (timestamp != null) {
				    table.setTemporaryEndTime(timestamp.toLocalDateTime());
				}
				list.add(table);
			}
		}
		
		return list;
	}
	
	//	詳細取得
	public Tables findByNumber(int tableNumber) throws Exception {
		Tables table = null;
		String sql = "SELECT table_number, table_type, table_status, temporary_end_time FROM TABLES WHERE table_number = ?";
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setInt(1, tableNumber);
			
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					table = new Tables();
					
					table.setTableNumber(rs.getInt("table_number"));
					table.setTableType(rs.getString("table_type"));
					table.setTableStatus(rs.getString("table_status"));
					Timestamp timestamp = rs.getTimestamp("temporary_end_time");

					if (timestamp != null) {
					    table.setTemporaryEndTime(timestamp.toLocalDateTime());
					}
				}
			}
		}
		
		return table;
	}
	
	
	//	更新
	public boolean updateStatus(int tableNumber, String tableStatus, LocalDateTime temporaryEndTime) throws Exception {
		String sql = "UPDATE TABLES SET table_status = ?,temporary_end_time = ? WHERE table_number = ?";
		
		try(Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setString(1, tableStatus);
			if (temporaryEndTime != null) {
			    st.setTimestamp(2, java.sql.Timestamp.valueOf(temporaryEndTime));
			} else {
			    st.setNull(2, java.sql.Types.TIMESTAMP);
			}
			st.setInt(3, tableNumber);
			
			int line = 	st.executeUpdate();
			return line > 0; 
		}
	}
	
	//時間切れ仮予約をクリア
	public void clearTemporary() throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(
					"UPDATE TABLES SET table_status = '空席',temporary_end_time = NULL "
					+ "WHERE table_status = '仮予約' AND temporary_end_time <= CURRENT_TIMESTAMP;");
			statement.executeUpdate();
			
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
	}
}
