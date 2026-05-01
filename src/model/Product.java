package model;

public class Product {
    private int productID;
    private NumeProd nume;
    private float price;
    private int stockQuantity;

    public Product() { }

    public Product(int productID, NumeProd nume, float price, int stockQuantity) {
        this.productID = productID;
        this.nume = nume;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
    
    public void setNume(NumeProd nume) {
        this.nume = nume;
    }

    public String getProductDetails() {
        return "ID: " + productID + " | Nume: " + nume + 
        	" | Preț: " + price + " | Stoc: " + stockQuantity + 
        	" | Valoarea totală din depozit: " + getTotalStockValue();
    }

    public float getTotalStockValue() {
        return this.price * this.stockQuantity;
    }

    public void updatePrice(float newPrice) {
        this.price = newPrice;
    }
    
    public void modifyPrice(float quantity) {
        this.price += quantity;
    }

    public void modifyStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public float getPrice() { 
    	return price; 
    }
    
    public NumeProd getNume() { 
    	return nume; 
    }
    
    public int getStockQuantity() { 
    	return stockQuantity; 
    }
    
    public int getProductID() { 
    	return productID; 
    }
}