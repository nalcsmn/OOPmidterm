package database;
import java.util.LinkedList;

import model.Person;
public class Database {

	//Create a list of Person classes
	private LinkedList<Person> personlist;
	private static Database database = null;
	private Person person;
	
	
	private Database(){
		
		//initialize list
		personlist = new LinkedList<Person>();
		//add random people to list in old users method
		oldUsers();
	}
	
	public static Database getDatabase() {
		
		if(database == null)
			database = new Database();
		
		return database;
	}
	
	public boolean verifyLogin(String username, String password) {
		
		boolean isCorrect = false;
		
		for(Person ee: personlist) 
			if(username.equals(ee.getUsername())) 	
				isCorrect = true;
		
		return isCorrect;
		
	}
	
	public boolean addPerson(String username, String password) {
		//create new person
		person = new Person();
		
		//set the username and password as the user input
		person.setUsername(username);
		person.setPassword(password);
		
		//add them to the person list
		personlist.add(person);
		
		//return true when done
		return true;

	}
	
	public boolean addDetails(String username, String firstname, String middlename, String lastname, String address, int number, int age) {
		
		boolean isAdded = false;
		//loop through my entire list of person
		for(Person ee: personlist)
			//if the user inputs username is the same as anything in my list get that user information
			if(username.equals(ee.getUsername())) {
			
				//set that user with new user input
				ee.setFirstname(firstname);
				ee.setMiddlename(middlename);
				ee.setLastname(lastname);
				ee.setAddress(address);
				ee.setNumber(number);
				ee.setAge(age);
				
				//set added as true when successful
				isAdded = true;
			}
		
		//return true when done
		return isAdded;
	}
	
