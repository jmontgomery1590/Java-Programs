package lispchecker;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class LISPChecker {
	
	static String lispCode;
	static Scanner scnr = new Scanner(System.in);
	
	public static String getCode() { //Ask user for custom String to be checked. 
		System.out.println("Please enter your LISP string: ");
		lispCode = scnr.next();
		return lispCode;
	}
	
	public static boolean codeNested(String lispCode) throws EmptyStackException { //Inputs provided String into Stack, iterating through each character in String.
		
		Stack<Character> codeStack = new Stack<Character>(); //Stack inputs data in a LIFO framework for proper variable checking.
		for(int i = 0; i < lispCode.length(); i++) {
			
			char lispChar = lispCode.charAt(i); //If character is an opening bracket, brace, or parentheses, adds to stack in order they appear.
			if (lispChar == '{' || lispChar == '[' || lispChar == '(') {
				codeStack.push(lispChar);
				continue;
				
			} try {
				if (lispChar == '}' && codeStack.peek() == '{' || 	//Cycles through String again. If closing bracket, brace, or parentheses is found,
					lispChar == ']' && codeStack.peek() == '[' ||	//searches Stack for opening equivalent. If found, removes opening from Stack.
					lispChar == ')' && codeStack.peek() == '(') {
				codeStack.pop();
				continue;
				} 
			}catch (EmptyStackException ese) { //Returns false if closing bracket, brace, or parentheses are left in String with no opening left in Stack.
				return false;
			}
		}
		return (codeStack.isEmpty()); //If all opening and closing parentheses, braces, and brackets have been removed from the Stack, with none left over, returns true.
	}
	
	public static void repeatCheck() { //Method that asks user, after program runs to completion, if they would like to run checker again.
		System.out.println("\nWould you like to check another LISP string? Yes or No:");
		String codeRepeat = scnr.next();
			if (codeRepeat.equalsIgnoreCase("Yes")) {
				main(null);
			} else if (codeRepeat.equalsIgnoreCase("No")) {
				System.out.println("Thank you for checking your LISP strings.");
				System.exit(0);
			} else {
				System.out.println("Your input is not valid. Please try again.");
				repeatCheck();
			}
	}

	public static void main(String[] args) { //Prints out result of String check.
		getCode();
		if (codeNested(lispCode)) {
			System.out.println("Properly Closed and Nested: True");
		} else {
			System.out.println("Properly Closed and Nested: False");
		}
		repeatCheck();
	}
}
