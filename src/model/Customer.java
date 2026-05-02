package model;

import java.util.ArrayList;

public class Customer extends User {
	
	private String firstName;
    private String lastName;
    private String adress;
    private String phoneNumber;
    private String status; // available, not home, rejects order
    private ArrayList<Order> orders;

    
    public Customer() {
        super(); 
        this.status = null;
    }
    
    public Customer(int ID, String uname, String pass, String mail, 
            String firstName, String lastName, String adress, String phoneNumber,
            ArrayList<Order> orders) {
	
		super(ID, uname, pass, mail);
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.orders = new ArrayList<>();
		if (orders != null) {
            for (Order item : orders) {
                this.orders.add(new Order(item));
            }
    	}
	}
    
    public Customer(Customer c) {
    	super(c);
    	firstName = c.firstName;
    	lastName = c.lastName;
    	adress = c.adress;
    	phoneNumber = c.phoneNumber;
    	this.orders = new ArrayList<>();
    	if (c.orders != null) {
            for (Order item : c.orders) {
                this.orders.add(new Order(item));
            }
    	}
    }
    
    public void getCustomerDetails() {
        afisare();
        System.out.println(" | Prenume: " + firstName + " | Nume: " + lastName +
                " | Adresa: " + adress + " | Nr. de telefon:  " + phoneNumber + " | Status: " + status);
    }
    
    public void createAccount() {
        System.out.println("Cont creat pentru clientul: " + firstName + " " + lastName);
    }

    public void placeOrder() {
        System.out.println("Comanda plasată cu succes de către " + firstName);
    }

    public String getFirstName() { 
    	return firstName; 
    }
    
    public String getLastName() { 
    	return lastName; 
    }
    
    public String getAddress() { 
    	return adress; 
    }
    
    public String getPhoneNumber() { 
    	return phoneNumber; 
    }
    
    public String getStatus() {
    	return status;
    }
    
    public void setFirstName(String FN) {
    	this.firstName = FN;
    }
    
    public void setLastName(String LN) {
    	this.lastName = LN;
    }
    
    public void setAdress(String add) {
    	this.adress = add;
    }
    
    public void setStatus(String status, Order order) {
        if (order != null && "Transporting order".equals(order.getStatus())) {
            this.status = status;
            System.out.println("Statusul clientului a fost setat la: " + status);
        } else {
            System.out.println("Eroare: Statusul clientului poate fi setat doar după ce comanda este în livrare (Transporting order).");
        }
    }
    
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.matches("07\\d{8}")) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid phone number.");
        }
    }
}
