package week_3;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;

import static org.junit.Assert.*;
import static test_utils.MethodUtil.findMethod;

public class Question_5_String_To_Int_ArrayTest {

    @Test
    public void testStringToIntArray() {

        Method method = findMethod("week_3.Question_5_String_To_Int_Array", "stringToIntArray", new Class[]{String.class});

        Question_5_String_To_Int_Array q5 = new Question_5_String_To_Int_Array();

        try {

            // Test with some valid input
            int[] arr = (int[]) method.invoke(q5, "12345");
            assertArrayEquals( new int[]{1, 2, 3, 4, 5}, arr);

            arr = (int[]) method.invoke(q5, "467468463453");
            assertArrayEquals( new int[]{4,6,7,4,6,8,4,6,3,4,5,3}, arr);

        } catch (InvocationTargetException ie) {
            String message = "Your method threw a " + ie.getTargetException().getClass().toString() + ", " + ie.getTargetException().getMessage();
            fail(message);

        } catch (Exception e) {
            fail(e.getMessage());
        }


        // Some Strings with non-numeric characters. Expect the method to return null in this case, and not crash.
        try {
            int[] arr = (int[]) method.invoke(q5, "4674r68463453");
            assertNull("Calling this method with a String containing with non-numeric characters should return null", arr);
        } catch (InvocationTargetException ie) {
            String message = "When called with the String \"4674r68463453\" Your method threw a " + ie.getTargetException().getClass().toString() + ", " + ie.getTargetException().getMessage();
            fail(message);

        } catch (Exception e) {
            fail(e.getMessage());
        }


        try {
            int[] arr = (int[]) method.invoke(q5, "!$SDFSD");
            assertNull("Calling this method with a String containing with non-numeric characters should return null", arr);

        } catch (InvocationTargetException ie) {
            String message = "When called with the String \"$SDFSD\" Your method threw a " + ie.getTargetException().getClass().toString() + ", " + ie.getTargetException().getMessage();
            fail(message);

        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
    
}