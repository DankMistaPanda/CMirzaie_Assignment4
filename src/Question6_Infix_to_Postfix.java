/*
6 (code) Infix to postfix [10 points]
Given a String input containing an infix expression. Return a String output containing the equivalent
postfix expression.
Infix expression: The expression of the form a op b. When an operator is in-between every pair of
operands.
Postfix expression: The expression of the form a b op. When an operator is followed for every pair of
operands.
Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. Ignore the right
associativity of ^.
Hint:
o If the scanned character is a ( , push it to the stack.
o If the scanned character is a ) , pop the stack and output it until a ( is encountered, and discard both
the parenthesis.
Constraints
• The input is guaranteed to be a valid expression.
Sample Input
a+b*(c^d-e)^(f+g*h)-i
Sample Output
abcd^e-fgh*+^*+i-
 */
import java.util.Stack;
public class Question6_Infix_to_Postfix {
    public static String postfix(String s){
        Stack<String> stack = new Stack<>();
        String output = "";
        String current;

        for(int i = 0; i < s.length(); i++){
            current = s.substring(i, i+1);
            if(current.equals("(")){
                stack.push(current);
            } else if(current.equals(")")){
                while(!stack.peek().equals("(")){
                    output += stack.pop();
                }
                stack.pop();
            } else if(check(current) == 0){
                output += current;
            } else if(stack.empty()){
                stack.push(current);
            } else{
                while(!stack.empty() && !stack.peek().equals("(") && check(current) <= check(stack.peek())){
                    output += stack.pop();
                }
                stack.push(current);
            }
            if(i == s.length()-1){
                while(!stack.empty()){
                    output += stack.pop();
                }
            }
        }

        return output;
    }

    public static int check(String s){
        switch (s){
            case "^":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            case "+":
                return 3;
            case "-":
                return 3;
            default:
                return 0;
        }
    }

    public static void main(String[] args){
        System.out.println("a+b*(c^d-e)^(f+g*h)-i" + "\tInput");
        System.out.println(postfix("a+b*(c^d-e)^(f+g*h)-i") + "\t\tOutput");
        System.out.println("abcd^e-fgh*+^*+i-" + "\t\tCheck Output");
    }
}
