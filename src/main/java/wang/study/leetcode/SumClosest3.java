package wang.study.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class SumClosest3 {
    @Test
    public void test() {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
    
    // low O(n^3)
    public int threeSumClosest(int[] nums, int target) {
        int sub = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    if (Math.abs(tmp - target) < sub) {
                        sub = Math.abs(tmp - target);
                        res = tmp;
                    }
                }
            }
        }
        return res;
    }
    
    // O(n^2)
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE, min, symbol = 1;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                min = nums[left] + nums[right] + nums[i] - target;
                if (min == 0) return target;// cut branches
                if (min > 0) {
                    if (min < closest) {// give up use abs function
                        closest = min;
                        symbol = 1;
                    }
                    right--;
                } else {
                    if (-min < closest) {
                        closest = -min;
                        symbol = -1;
                    }
                    left++;
                }
            }
        }
        return closest * symbol + target;
    }
}
