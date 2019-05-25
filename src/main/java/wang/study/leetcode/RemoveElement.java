package wang.study.leetcode;

import org.junit.Test;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0, i = 0;
        while (k < nums.length && i < nums.length) {
            if (nums[k] == val) {
                k++;
                continue;
            }
            nums[i++] = nums[k++];
        }
        return nums.length - k;
    }
    @Test
    public void test(){
        removeElement(new int[]{3,2,2,3},3);
    }
}
