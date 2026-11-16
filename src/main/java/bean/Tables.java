package bean;

import java.time.LocalDateTime;

public class Tables implements java.io.Serializable {
	
	private int tableNumber;
	private String tableType;
	private String tableStatus;
	private LocalDateTime temporaryEndTime;

	
	public int getTableNumber() {
		return tableNumber;
	}

	public String getTableType() {
		return tableType;
	}
	
	public String getTableStatus() {
		return tableStatus;
	}
	
	public LocalDateTime getTemporaryEndTime() {
		return temporaryEndTime;
	}
	
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	
	public void setTableStatus(String tableStatus) {
		this.tableStatus = tableStatus;
	}
	
	public void setTemporaryEndTime(LocalDateTime temporaryEndTime) {
		this.temporaryEndTime = temporaryEndTime;
	}

}