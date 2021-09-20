package pira_exercice.java_Junit01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyClassTest {

	MyClass myClassTester;
	
	@BeforeEach
	void initMyClass() {
		myClassTester = new MyClass();
	}
	
	
	@Test
    void testExceptionIsThrown() {
          
        assertThrows(IllegalArgumentException.class, () -> myClassTester.multiply(5000, 5));
    }

    @Test
    void testMultiply() {
        
        assertEquals(50, myClassTester.multiply(10, 5), "10 x 5 must be 50");
    }
    
    @Test
    void groupTest() {
       
    	
       assertAll("test all", ()-> assertEquals(50, myClassTester.multiply(10, 5), "actual")
    		   			   , ()-> assertThrows(IllegalArgumentException.class,()-> myClassTester.multiply(5000, 5))	);
       
    }

}
