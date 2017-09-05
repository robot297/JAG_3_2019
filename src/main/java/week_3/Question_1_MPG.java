package week_3;

/**
 *

 Write a program to calculate the MPG for a car journey.
 (MPG = Miles per gallon, calculate by dividing number of miles by number of gallons of gas used).

 Write a method called mpg that has two arguments, in the following order:
 - a double to represent the number of miles driven, and
 - a double to represent the number of gallons of gas used on a car journey
 And returns a double value, representing the MPG for the journey.

 Your method should calculate and return the MPG for the car journey.  Your main method should
 -	Ask the user for the miles and gas used
 -	Call your method
 -	Use the returned value to display the MPG

 */

public class Question_1_MPG {

    public static void main(String[] args) {
        new Question_1_MPG().calculate();
    }

    public void calculate() {

        // TODO Ask user for number of miles, as a double

        // TODO Ask user for gallons of gas used, as a double

        // TODO Create a method called mpg(miles, gas). This method will calculate and return the MPG

        // TODO Call the mpg method and save the returned MPG value

        // TODO Print the return value.

    }



    // TODO create a public method called "mpg".
    // Make sure you use the name mpg since the tests expect to find a method with that name.
    // The method takes two arguments, miles driven and gas used, in that order.
    // It will calculate and return the MPG for this journey.

    public static double mpg(double miles, double gas) {
        return miles/gas;
    }


}
