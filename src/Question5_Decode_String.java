import java.util.Stack;

/*
5 (code) Decode String [25 points]
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being
repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are
well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that
digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Constraints:
• 1 <= s.length <= 30
• s consists of lowercase English letters, digits, and square brackets '[]'.
• s is guaranteed to be a valid input.
• All the integers in s are in the range [1, 300].
 */
public class Question5_Decode_String {
    public static String decodeString(String s){
        Stack<String> stack = new Stack<>();
        boolean open = false;
        String output = "";
        String temp = "";
        int count = 0;
        for(int i = 0; i< s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                count = Integer.parseInt((String.valueOf(s.charAt(i))));
                i++;
            }
            if(s.charAt(i) == '['){
                open = true;
                i++;
            } else if (s.charAt(i) == ']'){
                open = false;
                while(count > 0){
                    output += temp;
                    count--;
                }
                i++;
            }
            if(open){
                temp += String.valueOf(s.charAt(i));
            }
            if(!open){
                output += String.valueOf(s.charAt(i));
            }
        }
        return output;
    }
    public static void main(String[] args){
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
