package tomkous.algos.ms;

import java.util.Stack;


public class ParantheseBalancing {
	
	    public static void main(String[] args) {
	        String expression1 = "{[()]}[]{()}[{()}]";
	        String expression2 = "{[(])}[[)";
	        String expression3 = "{[(])}[[){[()]}[]{()}[{()}]";
	        String expression4 = "{[()]}[]{()}[{()}]{[()]}";

	        System.out.println(expression1 + " is balanced: " + isBalanced(expression1)); // True
	        System.out.println(expression2 + " is balanced: " + isBalanced(expression2)); // False
	        System.out.println(expression3 + " is balanced: " + isBalanced(expression3)); // False
	        System.out.println(expression4 + " is balanced: " + isBalanced(expression4)); // False
	    }

	    public static boolean isBalanced(String expr) {
	        // Quick check: an empty string is technically balanced
	        if (expr == null || expr.isEmpty()) {
	            return true;
	        }

	        Stack<Character> stack = new Stack<>();

	        for (int i = 0; i < expr.length(); i++) {
	            char current = expr.charAt(i);

	            // 1. Push opening brackets onto the stack
	            if (current == '(' || current == '{' || current == '[') {
	                stack.push(current);
	            } 
	            // 2. Process closing brackets
	            else if (current == ')' || current == '}' || current == ']') {
	                // If stack is empty, there is no matching opening bracket
	                if (stack.isEmpty()) {
	                    return false;
	                }

	                char lastOpen = stack.pop();

	                // Check if the popped bracket matches the current closing bracket
	                if (!isMatchingPair(lastOpen, current)) {
	                    return false;
	                }
	            }
	        }

	        // 3. If the stack is empty, all brackets were successfully matched
	        return stack.isEmpty();
	    }

	    // Helper method to verify bracket pairs
	    private static boolean isMatchingPair(char open, char close) {
	        return (open == '(' && close == ')') ||
	               (open == '{' && close == '}') ||
	               (open == '[' && close == ']');
	    }
	}
