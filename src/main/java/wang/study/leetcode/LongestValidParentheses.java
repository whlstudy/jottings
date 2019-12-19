package wang.study.leetcode;

import org.junit.Test;


public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len < 2) return 0;
        int[] dp = new int[len + 1];
        int max = 0;
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) == ')') {
                if (s.charAt(i - 2) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (i - dp[i - 1] - 2 >= 0 && s.charAt(i - dp[i - 1] - 2) == '(') {
                    if (i - dp[i - 1] - 2 >= 0)
                        dp[i] += dp[i - dp[i - 1] - 2];
                    dp[i] += dp[i - 1] + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(longestValidParentheses("()(()()))"));
    }
}
