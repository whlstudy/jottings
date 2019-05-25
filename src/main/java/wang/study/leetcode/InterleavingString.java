package wang.study.leetcode;

import org.junit.Test;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) return false;
        if (len3 == 0) return true;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            if (i == 1) {
                dp[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1);
            } else {
                dp[i][0] = (s3.charAt(i - 1) == s1.charAt(i - 1)) && dp[i - 1][0];
            }
        }
        for (int i = 1; i <= len2; i++) {
            if (i == 1) {
                dp[0][i] = s3.charAt(i - 1) == s2.charAt(i - 1);
            } else {
                dp[0][i] = (s3.charAt(i - 1) == s2.charAt(i - 1)) && dp[0][i-1];
            }
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1))) ||
                        (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }
        return dp[len1][len2];
    }
    
    @Test
    public void test() {
        System.out.println(isInterleave("", "12", "12"));
    }
}
