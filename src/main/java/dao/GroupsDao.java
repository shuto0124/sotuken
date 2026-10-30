package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Groups;

public class GroupsDao extends Dao {
	//検索取得
	public Groups get(int groupNumber) throws Exception {
		Groups groups = new Groups();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("select * from groups where group_number=?");
			statement.setInt(1, groupNumber);
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
	//全件取得
	public List<Groups> findall() throws Exception {
		List<Groups> list = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;
		try {
			statement = connection.prepareStatement("select * from groups");
			
			rSet = statement.executeQuery();
			
			while(rSet.next()) {
				Groups groups = new Groups();
				groups.setGroupNumber(rSet.getInt("group_number"));
				groups.setMemberCount(rSet.getInt("member_count"));
				
				list.add(groups);
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
}