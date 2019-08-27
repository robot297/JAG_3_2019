package week_3;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;
import static test_utils.MethodUtil.findMethod;

public class Question_5_Change_Array_CaseTest {

    @Test(timeout = 3000)
    public void convertArrayCaseethodDeclared() {
        Method convertMethod = findMethod("week_3.Question_5_ChangeArrayCase", "convertArrayCase", new Class[]{String[].class, boolean.class});
        assertEquals("Your convertArrayCase method should return void.", Void.class, convertMethod.getReturnType());
        
    }

    @Test(timeout=3000)
    public void testConvertToUppercase() {
        invokeConvertArrayCase(new String[]{ "a", "b", "c"}, true, new String[]{ "A", "B", "C"});
        invokeConvertArrayCase(new String[]{ "a", "B", "c"}, true, new String[]{ "A", "B", "C"});
        invokeConvertArrayCase(new String[]{ "A", "B", "C", "5"}, true, new String[]{ "A", "B", "C", "5"});
        invokeConvertArrayCase(new String[]{ "Pizza", "PIZZA", "taCos", "ChEEse"}, true, new String[]{ "PIZZA", "PIZZA", "TACOS", "CHEESE"});
        invokeConvertArrayCase(new String[]{ "5", "E", "%", "G", "\t", "g"}, true, new String[]{ "5", "e", "%", "g", "\t", "g"});
    }


    @Test(timeout=3000)
    public void testConvertToLowercase() {
        invokeConvertArrayCase(new String[]{ "a", "b", "c"}, false, new String[]{ "a", "b", "c"});
        invokeConvertArrayCase(new String[]{ "a", "B", "c"}, false, new String[]{ "a", "b", "c"});
        invokeConvertArrayCase(new String[]{ "A", "B", "C", "5"}, false, new String[]{ "a", "b", "c", "5"});
        invokeConvertArrayCase(new String[]{ "Pizza", "PIZZA", "taCos", "ChEEse"}, false, new String[]{ "pizza", "pizza", "tacos", "cheese"});
        invokeConvertArrayCase(new String[]{ "5", "E", "%", "G", "\t", "g"}, false, new String[]{ "5", "e", "%", "g", "\t", "g"});
    }

    
    private void invokeConvertArrayCase(String[] input, boolean toUpper, String[] expectedOut) {

        Method method = findMethod("week_3.Question_5_ChangeArrayCase", "convertArrayCase", new Class[]{String[].class, boolean.class});

        try {

            method.invoke(null, input, toUpper);
            
            assertArrayEquals("Your stringToIntArray method, called with the Array '"
                            + Arrays.toString(input)
                            + "\n and whether to convert to uppercase = " + toUpper
                            + "\n is expected modify the original array to "
                            + Arrays.toString(expectedOut)
                            + ".\n",
                    expectedOut, input);

        } catch (InvocationTargetException ie) {
            String message = "When called with the Array '" + Arrays.toString(input) + "' your method threw a " + ie.getTargetException().getClass().toString() + ", " + ie.getTargetException().getMessage();
            fail(message);
        } catch (ClassCastException e) {
            fail("Is your method returning the correct type of data? It should r.");
        } catch (Exception e) {
            fail("This exception was thrown: " + e.getMessage());
        }
        
    }
    
    
}