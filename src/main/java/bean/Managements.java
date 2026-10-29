package bean;

import java.time.LocalTime;

public class Managements implements java.io.Serializable {
	
	private int setting_number;
	private LocalTime system_start_time;
	private LocalTime system_end_time;
	private int reservation_duration;
	
	public int getSettingNumber() {
		return setting_number;
	}

	public LocalTime getSystemStartTime() {
		return system_start_time;
	}
	
	public LocalTime getSystemEndTime() {
		return system_end_time;
	}
	
	public int getReservationDuration() {
		return reservation_duration;
	}
	
	public void setSettingNumber(int setting_number) {
		this.setting_number = setting_number;
	}
	
	public void setSystemStartTime(LocalTime system_start_time) {
		this.system_start_time = system_start_time;
	}
	
	public void setSystemEndTime(LocalTime system_end_time) {
		this.system_end_time = system_end_time;
	}
	
	public void setReservationDuration(int reservation_duration) {
		this.reservation_duration = reservation_duration;
	}
	
}