package wang.study.company.wzyh;

import java.util.Scanner;

/**
 * @author whl
 * @date 2019/10/16 7:54 下午
 * 微众银行
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] != 0) sum++;
            }
        }
        int remove = 0;
        int temp;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) {
                    temp = count(i, j, arr);
                    if (temp == 4) {
                        remove++;
                        arr[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) {
                    temp = count(i, j, arr);
                    if (temp == 3) {
                        remove++;
                        arr[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) {
                    temp = count(i, j, arr);
                    if (temp == 2) {
                        remove++;
                        arr[i][j] = 0;
                    }
                }
            }
        }
        System.out.println(sum - remove);
    }

    private static int count(int i, int j, int[][] arr) {
        int count = 0;
        if (i - 1 >= 0 && arr[i][j] == arr[i - 1][j]) count++;
        if (i + 1 < arr.length && arr[i][j] == arr[i + 1][j]) count++;
        if (j - 1 >= 0 && arr[i][j] == arr[i][j - 1]) count++;
        if (j + 1 < arr[0].length && arr[i][j] == arr[i][j + 1]) count++;
        return count;
    }
}
