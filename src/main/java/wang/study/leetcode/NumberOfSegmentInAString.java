package wang.study.leetcode;

import org.junit.Test;

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 */
public class NumberOfSegmentInAString {
    /**
     * 首先，根据空格符号切分字符串
     * 然后遍历数组，记录不为“”的字符串个数
     */
    public int countSegments(String s) {
        if(s.length() == 0) return 0;
        String[] strs = s.split(" ");
        int ret = 0,index = 0;
        while(index < strs.length){
            if(!strs[index].equals("")){
                ret++;
            }
            index++;
        }
        return ret;
    }

    @Test
    public void test(){
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }
}
