package wang.study.leetcode.dynamic;

import org.junit.Test;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 */

/**
 * The first and last can not appear at the same time.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    private int helper(int[] nums, int start, int end) {
        int dp[] = new int[nums.length];
        dp[1] = nums[start];
        for (int i = start; i < end; i++) {
            dp[i - start + 2] = Math.max(dp[i - start + 1], dp[i - start] + nums[i + 1]);
        }
        return dp[nums.length - 1];
    }

    @Test
    public void test() {
        System.out.println(rob(new int[]{1, 2, 3, 4}));
    }
}
