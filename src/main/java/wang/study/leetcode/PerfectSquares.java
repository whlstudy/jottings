package wang.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class PerfectSquares {

    // time out  (calculated too much extra content.)
    public int numSquares(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        int tmp = 1;
        int i = 2;
        while(tmp <= n){
            arr.add(tmp);
            tmp = i*i;
            i++;
        }
        dfs(arr.size()-1,n,arr,0,ret);
        Collections.sort(ret);
        return ret.get(0);
    }

    public void dfs(Integer end,int n,ArrayList<Integer> arr,int m,ArrayList<Integer> ret){
        if(n == 0){
            ret.add(m);
        }
        for(int i = end;i >= 0;i--){
            if(arr.get(i) <= n){
                dfs(i,n-arr.get(i),arr,m+1,ret);
            }
        }
    }



    @Test
    public void test(){
        System.out.println(numSquares(12));
    }
}
