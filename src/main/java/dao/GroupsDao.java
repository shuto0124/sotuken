package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Groups;

public class GroupsDao extends Dao {
	
	public Groups get(int group_number) throws Exception {
		Groups groups = new Groups();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("select * from groups where group_number=?");
			statement.setInt(1, group_number);
			ResultSet rSet = statement.executeQuery();

			
			if (rSet.next()) {
				groups.setGroupNumber(rSet.getInt("group_number"));
				groups.setMemberCount(rSet.getInt("member_count"));

			} else {
				groups = null;
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
		return groups;
	}
}