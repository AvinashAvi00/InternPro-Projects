import java.util.Stack;
import java.util.Scanner;

public class PostfixEvaluator {

    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the character is a digit, push it to the stack
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                // Pop two operands from the stack
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                // Perform the operation and push the result back to the stack
                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        // The result is the last element in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a postfix expression: ");
        String expression = scanner.nextLine();
        int result = evaluatePostfix(expression);
        System.out.println("The result of the postfix expression is: " + result);
    }
}
