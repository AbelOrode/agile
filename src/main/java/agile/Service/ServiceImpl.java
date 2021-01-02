package agile.Service;


import agile.Dao.Database;
import agile.Entity.Flight;
import agile.Exception.Exception;


public class ServiceImpl implements Service{
	
	
	public Boolean login(String name, String password) {
		  boolean res = false;
	        if (!name.equals("Abel")) {
	            throw new Exception("Username is invalid");
	        } else if (!password.equals("Housing$007")) {
	            throw new Exception("Password is invalid");
	        } else if (name.equals("Abel") && password.equals("Housing$007")) {
	            res = true;

	        }
	        return res;
	}
	
	 public Boolean logout(String name) {
	        boolean res = false;
	        if (!name.equals("Abel")) {
	            throw new Exception("Invalid Username");
	        } else {
	            res = true;
	            return res;
	        }
	    }
	 
	  public Boolean addFlightRecord(Flight flight,Database db) {
	        boolean res = false;
	        if(db.flightRecordExists(flight.getId())){
	            throw new Exception("ID Exists");
	        }
	        else if (flight.getName().length() < 2 || flight.getName().length() > 10) {
	            throw new Exception("Invalid name");
	        } else if (flight.getOrigin().length() < 2 || flight.getOrigin().length() > 15) {
	            throw new Exception("Please specify a valid origin address");
	        } else if (flight.getDestination().length() < 2 || flight.getDestination().length() > 15) {
	            throw new Exception("Please specify a valid destination address");
	        } 
	        else{
	            res=true;
	            db.addFlightRecord(flight);
	        }

	        return res;
	    }
	  
	  public String searchFlightRecords(int id,Database db) {
	        String result="";
	        if(!db.flightRecordExists(id)){
	            //System.out.println(false);
	            throw new Exception("Flight record does not exists");
	        }
	        else{
	            Flight flight= db.findFlightRecord(id);
	            result="Name: "+flight.getName() + "\n Origin Address: " + flight.getOrigin() + "\n Destination Address: "+ flight.getDestination()+"\n";	
	           
	        }
	        return result;
	    }
	  
	    public Boolean updateFlightRecord(Flight flight,Database db) {

	        boolean result = false;
	        if(!db.flightRecordExists(flight.getId())){
	            throw new Exception("Records exists!");
	        }
	        else if (flight.getName().length() < 2 || flight.getName().length() > 10) {
	            throw new Exception("Name not valid. Min length 2 | Max Length 10");
	        } else if (flight.getOrigin().length() < 2 || flight.getOrigin().length() > 15) {
	            throw new Exception("Origin address not valid. Min length 2 | Max Length 15");
	        } else if (flight.getDestination().length() < 2 || flight.getDestination().length() > 20) {
	            throw new Exception("Destination address not valid. Min length 2 | Max Length 20");
	        } 
	        else{
	            result=true;
	            db.updateFlightRecord(flight);
	        }
	        return result;
	    }
	    
	    public Boolean deleteFlightRecord(int id,Database db) {
	        boolean result=false;
	        if(!db.flightRecordExists(id)){
	      
	            throw new Exception("Record doesnt exist");
	        }
	        else{
	            result=true;
	            db.deleteFlightRecord(id);
	        }
	        return result;
	    }

		
}
