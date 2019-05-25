package wang.study.leetcode;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int i = 0,j = 1;
        int del = 0;
        for(;j < nums.length;){
            while(j < nums.length && nums[i] == nums[j]){
                del++;
                j++;
            }
            if(j < nums.length)
                nums[i+1] = nums[j];
            j++;
            i++;
        }
        return nums.length - del;
    }
    
    @Test
    public void test(){
        System.out.println(removeDuplicates(new int[]{1,1,1,1,1,1}));
    }
}
