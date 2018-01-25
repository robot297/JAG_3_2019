package week_3;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static test_utils.MethodUtil.*;

import java.lang.reflect.Method;

public class Question_3_Agile_Or_WaterfallTest  {
    
    @Test(timeout=3000)
    public void testAgileOrWaterfallMethodology() throws Exception {

        Class[] params = { int.class, boolean.class, boolean.class, boolean.class, boolean.class, boolean.class} ;
        Method agileOrWaterfall = findMethod("week_3.Question_3_Agile_Or_Waterfall", "agileOrWaterfall", params);

        try {

            Question_3_Agile_Or_Waterfall q3 = new Question_3_Agile_Or_Waterfall();

            // Example combos that should return Waterfall
            String decision = (String) agileOrWaterfall.invoke(q3, 50, true, false, true, false, false);  // All for waterfall
            assertEquals("Team of 50, true, false, true, false, false should return Waterfall (all factors in favor of waterfall).", q3.WATERFALL, decision);

            decision = (String) agileOrWaterfall.invoke(q3, 50, true, false, true, true, true);  // 4 out of 6 for waterfall
            assertEquals("Team of 50, true, false, true, true, true should return Waterfall (4 out of 5 factors in favor of waterfall).", q3.WATERFALL, decision);

            
            // Combos that should return Agile
            decision = (String) agileOrWaterfall.invoke(q3, 10, false, true, false, true, true);  // All for agile
            assertEquals("Team of 10, false, true, false, true, true should return Agile (all factors in favor of agile).", q3.AGILE, decision);

            decision = (String) agileOrWaterfall.invoke(q3, 40, true, true, false, true, true);  // 4 our of 6 for agile
            assertEquals("Team of 40, true, true, false, true, true should return  Agile (4 out of 6 factors in favor of agile).", q3.AGILE, decision);


            // Combos that should return Either
            decision = (String) agileOrWaterfall.invoke(q3, 10, true, false, true, true, true);   // 3 for each
            assertEquals("Team of 10, true, false, true, true, true should return either (3 factors for waterfall, 3 for agile).", q3.EITHER, decision);

            decision = (String) agileOrWaterfall.invoke(q3, 50, false, true, true, false, true);  // 3 for each
            assertEquals("Team of 50, false, true, true, false, true should return either (3 factors for waterfall, 3 for agile).", q3.EITHER, decision);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            //Either error in agileOrWaterfall method or wrong parameters
            fail("Check you have the correct method signature, returning the correct type. And check for errors in your agileOrWaterfall method");
        }


    }
}