
package bean;

import java.util.List;

public class OrderInfo {

    private int userNumber;          
    private int groupNumber;
    private int orderNumber;                
    private int totalAmount;                
    private List<OrderProduct> products;    

    public int getUserNumber() {
        return userNumber;
    }
    
    public int getGroupNumber() {
        return groupNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    
    public int getTotalAmount() {
        return totalAmount;
    }
    
    public List<OrderProduct> getProducts() {
        return products;
    }
    
    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }
    
    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setProducts(List<OrderProduct> products) {
        this.products = products;
    }
}
