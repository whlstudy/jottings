package wang.study.leetcode;

import org.junit.Test;

public class ReverseWorldInAString {
    public String reverseWords(String s) {
        String[] str = s.trim().split(" ");

        StringBuilder builder = new StringBuilder();
        for(int i = str.length-1;i>=0;i--){
            if(!"".equals(str[i])) {
                builder.append(str[i]).append(" ");
            }
        }

        // 考虑到""的存在,may be exists null exception
        if(builder.length() > 0) {
            builder.delete(builder.length() - 1, builder.length());
        }
        return builder.toString();
    }

    @Test
    public void test(){
        System.out.println(reverseWords(""));
    }
}