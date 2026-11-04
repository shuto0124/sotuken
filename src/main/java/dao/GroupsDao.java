package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import bean.Groups;
import bean.Users;

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
			int groupNumber = random.nextInt(90000) + 10000;
			try {
				statement = connection.prepareStatement(
						"select group_number from groups where group_number=?");
				statement.setInt(1, groupNumber);
				ResultSet rSet = statement.executeQuery();
				
				if (rSet.next()) {
					System.out.print("ループ");
				} else { 
					statement.close();
					groups.setGroupNumber(groupNumber);
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
	
	public Boolean syncGroups(int groupNomber) throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		int count = 0;
		int mcount = 0;
		
		try {
			statement = connection.prepareStatement("select * from users where group_number=?");
			statement.setInt(1, groupNomber);
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				mcount += 1;
			}
			statement.close();
			statement = connection.prepareStatement("update groups set member_count=? where group_number");
			statement.setInt(1, mcount);
			statement.setInt(2, groupNomber);
			
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
	
	
	
	public String join(Users users,int groupNumber) throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		int count = 0;
		
		try {
			Groups groups = get(groupNumber);
			int groupNomber = groups.getGroupNumber();
			if (groups != null) {
				if (groups.getMemberCount() <= 4) {
					statement = connection.prepareStatement(
							"update users set group_number=? where user_number=?");
					statement.setInt(1, groupNumber);
					statement.setInt(2, users.getUserNumber());
					
					count = statement.executeUpdate();
					boolean sync = syncGroups(groupNomber);
					if (sync==true) {
						System.out.print("同期成功");
						//削除処理を追加
					} else {
						System.out.print("同期エラー");
					}
				} else {
					return "満員";
				}
			} else {
				return "グループが見つからない";
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
			return "完了";
		} else {
			return "エラー";
		}
	} 
} 
