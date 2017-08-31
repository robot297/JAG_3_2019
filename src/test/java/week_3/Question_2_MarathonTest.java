package week_3;

import junit.framework.TestCase;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static test_utils.MethodUtil.findMethod;
import static test_utils.PrintUtils.*;

public class Question_2_MarathonTest extends TestCase {
    
    public void testTrainingSchedule() {
        
        // Find trainingSchedule method
        
        Method training = findMethod("week_3.Question_2_Marathon", "trainingSchedule", new Class[]{double.class, double.class, double.class});
        
        // Call method with example arguments
        
        catchStandardOut();
        
        Question_2_Marathon q2 = new Question_2_Marathon();
        
        
        try {
            
            int weeks = (int) training.invoke(q2, 3, 5, 20);
            assertEquals("When called with a starting distance of 3 miles and target of 5 miles, and 20% distance increase, the number of weeks should be 4", 4, weeks);
            
            // And some more data, check the number of weeks is correct
            
            weeks = (int) training.invoke(q2, 1, 20, 5);
            assertEquals("When called with a starting distance of 1 mile and target of 20 miles, and 5% distance increase, the number of weeks should be 63", 63, weeks);
            
            weeks = (int) training.invoke(q2, 1, 26.2, 5);
            assertEquals("Start 1 mile, target 26.2, increase 5% should be 68 weeks", 68, weeks);
            
            weeks = (int) training.invoke(q2, 10, 100, 8);
            assertEquals("Start 10 miles, target 100, increase 8% should be 31 weeks", 31, weeks);
            
            
            String printedOutput = resetStandardOut();
            printedOutput = printedOutput.replace("\n", " ");
            printedOutput = printedOutput.replace("\r", " ");
            
            
            String expectedPatternRegex = ".*1.*3.0.*2.*3.60.*3.*4.32.*4.*5.18.*";
            
            assertTrue("Check that your table is printing every row of the training schedule. If you think your code is correct, please alert Clara", Pattern.matches(expectedPatternRegex, printedOutput));
            
            // Check that there are no numbers with more than 2 decimal places
            
            String moreThan2decimalPlaces = ".*\\d*\\.[\\d]{3,}.*";
            assertFalse("Display numbers with 2 decimal places. Use String.format(). \nExample:  \n\tString.format(\"Distance %.2f miles\", 1.2345) \nwill generate the string \"Distance 1.23 miles\" " , Pattern.matches(moreThan2decimalPlaces, printedOutput));
            
            
        } catch (Exception e) {
            // For method invoke errors OR exceptions thrown from trainingSchedule method
            fail("Check your trainingSchedule method has the right name, right parameters, right return type, and does not throw any errors");
        }
        
        
        
    }
    
    
}