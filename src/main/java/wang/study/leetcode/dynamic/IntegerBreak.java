package wang.study.leetcode.dynamic;

import org.junit.Test;

public class IntegerBreak {
    /*
    // error. 考虑欠缺，想的太简单
    public int integerBreak(int n) {
        if(n < 2) return 0;
        if(n == 3) return 2;
        if(n == 2) return 1;
        int m = 1;
        while (m*m<= n) {
            m++;
        }
        m--;
        int k = n - m * m;
        if (k > 0) {
            int q = k / m;
            int p = k % m;
            if (q > 0 && p > 0) {
                return (int) (Math.pow(m + q + 1, p) * Math.pow(m + q, m - p));
            } else if (q == 0 && p > 0) {
                return (int) (Math.pow(m + 1, p) * Math.pow(m, m - p));
            } else if (q > 0) {
                return (int) (Math.pow(m + q, m));
            }
        }
        return (int) (Math.pow(m, m));
    }
     */

    // dp
    public int integerBreak1(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            int max = Integer.MIN_VALUE;
            for(int j = 1;j < i;j++){
                int sol1 = dp[j]*dp[i-j];// 很多个相加
                int sol2 = j*dp[i-j];// 多个相加
                int sol3 = j*(i-j);// 二个相加
                max = Math.max(max,sol1);
                max = Math.max(max,sol2);
                max = Math.max(max,sol3);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(integerBreak1(10));
    }
}
