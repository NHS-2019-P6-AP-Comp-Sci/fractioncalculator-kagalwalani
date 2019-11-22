/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner userInput = new Scanner(System.in);
		String equation = "";

		while (!equation.equals("quit")) {
			System.out.print("Enter equation: ");
			equation = userInput.nextLine();
			if (!equation.equals("quit")) {
				System.out.println(produceAnswer(equation));
			}
		}
		userInput.close();

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input

		// Parsing one line of input
		int space = input.indexOf(" "); // find the index of the first space and use it as reference
		String operand1 = input.substring(0, space); // substring of beginning to space before operator
		String operator = input.substring(space + 1, space + 2); // operator is always 1 in length
		String operand2 = input.substring(space + 3, input.length()); // substring of space after operator to the end

		// Parsing fractions: Operand 1
		parseOperand1(operand1);

		// Parsing fractions: Operand 2
		return parseOperand2(operand2);

	}

// TODO: Fill in the space below with any helper methods that you think you will
// need

	public static String parseOperand1(String op1) {
		int slash1 = op1.indexOf("/");
		String whole1 = op1;
		String numerator1 = "";
		String denominator1 = "";
		if (slash1 > 0) {
			int underscore1 = op1.indexOf("_");
			if (underscore1 > 0) {
				whole1 = op1.substring(0, underscore1);
				numerator1 = op1.substring(underscore1 + 1, slash1);
				denominator1 = op1.substring(slash1 + 1, op1.length());
				return "whole:" + whole1 + " numerator:" + numerator1 + " denominator:" + denominator1;
			} else {
				whole1 = "0";
				return "whole:" + whole1 + " numerator:" + numerator1 + " denominator:" + denominator1;
			}
		} else {
			return "whole:" + whole1 + " numerator:" + numerator1 + " denominator:" + denominator1;
		}
	}

	public static String parseOperand2(String op2) {
		int slash2 = op2.indexOf("/");
		String whole2 = op2;
		String numerator2 = "";
		String denominator2 = "";
		if (slash2 > 0) {
			int underscore2 = op2.indexOf("_");
			if (underscore2 > 0) {
				whole2 = op2.substring(0, underscore2);
				numerator2 = op2.substring(underscore2 + 1, slash2);
				denominator2 = op2.substring(slash2 + 1, op2.length());
				return "whole:" + whole2 + " numerator:" + numerator2 + " denominator:" + denominator2;
			} else {
				whole2 = "0";
				numerator2 = op2.substring(underscore2 + 1, slash2);
				denominator2 = op2.substring(slash2 + 1, op2.length());
				return "whole:" + whole2 + " numerator:" + numerator2 + " denominator:" + denominator2;
			}
		} else {
			numerator2 = "0";
			denominator2 = "1";
			return "whole:" + whole2 + " numerator:" + numerator2 + " denominator:" + denominator2;
		}
	}
}