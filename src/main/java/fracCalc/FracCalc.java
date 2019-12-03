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
		int space = input.indexOf(" "); // find the index of the first space
		String operand1 = input.substring(0, space); // substring of beginning to space before operator

		String new_String1 = input.substring(space + 1, input.length());
		int space2 = new_String1.indexOf(" "); // find the index of the second space
		String operator = new_String1.substring(0, space2); // operator is between the first space and the second space

		String new_String2 = new_String1.substring(space2, new_String1.length());
		String operand2 = new_String2.substring(space2, new_String2.length()); // substring of space after operator to the end
																				

		// Multiple operations
		while (operand2.indexOf(" ") > 0) {
			int space3 = operand2.indexOf(" ");
			String value = operand2.substring(0, space3);
			String new_String3 = operand2.substring(space3 + 1, operand2.length());
			int space4 = new_String3.indexOf(" ");
			String operator2 = new_String3.substring(space4 - 1, space4);
			operand2 = new_String3.substring(space4 + 1, new_String3.length());
			String new_equation = operand1 + " " + operator + " " + value;
			operand1 = produceAnswer(new_equation);
			operator = operator2;
		}

		// Parsing fractions: Operand 1
		String whole1 = operand1; // hi_
		String numerator1 = "";
		String denominator1 = "";
		int slash1 = operand1.indexOf("/");

		if (slash1 > 0) {
			int underscore1 = operand1.indexOf("_");
			if (underscore1 > 0) {
				whole1 = operand1.substring(0, underscore1);
				numerator1 = operand1.substring(underscore1 + 1, slash1);
				denominator1 = operand1.substring(slash1 + 1, operand1.length());
			} else {
				whole1 = "0";
				numerator1 = operand1.substring(underscore1 + 1, slash1);
				denominator1 = operand1.substring(slash1 + 1, operand1.length());
			}

		} else {
			numerator1 = "0";
			denominator1 = "1";
		}

		// Parsing fractions: Operand 2
		String whole2 = operand2;
		String numerator2 = "";
		String denominator2 = "";
		int slash2 = operand2.indexOf("/");

		if (slash2 > 0) {
			int underscore2 = operand2.indexOf("_");
			if (underscore2 > 0) {
				whole2 = operand2.substring(0, underscore2);
				numerator2 = operand2.substring(underscore2 + 1, slash2);
				denominator2 = operand2.substring(slash2 + 1, operand2.length());
			} else {
				whole2 = "0";
				numerator2 = operand2.substring(underscore2 + 1, slash2);
				denominator2 = operand2.substring(slash2 + 1, operand2.length());
			}

		} else {
			numerator2 = "0";
			denominator2 = "1";
		}

		// change strings to integers
		int int_whole1 = Integer.parseInt(whole1);
		int int_numerator1 = Integer.parseInt(numerator1);
		int int_denominator1 = Integer.parseInt(denominator1);

		int int_whole2 = Integer.parseInt(whole2);
		int int_numerator2 = Integer.parseInt(numerator2);
		int int_denominator2 = Integer.parseInt(denominator2);

		// convert to improper fraction
		int_numerator1 += int_denominator1 * Math.abs(int_whole1);
		if (int_whole1 < 0) {
			int_numerator1 *= -1;
		}

		int_numerator2 += int_denominator2 * Math.abs(int_whole2);
		if (int_whole2 < 0) {
			int_numerator2 *= -1;
		}

		int final_numerator = 0;
		int final_denominator = 0;
		int final_whole = 0;

		// if denominator is 0, quit
		if (int_denominator1 == 0 || int_denominator2 == 0) {
			return "Invalid input";
		}

		// if operator is not correct syntax, quit
		if (operator.length() > 1) {
			return "Invalid input";
		}

		// addition calculation
		// multiply whole values to fraction to get a common denominator
		if (operator.equals("+")) {
			int_numerator1 *= int_denominator2;
			int_numerator2 *= int_denominator1;
			final_numerator = int_numerator1 + int_numerator2;
			final_denominator = int_denominator1 * int_denominator2;
		}

		// subtraction calculation
		if (operator.equals("-")) {
			int_numerator1 *= int_denominator2;
			int_numerator2 *= int_denominator1;
			final_numerator = int_numerator1 - int_numerator2;
			final_denominator = int_denominator1 * int_denominator2;
		}

		// multiplication calculation
		if (operator.equals("*")) {
			final_numerator = int_numerator1 * int_numerator2;
			final_denominator = int_denominator1 * int_denominator2;
			if (int_numerator1 == 0 || int_numerator2 == 0) {
				return 0 + "";
			}
		}

		// division calculation
		if (operator.equals("/")) {
			final_numerator = int_numerator1 * int_denominator2;
			final_denominator = int_denominator1 * int_numerator2;
		}

		// make numerator negative instead of the denominator
		if (final_denominator < 0 && final_numerator > 0) {
			final_denominator *= -1;
			final_numerator *= -1;
		}

		// convert to mixed fraction if numerator is positive
		while (final_numerator / final_denominator >= 1) {
			final_numerator -= final_denominator;
			final_whole += 1;
		}

		// convert to mixed fraction if numerator is negative
		while (final_numerator / final_denominator <= -1) {
			final_numerator += final_denominator;
			final_whole -= 1;
		}

		// remove signs from numerator and denominator if there is a whole number
		if (final_whole != 0) {
			final_numerator = Math.abs(final_numerator);
			final_denominator = Math.abs(final_denominator);
		}

		// reduce fraction
		int gcd = 1;
		for (int i = 1; i <= Math.abs(final_numerator) && i <= Math.abs(final_denominator); i++) {
			if (final_numerator % i == 0 && final_denominator % i == 0)
				gcd = i;
		}
		final_numerator /= gcd;
		final_denominator /= gcd;

		// final output
		if (final_whole == 0) {
			if (final_numerator == 0) {
				return "0";
			} else {
				return final_numerator + "/" + final_denominator;
			}
		} else if (final_numerator == 0 || final_denominator == 1) {
			return final_whole + "";
		} else {
			return final_whole + "_" + final_numerator + "/" + final_denominator;
		}
	}
}

// TODO: Fill in the space below with any helper methods that you think you will
// need
