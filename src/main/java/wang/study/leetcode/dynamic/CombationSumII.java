package wang.study.leetcode.dynamic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination
 */
public class CombationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ret,candidates.length-1,new ArrayList<>(),candidates,target);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, int index, ArrayList<Integer> list, int[] candidates, int target) {
        if(target == 0){
            if(!isContain(ret,list)) {
                ret.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i = index;i >= 0;i--){
            if(target >= candidates[i]){
                list.add(candidates[i]);
                dfs(ret,i-1,list,candidates,target-candidates[i]);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isContain(List<List<Integer>> ret, ArrayList<Integer> list) {
        boolean flag = false;
        for(List arr:ret){
            if(arr.size() == list.size()){
                if(isEqual(arr,list)){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    private boolean isEqual(List arr, ArrayList<Integer> list) {
        boolean flag = true;
        for(int i = 0;i < arr.size();){
            if(arr.get(i) == list.get(i)){
                i++;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Test
    public void test(){
        combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }
}
