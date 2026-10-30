package bean;

import java.time.LocalTime;

public class Reservations implements java.io.Serializable {
	
	private int reservationNumber;
	private Groups groups;
	private Tables tables;
	private LocalTime timeLimit;
	
	public int getReservationNumber() {
		return reservationNumber;
	}

	public Groups getGroups() {
		return groups;
	}
	
	public Tables getTables() {
		return tables;
	}
	
	public LocalTime getTimeLimit() {
		return timeLimit;
	}
	
	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}
	
	public void setGroups(Groups groups) {
		this.groups = groups;
	}
	
	public void setTables(Tables tables) {
		this.tables = tables;
	}
	
	public void setTimeLimit(LocalTime timeLimit) {
		this.timeLimit = timeLimit;
	}
	
}