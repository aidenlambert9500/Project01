package com.Aiden.calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        if (args.length > 1) {
        	// gets the first and second numbers as well as the desired operation to perform on them
        	// when args.length > 1 (i.e. when the operation is not factorial)
            String firstNumStr = args[0];
            String operation = args[1];
            String secondNumStr = args[2];
            System.out.println("The expression is " + firstNumStr + operation + secondNumStr); 
            // converts the string inputs to doubles so they can be passed to the methods defined below
            double firstNum = Double.parseDouble(firstNumStr);
            double secondNum = Double.parseDouble(secondNumStr);
            // switch case to call different methods depending on the desired operation. Throws an error when an invalid operation is passed
            switch (operation) {
            	case "+":
            		System.out.println(add(firstNum, secondNum));
            		break;
            	case "-":
            		System.out.println(sub(firstNum, secondNum));
            		break;
            	case "*":
            		System.out.println(mult(firstNum, secondNum));
            		break;
            	case "/":
            		System.out.println(div(firstNum, secondNum));
            		break;
            	default:
            		System.out.println("Here");
            		throw new IllegalArgumentException("Invalid Operation entered. Program Terminated");
            }
        } // when args.length == 1 (i.e. the desired operation is factorial)
        else if (args.length == 1) {
        	String expression = args[0];
        	System.out.println("The expression is " + expression);
        	// extract the number value from the string (by slicing out the '!') and passing it to the factorial function
        	System.out.println(factorial(Double.parseDouble(expression.substring(0, expression.length() - 1))));
        } else {
            // No CLI arguments, ask for user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation (e.g., add, subtract, multiply, divide):");
            String operation = scanner.next();
            // Further processing based on operation
            // switch case to call different methods depending on the desired operation from the user
            // each case then prompts users to input two numbers and then passes them to the desired operation excluding factorial 
            // which only prompts users to input one number. Default case throws an error when an invalid operation is entered
            switch (operation) {
            case "add":
                System.out.println("Enter the first number:");
                double addFirstNum = Double.parseDouble(scanner.next());
                System.out.println("Enter the second number:");
                double addSecondNum = Double.parseDouble(scanner.next());
                System.out.println(add(addFirstNum, addSecondNum));
                break;
            case "subtract":
                System.out.println("Enter the first number:");
                double subFirstNum = Double.parseDouble(scanner.next());
                System.out.println("Enter the second number:");
                double subSecondNum = Double.parseDouble(scanner.next());
                System.out.println(sub(subFirstNum, subSecondNum));
                break;
            case "multiply":
                System.out.println("Enter the first number:");
                double multFirstNum = Double.parseDouble(scanner.next());
                System.out.println("Enter the second number:");
                double multSecondNum = Double.parseDouble(scanner.next());
                System.out.println(mult(multFirstNum, multSecondNum));
                break;
            case "divide":
                System.out.println("Enter the first number:");
                double divFirstNum = Double.parseDouble(scanner.next());
                System.out.println("Enter the second number:");
                double divSecondNum = Double.parseDouble(scanner.next());
                System.out.println(div(divFirstNum, divSecondNum));
                break;
        	case "factorial":
        		System.out.println("Enter an integer:");
            	double num = Double.parseDouble(scanner.next());
            	System.out.println(factorial(num));
            	break;
            default:
            	throw new IllegalArgumentException("Invalid Operation. Program Terminated.");
        }
        }
    }

    // Other Methods' placeholders
    
    // Accepts two doubles and returns their sum

    public static double add(double a, double b) {
        return a + b; 
    }

    // Accepts a double and returns its factorial
    public static double factorial(double n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    // Accepts two doubles and returns their difference
    public static double sub(double a, double b) {
    	return a - b;
    }
    
    // Accepts two doubles and returns their product
    public static double mult(double a, double b) {
    	return a * b;
    }
    
    // Accepts two doubles and returns their quotient and throws an error if attempting to divide by zero
    public static double div(double a, double b) {
    	if(b == 0) {
    		throw new IllegalArgumentException("Cannot Divide by Zero!");
    	}
    	return a / b;
    }
}

