/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args)
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	System.out.println("Enter equation: ");
    	String equation = userInput.nextLine();
    	produceAnswer(equation);
    	userInput.close();
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input
    	int space = input.indexOf(" ");
    	String value1 = input.substring(0,space);
    	String operator = input.substring(space+1,space+2);
    	String value2 = input.substring(space+3,input.length());
    	
        return value2;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
