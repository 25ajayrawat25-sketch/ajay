import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push the corresponding expected closing bracket onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket, verify match with top of stack
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        // String is valid only if all open brackets have been closed
        return stack.isEmpty();
    }
}
