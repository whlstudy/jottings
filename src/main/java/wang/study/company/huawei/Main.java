package wang.study.company.huawei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        int index = 0;
        double min = 200;
        int price = 0;
        Double tmp;
        for(int i = 1;i <= 10000;i++){
            tmp = n*i;
            double pre = Math.abs(tmp.intValue()-tmp);
            double next = 1-pre;
            if(min >pre){
                min = pre;
                index = i;
                price = tmp.intValue();
            }
            if(min >next){
                min = next;
                index = i;
                price = tmp.intValue()+1;
            }
            if(min == 0)
                break;
        }

        System.out.println(price +" "+index);
    }
}
