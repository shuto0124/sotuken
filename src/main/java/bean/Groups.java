package bean;

public class Groups implements java.io.Serializable {
	
	private int group_number;
	private int member_count;
	
	public int getGroupNumber() {
		return group_number;
	}

	public int getMemberCount() {
		return member_count;
	}
	
	public void setGroupNumber(int group_number) {
		this.group_number = group_number;
	}
	
	public void setMemberCount(int member_count) {
		this.member_count = member_count;
	}
}