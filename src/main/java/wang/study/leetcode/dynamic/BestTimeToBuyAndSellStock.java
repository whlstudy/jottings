package wang.study.leetcode.dynamic;

public class BestTimeToBuyAndSellStock {
    
    // poor performance
    public int maxProfit0(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
    
    // dp, use space for time
    public int maxProfit1(int[] prices) {
        int max = 0;
        if (prices.length > 0) {
            int[] dp = new int[prices.length];
            dp[0] = 0;
            for (int i = 1; i < prices.length; i++) {
                int tmp = prices[i] - prices[i - 1];
                dp[i] = dp[i - 1] + tmp;
                if (dp[i] < 0) dp[i] = 0;
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
    
    public int maxProfit2(int[] prices) {
        int max = 0;
        if (prices.length > 1) {
            int start = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < start) start = prices[i];
                else max = Math.max(max, prices[i] - start);
            }
        }
        return max;
    }
}
