package wang.study.leetcode;

import org.junit.Test;

public class DividedTwoInteger {
    public int divide(int dividend, int divisor) {
        long num1 = Math.abs((long) dividend);
        long num2 = Math.abs((long) divisor);
        boolean flag = (dividend > 0) ^ (divisor > 0);
        if (num2 == 1)
            return flag ? -Math.abs(dividend) : (num1 == Math.abs(dividend) ? Math.abs(dividend) : Integer.MAX_VALUE);
        int result = 0;
        while (num1 >= num2) {
            int count = 0;
            while (num1 >= num2 << count) {
                result += 1 << count;
                num1 -= num2 << count;
                count++;
            }
        }
        return result;
    }
    
    @Test
    public void test() {
        System.out.println(divide(10000000,4));
    }
}
