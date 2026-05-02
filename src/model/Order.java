package model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private int orderID;
    private Map<Product, Integer> products; 
    private String status;
    
    private Customer customer;
    private Courier courier;
    private Admin admin;

    public Order() {
        this.products = new HashMap<>();
        this.status = "Pending";
    }

    public Order(int orderID) {
        this.orderID = orderID;
        this.products = new HashMap<>();
        this.status = "Pending";
    }
    
    public Order(Order o) {
        this.orderID = o.orderID;
        this.status = o.status;
        this.products = new HashMap<>(); 
        for(Map.Entry<Product, Integer> item : o.products.entrySet()) {
            this.products.put(item.getKey(), item.getValue());
        }
        this.customer = o.customer; 
        this.courier = o.courier;
        this.admin = o.admin;
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}