package week_3;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;
import static test_utils.MethodUtil.findMethod;

public class Question_5_String_To_Int_ArrayTest {
    
    @Test(timeout=3000)
    public void testStringToIntArrayAllInt() {
    
        invokeStringToArrayMethod("7", new int[]{7});
        invokeStringToArrayMethod("12345", new int[]{1, 2, 3, 4, 5});
        invokeStringToArrayMethod("467468463453", new int[]{4, 6, 7, 4, 6, 8, 4, 6, 3, 4, 5, 3});
    
    }
    
    @Test(timeout=3000)
    public void testStringToIntArrayNonNumericReturnNull() {
    
        // Some or all non-numeric characters
        invokeStringToArrayMethod("!@#$%^&#%%$", null);
        invokeStringToArrayMethod("pizza", null);
        invokeStringToArrayMethod("098765g6543", null);
        invokeStringToArrayMethod("a1234567", null);
    
    }
    
    @Test(timeout=3000)
    public void testStringToIntArrayEmptyStringReturnNull() {

        // Empty String should return null
        invokeStringToArrayMethod("", null);

    }

    @Test(timeout=3000)
    public void testStringToIntArrayWhitespaceStringReturnNull() {

        // White space Strings should return null
        invokeStringToArrayMethod("    ", null);
        invokeStringToArrayMethod("   \t ", null);
        invokeStringToArrayMethod(" \t \n \t   ", null);
    
    }
    
    
    @Test(timeout=3000)
    public void testStringToIntArrayNullStringReturnNull() {
        
        // Null String should return null
        invokeStringToArrayMethod(null, null);
        
    }
    
    
    private void invokeStringToArrayMethod(String input, int[] expectedOut) {
        
        Method method = findMethod("week_3.Question_5_String_To_Int_Array", "stringToIntArray", new Class[]{String.class});
        
        Question_5_String_To_Int_Array q5 = new Question_5_String_To_Int_Array();
        
        try {
            int[] arr = (int[]) method.invoke(q5, input);
            assertArrayEquals("Your stringToIntArray method, called with the String '"
                            + ( (input == null) ? "null" : input )
                            + "' is expected to return "
                            + ( (expectedOut == null) ? "null" : "the array " + Arrays.toString(expectedOut))
                            + ".\n",
                    expectedOut, arr);
    
        } catch (InvocationTargetException ie) {
            String message = "When called with the String '" + input + "' your method threw a " + ie.getTargetException().getClass().toString() + ", " + ie.getTargetException().getMessage();
            fail(message);
            
        } catch (Exception e) {
            fail("Your program threw this exception: " +e.getMessage());
        }
        
    }
    
    
}