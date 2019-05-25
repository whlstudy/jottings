package wang.study.leetcode;

import org.junit.Test;

public class PalindromicSubstrings {
    @Test
    public void test(){
        countSubstrings("aaa");
    }
    public int countSubstrings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        for(int i = 0;i < len;i++){
            dp[i][i] = true;
            count++;
        }
        for(int i = 0;i < len-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                count++;
            }
        }
        int k = 3;
        while(k <= len){
            for(int i = 0;i < len-k+1;i++){
                int j = i + k -1;
                if (dp[i + 1][j-1] &&
                        s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                }
            }
            k++;
        }
        return count;
    }
}
