package wang.study.leetcode.dynamic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    List<Integer> ret = new ArrayList<>();
    int max = -1;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length <= 2) return ret;
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        dfs(1,nums[0], list,nums);
        return ret;
    }

    private void dfs(int index, int pre, ArrayList<Integer> list,int[] nums) {
        if(index == nums.length){
            int tmp = list.size();
            if(tmp > max) {
                max = tmp;
                ret = new ArrayList<>(list);
            }
            return;
        }

        for(int i = index;i < nums.length;i++){
            if(nums[i] % pre == 0){
                list.add(nums[i]);
                dfs(i+1,nums[i],list,nums);
                list.remove(list.size()-1);
            }
        }
    }

    @Test
    public void test(){
        largestDivisibleSubset(new int[]{1,2,3,4,5,8});
    }
}
