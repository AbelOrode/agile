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
public class deleteRecordTest {
	ServiceImpl service = new ServiceImpl();
	
	/**
	 * Rigorous Test :-)
	 */
	
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}
	

    @Test
    public void deleteFlightRecord1(){
        Flight flight = new Flight(4,"Orode","Tunisia", "Algeria");
        Database db = mock(Database.class);
        when(db.flightRecordExists(4)).thenReturn(true);
        when(db.findFlightRecord(4)).thenReturn(flight);


        assertEquals(true,service.deleteFlightRecord(4,db) );
    }


}
