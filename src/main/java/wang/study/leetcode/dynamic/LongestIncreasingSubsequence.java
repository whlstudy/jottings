package wang.study.leetcode.dynamic;

import org.junit.Test;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /**
     * O(n^2)
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length == 0) return 0;
        int ret = 1;
        dp[0] = 1;
        for(int i = 1; i < nums.length;i++){
            for(int j = i-1;j >= 0;j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i] == 0) dp[i] = 1;
            ret = Math.max(ret,dp[i]);
        }
        return ret;
    }

    // O(nlogn)
    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];

        int len = 0;
        for(int i = 0; i < nums.length; i++) {
            int index = -Arrays.binarySearch(tails, 0, len, nums[i]);
            if(index > 0) {
                len  = Math.max(index, len);
                tails[index - 1] = nums[i];
            }
        }

        return len;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLIS1(new int[]{1,8,5,7,3,10}));
    }
}
