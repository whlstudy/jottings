package wang.study.company.bd2019;

import java.util.Arrays;
import java.util.Scanner;

public class stringtest {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(sc.hasNext()){
            StringBuffer str_b = new StringBuffer(sc.next());
            Pattern pattern = Pattern.compile("(.)\\1+");
            Matcher matcher = pattern.matcher(str_b);
            while (matcher.find()){
                String repeat = matcher.group(0);
                int index = str_b.indexOf(repeat);
                str_b.replace(index,index+repeat.length(),repeat.substring(0,2));
            }
            System.out.println(str_b.toString());
        }
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr;
        while(n-->0){
            arr = sc.next().toCharArray();
            int k = 0;
            for(int i = 0;i < arr.length;i++){
                arr[k++] = arr[i];
                if(k >= 3 && arr[k-1] == arr[k-2] && arr[k-2] == arr[k-3]) k--;
                if(k >= 4 && arr[k-4] == arr[k-3] && arr[k-2] == arr[k-1]) k--;
            }
            System.out.println(Arrays.copyOfRange(arr,0,k));

        }
    }
}
