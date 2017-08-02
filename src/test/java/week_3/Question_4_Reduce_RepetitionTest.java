package week_3;

import com.google.common.base.Joiner;
import input.InputUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;

import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;
import static org.powermock.api.easymock.PowerMock.mockStatic;
import static org.powermock.api.easymock.PowerMock.replay;



@RunWith(PowerMockRunner.class)
@PrepareForTest(InputUtils.class)
public class Question_4_Reduce_RepetitionTest {


    // This one is tricky to test since student must decide how to restructure the program.

    @Test
    public void testCoffeeShop() throws Exception {

        mockStatic(InputUtils.class);
        expect(InputUtils.doubleInput(anyString())).andReturn(2.50);
        expect(InputUtils.intInput(anyString())).andReturn(30);
        replay(InputUtils.class);


        Class coffee = Class.forName("week_3.Question_4_Reduce_Repetition");
        Method[] methods = coffee.getMethods();

        // Any methods that take a String argument, like the name of a drink?

        for (Method m : methods) {

            Class[] paramTypes = m.getParameterTypes();
            if (paramTypes.length > 0 && paramTypes[0] == String.class) {
                System.out.println("string method " + m);

                // test this method

                try {
                    Question_4_Reduce_Repetition q4 = new Question_4_Reduce_Repetition();
                    double sales = (double) m.invoke(q4, "Coffee");
                    assertEquals( 2.50 * 30 , sales, 0.00001);
                } catch (Exception e) {
                    fail("Error trying to call " + m.getName() + " If you think your code is correct, or this isn't the right method to test, please tell Clara.");
                }

            }


        }
    }


    @Test
    public void testCoffeeShopFileSize() throws Exception {

        // Test to see if the number of lines of code in the file got smaller... The sort of test you would only every write for checking student code :)

        Joiner joiner = Joiner.on(System.getProperty("file.separator"));
        String path = joiner.join("src", "main", "java", "week_3", "Question_4_Reduce_Repetition.java");   // yuck for the absolute file path. Also yuck for not checking if there is a library method to join parts of the path.
        System.out.println(path);
        BufferedReader reader = new BufferedReader(new FileReader(path));

        int loc = 0;
        String line;

        // Ignore comments, and count lines of code.

        boolean inBlockComment = false;  // Flag to identify if line is part of multi-line comment.

        while ( (line = reader.readLine()) != null){

            line = line.trim();

            if (line.startsWith("/*")) { inBlockComment = true;
                // Does this comment start and end on the same line?
                if (line.contains("*/")) {
                    inBlockComment = false;
                }
            }

            if (line.endsWith("*/")) { inBlockComment = false; }

            if (inBlockComment) { continue; }

            if (line.startsWith("//")) {}  //ignore
            else if (line.length() == 0) {}  // blank, ignore

            else {
                loc++;
            }
        }

        // Original file had 33 lines of code.
        int originalLoc = 33;

        System.out.println(loc);
        assertTrue("Your version of this program would be expected to have less lines of code than the original. \nOnly lines of code are counted, comments are not counted - write lots of comments!.\nIf you think your solution is correct and this method is not counting the lines correctly, please tell Clara. ", loc < originalLoc );



    }


}