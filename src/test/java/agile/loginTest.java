package agile;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import agile.Service.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class loginTest {
ServiceImpl service = new ServiceImpl();
	
	/**
	 * Rigorous Test :-)
	 */
	
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	   @Test
	    public void login01() {

	        Throwable exception = assertThrows(
	                Exception.class, () -> {
	                    service.login("sdd", "Housing$007");
	                }
	        );
	        assertEquals("Username is invalid", exception.getMessage());
	    }

	    @Test
	    public void login02() {

	        Throwable exception = assertThrows(
	                Exception.class, () -> {
	                    service.login("Abel", "passs");
	                }
	        );
	        assertEquals("Password is invalid", exception.getMessage());

	    }

	    @Test
	    public void login03() {

	        assertEquals(true, service.login("Abel", "Housing$007"));
	    }
}
