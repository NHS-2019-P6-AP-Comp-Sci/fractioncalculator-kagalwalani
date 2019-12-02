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
		String whole1 = operand1;
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

		/*
		 * System.out.println(whole1 + " " + numerator1 + " " + denominator1);
		 * System.out.println(operator); System.out.println(whole2 + " " + numerator2 +
		 * " " + denominator2);
		 */

		int int_whole1 = Integer.parseInt(whole1);
		int int_numerator1 = Integer.parseInt(numerator1);
		int int_denominator1 = Integer.parseInt(denominator1);

		int int_whole2 = Integer.parseInt(whole2);
		int int_numerator2 = Integer.parseInt(numerator2);
		int int_denominator2 = Integer.parseInt(denominator2);

		/*
		 * System.out.println(int_whole1 + " " + int_numerator1 + " " +
		 * int_denominator1); System.out.println(int_whole2 + " " + int_numerator2 + " "
		 * + int_denominator2);
		 */

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

		// addition calculation
		// multiply whole values to fraction to get a common denominator

		if (operator.equals("+")) {
			int_numerator1 *= int_denominator2;
			int_numerator2 *= int_denominator1;

			// show denominator value is correct
			int temp_denominator = int_denominator1;
			int_denominator1 *= int_denominator2;
			int_denominator2 *= temp_denominator;

			final_numerator = int_numerator1 + int_numerator2;
			final_denominator = int_denominator1;
		}

		// subtraction calculation
		if (operator.equals("-")) {
			int_numerator1 *= int_denominator2;
			int_numerator2 *= int_denominator1;

			// show denominator value is correct
			int temp_denominator = int_denominator1;
			int_denominator1 *= int_denominator2;
			int_denominator2 *= temp_denominator;

			final_numerator = int_numerator1 - int_numerator2;
			final_denominator = int_denominator2;
		}
		// multiplication calculation
		if (operator.equals("*")) {
			final_numerator = int_numerator1 * int_numerator2;
			final_denominator = int_denominator1 * int_denominator2;
		}

		// division calculation
		if (operator.equals("/")) {
			final_numerator = int_numerator1 * int_denominator2;
			final_denominator = int_denominator1 * int_numerator2;
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

		if (final_whole != 0) {
			final_numerator = Math.abs(final_numerator);
			final_denominator = Math.abs(final_denominator);
		}
		// final output
		if (final_whole == 0) {
			return final_numerator + "/" + final_denominator;
		} else if (final_numerator == 0 && final_denominator == 1) {
			return final_whole + "";
		} else {
			return final_whole + "_" + final_numerator + "/" + final_denominator;
		}
	}
}

// TODO: Fill in the space below with any helper methods that you think you will
// need
