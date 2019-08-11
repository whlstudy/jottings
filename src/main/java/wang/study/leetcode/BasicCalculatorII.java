package wang.study.leetcode;

import org.junit.Test;

import java.util.Stack;

public class BasicCalculatorII {
    /**
     * TODO
     * 考虑不周全 忽略大于一位的数字
     */
    public int calculate(String s) {
        s = s.replace(" ","");
        if (s.length() == 0) return 0;
        Stack<Integer> cst = new Stack<>();
        Stack<Character> ost = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                cst.push(Integer.parseInt(s.substring(index, index + 1)));
                index++;
            } else if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                ost.push(s.charAt(index));
                index++;
            } else if (s.charAt(index) == '*' || s.charAt(index) == '/') {
                if (index + 1 < s.length() && !cst.empty()) {
                    int ret = doCal(cst.pop(), s.charAt(index), Integer.parseInt(s.substring(index + 1, index + 2)));
                    cst.push(ret);
                    index += 2;
                }
            }
        }
        while (!ost.isEmpty()){
            int arg2 = cst.pop();
            int arg1 = cst.pop();
            int ret = doCal(arg1,ost.pop(),arg2);
            cst.push(ret);
        }
        return cst.pop();
    }

    private int doCal(Integer arg1, char operator, int arg2) {
        switch (operator) {
            case '+':
                return arg1 + arg2;
            case '-':
                return arg1 - arg2;
            case '/':
                if (arg2 != 0) {
                    return arg1 / arg2;
                }
                return 0;
            case '*':
                return arg1 * arg2;

                default:
                    return 0;
        }
    }

    @Test
    public void test(){
        System.out.println(calculate("3+2 * 2"));
    }
}
