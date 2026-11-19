package bean;

public class Groups implements java.io.Serializable {
	
	private int groupNumber;
	private int memberCount;
	private int representativeNumber;
	
	public int getGroupNumber() {
		return groupNumber;
	}

	public int getMemberCount() {
		return memberCount;
	}
	
	public int getRepresentativeNumber() {
		return representativeNumber;
	}
	
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}
	
	public void settRepresentativeNumber(int representativeNumber) {
		this.representativeNumber = representativeNumber;
	}
}