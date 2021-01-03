package agile;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;


import agile.Dao.Database;
import agile.Entity.Flight;
import agile.Exception.Exception;
import agile.Service.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class addRecordTest {
	ServiceImpl service = new ServiceImpl();
		
	 /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
    public void addFlightRecord() throws Exception {
        Flight flight = new Flight(1, "Niall Murray", "Ireland","Nigeria");
        Database db = mock(Database.class);

        Throwable exception = assertThrows(
                Exception.class, () -> {
                    service.addFlightRecord(flight, db);
                }
        );
        assertEquals("Invalid name", exception.getMessage());
    }
    
    @Test
    public void addFlightRecord1() throws Exception {
        Flight flight = new Flight(2, "Niall", "IrelandEnglandWales","Nigeria");
        Database db = mock(Database.class);

        Throwable exception = assertThrows(
                Exception.class, () -> {
                    service.addFlightRecord(flight, db);
                }
        );
        assertEquals("Please specify a valid origin address", exception.getMessage());
    }
    
    @Test
    public void addFlightRecord2() throws Exception {
        Flight flight = new Flight(2, "Niall", "Ireland","NigeriaGhanaMorroco");
        Database db = mock(Database.class);

        Throwable exception = assertThrows(
                Exception.class, () -> {
                    service.addFlightRecord(flight, db);
                }
        );
        assertEquals("Please specify a valid destination address", exception.getMessage());
    }//
}
