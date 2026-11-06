package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Tables;

public class TablesDao extends Dao {
	
	//	全件取得
	public List<Tables> findAll() throws Exception {
		List<Tables> list = new ArrayList<>();
		String sql = "SELECT table_number, table_type, table_status FROM TABLES ORDER BY table_number";
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql);
			 ResultSet rs = st.executeQuery()) {
			
			while (rs.next()) {
				Tables table = new Tables();
				
				table.setTableNumber(rs.getInt("table_number"));
				table.setTableType(rs.getString("table_type"));
				table.setTableStatus(rs.getString("table_status"));
			}
		}
		
		return list;
	}
	
	//	詳細取得
	public Tables findByNumber(int tableNumber) throws Exception {
		Tables table = null;
		String sql = "SELECT table_number, table_type, table_status FROM TABLES WHERE table_number = ?";
		
		try (Connection con = getConnection();
			 PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setInt(1, tableNumber);
			
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					table = new Tables();
					
					table.setTableNumber(rs.getInt("table_number"));
					table.setTableType(rs.getString("table_type"));
					table.setTableStatus(rs.getString("table_status"));
				}
			}
		}
		
		return table;
	}
	
	//	更新
	public boolean updateStatus(int tableNumber, String tableStatus) throws Exception {
		String sql = "UPDATE TABLES SET table_status = ? WHERE table_number = ?";
		
		try(Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(sql)) {
			
			st.setString(1, tableStatus);
			st.setInt(2, tableNumber);
			
			int line = 	st.executeUpdate();
			return line > 0; 
		}
	}
}