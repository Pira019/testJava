package pira_exercice.java_Junit01;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class LinuxTests {

	@Test
    void testName() throws Exception {
        // only run on Linux
        Assumptions.assumeTrue(System.getProperty("os.name").contains("windows"));
       
        assertTrue(true);
    }
}
