package pira_exercice.java_Junit01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class UsingNestedTests {
	
	private List<String> list;

    @BeforeEach
    void setup() {
        list = Arrays.asList("JUnit 5", "Mockito");
    }

    @Test
    void listTests() {
        assertEquals(2, list.size());
    }

    // TODO define inner class with @Nestled
    // write one tests named checkFirstElement() to check that the first list element is "JUnit 4"
    // write one tests named checkSecondElement() to check that the first list element is "JUnit 4"
    @DisplayName("Grouped tests for checking members")
    @Nested
    class CheckMembers {
        @Test
        @DisplayName("checkFirstElement")
        void checkFirstElement() {
            assertEquals(("JUnit 5"), list.get(0));
        }

        @Test
        @DisplayName("checkSecondElement")
        void checkSecondElement() {
            assertEquals(("Mockito"), list.get(1));
        }

    }

}
