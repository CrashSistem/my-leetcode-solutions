class Solution {
    public boolean isValid(String s) {
        
        char[] stack = new char[s.length()];
        int top = -1; // Stack pointer
        
        for (char c : s.toCharArray()) {
            // If opening bracket, push to stack
            if (c == '(' || c == '{' || c == '[') {
                top++;
                stack[top] = c;
            } 
            // If closing bracket
            else {
                // Check if stack is empty
                if (top == -1) return false;
                
                // Get the top element
                char last = stack[top];
                top--; // pop from stack
                
                // Check if brackets match
                if (c == ')' && last != '(') return false;
                if (c == '}' && last != '{') return false;
                if (c == ']' && last != '[') return false;
            }
        }
        
        // Stack should be empty at the end
        return top == -1;
    }
}
