package wang.study.leetcode;

public class ClimbingStairs {
    public int climbStairs0(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairs0(n-1) + climbStairs0(n-2);
    }
    
    public int climbStairs1(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3;i < n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n-1];
    }
}
