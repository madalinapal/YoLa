package model;

public class Admin extends User {

    private String firstName;
    private String lastName;


    public Admin() {
        super();
    }
    
    public Admin(int ID, String uname, String pass, String mail, String firstName, String lastName) {
        super(ID, uname, pass, mail);
        this.firstName = firstName;
        this.lastName = lastName;
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

    public void addProduct() {
        System.out.println("Product added to stock by admin: " + getUsername());
    }

    public void prepareOrder() {
        System.out.println("Order is processing...");
    }

    public void manageUserData() {
        System.out.println("Managing users...");
    }

  
}