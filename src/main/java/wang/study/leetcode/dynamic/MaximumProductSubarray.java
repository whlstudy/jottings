package wang.study.leetcode.dynamic;

import org.junit.Test;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp0 = new int[nums.length];
        int[] dp1 = new int[nums.length];
        dp0[0] = nums[0];
        dp1[0] = nums[0];
        int max =nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp0[i] = Math.max(Math.max(nums[i],nums[i]*dp0[i-1]),nums[i]*dp1[i-1]);
            dp1[i] = Math.min(Math.min(nums[i],nums[i]*dp1[i-1]),nums[i]*dp0[i-1]);
            max = Math.max(max,dp0[i]);
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(maxProduct(new int[]{2,-1,0,1,1}));
    }
}
