package week_3;

import static input.InputUtils.*;

/**
 *
 * The fare to ride the bus during regular (not rush) hours is $2.00.
 * The fare to ride the bus during rush hours is $2.50.
 *
 * Create a program to calculate the total spent on bus rides,
 * from the number of regular and number of rush hour trips taken.
 */


public class Question_3_Bus_Fares {


    // You don't need to modify the main method
    public static void main(String[] args) {
    
        int regularFareBusRides = positiveIntInput("How many times did you ride the bus during regular hours?");
        int rushFareBusRides = positiveIntInput("How many times did you ride the bus during rush hours?");
    
        // TODO call your new method to calculate the total amount spent on bus rides.
        // TODO print the total amount spent on all bus rides.
    
    }
    
    // TODO create a new public static method called fareTotal
    // The fareTotal method takes two arguments in this order:
    //    regularRides, an int, for the number of regular bus rides the user made
    //    rushRides, an int, for the number of rush hour bus rides the user made
    //
    // The fareTotal method should calculate the total amount spent of bus rides.
    // A regular bus fare is $2, a rush hour bus fare is $2.50.
    //
    // The fareTotal method will return the total amount spent on bus rides
    // The return value from the fareTotal method will be a double.
    

}

