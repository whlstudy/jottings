package wang.study.leetcode;

import org.junit.Test;

public class UniqueBinarySearchTree {
    public int numTrees(int n) {
        int[] arr = new int[n+1];
        if(n == 0) return 0;
        if(n == 1) return 1;
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2;i <= n;i++){
            for(int j = 0;j <= i-1;j++){
                arr[i] += arr[j] * arr[i-j-1];
            }
        }
        return arr[n];
    }
    
    @Test
    public void test(){
        numTrees(3);
    }
}
