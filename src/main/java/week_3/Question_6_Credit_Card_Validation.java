package week_3;

import static input.InputUtils.stringInput;

/**
 *
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
 
 https://en.wikipedia.org/wiki/Luhn_algorithm

 Process each digit as follows.
 If the digit is in an even position, multiply that digit by 2.
 If the multiplied digit is 10 or more, add the digits in that number together. So if the digit is 6, 6x2 = 12, so add 1+2 = 3.

 Digits in odd positions stay as they are.

 Add together all of the processed digits. If the resulting sum divides by 10, the number is a valid one. Otherwise, it is not.

 For testing, here’s some example valid CC numbers, (unlikely to be actual numbers) which are valid credit
 card numbers according to the rules in the link above:

 4123123412341236
 4000111122223339
 4123456789012349

 As an example, for the number 4123456789012349

 Credit card digits in the top row, processed digits in following rows

 Digits:                        4	    1	    2	    3	    4	    5	    6	    7	    8	    9	    0	    1	    2	    3	    4	    9
 Double even position digits:   4x2=8	1	    2x2=4	3	    4x2=8	5	    6x2=12  7	    8x2=16  9       0x2=0	1	    2x2=4	3	    4x2=8	9
 Add digits for 10+:            8       1       4       3       8       5       1+3=3   7       1+6=7   9       0       1       4       3       8       9


 So the sum is 8 + 1 + 4 + 3 + 8 + 5 + 3 + 7 + +7 + 9 + 0 + 1 + 4 + 3 + 8 + 9 = 80.
 80 divided by 10 has no remainder, so the card number 4123456789012349 is valid.

 Test your program with some “valid” numbers, and also try changing one digit, like change a 3 to a 4,
 and verify that the number is now invalid.

 Also remember to check that the String is the right length, starts with 4, and contains only numbers.

 */
public class Question_6_Credit_Card_Validation {

    public static void main(String[] args) {
        new Question_6_Credit_Card_Validation().validator();
    }

    public void validator() {

        String ccNumber = stringInput("Please enter the credit card number, digits only: ");
        boolean isValid = isVisaCreditCardNumberValid(ccNumber);

        if (isValid) {
            System.out.println("This seems to be a valid credit card number");
        } else {
            System.out.println("This is **not** a valid credit card number.");
        }

    }

    public boolean isVisaCreditCardNumberValid(String cc) {

        //TODO Replace with your code to process the credit card number, and determine if it is valid.

        return false;

    }


}
