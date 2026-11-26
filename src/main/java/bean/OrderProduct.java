package bean;

public class OrderProduct {

    private String productName;  
    private int quantity;        
    private int subtotal;        

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public int getSubtotal() {
        return subtotal;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
