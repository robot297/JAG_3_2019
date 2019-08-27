package week_3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static test_utils.MethodUtil.findMethod;

import java.lang.reflect.Method;

public class Question_4_Agile_Or_WaterfallTest {
    
    private Method agileOrWaterfall;
    
    @Before
    public void findStudentMethod(){
        Class[] params = { int.class, boolean.class, boolean.class, boolean.class, boolean.class, boolean.class } ;
        agileOrWaterfall = findMethod("week_3.Question_4_Agile_Or_Waterfall", "agileOrWaterfall", params);
    }


    @Test(timeout=3000)
    public void testAgileOrWaterfallMethodology_Agile() {
        
        try {
            // Combos that should return Agile
            String decision = (String) agileOrWaterfall.invoke(null, 10, false, true, false, true, true);  // All for agile
            assertEquals("Team of 10, false, true, false, true, true should return Agile (all factors in favor of agile).", Question_4_Agile_Or_Waterfall.AGILE, decision);
            
            decision = (String) agileOrWaterfall.invoke(null, 40, true, true, false, true, true);  // 4 out of 6 for agile
            assertEquals("Team of 40, true, true, false, true, true should return Agile (4 out of 6 factors in favor of agile).", Question_4_Agile_Or_Waterfall.AGILE, decision);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail("Check you have the correct method name, and the method is public and static, and returns the correct type of variable. " +
                    "\nAnd check for errors in your agileOrWaterfall method");
        }
        
        
    }
    
    
    @Test(timeout=3000)
    public void testAgileOrWaterfallMethodology_Waterfall() {
        
        try {
            // Example combos that should return Waterfall
            String decision = (String) agileOrWaterfall.invoke(null, 50, true, false, true, false, false);  // All for waterfall
            assertEquals("Team of 50, true, false, true, false, false should return Waterfall (all factors in favor of waterfall).", Question_4_Agile_Or_Waterfall.WATERFALL, decision);
            
            decision = (String) agileOrWaterfall.invoke(null, 50, true, false, true, true, true);  // 4 out of 6 for waterfall
            assertEquals("Team of 50, true, false, true, true, true should return Waterfall (4 out of 5 factors in favor of waterfall).", Question_4_Agile_Or_Waterfall.WATERFALL, decision);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //Either error in agileOrWaterfall method or wrong parameters or not static
            fail("Check you have the correct method name, and the method is public and static, and returns the correct type of variable. " +
                    "\nAnd check for errors in your agileOrWaterfall method");
        }
    }
    
    
    @Test(timeout=3000)
    public void testAgileOrWaterfallMethodology_Either() {

        try {
            // Combos that should return Either
            String decision = (String) agileOrWaterfall.invoke(null, 10, true, false, true, true, true);   // 3 for each
            assertEquals("Team of 10, true, false, true, true, true should return either (3 factors for waterfall, 3 for agile).", Question_4_Agile_Or_Waterfall.EITHER, decision);
            
            decision = (String) agileOrWaterfall.invoke(null, 50, false, true, true, false, true);  // 3 for each
            assertEquals("Team of 50, false, true, true, false, true should return either (3 factors for waterfall, 3 for agile).", Question_4_Agile_Or_Waterfall.EITHER, decision);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail("Check you have the correct method name, and the method is public and static, and returns the correct type of variable. " +
                    "\nAnd check for errors in your agileOrWaterfall method");
        }
        
        
    }
    
}