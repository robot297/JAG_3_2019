package week_3;

/**
 *
 *
 *

 Write a program that can help decide if a particular programming project
 is best solved using a Waterfall or Agile methodology.

 Your program should ask the user:

 •	How many programmers will be on the team   [ More than 30 programmers -> Waterfall ]
 •	If there needs to be firm deadlines and a fixed schedule  [ Yes - > Waterfall ]
 •	If the programmers have experience in requirements, analysis and testing as well as coding [ Yes - > Agile ]
 •	If there are stringent quality control requirements   [ Yes -> Waterfall ]
 •	If early integration is desirable   [ Yes -> Agile ]
 •	If the customer will be requiring working models early in the process  [ Yes -> Agile ]
 
 There's a yesNoInput method in the InputUtils library that returns boolean values from user input.
 
 
 Write a method called agileOrWaterfall,
 which takes this data as integer and boolean arguments.
 **The arguments should be provided in the order given above**.
 `agileOrWaterfall` will return a String, a suggestion on whether Agile, or Waterfall, or either, may be is best.
 
 Notice that there are three global constants AGILE, WATERFALL and EITHER.
 Your agileOrWaterfall method should return one of these Strings.
 
 Use your agileOrWaterfall method in your program to suggest which methodology to use.

 Your main method should do the task of asking questions and printing the result.
 Your agileOrWaterfall method should be given the relevant data, and do the processing,
 deciding, and returning the result.

 */
public class Question_3_Agile_Or_Waterfall {

    public String AGILE = "Agile";
    public String WATERFALL = "Waterfall";
    public String EITHER = "Either";


    public static void main(String[] args) {
        new Question_3_Agile_Or_Waterfall().methodology();
    }

    public void methodology() {

        // TODO Ask user the 6 questions
        // TODO Call the agileOrWaterfall method
        // TODO Use the suggestion agileOrWaterfall returns to print a message for the user.

    }

    // TODO write a public agileOrWaterfall method. It should have this name, and take
    // the 6 arguments needed, in the same order given in the description.

    // TODO this function should return one of the three Strings AGILE, WATERFALL or EITHER.

}
