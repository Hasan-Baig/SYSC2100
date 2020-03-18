package assignment3;
import java.util.HashMap;

public class InfixCalculator {
	
	private String userInput;
	private StackListBased<Integer> stack;
	private String postFix = "";
	
    /** 
     * Method initialize variables
     * 
     * @param input is the user's String input
     */
	public InfixCalculator(String input) {
		this.userInput = input;
		stack = new StackListBased<Integer>();
	}
	
	/** 
     * Method displays infix, postfix and result
     */	
	public void evaluateInfix() {
		System.out.println("infix: " + userInput);
		String postFix = convertPostfix(userInput);
		System.out.println("postfix: " + postFix);
		System.out.println("result: " + getPostfix(postFix));
	}
	
	/**
     * Method takes infix and converts to postfix form
     * 
     * @param infix - user input
     */
	public String convertPostfix(String infix) {
		
        HashMap<String, Integer> precedence = new HashMap<String, Integer>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);
        
        String[] infixArr = infix.replaceAll("\\s+", "").split("(?=[-+*/()])|(?<=[-+*/()])");
        
        StackListBased<String> opStack = new StackListBased<>();
        
        for (final String ch : infixArr) {
        	//digit
        	if (ch.matches("\\d+")) {
        		postFix += ch + " ";
        	}
        	
        	switch (ch) {
        		case "(": // opening bracket
        			opStack.push(ch);
        			break;
        		case ")": // closing bracket
        			while (!opStack.peek().equals("(")) {
            			postFix += opStack.pop() + " ";
        			}
        			opStack.pop();
        			break;
        		// operators
        		case "-":
        		case "+":
        		case "*":
        		case "/":
        			while (!opStack.isEmpty() && !opStack.peek().equals("(") && (precedence.get(ch) <= precedence.get(opStack.peek()))) {
            			postFix += opStack.pop() + " ";
        			}
        			opStack.push(ch);
        			break;
        	}
        }
        
        while (!opStack.isEmpty()) {
        	postFix += opStack.pop() + " ";
        }
        
        return postFix;
	}
	
	/**
     * Method output result of expression
     * 
     * @param postfix
     */
    public int getPostfix (String postFix) {
        for (String ch : postFix.split(" ")) {
        	if (ch.matches("\\d+")) {
                stack.push(Integer.parseInt(ch));
            } else {
            	// if operator (+-*/) perform operation on top two num of stack
            	int num1 = stack.pop();
            	int num2 = stack.pop();
            	switch (ch) {
                	case "+":
                		stack.push(num2 + num1);
                		break;
                	case "-":
                		stack.push(num2 - num1);
                		break;
                	case "*":
                		stack.push(num2 * num1);
                		break;
                	case "/":
                		stack.push(num2 / num1);
                		break;
            	}
            }
        }
        return stack.pop();
    }
}
