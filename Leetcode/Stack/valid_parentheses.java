import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
                continue;
            }
            else if (stack.empty() == true) return false;
            else if (bracket == ')' && stack.peek() != '(') return false;
            else if (bracket == '}' && stack.peek() != '{') return false;
            else if (bracket == ']' && stack.peek() != '[') return false;
            stack.pop();
        }
        if (stack.empty() == false) return false;            
        return true;
    }
}
