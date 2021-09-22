package pira_exercice.java_Junit01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class EmailValidatorTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void test() {
		fail("Not yet implemented");
	}
	
	// TODO Write test for EmailValidator
    // The names of the methods should give you a pointer what to test for

    @Test
    public void ensureThatEmailValidatorReturnsTrueForValidEmail() {
        assertTrue(EmailValidator.isValidEmail("lars.vogel@gmail.com"));
    }

    @Test
    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
    	
    	//given
    	String email ="sam@learn.mailgun.com";
    	
        assertTrue(EmailValidator.isValidEmail(email));
    }

    @Test
    public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {

    	//given
    	String invalidEmail ="example.com";
    	
    	assertFalse(EmailValidator.isValidEmail(invalidEmail));
    }

    @Test
    public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
    	//given
    	String invalidEmailDoubleDot ="example@gmail..com";
    	
    	assertFalse(EmailValidator.isValidEmail(invalidEmailDoubleDot));
    }

    @Test
    public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
    	//given
    	String invalidEmailDo ="example.com";
    }

    @Test
    public void emailValidator_EmptyString_ReturnsFalse() {
    	//given
    	String EmptyString ="";
    	
    	assertFalse(EmailValidator.isValidEmail(EmptyString));
    	
    	
    }

    @Test
    public void emailValidator_NullEmail_ReturnsFalse() {
    	 
       assertFalse(EmailValidator.isValidEmail(""));
    }

}
