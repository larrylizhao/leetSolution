package Leetcode;

import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class LC20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if(!stack.empty() && isPairs(stack.peek(), c)) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.empty();
    }

    private boolean isPairs(char c1, char c2) {
        if(c1 == '(' && c2 == ')') {
            return true;
        }
        if(c1 == '[' && c2 == ']') {
            return true;
        }
        if(c1 == '{' && c2 == '}') {
            return true;
        }

        return false;
    }
}
