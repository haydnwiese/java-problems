package _20_valid_parentheses;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                charStack.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if (charStack.empty())
                    return false;
                
                Character poppedChar = charStack.pop();
                if (poppedChar == '{' && c != '}' 
                    || poppedChar == '(' && c != ')' 
                    || poppedChar == '[' && c != ']') {
                    return false;
                }
            }
        }
        
        return charStack.empty();
    }
}