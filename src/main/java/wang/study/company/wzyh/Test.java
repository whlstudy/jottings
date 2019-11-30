package wang.study.company.wzyh;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author whl
 * @date 2019/10/17 6:44 下午
 */
public class Test {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxPower = (int) Math.pow(3,(int)(Math.log(Integer.MAX_VALUE)/Math.log(3)));
        System.out.println(maxPower % n == 0);
    }


}
