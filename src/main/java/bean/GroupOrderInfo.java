
package bean;

import java.util.List;

public class GroupOrderInfo {

    private int groupNumber;              
    private String usageTime;             
    private int memberCount;               
    private int totalAmount;               
    private String status;                 
    private List<OrderInfo> orders;        

    public int getGroupNumber() {
        return groupNumber;
    }
    
    public String getUsageTime() {
        return usageTime;
    }
    
    public int getMemberCount() {
        return memberCount;
    }
    
    public int getTotalAmount() {
        return totalAmount;
    }
    
    public String getStatus() {
        return status;
    }
    
    public List<OrderInfo> getOrders() {
        return orders;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setUsageTime(String usageTime) {
        this.usageTime = usageTime;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrders(List<OrderInfo> orders) {
        this.orders = orders;
    }
}
