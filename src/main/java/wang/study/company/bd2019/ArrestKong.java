package wang.study.company.bd2019;

import java.util.ArrayList;
import java.util.Scanner;


public class ArrestKong {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0;i < N;i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        dfs(ret,D,0,new int[3],0);
        System.out.println(ret.size()%99997867);
    }

    public static void dfs(ArrayList ret,int D,int index,int[] arr,int number){

    }*/

    // 必须使用long类型，不然只能通过20%
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long D = sc.nextLong();
        long count = 0L;
        long[] arr = new long[(int)N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        for (int i = 0,j =1; i < N-2; i++) {
            while (j < N && arr[j] - arr[i] <= D) {
                j++;
            }
            j--;
            if(j-i >=2) {
                count += C(j-i);
            }
        }
        System.out.println(count % 99997867);
    }

    private static long C(long num) {
        return num * (num - 1) / 2;
    }
}
