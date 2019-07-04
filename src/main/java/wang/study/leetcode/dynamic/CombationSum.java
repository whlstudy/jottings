package wang.study.leetcode.dynamic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ret,candidates.length-1,new ArrayList<>(),candidates,target);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, int index, ArrayList<Integer> list,int[] candidates,int target) {
        if(target == 0){
            ret.add(new ArrayList<>(list));
            return;
        }else if(target < 0){
            return;
        }
        for(int i = index;i >= 0;i --){
            if(target >= candidates[i]){
                list.add(candidates[i]);
                dfs(ret,i,list,candidates,target-candidates[i]);
                list.remove(list.size()-1);
            }
        }
    }

    @Test
    public void test(){
        combinationSum(new int[]{1,43,53,4,3},10);
    }
}
