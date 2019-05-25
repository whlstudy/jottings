package wang.study.leetcode.dynamic;


import org.junit.Test;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if(p.charAt(j-2) != '.' && p.charAt(j-2) != s.charAt(i-1)){
                        dp[i][j] = dp[i][j-2];
                    }else {
                        dp[i][j] = dp[i][j-1] || dp[i][j-2] || dp[i-1][j];
                    }
                }else{
                    dp[i][j] = dp[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1);
                }
            }
        }

        return dp[n][m];
    }

    @Test
    public void test() {
        System.out.println(isMatch("abc", "ad.*"));
    }
}
