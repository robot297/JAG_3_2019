package week_3;

/**
 *
 Write a method called stringToIntArray which takes a number represented as a
 String as an argument, for example "12345" or "4321432143214321" ;
 and returns the digits of that number in an array.
 
 Your method should create an int[] array with one digit of your number per
 element, and return this array.
 
 If any of the characters in the string are not numbers, return null.
 
 
 So, if the user enters
 
 "12345"
 
 then your method should return this array :
 
 { 1, 2, 3, 4, 5 }
 
 
 if the user enters
 
 "abc"
 
 then your method should return null.
 
 
 if the user enters
 
 "123b456"
 
 then your method should return null, because of the 'b' character.
 
 
 If the user enters an empty string, your method should return null.
 
 If the method is called with a null String, your method should return null.
 
 You'll need to look up some Java library methods. You may need some methods from
 some or all of these library classes: String, Character, Integer.
 
 */



public class Question_5_String_To_Int_Array {

    public static void main(String[] args) {
        new Question_5_String_To_Int_Array().stringsToArrays();
    }

    private void stringsToArrays() {

        // TODO Ask user for a String
        // TODO Call your stringToIntArray method with this Sting as the argument
        // TODO Test to see if the array has values or if it is null [ meaning that there were non-int characters in the string]
        // TODO If the array was created, print the elements of the array to verify it was converted correctly

    }


   // TODO Create a method called stringToIntArray(String)
    // Convert the String to an integer array of the digits
    // If the String contains non-numeric characters, return null.
    // If the String is null, return null.


}
