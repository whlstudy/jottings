package wang.study.company.pdd2;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i = 1;i <= n;i++){
            arr[i] = sc.nextInt();
        }
        int ret = 0;
        int tempM = 0;
        for(int i = 1;i <= n;i++){
            if(i*2 <= n && i*2+1 <= n){
                tempM = Math.min(arr[i*2],arr[i*2+1]);
                ret += Math.max(arr[i],tempM);
                arr[i*2] -= Math.max(arr[i],tempM);
                arr[i*2+1] -= Math.max(arr[i],tempM);
            }else if(i*2 == n){
                tempM = Math.max(arr[i],arr[n]);
                ret += tempM;
                arr[n] -= tempM;
            }else {
                if(arr[i] > 0)
                    ret += arr[i];
            }
        }
        System.out.println(ret);
    }
}
