package wang.study.leetcode;

import org.junit.Test;

import java.util.Arrays;

// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
public class NextPermutation {

    /**
     * error
     */
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

    /*
     *  1.find the first decline point
     *  2.sort the last SubArrays
     *  3.exchange the point
     */
    public void nextPermutation1(int[] nums) {
        for(int i = nums.length-1;i > 0;i--){
            if(nums[i-1] < nums[i]){
                Arrays.sort(nums,i,nums.length); // 先排序保证顺序
                for(int j = i;j < nums.length;j++){
                    if(nums[j] > nums[i-1]){
                        int tmp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = tmp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    @Test
    public void test(){
        nextPermutation(new int[]{2,3,1});
    }
}
