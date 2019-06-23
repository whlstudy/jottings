package wang.study.leetcode.dynamic;

import org.junit.Test;

import java.awt.geom.QuadCurve2D;

public class RangeSumQuery {
    /*
    // poor performance

    private int[] nums;

    // Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
    RangeSumQuery(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        while (i <= j){
            sum += nums[i++];
        }
        return sum;
    }
    */

    /*
    // memory limit exceeded
    private int[][] dp;
    RangeSumQuery(int[] nums) {
        dp = new int[nums.length][nums.length];
        for(int i = 0;i < nums.length;i++){
            dp[i][i] = nums[i];
        }

        for(int i = 0;i < nums.length;i++){
            for(int j = i+1;j < nums.length;j++){
                dp[i][j] = dp[i][j-1] + nums[j];
            }
        }
    }

    public int sumRange(int i, int j) {
        return dp[i][j];
    }
    */
}
