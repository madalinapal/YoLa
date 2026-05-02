package model;

public class Product {
    private int productID;
    private NumeProd nume;
    private float price;
    private int stockQuantity;
    
    private Admin admin; 

    public Product() { }

    public Product(int productID, NumeProd nume, float price, int stockQuantity) {
        this.productID = productID;
        this.nume = nume;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
    
    public Product(Product p) {
        this.productID = p.productID;
        this.nume = p.nume;
        this.price = p.price;
        this.stockQuantity = p.stockQuantity;
        this.admin = p.admin; 
    }
    
    public void setNume(NumeProd nume) {
        this.nume = nume;
    }

    public void getProductDetails() {
        System.out.println("ID: " + productID + " | Nume: " + nume + 
            " | Preț: " + price + " | Stoc: " + stockQuantity + 
            " | Valoarea totală din depozit: " + getTotalStockValue());
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
    
    public void setPrice(float prc) { 
        this.price = prc; 
    }
    
    public NumeProd getNume() { 
        return nume; 
    }
    
    public int getStockQuantity() { 
        return stockQuantity; 
    }
    
    public void setStockQuantity(int stock) { 
         this.stockQuantity = stock; 
    }
    
    public int getProductID() { 
        return productID; 
    }
    
    public void setProductID(int pID) { 
        this.productID = pID; 
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}