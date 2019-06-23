package wang.study.leetcode.dynamic;

import org.junit.Test;

public class BestTimeToBuyAndSellStock3 {
    
    // poor performance
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0;i < prices.length/2;i++){
            int tmp = maxProfit2(0,i,prices) + maxProfit2(i,prices.length,prices);
            max = Math.max(max,tmp);
        }
        return max;
    }
    
    public int maxProfit2(int s,int e, int[] prices) {
        int max = 0;
        if (e-s >= 1) {
            int start = prices[s];
            for (int i = s; i < e; i++) {
                if (prices[i] < start) start = prices[i];
                else max = Math.max(max, prices[i] - start);
            }
        }
        return max;
    }
    
    @Test
    public void test(){
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }

}
