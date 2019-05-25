package wang.study.leetcode.dynamic;

import org.junit.Test;

public class HouseRobber {
    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed, the only constraint
     * stopping you from robbing each of them is that adjacent houses have
     * security system connected and it will automatically contact the police
     * if two adjacent houses were broken into on the same night.
     */
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;

        for(int i = 1;i <= nums.length;i++){
            if(i == 1) dp[i] = nums[i-1];
            else {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
            }
        }
        return dp[nums.length];
    }

    @Test
    public void test(){
        System.out.println(rob(new int[]{1,2,3,5}));
    }
}
