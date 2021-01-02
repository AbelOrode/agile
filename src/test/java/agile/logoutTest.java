package agile;

import static org.junit.Assert.*;
import agile.Service.ServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class logoutTest {
ServiceImpl service = new ServiceImpl();
	
	/**
	 * Rigorous Test :-)
	 */

		@Test
		public void logout01() {
		    Throwable exception = assertThrows(
		            Exception.class, () -> {
		                service.logout("James");
		            }
		    );
		    assertEquals("Invalid Username", exception.getMessage());
		
		}

		@Test
		public void logout02() {
		    assertEquals(true, service.logout("Abel"));
		}
		
	

}
