package pira_exercice.java_Junit01;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataServiceTest {

	// TODO initialize before each test
    DataService dataService;

    
	@BeforeEach
	void setUp()   {
		
		dataService = new DataService();
	}

	 
    @Test
    void ensureThatInitializationOfTolkeinCharactorsWorks() {
        TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, Race.HOBBIT);

        // TODO check that age is 33
        // TODO check that name is "Frodo"
        // TODO check that name is not "Frodon"
        
        
         assertAll("Check age, frodo and Frodon name", () -> assertEquals(33, frodo.age),
        		 									   () -> assertEquals("Frodo", frodo.getName()),
        		 									   ()-> assertNotEquals("Frodon", frodo.getName()));
         									
    }

    @Test
    void ensureThatEqualsWorksForCharaters() {
        Object jake = new TolkienCharacter("Jake", 43, Race.HOBBIT);
        Object sameJake = jake;
        Object jakeClone = new TolkienCharacter("Jake", 12, Race.HOBBIT);
        // TODO check that:
        // jake is equal to sameJake
        // jake is not equal to jakeClone
        
        assertAll("checks onject", ()-> assertEquals(jake,sameJake),
        						   ()-> assertNotEquals(jake,jakeClone));
        
    }

    @Test
    void checkInheritance() {
        TolkienCharacter tolkienCharacter = dataService.getFellowship().get(0);
        // TODO check that tolkienCharacter.getClass is not a movie class
       
        assertNotEquals(tolkienCharacter, Movie.class); // what i do
        
        assertFalse(Movie.class.isAssignableFrom(tolkienCharacter.getClass())); // what is correct 
        assertTrue(TolkienCharacter.class.isAssignableFrom(tolkienCharacter.getClass())); // what is correct
        
    }

    @Test
    void ensureFellowShipCharacterAccessByNameReturnsNullForUnknownCharacter() {
        // TODO imlement a check that dataService.getFellowshipCharacter returns null for an
        // unknow felllow, e.g. "Lars" 
    	
    	assertNull(dataService.getFellowshipCharacter("Lars"));
    }

    @Test
    void ensureFellowShipCharacterAccessByNameWorksGivenCorrectNameIsGiven() {
        // TODO imlement a check that dataService.getFellowshipCharacter returns a fellow for an
        // existing felllow, e.g. "Frodo"

    	assertNotNull(dataService.getFellowshipCharacter("Frodo"));
    }


    @Test
    void ensureThatFrodoAndGandalfArePartOfTheFellowsip() {

        List<TolkienCharacter> fellowship = dataService.getFellowship();

        // TODO check that Frodo and Gandalf are part of the fellowship
        
        
        //Correction 
        
        TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, Race.HOBBIT);
        TolkienCharacter gandalf = new TolkienCharacter("Gandalf", 2020, Race.MAIA);

        assertTrue(fellowship.contains(frodo));
        assertTrue(fellowship.contains(gandalf));
    
    }

    @Test
    void ensureThatOneRingBearerIsPartOfTheFellowship() {

        List<TolkienCharacter> fellowship = dataService.getFellowship();

        
        // TODO test that at least one ring bearer is part of the fellowship
        
        //correction
        
        Map<Ring, TolkienCharacter> ringBearers = dataService.getRingBearers();
        assertTrue(ringBearers.values().stream().anyMatch(ringBearer -> fellowship.contains(ringBearer)));
         
        
      
    }

    // TODO Use @RepeatedTest(int) to execute this test 1000 times
    @Test
    @Tag("slow")
    @RepeatedTest(1000)
    @DisplayName("Minimal stress testing: run this test 1000 times to ")
    void ensureThatWeCanRetrieveFellowshipMultipleTimes() {
        dataService = new DataService();
        assertNotNull(dataService.getFellowship()); 
    }

    @Test
    void ensureOrdering() {
        List<TolkienCharacter> fellowship = dataService.getFellowship();

        // ensure that the order of the fellowship is:
        // frodo, sam, merry,pippin, gandalf,legolas,gimli,aragorn,boromir

        //correction
        
        assertEquals(dataService.getFellowshipCharacter("Frodo"), fellowship.get(0));
        assertEquals(dataService.getFellowshipCharacter("Sam"), fellowship.get(1));
        assertEquals(dataService.getFellowshipCharacter("Merry"), fellowship.get(2));
        assertEquals(dataService.getFellowshipCharacter("Pippin"), fellowship.get(3));
        assertEquals(dataService.getFellowshipCharacter("Gandalf"), fellowship.get(4));
        assertEquals(dataService.getFellowshipCharacter("Legolas"), fellowship.get(5));
        assertEquals(dataService.getFellowshipCharacter("Gimli"), fellowship.get(6));
        assertEquals(dataService.getFellowshipCharacter("Aragorn"), fellowship.get(7));
        assertEquals(dataService.getFellowshipCharacter("Boromir"), fellowship.get(8));

    }

    @Test
    void ensureAge() {
        List<TolkienCharacter> fellowship = dataService.getFellowship();

        // TODO test ensure that all hobbits and men are younger than 100 years

        // TODO also ensure that the elfs, dwars the maia are all older than 100 years
       
        //correction
        
        assertTrue(fellowship.stream()
                .filter(fellow -> fellow.getRace().equals(Race.HOBBIT) || fellow.getRace().equals(Race.MAN))
                .allMatch(fellow -> fellow.age < 100));

        assertTrue(
                fellowship
                        .stream().filter(fellow -> fellow.getRace().equals(Race.ELF)
                                || fellow.getRace().equals(Race.DWARF) || fellow.getRace().equals(Race.MAIA))
                        .allMatch(fellow -> fellow.age > 100));

        // HINT fellowship.stream might be useful here
        
        
    }

    @Test
    void ensureThatFellowsStayASmallGroup() {

        List<TolkienCharacter> fellowship = dataService.getFellowship();

        // TODO Write a test to get the 20 element from the fellowship throws an
        // IndexOutOfBoundsException
        
        assertThrows(IndexOutOfBoundsException.class, () -> fellowship.get(20));
    }
    
    
   
    
    @Test
    void ensureThatTestDoesnotRunMoreThe3s() {
    	
    	assertTimeout(Duration.ofSeconds(3), ()-> dataService.update());
    }

}
