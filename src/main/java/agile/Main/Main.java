package agile.Main;

import agile.Dao.Database;
import agile.Entity.Flight;
import agile.Exception.Exception;
import agile.Service.ServiceImpl;

import java.util.Scanner;

//Added a Main class
public class Main {

	static Scanner sc = new Scanner (System.in);
	static ServiceImpl service = new ServiceImpl();
	static Database db = new Database();
	static int count = 0;
	
	public static void main (String args[]) {
		Database.initDB();
            adminLogin();
	}
		
	public static void adminLogin() {
        System.out.println("Welcome Admin. Enter credentials \n ");
        System.out.println("Enter your username:");
        String username = sc.next();
        System.out.println("Enter your password:");
        String password = sc.next();
        try {
            if (service.login(username, password)) {
                System.out.println("Login Successful \n");
                adminPanel();
            } else {
                adminLogin();
          }
        } catch (Exception ex) {
            System.out.println("Error detected:---->" + ex.getMessage());
            adminLogin();
        }

    }
	
	   public static void adminPanel() {
	        System.out.println("Please select an option \n ");
	        System.out.println("1.Add Record \n---------------\n ");
	        System.out.println("2.Update Record\n---------------\n ");
	        System.out.println("3.Find Record \n---------------\n ");
	        System.out.println("4.Delete Record\n---------------\n ");
	        System.out.println("5.Logout \n---------------\n");

	        int choice = sc.nextInt();
	        if (choice == 1) {
	            addFlightRecord();
	        } else if (choice == 2) {
	            updateFlightRecord();
	        } else if (choice == 3) {
	            searchFlightRecord();
	        } else if (choice == 4) {
	            deleteFlightRecord();
	        } else if (choice == 5) {
	            logOut();
	        } else {
	        	System.out.println("-------------------");
	            System.out.println("Please select one of the option above \n");
	            adminPanel();
	        }

	    }
	   
	   public static void addFlightRecord() {
	        System.out.println("Enter details \n --------------");
	        System.out.println("Enter Name \n");
	        String name = sc.next();
	        System.out.println("Enter Origin Address \n");
	        String origin = sc.next();
	        System.out.println("Enter Destination Address \n");
	        String destination = sc.next();
	        

	        Flight flight = new Flight();
	        flight.setName(name);
	        flight.setOrigin(origin);
	        flight.setDestination(destination);
	    
	        try {
	            if (service.addFlightRecord(flight, db)) {
	                System.out.println("\n Record created \n");
	                adminPanel();

	            }
	        } catch (Exception ex) {
	            System.out.println("|---------------|");
	            System.out.println(ex.getMessage());
	            adminPanel();
	        }

	    }
	   
	   public static void updateFlightRecord() {
	        System.out.println("Enter an Id to update record\n");
	        int id = sc.nextInt();
	        System.out.println("Enter name \n");
	        String name = sc.next();
	        System.out.println("Enter origin address \n");
	        String origin = sc.next();
	        System.out.println("Enter destination address \n");
	        String destination = sc.next();
	       
	        Flight flight = new Flight();
	        flight.setId(id);
	        flight.setName(name);
	        flight.setOrigin(origin);
	        flight.setDestination(destination);

	        try {
	            if (service.updateFlightRecord(flight, db)) {
	                System.out.println("--- Record updated successfully \n");
	                adminPanel();
	            }

	        } catch (Exception ex) {
	            System.out.println("\n " + ex.getMessage() + "\n");
	            adminPanel();
	        }
	    }
	   
	   public static void searchFlightRecord() {
	        System.out.println("Enter an Id to get flight record detail\n");
	        int id=sc.nextInt();
	        try{
	            System.out.println(service.searchFlightRecords(id,db));
	            adminPanel();
	        }
	        catch (Exception ex){
	            System.out.println("\n " + ex.getMessage() + "\n");
	            adminPanel();
	        }

	    }
	   
	   public static void deleteFlightRecord() {
	        System.out.println(" \n Delete Record? y for Yes and n for No \n");
	        String choice= sc.next();
	        if(choice.equalsIgnoreCase("y")) {
	            System.out.println(" \n Provide Flight Id\n ");
	            int id = sc.nextInt();
	            try{
	               service.deleteFlightRecord(id,db);
	               System.out.println("Record deleted successfully");
	               adminPanel();
	            }
	            catch (Exception ex){
	                System.out.println(" \n " + ex.getMessage() + "\n ");
	                adminPanel();
	            }
	        }
	        else if(choice.equalsIgnoreCase("n")){
	            adminPanel();
	        }
	        else{
	            System.out.println(" \n Please Enter y or n \n ");
	            deleteFlightRecord();
	        }
	    }
	   
	    public static void logOut() {

            System.out.println("Enter username");
            String choice = sc.next();
            if (service.logout(choice)) {
                System.out.println("Log out? y for Yes and n for No");
                String choice1 = sc.next();
                if (choice1.equalsIgnoreCase("y")) {
                    adminLogin();
                } else if (choice1.equalsIgnoreCase("n")) {
                    adminPanel();
                }
	            
	        } 
	    }
}
