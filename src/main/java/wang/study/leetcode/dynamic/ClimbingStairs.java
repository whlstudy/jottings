package wang.study.leetcode.dynamic;

import org.junit.Test;

public class ClimbingStairs {
    public int climbStairs0(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs0(n-1) + climbStairs0(n-2);
    }
    
    public int climbStairs1(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3;i < n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n-1];
    }

    public static class HouseRobber {
        public int rob(int[] nums) {
            if(nums.length == 0) return 0;
            if(nums.length == 1) return nums[0];
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(dp[0],nums[1]);
            for(int i = 2;i < nums.length;i++){
                dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
            }
            return dp[nums.length-1];
        }

        @Test
        public void test(){
            System.out.println(rob(new int[]{2,7,9,3,1}));
        }
    }
}
