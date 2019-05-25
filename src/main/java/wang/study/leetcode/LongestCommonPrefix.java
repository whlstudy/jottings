package wang.study.leetcode;

import org.junit.Test;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        StringBuilder ret = new StringBuilder(strs[0]);
        for(int i = 1;i < strs.length;i++){
            int index = 0;
            while (index < ret.length() && index < strs[i].length() && ret.charAt(index) == strs[i].charAt(index)){
                index++;
            }
            if (index < ret.length()){
                ret.delete(index,ret.length());
            }
        }
        if(ret.length() == 0) return "";
        return ret.toString();
    }

    @Test
    public void test(){
        System.out.println(longestCommonPrefix(new String[] {"abcd","abc","ab",""}));
    }
}
