package wang.study.company.pdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public void arraySort(int[] A,int[] B){
        int index = -1;
        // 找到异常点
        int[] tmp = Arrays.copyOf(A,A.length);
        Arrays.sort(tmp);
        for(int i = 0;i < A.length;i++){
            if(tmp[i] != A[i]){
                index = i;
            }
        }

        // 找到填充点
        for(int i = 0;i < B.length;i++){
            if(index == 0 && B[i] < A[index+1]){
                A[index] = B[i];
            } else if(index == A.length-1 && B[i] > A[index-1]){
                A[index] = B[i];
            }else if(A[index-1] < B[i] && B[i] < A[index+1]){
                A[index] = B[i];
            }
        }

        for(int i = 0;i < A.length;i++){
            System.out.print(A[i] + " ");
        }
    }

    @Test
    public void test(){
        int[] a = new int[]{1,3,7,4,10};
        int[] b = new int[]{2,1,5,8,9};
        arraySort(a,b);
    }
}
