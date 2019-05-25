package wang.study.leetcode;

import org.junit.Test;

public class MaximumSubarray {
    // greedy
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int tmp = 0;
        for(int n : nums){
            tmp += n;
            if(maxSum < tmp) maxSum = tmp;
            if(tmp < 0) tmp = 0;
        }
        return maxSum;
    }

    @Test
    public void test(){
        maxSubArray(new int[]{-2,1});
    }
}
