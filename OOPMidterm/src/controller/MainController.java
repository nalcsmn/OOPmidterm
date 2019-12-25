package controller;
import database.Database;

public class MainController {
	
	private Database database;
	private static MainController controller = null;
	String uname, pword;
	
	
	private MainController() {
		
		database = Database.getDatabase();
	}
	
	public static MainController getMainController() {
		
		if(controller == null)
			controller = new MainController();
		
		return controller;
	}
	
	public boolean verifyLogin(String username, String password) {
		
		//Goes to database to see if user input is true or false
		 if(database.verifyLogin(username, password)) {
			uname = username;
			pword = password;
		 }
		 
		 //will return true if username and password is in the List else false
		 return database.verifyLogin(username, password);
			
	}

	public boolean addPerson(String username, String password) {
		//will return true if person added successfully(only the username and password)
		return database.addPerson(username, password);
	}
	
	public boolean addDetails(String firstname, String middlename, String lastname, String address, int number, int age) {
		//Will return true if the user details are added successfully(i.e all other information)
		return database.addDetails(this.uname, firstname, middlename, lastname, address, number, age);
	}
	
	public void data() {
		//This is the logic for the data manipulation for the whitespace + pyimid in database
		database.data(uname);
	}
}
