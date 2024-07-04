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
        	System.out.println(factorial(Integer.parseInt(expression.substring(0, expression.length() - 1))));
        } else {
            // No CLI arguments, ask for user input
            Scanner scanner = new Scanner(System.in);
            
            while (true) {
            	System.out.println("Enter operation (e.g., add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial, permutation, permutationWithoutRecursion) or 'exit' to quit:");           
	            String operation = scanner.next();
	            // Further processing based on operation
	            // switch case to call different methods depending on the desired operation from the user
	            // each case then prompts users to input two numbers and then passes them to the desired operation excluding factorial 
	            // which only prompts users to input one number. Default case throws an error when an invalid operation is entered
	            switch (operation.toLowerCase()) {
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
	            	int num = Integer.parseInt(scanner.next());
	            	System.out.println(factorial(num));            	
	            	break;
	        	case "pow":
	        		System.out.println("Enter an number:");
	        		double numPow = Double.parseDouble(scanner.next());
	        		System.out.println("Enter an exponent:");
	        		double numPowExp = Double.parseDouble(scanner.next());
	        		System.out.println(power(numPow, numPowExp ));
	        		break;
	        	case "sqrt":
	        		System.out.println("Enter an number:");
	        		double numSqrt = Double.parseDouble(scanner.next());
	        		System.out.println(sqrt(numSqrt));
	        		break;
	        	case "log":
	        		System.out.println("Enter an number:");
	        		double numLog = Double.parseDouble(scanner.next());
	        		System.out.println(log(numLog));
	        		break;
	        	case "log10":
	        		System.out.println("Enter an number:");
	        		double numLog10 = Double.parseDouble(scanner.next());
	        		System.out.println(log10(numLog10));
	        		break;
	        	case "sin":
	        		System.out.println("Enter an number:");
	        		double numSine = Double.parseDouble(scanner.next());
	        		System.out.println(sin(Math.toRadians(numSine)));
	        		break;
	        	case "cos":
	        		System.out.println("Enter an number:");
	        		double numCos = Double.parseDouble(scanner.next());
	        		System.out.println(cos(Math.toRadians(numCos)));
	        		break;
	        	case "tan":
	        		System.out.println("Enter an number:");
	        		double numTan = Double.parseDouble(scanner.next());
	        		System.out.println(tan(Math.toRadians(numTan)));
	        		break;
	        	case "permutation":
	        		System.out.println("Enter an number of items:");
	        		int items = Integer.parseInt(scanner.next());
	        		System.out.println("Enter an number of items to select:");
	        		int itemsSelected = Integer.parseInt(scanner.next());
	        		System.out.println(permutation(items, itemsSelected));
	        		break;
	        	case "permutationwithoutrecursion":
	        		System.out.println("Enter an number of items:");
	        		int itemsWORecursion = Integer.parseInt(scanner.next());
	        		System.out.println("Enter an number of items to select:");
	        		int itemsSelectedWORecursion = Integer.parseInt(scanner.next());
	        		System.out.println(permutationWithoutRecursion(itemsWORecursion, itemsSelectedWORecursion));
	        		break;	
	        	case "exit":
	        		System.out.println("Program exited.");
	        		scanner.close();
	        		return;
	            }
            }
        }
    }

    // Other Methods' placeholders
    
    // Accepts two doubles and returns their sum

    public static double add(double a, double b) {
        return a + b; 
    }

    // Factorial calculation with progress display
    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        return factorialHelper(num, num);
    }

    private static long factorialHelper(int originalNum, int num) {
        if (num <= 1) {
            return 1;
        }
        // Calculate progress and update progress bar
        int progress = (int) (((originalNum - num) / (double) originalNum) * 100);
        System.out.println("Calculating factorial: " + progress + "%");
        return num * factorialHelper(originalNum, num - 1);
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
    // Accepts two doubles and returns the first number to the power of the second
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Accepts a double and returns its square root
    public static double sqrt(double number) {
        return Math.sqrt(number);
    }

    // Accepts a double and returns its natural logarithm
    public static double log(double number) {
        return Math.log(number);
    }

    // Accepts a double and returns its base-10 logarithm
    public static double log10(double number) {
        return Math.log10(number);
    }

    // Accepts a double and returns its Sine function value
    public static double sin(double angleRadians) {
        return Math.sin(angleRadians);
    }

    // Accepts a double and returns its Cosine function value
    public static double cos(double angleRadians) {
        return Math.cos(angleRadians);
    }

    // Accepts a double and returns its Tangent function value
    public static double tan(double angleRadians) {
        return Math.tan(angleRadians);
    }
    // Accepts two integers and returns the number of possible permutations. Throws an error if the number of items is negative or less than the number of items selected.
    public static int permutation(int items, int itemsSelected) {
    	if (items < 0) {
    		throw new IllegalArgumentException("Number of items cannot be negative");
    	}
    	if (itemsSelected > items) {
    		throw new IllegalArgumentException("Items selected cannot be greater than number of items");
    	}
    	if (itemsSelected == 0) {
            return 1; // Base case: 0 items selected, only 1 way (empty selection)
        } else {
            return items * permutation(items - 1, itemsSelected - 1);
        }
    }
    // Accepts two integers and returns the number of possible permutations without using recursion. Throws an error if the number of items is negative or less than the number of items selected.

    public static int permutationWithoutRecursion(int items, int itemsSelected) {
    	if (items < 0) {
    		throw new IllegalArgumentException("Number of items cannot be negative");
    	}
    	if (itemsSelected > items) {
    		throw new IllegalArgumentException("Items selected cannot be greater than number of items");
    	}
    	int result = 1;
    	for(int i = 0; i < itemsSelected; i++) {
    		result *= (items - i);
    	}
    	return result;
    }

}

