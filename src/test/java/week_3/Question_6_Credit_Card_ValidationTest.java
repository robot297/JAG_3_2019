package week_3;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class Question_6_Credit_Card_ValidationTest {

    @Test(timeout=3000)
    public void testIsCreditCardValid() {
        
        Question_6_Credit_Card_Validation q6 = new Question_6_Credit_Card_Validation();
    
        //Some "valid" credit card numbers. Unlikely to be real credit card numbers.
    
        assertTrue("4123123412341236 should be valid", q6.isVisaCreditCardNumberValid("4123123412341236"));
        assertTrue("4000111122223339 should be valid", q6.isVisaCreditCardNumberValid("4000111122223339"));
        assertTrue("4123456789012349 should be valid", q6.isVisaCreditCardNumberValid("4123456789012349"));

    }
    
    
    @Test(timeout=3000)
    public void testInvalidCardWrongLength() {
    
        Question_6_Credit_Card_Validation q6 = new Question_6_Credit_Card_Validation();
    
        //Invalid - too short
        assertFalse("4445556666 should be invalid - too short", q6.isVisaCreditCardNumberValid("4445556666"));
        assertFalse("44455556666777 should be invalid - too short", q6.isVisaCreditCardNumberValid("44455556666777"));
        assertFalse("Empty String should be invalid - too short", q6.isVisaCreditCardNumberValid(""));
    
        //Invalid - too long
        assertFalse("444455566664445556666777 should be invalid - too long", q6.isVisaCreditCardNumberValid("444455566664445556666777"));
        assertFalse("44445555666677778 should be invalid - 17 digits, too long", q6.isVisaCreditCardNumberValid("44445555666677778"));
    
    }
    
    
    @Test(timeout=3000)
    public void testInvalidCardWrongStartDigit() {
    
        Question_6_Credit_Card_Validation q6 = new Question_6_Credit_Card_Validation();
    
        //Invalid - right length, but doesn't start with 4
        assertFalse("5123189756461236 should be invalid - doesn't start with 4", q6.isVisaCreditCardNumberValid("5123189756461236"));
    
    }
    
    
    @Test(timeout=3000)
    public void testInvalidCardWrongCheckDigit() {
        
        Question_6_Credit_Card_Validation q6 = new Question_6_Credit_Card_Validation();
    
        //Invalid - check digit wrong
        // ...can create an array or list of invalid inputs and use a loop to test them all
        String[] invalidInputs = {"4567568658341240", "4658907842345226", "4904563343456566", "4111111111111112"};

        for (String invalid : invalidInputs) {
            assertFalse(invalid + " should be invalid - check digit is wrong", q6.isVisaCreditCardNumberValid(invalid));
        }

        // Invalid - contains non-numeric characters
        String[] moreInvalidInputs = {"4567568p68341240", "QWERTYUIOP", "7642UIOP%^&*4364"};

        // Java's for each loop
        for (String invalid : moreInvalidInputs) {
            assertFalse(invalid + " should be invalid, contains non-numeric characters", q6.isVisaCreditCardNumberValid(invalid));
        }
    }

    
}