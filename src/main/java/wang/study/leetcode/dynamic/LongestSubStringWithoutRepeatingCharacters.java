package wang.study.leetcode.dynamic;

import org.junit.Test;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] dp = new int[s.length()];
        if(s.length() == 0) return 0;
        dp[0] = 1;
        for(int i = 1;i < s.length();i++){
            String tmp = s.substring(i-dp[i-1],i);
            int index = tmp.indexOf(s.charAt(i));
            if(index >= 0){
                dp[i] = dp[i-1] - index;
            }else{
                dp[i] = dp[i-1] + 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0;i < s.length();i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abcabcacc"));
    }
}
