package wang.study.leetcode;

import org.junit.Test;

import java.util.Arrays;

// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int index = -1;
        boolean target = false;
        for(int i = nums.length-1;i >= 0;i--){
            int tmp = nums[i];
            index = i;
            for(int j = i-1;j >=0;j--){
                if(tmp > nums[j]){
                    target = true;
                    break;
                }
            }
            if(target) break;
        }
        if(!target){
            Arrays.sort(nums);
        }else {
            int tmp = nums[index];
            int n = -1;
            for(int i = index-1;i >= 0;i--){
                if(nums[i] >= tmp){
                    nums[i+1] = nums[i];
                }else {
                    nums[i+1] = nums[i];
                    nums[i] = tmp;
                    n = i+1;
                    break;
                }
            }
            Arrays.sort(nums,n,nums.length);
        }
    }

    @Test
    public void test(){
        nextPermutation(new int[]{2,3,1});
    }
}
