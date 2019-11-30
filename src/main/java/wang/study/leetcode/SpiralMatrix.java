package wang.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };

        List<Integer> ret = spiralOrder(arr);
        for (Integer temp : ret) {
            System.out.print(temp);
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if(matrix.length == 0) return ret;
        int r1 = 0, r2 = matrix.length-1;
        int c1 = 0, c2 = matrix[0].length-1;
        while(r1 <= r2 && c1 <= c2){
            for(int i = c1;i <= c2;i++) ret.add(matrix[r1][i]);
            for(int j = r1 + 1;j <= r2;j++) ret.add(matrix[j][c2]);
            if(r1 < r2 && c1 < c2){
                for(int i = c2 - 1;i > c1;i--) ret.add(matrix[r2][i]);
                for(int j = r2;j > r1;j--) ret.add(matrix[j][c1]);
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return ret;
    }
}
