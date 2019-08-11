package wang.study.leetcode.dynamic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class PermutationsII {
    /**
     * 使用dfs
     * 用一个数组记录已经已经访问过的元素
     * 去重
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length == 0) return ret;
        dfs(ret, nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, int[] nums, ArrayList<Integer> tmp, boolean[] isUsed) {
        if (tmp.size() == nums.length) {
            if (!isExists(ret, tmp)) {
                ret.add(new ArrayList<>(tmp));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                tmp.add(nums[i]);
                isUsed[i] = true;
                dfs(ret, nums, tmp, isUsed);
                tmp.remove(tmp.size() - 1);
                isUsed[i] = false;
            }
        }
    }

    private boolean isExists(List<List<Integer>> ret, ArrayList<Integer> tmp) {
        int len = tmp.size();
        for (List<Integer> ex : ret) {
            int i ;
            for (i = 0; i < len; i++) {
                if(ex.get(i) != tmp.get(i)){
                    break;
                }
            }
            if(i == len) return true;
        }
        return false;
    }

    @Test
    public void test(){
        permuteUnique(new int[]{1,1,2});
    }
}
