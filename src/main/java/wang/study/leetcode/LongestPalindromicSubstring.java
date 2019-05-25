package wang.study.leetcode;

import org.junit.Test;

public class LongestPalindromicSubstring {
    @Test
    public void test() {
        System.out.println(longestPalindrome("abacab"));
    }

    // 超时
    public String longestPalindrome(String s) {
        boolean[][] flag = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                flag[i][j] = isPalindromic(s.substring(i, j + 1));
            }
        }
        Integer max = Integer.MIN_VALUE;
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (flag[i][j] && max < j - i) {
                    max = j - i;
                    str = s.substring(i, j + 1);
                }
            }
        }
        return str;
    }

    private boolean isPalindromic(String substring) {
        return substring.equals(new StringBuilder(substring).reverse().toString());
    }

    // dynamic planing
    public String longestPalindrome2(String s) {
        int n = s.length();
        if(n == 0) return "";
        boolean[][] flag = new boolean[n][n];
        int maxlen = 1;
        for (int i = 0; i < n; i++) {
            flag[i][i] = true;
        }
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                flag[i][i + 1] = true;
                start = i;
                maxlen = 2;
            }
        }

        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (flag[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    flag[i][j] = true;
                    if (k > maxlen) {
                        start = i;
                        maxlen = k;
                    }
                }
            }
        }
        return s.substring(start, start + maxlen);
    }
}
