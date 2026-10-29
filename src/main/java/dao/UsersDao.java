package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Users;


public class UsersDao extends Dao {
	//個人番号から情報を取得
	public Users get(int user_number) throws Exception {
		Users users = new Users();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("select * from users where user_number=?");
			statement.setInt(1, user_number);
			ResultSet rSet = statement.executeQuery();
			GroupsDao groupsDao = new GroupsDao();
			
			if (rSet.next()) {
				users.setUserNumber(rSet.getInt("user_number"));
				users.setUserName(rSet.getString("user_name"));
				users.setPassword(rSet.getString("password"));
				users.setAccountStatus(rSet.getString("account_status"));
				  
				users.setGroups(groupsDao.get(rSet.getInt("group_number")));
			} else {
				users = null;
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
		return users;
	}
	
	//全件取得
	public List<Users> findall() throws Exception {
		List<Users> list = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;
		try {
			statement = connection.prepareStatement("select * from users");
			
			rSet = statement.executeQuery();
			
			GroupsDao groupsDao = new GroupsDao();
			
			while(rSet.next()) {
				Users users = new Users();
				users.setUserNumber(rSet.getInt("user_number"));
				users.setUserName(rSet.getString("user_name"));
				users.setPassword(rSet.getString("password"));
				users.setAccountStatus(rSet.getString("account_status"));
				  
				users.setGroups(groupsDao.get(rSet.getInt("group_number")));
				
				list.add(users);
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
	
	//登録更新
	public boolean save(Users users) throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		int count = 0;
		
		try {
			//個人番号が存在しているか
			Users old = get(users.getUserNumber());
			//存在しない 保存
			if (old == null) {
				statement = connection.prepareStatement(
						"insert into users(user_number,user_name,password,account_status,group_number) values(?,?,?,?,?)");
				statement.setInt(1, users.getUserNumber());
				statement.setString(2, users.getUserName());
				statement.setString(3, users.getPassword());
				statement.setString(4, users.getAccountStatus());
				statement.setInt(5, users.getGroups().getGroupNumber());
			//存在する　更新
			} else {
				statement = connection.prepareStatement(
						"update users set user_name=?, password=?, account_status=?, group_number=? where user_number=?");
				statement.setString(1, users.getUserName());
				statement.setString(2, users.getPassword());
				statement.setString(3, users.getAccountStatus());
				statement.setInt(4, users.getGroups().getGroupNumber());
				statement.setInt(5, users.getUserNumber());
			}
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
	
}