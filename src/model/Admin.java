package model;

import java.util.ArrayList;

public class Admin extends User {

    private String firstName;
    private String lastName;
    private ArrayList<Order> orders;

    public Admin() {
        super();
    }
    
    public Admin(int ID, String uname, String pass, String mail, 
    		String firstName, String lastName, ArrayList<Order> orders) {
        super(ID, uname, pass, mail);
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = new ArrayList<>();
        if (orders != null) {
            for (Order item : orders) {
                this.orders.add(new Order(item));
            }
    	}
    }
    
    public Admin(Admin a) {
    	super(a);
    	this.firstName = a.firstName;
    	this.lastName = a.lastName;
    	this.orders = new ArrayList<>();
    	if (a.orders != null) {
            for (Order item : a.orders) {
                this.orders.add(new Order(item));
            }
    	}
    	
    }
    public void receivePayment(Order order) {
        System.out.println("Admin " + this.getFirstName() + " a primit plata pentru comanda ID: " + order.getOrderID());
        order.setStatus("Delivered");
    }

    public void getAdminDetails() {
    	afisare();
        System.out.println(" | Prenume: " + firstName + " | Nume: " + lastName);
    }
    
    public String getFirstName() { 
    	return firstName; 
    }
    
    public void setFirstName(String firstName) { 
    	this.firstName = firstName; 
    }

    public String getLastName() { 
    	return lastName; 
    }
    
    public void setLastName(String lastName) { 
    	this.lastName = lastName; 
    }

    public void addProduct(Product p) {
        System.out.println("Product " + p.getNume() +  " added to stock by admin: " + getUsername());
    }

    public void prepareOrder() {
        System.out.println("Order is processing...");
    }

    public void manageUserData() {
        System.out.println("Managing users...");
    }
    
    // metoda care implementeaza logica din diagrama de activitati
    // returneaza true daca stocul este suficient si comanda este pregatita
    public boolean processOrder(Order order, Product product, int requestedQuantity) {
       // verific stocul
       if (product.getStockQuantity() >= requestedQuantity) {
           // destul stoc
           order.addProduct(product, requestedQuantity);
           order.setStatus("Finished"); 
           return true;
       } else {
           // nu e destul stoc
           order.setStatus("Cancelled - Notify Customer"); 
           System.out.println("Request supply: product " + product.getNume() + " , quantity " + requestedQuantity);
           return false;
       }
   }

  
}