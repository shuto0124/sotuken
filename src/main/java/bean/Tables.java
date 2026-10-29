package bean;

public class Tables implements java.io.Serializable {
	
	private int table_number;
	private String table_type;
	private String table_status;

	
	public int getTableNumber() {
		return table_number;
	}

	public String getTableType() {
		return table_type;
	}
	
	public String getTableStatus() {
		return table_status;
	}
	
	public void setTableNumber(int table_number) {
		this.table_number = table_number;
	}
	
	public void setTableType(String table_type) {
		this.table_type = table_type;
	}
	
	public void setTableStatus(String table_status) {
		this.table_status = table_status;
	}
	

}