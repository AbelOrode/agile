package agile;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import agile.Dao.Database;
import agile.Entity.Flight;
import agile.Service.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class searchRecordsTest {
ServiceImpl service = new ServiceImpl();
	
	/**
	 * Rigorous Test :-)
	 */
	
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}
	
	 @Test
	    public void searchFlightRecords(){
	        Flight flight = new Flight(100, "Abel", "Texas", "Hawaii");
	        Database db = mock(Database.class);
	        when(db.flightRecordExists(100)).thenReturn(true);
	        when(db.findFlightRecord(100)).thenReturn(flight);
	        String result="Name: "+ flight.getName()+"\n Origin Address: "+flight.getOrigin()+"\n Destination Address: "+flight.getDestination()+"\n";


	        assertEquals(result,service.searchFlightRecords(100,db));
	    }
}
