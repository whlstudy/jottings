package wang.study.leetcode.dynamic;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump1(new int[]{3,2,1,0,4}));
    }

    // 36% 49%
    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        if(nums.length == 0) return true;
        dp[0] = true;
        for(int i = 1;i < nums.length;i++){
            if(dp[i-1]) {
                for (int j = i; j < i + nums[i - 1] && j < nums.length; j++) {
                    dp[j] = true;
                }
            }
        }
        return dp[nums.length-1];
    }

    // 99.16%  98.29%
    public static boolean canJump1(int[] nums){
        if(nums.length == 1) return true;
        int reach = nums[0];
        for(int i = 1;i <= reach;i++){
            reach = Math.max(reach,nums[i]+i);
            if(reach >= nums.length-1) return true;
        }
        return false;
    }
}
