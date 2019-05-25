package wang.study.leetcode;

import org.junit.Test;

public class ImplementStrStr {

    // poor performance return method
    public int strStr(String haystack, String needle) {
        if("".equals(needle) || needle == null) return 0;
        int hlen = haystack.length();
        int nlen = needle.length();
        if(hlen < nlen) return -1;
        for(int i = 0;i <= hlen-nlen;i++){
            int j;
            for(j = 0;j< nlen;j++){
                if(haystack.charAt(i+j) == needle.charAt(j)){
                    continue;
                }
                break;
            }
            if(j == nlen) return i;
        }
        return -1;
    }


    // KMP

    @Test
    public void test(){
        System.out.println(strStr("hello world me","ld"));
    }
}
