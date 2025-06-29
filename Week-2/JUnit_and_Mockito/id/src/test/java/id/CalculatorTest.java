package id;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CalculatorTest 
{
	 private Calculator calculator;
         
	  @Test
	    public void testExternalApi() {
	        ExternalApi mockApi = mock(ExternalApi.class);
	        when(mockApi.getData()).thenReturn("Mock Data");
	        MyService service = new MyService(mockApi);
	        String result = service.fetchData();
	        assertEquals("Mock Data", result);
	       
	      
	    }
	    @Before
	    public void setUp() {
	        calculator = new Calculator();
	        System.out.println("Setup complete");
	    }
	    @After
	    public void tearDown() {
	        calculator = null;
	        System.out.println("Teardown complete");
	    }

	    @Test
	    public void testAddition() {
	        int a = 5;
	        int b = 3;
	        int result = calculator.add(a, b);
	        assertEquals(8, result);
	    }

	    @Test
	    public void testSubtraction() {
	        int a = 10;
	        int b = 4;
	        int result = calculator.subtract(a, b);
	        assertEquals(6, result);
	    }
	    
	    
	  
	 @Test
	    public void testAdd() {
	        Calculator calc = new Calculator();
	        int result = calc.add(2, 3);
	        assertEquals(5, result);
	        assertTrue(result > 0);
	        assertFalse(result < 0);
	        assertNotNull(calc);
	        assertNull(null);
	     
	    }

}
