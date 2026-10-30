package bean;

public class Groups implements java.io.Serializable {
	
	private int groupNumber;
	private int memberCount;
	
	public int getGroupNumber() {
		return groupNumber;
	}

	public int getMemberCount() {
		return memberCount;
	}
	
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}
}