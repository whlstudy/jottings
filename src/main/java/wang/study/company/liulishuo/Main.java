package wang.study.company.liulishuo;

import java.util.Scanner;

/**
 * @author whl
 * @date 2019/10/18 6:56 下午
 */
public class Main {
    public static void main0(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr1 = str.split(" ");
        int n = arr1.length;
        int[][] arr = new int[2][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = Integer.parseInt(arr1[i]);
            arr[1][i] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
            for(int j = 0;j < i;j++){
                if(arr[0][j] != 0) {
                    if (arr[0][i] > arr[1][j]) {
                        arr[0][j] = 0;
                        arr[1][j] = arr[1][i];
                        arr[1][j] = 0;
                        break;
                    }
                }
            }
        }
        int sum = 0;
        for(int i = 0;i < n;i++){
            if(arr[0][i] != 0) sum++;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1) {
            System.out.println(1);
            return;
        }
        if(n == 2) {
            System.out.println(2);
            return;
        }
        long a = 1;
        long b = 2;
        long c = 0;
        for(int i = 2;i < n;i++){
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }
}
