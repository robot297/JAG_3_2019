package week_3;

import junit.framework.TestCase;

public class Question_6_Credit_Card_ValidationTest extends TestCase {


    public void testIsCreditCardValid() {

        //Some valid credit card numbers

        Question_6_Credit_Card_Validation q6 = new Question_6_Credit_Card_Validation();

        assertTrue("4123123412341236 should be valid", q6.isVisaCreditCardNumberValid("4123123412341236"));
        assertTrue("4000111122223339 should be valid", q6.isVisaCreditCardNumberValid("4000111122223339"));
        assertTrue("4123456789012349 should be valid", q6.isVisaCreditCardNumberValid("4123456789012349"));

    }

    public void testInvalidCard() {

        Question_6_Credit_Card_Validation q6 = new Question_6_Credit_Card_Validation();

        //Invalid - too short
        assertFalse("4445556666 should be invalid - too short", q6.isVisaCreditCardNumberValid("4445556666"));
        assertFalse("44455556666777 should be invalid - too short", q6.isVisaCreditCardNumberValid("44455556666777"));

        //Invalid - too long
        assertFalse("44455566664445556666 should be invalid - too long", q6.isVisaCreditCardNumberValid("44455566664445556666"));
        assertFalse("4445555666677777 should be invalid - too long", q6.isVisaCreditCardNumberValid("4445555666677777"));


        //Invalid - doesn't start with 4
        assertFalse("5123189756461236 should be invalid - doesn't start with 4", q6.isVisaCreditCardNumberValid("5123189756461236"));

        //Invalid - check digit wrong
        // ...can create an array or list of invalid inputs and use a loop to test them all
        String[] invalidInputs = {"4567568658341240", "4658907842345226", "4904563343456566"};

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