package bean;

import java.time.LocalTime;

public class Reservations implements java.io.Serializable {
	
	private int reservation_number;
	private Groups groups;
	private Tables tables;
	private LocalTime time_limit;
	
	public int getReservationNumber() {
		return reservation_number;
	}

	public Groups getGroups() {
		return groups;
	}
	
	public Tables getTables() {
		return tables;
	}
	
	public LocalTime getTimeLimit() {
		return time_limit;
	}
	
	public void setReservationNumber(int reservation_number) {
		this.reservation_number = reservation_number;
	}
	
	public void setGroups(Groups groups) {
		this.groups = groups;
	}
	
	public void setTables(Tables tables) {
		this.tables = tables;
	}
	
	public void setTimeLimit(LocalTime time_limit) {
		this.time_limit = time_limit;
	}
	
}