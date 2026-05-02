package model;
import java.util.ArrayList;

public class Courier extends User {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private ArrayList<Order> orders;

    public Courier() {
        super();
    }

    public Courier(int ID, String uname, String pass, String mail, 
    		String firstName, String lastName, String phoneNumber, ArrayList<Order> orders) {
        super(ID, uname, pass, mail);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.orders = new ArrayList<>();
        if (orders != null) {
            for (Order item : orders) {
                this.orders.add(new Order(item));
            }
    	}
    }
    
    public Courier (Courier c) {
    	firstName = c.firstName;
    	lastName = c.lastName;
    	phoneNumber = c.phoneNumber;
    	this.orders = new ArrayList<>();
        if (c.orders != null) {
            for (Order item : c.orders) {
                this.orders.add(new Order(item));
            }
    	}
    }

    public void takeOrder(Order order, Customer customer) {
        String mesaj = "Curierul " + this.getLastName() + 
                       " a luat comanda cu id-ul " + order.getOrderID() + 
                       " și o duce la clientul cu numele " + customer.getFirstName() + 
                       " " + customer.getLastName();
        
        System.out.println(mesaj);
    }
    
    public void getCourierDetails() {
    	afisare();
        System.out.println(" | Curier: " + firstName + " " + lastName + 
               " | Telefon: " + phoneNumber + 
               " | Username din sistem: " + getUsername()); 
    }

    public void deliverAndCollectPayment(Order order) {
        System.out.println("Order " + order.getOrderID() +  " delivered and payment collected by " + lastName);
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
    
    public String getPhoneNumber() { 
    	return phoneNumber; 
    }
    
    public void setPhoneNumber(String phoneNumber) { 
    	this.phoneNumber = phoneNumber; 
    }
}