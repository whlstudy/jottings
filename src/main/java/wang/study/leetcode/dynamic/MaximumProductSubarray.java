package wang.study.leetcode.dynamic;

// Given an integer array nums, find the contiguous subarray within
// an array (containing at least one number) which has the largest product.
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[] dp0 = new int[nums.length];
        int min = Integer.MAX_VALUE;

        if(nums.length >= 1) dp0[0] = nums[0];
        for(int i = 1;i < nums.length;i++){

        }
    }
}
