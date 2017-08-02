package week_3;

import static input.InputUtils.doubleInput;

/**
 *
 *

 Marathon

 You have a friend who wants to run a marathon race, which is 26.2 miles.
 Currently, your friend can run exactly 1 mile.  Your friend's plan is to
 try to run 10% further every week, until they can run the entire
 marathon distance.

 So in the
   first week of training, they will run 1 mile;
   second week 1.1 miles,
   third week 1.21 miles...

 You would like to write a program to print out their training schedule.

 But, what if your friend thinks this schedule is too slow? Or too fast?
 Your friend can get to the marathon distance sooner by increasing their distance
 by 15% every week?  Or, they may want to be more leisurely and increase by 3% every week.
 How does that affect the number of weeks needed?

 Then, you think, what if your friend decides they want to train for a
 10 mile race? Or a 100 mile race?

 What if you friend starts with the ability to run 5 miles?

 Write a method that takes 3 arguments:
   - the current distance your friend can run,
   - the target distance
   - the percent increase. This should be expressed as 5 for 5%, 10 for 10%.

 In your method, use a loop to calculate the distance they need to run every
 week until they can run the target distance.

 The method should print the weekly distance data as a table.
 Use string formatting to display the weekly distances to 2 decimal places.

 The method should return the number of weeks it will take, as an integer.


 */
public class Question_2_Marathon {

    public static void main(String[] args) {
        new Question_2_Marathon().training();
    }

    public void training() {

        double currentDistance = doubleInput("How far can you run right now, in miles? ");
        double targetDistance = doubleInput("What is the target distance, in miles? ");
        double weeklyPercentIncrease = doubleInput("What percent further do you want to run every week? Enter 5 for 5% ");

        // TODO Call your trainingSchedule method.
        // The method will print a table of weeks and distances; and return total number of weeks
        // TODO Print the total number of weeks.


    }


    // TODO write a method called trainingSchedule
    // It will take 3 arguments: currentDistance, targetDistance, and percentIncrease
    // The method will print a table of weeks and distances;
    //    the table columns should be in that order (weeks then distance)
    //    use String formatting to display distances to 2 decimal places
    // and return total number of weeks


}
