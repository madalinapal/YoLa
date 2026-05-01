package model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private int orderID;
    private Map<Product, Integer> products; 
    private String status;

    public Order(int orderID) {
        this.orderID = orderID;
        this.products = new HashMap<>();
        this.status = "Pending";
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
        product.modifyStock(-quantity);
    }

    public float calculateTotal() {
        float total = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

   
    public void getOrderDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comanda ID: ").append(orderID).append(" | Status: ").append(status).append("\n");
        sb.append("Produse:\n");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            sb.append("- ").append(entry.getKey().getNume()) 
              .append(": ").append(entry.getValue()).append(" buc\n");
        }
        sb.append("Total de plată: ").append(calculateTotal());
        System.out.println(sb.toString());
    }

    
    public int getOrderID() { 
    	return orderID; 
    }
    
    public void setOrderID(int ordID) { 
    	this.orderID = ordID; 
    }
    
    public String getStatus() { 
    	return status; 
    }
    
    public void setStatus(String status) { 
    	this.status = status; 
    }
}