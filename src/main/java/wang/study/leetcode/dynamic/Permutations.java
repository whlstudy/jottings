package wang.study.leetcode.dynamic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Permutations {
    /**
     * 使用dfs
     * 用一个数组记录已经已经访问过的元素
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums.length == 0) return ret;
        dfs(ret,nums,new ArrayList<>(),new boolean[nums.length]);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, int[] nums, ArrayList<Integer> tmp, boolean[] isUsed) {
        if(tmp.size() == nums.length){
            ret.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(!isUsed[i]){
                tmp.add(nums[i]);
                isUsed[i] = true;
                dfs(ret,nums,tmp,isUsed);
                tmp.remove(tmp.size()-1);
                isUsed[i] = false;
            }
        }
    }

    @Test
    public void test(){
        permute(new int[]{1,2,3,4,5});
    }
}