	public void data(String uname) {
		
		String totalPrime = "";
		double total = 0;

		//in my person list
		for(Person ee: personlist)
			//if user inputs usernmae matches in my list
			if(uname.equals(ee.getUsername())) {
			
				//combines all the names into one string
				String Fullname = ee.getFirstname()	+ " " +  ee.getMiddlename() + " " + ee.getLastname();
				//replaces all spaces with nothing i.e eliminates spaces
				String fullname = Fullname.replaceAll(" ", "");
				
				//gets the full length of fullname and address
				int fullSize = fullname.length() + ee.getAddress().replaceAll(" ", "").length();
				
				//First condition
				if(fullSize > ee.getAge() * 2) {
					for(int i = 0; i < fullname.length(); i++) {
						
						
						//Checks each letter for the correct information and will add them to total
						
						if(fullname.charAt(i) == ' ') {
							total = total + 1;
							System.out.println("whitespace 1 "+ fullname.charAt(i)+ " " + total);
						      System.out.println();


						}else if(fullname.charAt(i) >= 'A' && fullname.charAt(i) <= 'Z') {
							total = total + 3;
							System.out.println("Uppercase 3 "+ fullname.charAt(i)+ " " + total);
						      System.out.println();


							
						}else if(fullname.charAt(i) >= 'a' && fullname.charAt(i) <= 'z') {
							total = total + 4;
							System.out.println("lowercase 4 "+ fullname.charAt(i) + " "+ total);
						      System.out.println();


						}
						
						if(fullname.charAt(i) == ' ') {
							if(i+1  < fullname.length()) {
								if(fullname.charAt(i+1) >= 'a' && fullname.charAt(i+1) <= 'z') {
									total = total + 3;
									System.out.println("whitespace lowercase 3 " + fullname.charAt(i)+ " "+ total);
								      System.out.println();


								}
							}
						}
							
						if(fullname.charAt(i) >= 'a' && fullname.charAt(i) <= 'z') {
							if(i+1 < fullname.length()) {
								if(fullname.charAt(i+1) >= 'A' && fullname.charAt(i+1) <= 'Z') {
									total = total + 1;
									
									System.out.println("lowercase uppercase " + fullname.charAt(i) + " "+ total);
								      System.out.println();


								}
							}
						}
						if(fullname.charAt(i) >= 'a' && fullname.charAt(i) <= 'z') {
							if(i+1 < fullname.length()) {
								if(fullname.charAt(i+1) >= 'a' && fullname.charAt(i+1) <= 'z') {
									total = total + 0.5;
									
									System.out.println("lowercase lowercase .5 "+ fullname.charAt(i)+ " " + total);
								      System.out.println();


								}
							}	
						}
							
						if(fullname.charAt(i) >= 'A' && fullname.charAt(i) <= 'Z') {
							if(i+1  < fullname.length()) {
								if(fullname.charAt(i+1) >= 'A' && fullname.charAt(i+1) <= 'Z') {
									total = total + 3;
									
									System.out.println("upper upper 3 "+ fullname.charAt(i)+ " " + total);
								      System.out.println();


								}
							}
						}
							
						if(fullname.charAt(i) >= 'A' && fullname.charAt(i) <= 'Z') {
							if(i+1 < fullname.length()) {
								if(fullname.charAt(i+1) == ' ') {
									total = total + 2;
									System.out.println("upper whitespace 2 "+ fullname.charAt(i) + " "+ total);
								      System.out.println();


								}
							}
						}
							
						if(fullname.charAt(i) == ' ') {
							if(i+1  < fullname.length()) {
								if(fullname.charAt(i+1) >= 'A' && fullname.charAt(i+1) <= 'Z') {
									total = total + 1;
									
									System.out.println("whitespace upper 1 "+ fullname.charAt(i) + " "+ total);
								      System.out.println();


								}
							}	
						}	
					}
					///////////////////////////////////////////////////////////////////////////////////
					//2nd condition 
				}else {
					//checks if number is prime
					if((ee.getAge() + ee.getNumber()) % 2 == 0) {
						int num = 0;
						
						for(int i = 0; i < ee.getAge() + ee.getNumber(); i++) {
							
							
							for (i = 1; i <= ee.getAge() + ee.getNumber(); i++){ 		 		  
						        
								int counter=0; 	
								
						         for(num = i; num>=1; num--){
						        	 if(i%num==0){
						        		 
						        		 counter = counter + 1;
						        	 }
						         }
							 if (counter ==2){
							    totalPrime = totalPrime + i + " ";
							 }	
						   }	
						      System.out.println("Prime numbers from 1 to n are :");
						      System.out.println(totalPrime);

									
						}
						//3rd condition 
					}else {
						 
						//checks if number is composite
						int sum = ee.getAge() + ee.getNumber();
						
						for(int i = 0; i < sum; i++) {
							
							 if (i <= 1)  
							          
							 if (i <= 3)  
							  
							 if (i % 2 == 0 || i % 3 == 0) {
							 }
							  
					        for (int z = 2; z * z <= i; z = z + 1) 
					            if (i % z == 0 || i % (z + 2) == 0) {
								      System.out.println("IS Composite " + i);
								      break;
					            } 	  
						}

						
					}
					//Final displays primyid
					 int rows = 5, k = 0;
				        for(int i = 1; i <= ee.getAge() + ee.getNumber(); ++i, k = 0) {
				            for(int space = 1; space <= ee.getAge() + ee.getNumber() - i; ++space) {
				                System.out.print("  ");
				            }
				            while(k != 2 * i - 1) {
				                System.out.print("* ");
				                ++k;
				            }
				            System.out.println();
				        }
				}
			}
	}
	
	private void oldUsers() {
		
		//Creates and adds random users to list
		Person a = new Person();
		
		a.setFirstname("James");
		a.setMiddlename("Allen");
		a.setLastname("Maye");
		a.setAddress("3043 Ludlow Roads");
		a.setAge(25);
		a.setNumber(45);
		a.setUsername("Arkarian");
		a.setPassword("12345");
		
		personlist.add(a);
		
		Person b = new Person();
		
		b.setFirstname("John");
		b.setMiddlename("Carlo");
		b.setLastname("Bitay");
		b.setAddress("A Random Street Address 122234");
		b.setAge(19);
		b.setNumber(69);
		b.setUsername("Bits");
		b.setPassword("12qwaszx");
		
		personlist.add(b);
		
		

		System.out.println("kk");
		
		
		
		
	}
}
