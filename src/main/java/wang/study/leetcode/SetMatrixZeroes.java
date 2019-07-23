package wang.study.leetcode;

import org.junit.Test;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int min = Integer.MIN_VALUE;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for(int j = 0;j < col;j++){
                if(matrix[i][j] == 0){
                    for(int m = 0;m < row;m++){
                        if(matrix[m][j] != 0){
                            matrix[m][j] = min;
                        }
                    }
                    for(int m = 0;m < col;m++){
                        if(matrix[i][m] != 0){
                            matrix[i][m] = min;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == min){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        int min = Integer.MIN_VALUE;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] tmp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for(int j = 0;j < col;j++){
                if(matrix[i][j] == 0){
                    tmp[i][j] = min;
                    for(int m = 0;m < row;m++){
                        tmp[m][j] = min;
                    }
                    for(int m = 0;m < col;m++){
                        tmp[i][m] = min;
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(tmp[i][j] == min){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    @Test
    public void test(){
        int[][] arr = new int[][] {
                {1,2,3},{1,0,1},{1,1,1}
        };
        setZeroes1(arr);
    }
}
