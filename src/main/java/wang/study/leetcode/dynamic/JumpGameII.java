package wang.study.leetcode.dynamic;

import com.sun.mail.imap.protocol.INTERNALDATE;

import java.util.Arrays;

public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    // 15.69% 59.61%
    public static int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1;i < nums.length;i++){
            for(int j = i;j < nums[i-1] + i;j++){
                dp[j] = Math.min(dp[i-1] + 1,dp[j]);
            }
        }
        return dp[nums.length-1];
    }
}
