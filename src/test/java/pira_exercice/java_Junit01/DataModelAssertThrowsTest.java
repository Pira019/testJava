package pira_exercice.java_Junit01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DataModelAssertThrowsTest {
	
	  @Test
	    @DisplayName("Ensure that access to the fellowship throws exception outside the valid range")
	    void ensureThatIndexOutOfBoundMessageForFellowAccessIsCorrect() {
	        DataService dataService = new DataService();
	        List<TolkienCharacter> fellowship = dataService.getFellowship();
	        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> fellowship.get(20));
	        assertEquals("Index 20 out of bounds for length 9", exception.getMessage());
	    }

	    @Test
	    //@Disabled("Please fix and enable") // problem fixed
	    public void ensureThatAgeMustBeLargerThanZeroViaSetter() {
	        TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, Race.HOBBIT);
	        // use assertThrows() rule to check that the message is:
	        // Age is not allowed to be smaller than zero
	        
	        
	        Throwable execeptionAge = assertThrows(IllegalArgumentException.class, () -> frodo.setAge(-1));
	        assertEquals("Age is not allowed to be smaller", execeptionAge.getMessage());

	    }

	    @Test
	   // @Disabled("Please fix and enable") // problem fixed
	    public void testThatAgeMustBeLargerThanZeroViaConstructor() {
	        // use assertThrows() rule to check that an IllegalArgumentException exception is thrown and
	        // that the message is:
	        // "Age is not allowed to be smaller than zero"

	       // TolkienCharacter frodo = new TolkienCharacter("Frodo", -1, Race.HOBBIT);
	        
	        IllegalArgumentException execeptionAge = assertThrows(IllegalArgumentException.class, () -> new TolkienCharacter("Frodo", -1, Race.HOBBIT));
	        
	        assertEquals("Age is not allowed to be smaller", execeptionAge.getMessage());

	    }

}
