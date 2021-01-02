package agile.Service;

import agile.Dao.Database;
import agile.Entity.Flight;

public interface Service {
	Boolean login(String username, String password);
    Boolean logout(String username);
    Boolean addFlightRecord(Flight flight, Database db);
    String searchFlightRecords(int id,Database db);
    Boolean updateFlightRecord(Flight flight,Database db);
    Boolean deleteFlightRecord(int id,Database db);
}
