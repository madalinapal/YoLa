package model;

public class User {
	int UserID;
	String username;
	String password;
	String email;
	
	public User() {
		
	}
	
	public User(int ID, String uname, String pass, String mail) {
		UserID = ID;
		username = uname;
		pass = password;
		email = mail;
	}
	
	public void login() {
		String tipUtilizator = this.getClass().getSimpleName();
	    System.out.println(tipUtilizator + "-ul " + username + " s-a logat.");
    }

    public void logout() {
    	String tipUtilizator = this.getClass().getSimpleName();
        System.out.println(tipUtilizator + "-ul " + username + " s-a delogat.");
    }
    
    public String getUsername() {
    	return username;
    }
    
    public String getemail() {
    	return email;
    }
    
    public int getUserID() {
    	return UserID;
    }
    
    public void setUserID(int userID) { 
    	UserID = userID; 
    }
    
    public void setUsername(String username) { 
    	this.username = username; 
    }
    
    public void setPassword(String pass) { 
    	password = pass; 
    }
    
    public boolean isValid() {
        return username != null && !username.isEmpty() && email != null && email.contains("@");
    }
}
