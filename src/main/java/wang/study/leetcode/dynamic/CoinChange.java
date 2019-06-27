package wang.study.leetcode.dynamic;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that
 * amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class CoinChange {

    // error
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int ret = 0;
        for (int i = coins.length - 1; i >= 0; ) {
            if (coins[i] <= amount) {
                ret++;
                amount -= coins[i];
            } else {
                i--;
            }
            if (amount == 0) {
                return ret;
            }
        }
        return -1;
    }

    private Integer stepNumber;

    // dfs (the minimum number of steps was not found)
    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        boolean flag = dfs(coins, amount, coins.length - 1, 0);
        return flag ? stepNumber : -1;
    }

    private boolean dfs(int[] coins, int amount, int index, int step) {
        if (index >= 0 && amount == 0) {
            stepNumber = step;
            return true;
        } else if (amount < 0) {
            return false;
        }

        for (int i = index; i >= 0; i--) {
            boolean flag = false;
            if (coins[i] <= amount) {
                flag = dfs(coins, amount - coins[i], i, step + 1);
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }


    // dfs (find the minimum number of step)   **success but easy to time out** because find all possible path
    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        List<Integer> result = new ArrayList<>();
        dfs1(coins, amount, coins.length - 1, 0, result);
        int min = Integer.MAX_VALUE;
        for (Integer tmp : result) {
            if (min > tmp) {
                min = tmp;
            }
        }
        return min < Integer.MAX_VALUE ? min : -1;
    }

    private void dfs1(int[] coins, int amount, int index, int len, List<Integer> result) {
        if (amount == 0) {
            result.add(len);
        } else if (amount < 0) {
            return;
        }
        for(int i = index;i >= 0;i--){
            if(coins[i] <= amount){
                dfs1(coins,amount-coins[i],i,len+1,result);
            }
        }
    }

    // dp trade space for time
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1;i <= amount;i++){
            dp[i] = amount+1; // **
            for(int coin:coins){
                if(i >= coin){
                    dp[i] = Math.min(dp[i],1+dp[i-coin]);
                }
            }
        }
        return dp[amount] == amount+1? -1:dp[amount];
    }

    @Test
    public void test() {
        System.out.println(coinChange3(new int[]{186,419,83,408}, 6249));
    }
}
