package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	public Groups creategroup() throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		int count = 0;
		Groups groups = new Groups();
		
		do {
			Random random = new Random();
			int groupnumber = random.nextInt(90000) + 10000;
			try {
				statement = connection.prepareStatement(
						"select group_number from groups where group_number=?");
				statement.setInt(1, groupnumber);
				ResultSet rSet = statement.executeQuery();
				
				if (rSet.next()) {
					System.out.print("ループ");
				} else { 
					statement.close();
					groups.setGroupNumber(groupnumber);
					groups.setMemberCount(1);
					
					rSet = null;
					statement = connection.prepareStatement(
				"insert into groups(group_number,member_count) values(?,?)");
					
					statement.setInt(1, groups.getGroupNumber());
					statement.setInt(2, groups.getMemberCount());
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
			
		return groups;
	}
} 
