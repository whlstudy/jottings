package wang.study.leetcode.dynamic;

import org.junit.Test;

public class CountNumberWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 10;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 10;
        for(int i = 2; i <= n;i++){
            dp[i] = 9*fact(i) + dp[i-1];
        }
        return dp[n];
    }

    // 组合
    private int fact(int n) {
        int count = 1;
        int prod = 1;

        for(int i = 9;count < n;i--){
            prod *= i;
            count++;
        }
        return prod;
    }

    @Test
    public void test(){
        countNumbersWithUniqueDigits(2);
    }
}
