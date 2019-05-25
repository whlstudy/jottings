package wang.study.leetcode;


import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int len = s.length();
        if (len == 0) return true;
        int i = 0;
        st.push(s.charAt(i));
        i++;
        while (i < len) {
            if (!st.empty() && isCompare(st.peek(), s.charAt(i))) {
                i++;
                st.pop();
            } else {
                st.push(s.charAt(i));
                i++;
            }
        }
        return st.empty() && i == len;
    }
    
    private boolean isCompare(char c1, char c2) {
        if (c1 == '(' && c2 == ')') return true;
        if (c1 == '[' && c2 == ']') return true;
        return c1 == '{' && c2 == '}';
    }
    
    
    public void test() {
        System.out.println(isValid("()[]{}"));
    }
}
