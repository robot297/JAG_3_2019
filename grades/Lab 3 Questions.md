# Lab 2 

### Question 1 MPG

 Write a program to calculate the MPG for a car journey.
 (MPG = Miles per gallon, calculate by dividing number of miles by number of gallons of gas used).

 Write a method called mpg that has two arguments:
 * a number of miles driven, and
 * a number of gallons of gas used on a car journey
 And returns a double value, representing the MPG for the journey.

 Your method should calculate and return the MPG for the car journey.  Your main method should
 *	Ask the user for the miles and gas used
 *	Call your method
 *	Use the returned data to display the MPG

### Question 2 Marathon
    
 You have a friend who wants to run a marathon race, which is 26.2 miles.
 Currently, your friend can run exactly 1 mile.  Your friend's plan is to
 try to run 10% further every week, until they can run the entire
 marathon distance.

 So in the first week of training, they will run 1 mile;  
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


### Question 3 Agile or Waterfall

 Write a program that can help decide if a particular programming project
 is best solved using a Waterfall or Agile methodology.

 Your program should ask the user:

 *	How many programmers will be on the team.  More that ~30 programmers -> Waterfall
 *	If there needs to be firm deadlines and a fixed schedule. Yes - > Waterfall
 *	If the programmers have experience in requirements, analysis and testing as well as coding. Yes - > Agile
 *	If there are stringent quality control requirements. Yes -> Waterfall 
 *	If early integration is desirable.    Yes -> Agile
 *	If the customer will be requiring working models early in the process. Yes -> Agile 

 Write a method called agileOrWaterfall,
 which takes this data as integer and boolean arguments.
 The arguments should be provided in the order given above.
 and returns a suggestion on whether Agile, or Waterfall, or either, may be is best.

 There's a yesNoInput method in `InputUtils.java`.

 Use this method in your program to suggest which methodology to use.

 Your main method should do all of the asking questions and printing the result.
 Your agileOrWaterfall method should be given the relevant data, and do the processing,
 deciding, and returning the result.


### Question 4 Reduce Repetition

Start with the `Question_4_Reduce_Repetition.java` program.
 
  Notice there are several drinks, and the code to get the total sales for each is very similar. Can you create and use another method (or methods) that will be called from the coffeeShop method, to make this program less repetitive?

  Hint: would an array of drink names help?

### Question 5 String To int Array

  Write a method called stringToIntArray which takes a number represented as a
  String as an argument, for example "12345" or "4321432143214321" ;
  and returns the digits of that number in an array.
 
  Your method should create an int[] array with one digit of your number per
  element, and return this array.
 
  If any of the characters in the string are not numbers, return null.
 
 
  So, if the user enters
 
 ` "12345" `
 
  then your method should return this array :
 
 ` { 1, 2, 3, 4, 5 } `
 
 
  if the user enters
 
  ` "abc" `
 
  then your method should return null.
  
  
### Question 6


 Credit card numbers have a check digit at the end that can be used to check if the number is entered correctly.
 This is how websites can indicate that your card number is invalid without asking your bank.

 The last digit of your credit card number is a check digit. When you enter a credit card number, an algorithm
 does a calculation with the digits in the number, to make sure that the number follows a certain pattern.
 This helps catch mis-entered credit card numbers, for example, if two digits are transposed.

 (It doesn’t check if the account is valid – just if the digits are most likely entered correctly.)

 Credit cards also begin with a specific number or numbers and must be a certain length. For example,
 all Visa card numbers begin with 4. And Visa card numbers should be 16 digits.

 And, credit card numbers should only be digits. No spaces, dashes, letters, or other characters.

 Write a program that asks a user for a Visa credit card number. Save this as a String.

 Write a method called isVisaCreditCardNumberValid(String cardNumber) to examine the String, and decide
 if the credit card number that it represents is valid or not.  Your method should return a boolean value.

 Here's how the validation is done:

 http://web.eecs.umich.edu/~bartlett/credit_card_number.html

 Process each digit as follows.
 If the digit is in an even position, multiply that digit by 2.
 If the multiplied digit is 10 or more, add the digits in that number together. So if the digit is 6, 6x2 = 12, so add 1+2 = 3.

 Digits in odd positions stay as they are.

 Add together all of the processed digits. If the resulting sum divides by 10, the number is a valid one. Otherwise, it is not.

 For testing, here’s some example valid CC numbers, (unlikely to be actual numbers) which are valid credit
 card numbers according to the rules in the link above:

``` 
4123123412341236
4000111122223339
4123456789012349
 ```

 As an example, for the number `4123456789012349`

 Credit card digits in the top row, processed digits in following rows

```
 Digits:                        4	    1	    2	    3	    4	    5	    6	    7	    8	    9	    0	    1	    2	    3	    4	    9
 Double even position digits:   4x2=8	1	    2x2=4	3	    4x2=8	5	    6x2=12  7	    8x2=16  9       0x2=0	1	    2x2=4	3	    4x2=8	9
 Add digits for 10+:            8       1       4       3       8       5       1+3=3   7       1+6=7   9       0       1       4       3       8       9
```

 So the sum is 8 + 1 + 4 + 3 + 8 + 5 + 3 + 7 + +7 + 9 + 0 + 1 + 4 + 3 + 8 + 9 = 80.
 80 divided by 10 has no remainder, so the card number 4123456789012349 is valid.

 Test your program with some “valid” numbers, and also try changing one digit, like change a 3 to a 4,
 and verify that the number is now invalid.

 Also remember to check that the String is the right length, starts with 4, and contains only numbers.
