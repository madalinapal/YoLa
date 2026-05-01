package model;

public class Customer extends User {
	

	private String firstName;
    private String lastName;
    private String adress;
    private String phoneNumber;

    
    public Customer() {
        super(); 
    }
    
    public Customer(int ID, String uname, String pass, String mail, 
            String firstName, String lastName, String adress, String phoneNumber) {
	
	super(ID, uname, pass, mail);
	
	this.firstName = firstName;
	this.lastName = lastName;
	this.adress = adress;
	this.phoneNumber = phoneNumber;
	}
    
    public void getCustomerDetails() {
    	afisare();
        System.out.println(" | Prenume: " + firstName + " | Nume: " + lastName +
        		" | Adresa: " + adress + " | Nr. de telefon:  " + phoneNumber );
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
    
    public void setFirstName(String FN) {
    	firstName = FN;
    }
    
    public void setLastName(String LN) {
    	lastName = LN;
    }
    
    public void setAdress(String add) {
    	adress = add;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.matches("07\\d{8}")) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid phone number.");
        }
    }
}
