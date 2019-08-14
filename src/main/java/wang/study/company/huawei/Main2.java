package wang.study.company.huawei;

import java.util.*;

public class Main2 {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = str.split(",");
        List<String> ret = new ArrayList<>();
        int count = 0;
        boolean flag = false;
        int j = 0;
        for(int i = 0; i< arr.length;i++){
            String t = arr[i].replaceAll("\"\"","\"");
            if(arr[i].equals("")){
                ret.add("--");
            }else if (flag){
                j++;
                String tmp = ret.get(i-1)+","+t;
                ret.remove(i-1);
                ret.add(tmp);
                if(arr[i].charAt(arr[i].length()-1) == '"' || arr[i].indexOf("\"\"\"") ==arr[i].length()-3){
                    flag = false;
                }
            }else if((arr[i].charAt(0) == '"' && (arr[i].length() > 1 && arr[i].charAt(1) != '"')) || (arr[i].indexOf("\"\"\"") == 0 && arr[i].indexOf("\"\"\"\"") != 0)){
                ret.add(t);
                flag = true;
            }else {
                ret.add(t);
            }
            count++;
        }
        System.out.println(count-j);
        for(String s : ret){
            System.out.println(s);
        }
    }
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int m = sc.nextInt();
        int i = sc.nextInt();
        int n = sc.nextInt();
        while(T-- >= 0){
            int k = sc.nextInt();
            int[][] arr = new int[m][m];
            boolean[][] flag = new boolean[m][m];
            for(int j = 0;j < k;j++){
                int l0 = sc.nextInt();
                int l1 = sc.nextInt();
                int l2 = sc.nextInt();
                arr[l0][l1] = l2;
            }
            TreeMap<Integer,List<Integer>> ret = new TreeMap<>();
            dfs(ret,0,i,n,arr,0,flag);
            for(Map.Entry entry:ret.entrySet()){
                List<Integer> tmp = (List<Integer>)entry.getValue();
                for(Integer s: tmp) {
                    System.out.print(entry.getValue() + " ");
                }
            }
            System.out.println();
        }
    }

    private static void dfs(TreeMap<Integer,List<Integer>> ret, int d, int i, int n, int[][] arr, int tt,boolean[][] flag) {
        if(d == n){
            List<Integer> tmp = ret.get(tt);
            if( tmp != null){
                tmp.add(i);
                ret.put(tt,tmp);
            }else {
                List<Integer> t = new ArrayList<>();
                t.add(i);
                ret.put(tt, t);
            }
            return;
        }
        for(int j = 0;j< arr.length;j++){
            if((arr[i][j] != 0  && flag[i][j] == false) || (arr[j][i] != 0 && flag[j][i] == false)){
                flag[i][j] = true;
                flag[j][i] = true;
                dfs(ret,d+1,j,n,arr,tt+(arr[i][j] == 0? arr[j][i]:arr[i][j]),flag);
                flag[i][j] = false;
                flag[j][i] = false;
            }
        }
        return;
    }
}
