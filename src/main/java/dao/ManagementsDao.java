package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import bean.Managements;


public class ManagementsDao extends Dao {
	//設定を作成  設定のプリセットは考えていないので1件のみを想定している 初期は設定番号は1
	public boolean createSetting() throws Exception {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		int count = 0;
		try {
			statement = connection.prepareStatement(
					"insert into managements(setting_number,system_start_time,"
					+ "system_end_time,reservation_duration) value(?,?,?,?)");
			statement.setInt(1, 1);
			statement.setTime(2, java.sql.Time.valueOf("12:00:00"));
			statement.setTime(3, java.sql.Time.valueOf("14:00:00"));
			statement.setInt(4, 30);
			
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

	//設定を取得 設定番号1限定の処理です
	
	public Managements get() throws Exception {
		Managements manage = new Managements();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(
					"select * from managements where setting_number=?");
			statement.setInt(1, 1);
			ResultSet rSet = statement.executeQuery();
			
			if (rSet.next()) {
				manage.setSettingNumber(rSet.getInt("setting_number"));
				Time time = rSet.getTime("system_start_time");
				manage.setSystemStartTime(time != null ? time.toLocalTime() : null);
				time = rSet.getTime("system_end_time");
				manage.setSystemEndTime(time != null ? time.toLocalTime() : null);
				manage.setReservationDuration(rSet.getInt("reservation_duration"));
			} else {
				manage = null;
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
		return manage;
	}
	
//時間設定の更新
	
	//開始
	
	//終了
	
	//利用
	
	
}