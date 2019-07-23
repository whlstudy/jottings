package wang.study.leetcode;

import org.junit.Test;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int target = 0;
        for (int i = 0; i < row - target ; i++) {
            for (int j = i; j < col - target; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[row-j][i];
                matrix[row-j][i] = matrix[row-i][col-j];
                matrix[row-i][col-j] = matrix[j][col-i];
                matrix[j][col-i] = tmp;
            }
            target++;
        }

        for(int i = 0;i <matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void test(){
        int[][] arr = new int[][]{
                {1,2,3,10},
                {4,5,6,11},
                {7,8,9,12},
                {13,14,15,16}
        };

        rotate(arr);
    }
}
