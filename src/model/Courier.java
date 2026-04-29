package model;

public class Courier extends User {
    private String firstName;
    private String lastName;
    private int phoneNumber;

    public Courier() {
        super();
    }

    public Courier(int ID, String uname, String pass, String mail, String firstName, String lastName, int phoneNumber) {
        super(ID, uname, pass, mail);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public void takeOrder(Order order, Customer customer) {
        String mesaj = "Curierul " + this.getLastName() + 
                       " a luat comanda cu id-ul " + order.getOrderID() + 
                       " și o duce la clientul cu numele " + customer.getFirstName() + 
                       " " + customer.getLastName();
        
        System.out.println(mesaj);
    }
    
    public String getCourierDetails() {
        return "Curier: " + firstName + " " + lastName + 
               " | Telefon: " + phoneNumber + 
               " | Username din sistem: " + getUsername(); 
    }

    public void deliverAndCollectPayment(Order order) {
        System.out.println("Order" + order.getOrderID() +  "delivered and payment collected by " + lastName);
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
    
    public int getPhoneNumber() { 
    	return phoneNumber; 
    }
    
    public void setPhoneNumber(int phoneNumber) { 
    	this.phoneNumber = phoneNumber; 
    }
}