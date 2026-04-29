package model;

public class User {
	int UserID;
	String username;
	String password;
	String email;
	
	public User(int ID, String uname, String pass, String mail) {
		UserID = ID;
		username = uname;
		pass = password;
		email = mail;
	}
}
