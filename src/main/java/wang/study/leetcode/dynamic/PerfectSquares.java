package wang.study.leetcode.dynamic;

import org.junit.Test;

import java.util.ArrayList;

public class PerfectSquares {
    // poor performance
    public int numSquares(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 1;
        int tmp = 1;
        while(tmp <= n){
            arr.add(tmp);
            i++;
            tmp = i * i;
        }

        int[] makeN = new int[n+1];
        makeN[0] = 0;
        for(int j = 1; j <= n; j++){
            for(Integer num : arr){
                if(j - num < 0){
                    break;
                }else{
                    if(makeN[j] == 0 || makeN[j] > makeN[j-num]+1){
                        makeN[j] = makeN[j-num]+1;
                    }
                }
            }
        }

        return makeN[n];
    }


    @Test
    public void test(){
        System.out.println(numSquares(12));
    }
}
