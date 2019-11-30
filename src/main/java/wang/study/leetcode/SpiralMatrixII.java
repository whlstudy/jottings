package wang.study.leetcode;


/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        int[][] ret = generateMatrix(3);
        for(int i = 0;i < ret.length;i++){
            for(int j = 0;j < ret[0].length;j++){
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int r1 = 0,r2 = n-1;
        int c1 = 0,c2 = n-1;
        int target = 1;
        while(r1 <= r2 && c1 <= c2){
            for(int i = c1;i <= c2;i++) ret[r1][i] = target++;
            for(int j = r1 + 1;j <= r2;j++) ret[j][c2] = target++;
            if(r1 < r2 && c1 < c2){
                for(int i = c2 - 1;i > c1;i--) ret[r2][i] = target++;
                for(int j = r2;j > r1;j--) ret[j][c1] = target++;
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return ret;
    }
}
