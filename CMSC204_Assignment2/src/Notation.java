/**
 * This class converts infix to post fix and evaluate post fix expressions.
 * @author Suneth Ramawickrama
 */

public class Notation {

	/**
	 * coverts infix to postfix
	 * @param complexInfix infix string to be converted to postfix
	 * @return postfix string
	 */
	public static String convertInfixToPostfix(String complexInfix) {

		MyStack<Character> stack = new MyStack<Character>();
		MyQueue<Character> queue = new MyQueue<Character>();

		try {
			for (int i = 0; i < complexInfix.length(); i++) {

				Character charAtI = complexInfix.charAt(i);
				if (charAtI == ' ') {

				} else if (Character.isDigit(charAtI)) {
					queue.enqueue(charAtI);
				} else if (charAtI == '(') {
					stack.push(charAtI);
				}

				else if (isOperator(charAtI)) {
					while (!stack.isEmpty() && checkPrecedence(stack.top()) >= checkPrecedence(charAtI)) {
						queue.enqueue(stack.pop());
					}

					stack.push(charAtI);
				}

				else if (charAtI == ')') {
					while (!stack.isEmpty() && stack.top() != '(') {
						queue.enqueue(stack.pop());
					}

					if (stack.isEmpty()) {
						throw new InvalidNotationFormatException();
					}

					stack.pop();
				}

			}

			while (!stack.isEmpty()) {
				if (stack.top() == '(') {
					throw new InvalidNotationFormatException(); 
				}
				queue.enqueue(stack.pop());
			}

		}

		catch (StackOverflowException e) {
			e.printStackTrace();
		} catch (StackUnderflowException e) {
			e.printStackTrace();
		} catch (QueueOverflowException e) {
			e.printStackTrace();
		}

		return queue.toString();
	}

	
	/**
	 * coverts postfix to infix 
	 * @param easyPostfix postfix string to be converted to intfix
	 * @return infix string
	 */
	public static String convertPostfixToInfix(String easyPostfix) {

		MyStack<String> stack = new MyStack<String>();

		Character currentChar = ' ';

		try {

			for (int i =0 ; i < easyPostfix.length() ; i++) {

				currentChar = easyPostfix.charAt(i);

				if (currentChar == ' ') {

				}

				else if (!isOperator(currentChar)) {
					stack.push(currentChar.toString());
				}

				else if (isOperator(currentChar)) {
					if(stack.size()<2) {
						throw new InvalidNotationFormatException();
					}

					String c1 = stack.pop();
					String c2 = stack.pop();
					String str = "(" + c2 + currentChar + c1 + ")";
					stack.push(str);
				}
			}

			if (stack.size() != 1) {
				throw new InvalidNotationFormatException();
			}

		}

		catch(StackOverflowException e) {
			e.printStackTrace();
		}

		catch(StackUnderflowException e) {
			e.printStackTrace();
		}

		return stack.pop();
	}

	
	/**
	 * evaluate postfix expression
	 * @param postfixExpr postfix expression to be evaluated
	 * @return evaluated double value
	 */
	public static double evaluatePostfixExpression(String postfixExpr) {
		
		MyStack <Double> stack = new MyStack<Double>();

		Character currentChar = ' ';
		try {
			for (int i = 0 ; i < postfixExpr.length() ; i++) {

				currentChar = postfixExpr.charAt(i);

				if (currentChar == ' ') {

				}

				else if (currentChar == '(' || Character.isDigit(currentChar)) {
					stack.push((double)Character.getNumericValue(currentChar));
				}

				else if (isOperator(currentChar)) {

					if (stack.size() < 2) 
						throw new InvalidNotationFormatException();

					Double c1 = stack.pop();
					Double c2 = stack.pop();


					Double result = doCalculations(currentChar, c2, c1); 
					stack.push(result);

				}
			}

			if (stack.size() != 1) {
				throw new InvalidNotationFormatException();
			}

		}

		catch(StackOverflowException e) {
			e.printStackTrace();
		}

		catch(StackUnderflowException e) {
			e.printStackTrace();
		}

		return stack.pop();
	}
	

	/**
	 * do calculations based on operands and operators
	 * @param operator operator such as +, -, *, or /
	 * @param n1 the first number
	 * @param n2 the second number
	 * @return result of the calculation
	 */
	private static double doCalculations(Character operator, Double n1, Double n2) {
		Double result = 0.0;
		
		switch(operator){
		case '+':
			result = n1 + n2;
			break;
			
		case '-':
			result = n1 - n2;
			break;
		case '*':
			result = n1 * n2;
			break;
		case '/':
			result = n1 / n2;
			break;
		default:
			result = (double) -1;
		}
		
		return result;
		
	}
	
	
	/**
	 * returns precedence for each operator
	 * @param operator operator such as +, -, *, or /
	 * @return the precedence of the operator
	 */
	private static int checkPrecedence(char operator) {
		if (operator == '+' || operator == '-')
			return 1;
		else if (operator == '*' || operator == '/')
			return 2;
		else 
			return -1;
	}
	
	
	 /**
	  * returns whether a given character is a operator or not
	 * @param ch the character to check
	 * @return true if the character passsed in is a operator
	 */
	private static boolean isOperator(char ch) {
	        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	    }

}


