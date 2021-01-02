package agile.Dao;

import agile.Entity.Flight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

	 private static  Connection con;
	 private static Statement stmt;
	 private static ResultSet rs;
	 
	 public static void initDB() {
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 String url = "jdbc:mysql://localhost:3306/agile_db";
			 con = DriverManager.getConnection(url, "root", "Housing$007");
			 stmt = con.createStatement();
		 }catch (Exception ex) {
			 System.out.println("Database connection failed");
		 }
	 }
	 
	 public boolean addFlightRecord(Flight flight) {
		 String query = "INSERT INTO Flighttable VALUES("+null+",'" + flight.getName() + "','" + flight.getOrigin() + "','" + flight.getDestination()+"');";
		
		 try {
			 stmt.executeUpdate(query);
			 return true;
		 } catch(Exception ex) {
			 System.out.println(ex.getMessage());
		 }
		 return false;
	 }
	 
	 public boolean updateFlightRecord(Flight flight) {
		 String query = "UPDATE Flighttable SET name ='" + flight.getName() + "', origin = '" + flight.getOrigin() + "', destination = '" + flight.getDestination()+ "' WHERE id='"+ flight.getId()+"';";
		 try {
			 stmt.executeUpdate(query);
			 return true;
		 }catch (Exception ex) {
			 System.out.println(ex.getMessage());
		 }
		 return false;
	 }
	 
	 public boolean deleteFlightRecord(int id) {
		 String query = "DELETE FROM Flighttable WHERE id='"+id+"';";
		 
		 try {
			 stmt.executeUpdate(query);
			 return true;
		 }catch(Exception ex) {
			 System.out.println(ex.getMessage());
		 }
		 return false;
	 }
	 
	 public Flight findFlightRecord(int id) {
		 Flight flight = new Flight();
		 String name = ""; String origin =""; String destination = "";
		 String query = "SELECT * FROM Flighttable WHERE id ="+id+"";
		 
		 try {
			 rs = stmt.executeQuery(query);
			 while(rs.next()) {
				 name = rs.getString(2);
				 origin = rs.getString(3);
				 destination = rs.getString(4);
			 }
			 flight.setName(name);
			 flight.setDestination(destination);
			 flight.setOrigin(origin);
					 
		 }catch (Exception ex) {
			 System.out.println(ex.getMessage());
		 }
		 return flight;
		 
	 }
	 
	 public boolean flightRecordExists(int id) {
		 if(findFlightRecord(id).getName().trim().matches("")) {
			 return false;
		 }else {
			 return true;
		 }
	 }
}
