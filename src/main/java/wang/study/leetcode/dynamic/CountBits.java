package wang.study.leetcode.dynamic;

import org.junit.Test;

import java.util.TreeSet;

public class CountBits {
    // poor performance
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        int i = 1;
        TreeSet<Integer> set = new TreeSet<>();
        while(i <= num){
            set.add(i);
            i = i<<1;
        }
        for(int j = 1;j <= num;j++){
            if(set.contains(j)){
                dp[j] = 1;
            }else {
                int tmp = set.lower(j);
                dp[j] = dp[tmp]+dp[j-tmp];
            }
        }
        return dp;
    }

    // Use "base" keep tracking of the nearest power of 2, save the space and time.
    public int[] countBits1(int num){
        int[] dp = new int[num+1];
        dp[0] = 0;
        for(int i = 1,base = 1;i <= num;i++){
            if(i < 2*base){
                dp[i] = 1+dp[i-base];
            }else{
                base <<= 1;
                dp[i] = 1;
            }
        }
        return dp;
    }

    @Test
    public void test(){
        countBits1(6);
    }
}
