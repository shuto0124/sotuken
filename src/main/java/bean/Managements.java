package bean;

import java.time.LocalTime;

public class Managements implements java.io.Serializable {
	
	private int settingNumber;
	private LocalTime systemStartTime;
	private LocalTime systemEndTime;
	private int reservationDuration;
	
	public int getSettingNumber() {
		return settingNumber;
	}

	public LocalTime getSystemStartTime() {
		return systemStartTime;
	}
	
	public LocalTime getSystemEndTime() {
		return systemEndTime;
	}
	
	public int getReservationDuration() {
		return reservationDuration;
	}
	
	public void setSettingNumber(int settingNumber) {
		this.settingNumber = settingNumber;
	}
	
	public void setSystemStartTime(LocalTime systemStartTime) {
		this.systemStartTime = systemStartTime;
	}
	
	public void setSystemEndTime(LocalTime systemEndTime) {
		this.systemEndTime = systemEndTime;
	}
	
	public void setReservationDuration(int reservationDuration) {
		this.reservationDuration = reservationDuration;
	}
	
}