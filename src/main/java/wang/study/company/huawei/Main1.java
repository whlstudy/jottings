package wang.study.company.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = 0;
        int index = -1;
        List<Integer> arr = toB(n);
        for(int i = 0;i < arr.size()-2;){
            if(i+1 < arr.size() && i+2 < arr.size()){
                if(arr.get(i) == 1 && arr.get(i+1) == 0 && arr.get(i+2) == 1){
                    if(index == -1){
                        index = i;
                    }
                    ret++;
                }
                if(arr.get(i+1) == 1) i++;
                else i+=2;
            }else {
                i++;
            }
        }
        System.out.println(ret + " " + index);
    }

    private static List<Integer> toB(int n) {
        List<Integer> arr = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        while(n > 0){
            stack.push(n%2);
            n = n/2;
        }
        while (!stack.isEmpty()){
            arr.add(stack.pop());
        }
        return arr;
    }
}
