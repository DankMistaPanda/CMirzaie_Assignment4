/*
4 (code) Balanced Symbols [25 points]
A Symbol is considered to be any one of the following characters: (, ), {, }, <, >, ¿, ?, [, or ].
Two Symbols are considered to be a matched pair if the an opening Symbols (i.e., (, [, <, ¿, or {) occurs to the
left of a closing symbol (i.e., ), ], >, ? , or }) of the exact same type. There are five types of matched pairs of
symbols: [ ], { }, < >, ¿?, and ( ).
A matching pair of symbols is not balanced if the set of symbols it encloses are not matched. For
example, {[(]?)} is not balanced because the contents in between { and } are not balanced. The pair of square
brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses an unbalanced
closing square bracket, ].
By this logic, we say a sequence of symbols is balanced if the following conditions are met:
• It contains no unmatched symbols
• The subset of symbols enclosed within the confines of a matched pair of symbols is also a matched pair
of symbols
Given a String of symbols, determine whether the sequence of symbols is balanced. If the input is balanced,
return YES. Otherwise, return NO.
Function Description: Write a function named isBalanced(s), where the parameter s is defined as:
• String s: a String of brackets
Returns
• String: either YES or NO
Input Format
A single String s will contain only a sequence of brackets. Can be empty.
Constraints
• 1 ≤ |𝑠| ≤ 10!, where |𝒔| is the length of the sequence
• All characters in the sequences ∈ { '{', '}', '(‘, ')', '[', ']', '<', '>', '¿', '?' }
• You are allowed to use the LinkedList class but only the add(), remove(), and peek() methods
Output Format
For each String, return YES or NO
Sample Inputs
{[()]}
{[(])}¿
{{[[(()<>)]]}}
Sample Output
YES
NO
YES
Explanation
1. The String {[()]} meets both criteria for being a balanced String.
2. The String {[(])} is not balanced because the brackets enclosed by the matched
pair { and } are not balanced: [(]).
3. The String {{[[(()<>)]]}} meets both criteria for being a balanced String.
 */
import java.util.Stack;
public class Question4_Balanced_Symbols {
    public static String isBalanced(String s){
       Stack<String> stack = new Stack<>();

       for(int i = 0; i < s.length(); i++){
           stack.push(String.valueOf(s.charAt(i)));
       }
       String st;
       int parenthesis = 0;
       int curlyBrace = 0;
       int vector = 0;
       int question = 0;
       int bracket = 0;
       for(int i = 0; i < s.length(); i++){
           st = stack.pop();

           switch (st){
               case "(":
                   parenthesis++;
                   break;
               case ")":
                   parenthesis++;
                   break;
               case "{":
                   curlyBrace++;
                   break;
               case "}":
                   curlyBrace++;
                   break;
               case "<":
                   vector++;
                   break;
               case ">":
                   vector++;
                   break;
               case "¿":
                   question++;
                   break;
               case "?":
                   question++;
                   break;
               case "[":
                   bracket++;
                   break;
               case "]":
                   bracket++;
                   break;
           }
       }
        if (parenthesis%2 != 0){
            return "NO";
        }
        if (curlyBrace%2 != 0){
            return "NO";
        }
        if (vector%2 != 0){
            return "NO";
        }
        if (question%2 != 0){
            return "NO";
        }
        if (bracket%2 != 0){
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args){
        System.out.println("Input:\n" +
                "{[()]}\n" +
                "{[(])}¿\n" +
                "{{[[(()<>)]]}}");
        System.out.println("Program Output:\n" +
                isBalanced("{[()]}") + "\n" +
                isBalanced("{[(])}¿") + "\n" +
                isBalanced("{{[[(()<>)]]}}"));
        System.out.println("Correct Output:\n" +
                "YES\n" +
                "NO\n" +
                "YES");
    }
}
