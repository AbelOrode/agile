package agile;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import agile.Dao.Database;
import agile.Entity.Flight;
import agile.Exception.Exception;
import agile.Service.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class updateRecordTest {
	ServiceImpl service = new ServiceImpl();
	
	/**
	 * Rigorous Test :-)
	 */
	
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}
	
	 @Test
	    public void updateFlightRecord() throws Exception {
	        Flight flight = new Flight(1, "Johnson Andrew Mcabe", "Dublin", "Cork");
	        Database db = mock(Database.class);
	        when(db.flightRecordExists(flight.getId())).thenReturn(true);

	        Throwable exception = assertThrows(
	                Exception.class, () -> {
	                    service.updateFlightRecord(flight, db);
	                }
	        );
	        assertEquals("Name not valid. Min length 2 | Max Length 10", exception.getMessage());
	    }
	 
	 @Test
	    public void updateFlightRecord1() throws Exception {
	        Flight flight = new Flight(2, "Abel", "LimerickCorkClaire", "Dundark");
	        Database db = mock(Database.class);
	        when(db.flightRecordExists(flight.getId())).thenReturn(true);

	        Throwable exception = assertThrows(
	                Exception.class, () -> {
	                    service.updateFlightRecord(flight, db);
	                }
	        );
	        assertEquals("Origin address not valid. Min length 2 | Max Length 15", exception.getMessage());
	    }
	 
	 @Test
	    public void updateFlightRecord2() throws Exception {
	        Flight flight = new Flight(2, "Abel", "Limerick", "HungaryRussiaSingapore");
	        Database db = mock(Database.class);
	        when(db.flightRecordExists(flight.getId())).thenReturn(true);

	        Throwable exception = assertThrows(
	                Exception.class, () -> {
	                    service.updateFlightRecord(flight, db);
	                }
	        );
	        assertEquals("Destination address not valid. Min length 2 | Max Length 20", exception.getMessage());
	    }
}
