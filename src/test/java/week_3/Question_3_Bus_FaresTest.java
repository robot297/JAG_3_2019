package week_3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static test_utils.MethodUtil.findMethod;

public class Question_3_Bus_FaresTest {

    
    @Test(timeout = 3000)
    public void createdBusFareMethod() {
        findMethod("week_3.Question_3_Bus_Fares", "fareTotal", new Class[]{int.class, int.class});
    }
    
    
    @Test(timeout = 3000)
    public void testBusFareCalculations() {
    
        Method busFares = findMethod("week_3.Question_3_Bus_Fares", "fareTotal", new Class[]{int.class, int.class});
        
        try {
        
            double fareTotal =  (double) busFares.invoke(null, 4, 7);   // 4 regular rides, 7 rush hour rides
            
            // 4 regular fares at $2 each = $8. 7 rush hour fares at $2.50 each = $17.50. Total $25.50
            assertEquals("When called with 4 regular fares and 7 rush hour fares, your method should return 25.50. \n" +
                    "4 regular fares at $2 each = $8. 7 rush hour fares at $2.50 each = $17.50. Total $25.50\n" +
                    "The argument for regular fares is first, followed by the argument for rush hour fares\n" +
                    "Check that your math is correct.\n",
                    25.50, fareTotal, 0);
            
        }
        catch (NullPointerException e) {
            fail("Make sure the fareTotal method is static. The method header should start public static... ");
        }
        catch (ClassCastException e) {
            fail("Make sure you return a double (not a Double) from the fareTotal method ");
        } catch (InvocationTargetException | IllegalAccessException e) {
            fail("Error calling your method with the arguments 4 and 7. Check your method definition");
        }
    
    }

}