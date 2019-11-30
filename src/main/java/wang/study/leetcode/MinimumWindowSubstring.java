package wang.study.leetcode;

/**
 * @author whl
 * @date 2019/11/12 7:39 下午
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] arr = new int[256];
        for (int i = 0; i < t.length(); i++)
            arr[t.charAt(i)]++;
        int start = 0, minLeft = -1, count = 0, min = Integer.MAX_VALUE;
        for(int i = 0;i < s.length();i++){
            if(--arr[s.charAt(i)] >= 0) count++;
            while(count == t.length()){
                if(min > i - start + 1){
                    min = i - start + 1;
                    minLeft = start;
                }
                if(++arr[s.charAt(start)] > 0) count--;
                start++;
            }
        }
        return minLeft == -1 ? "" : s.substring(minLeft,minLeft + min);
    }
}
