package wang.study.leetcode.dynamic;

import org.junit.Test;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * You may assume that there is only lower case English letters in
 * both s and t. t is potentially a very long (length ~= 500,000) string,
 * and s is a short string (<=100).
 *
 * A subsequence of a string is a new string which is formed from the
 * original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters.
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class IsSubsequence {
    /**
     * Solution:
     *  双指针法
     */
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        int flag = 0;
        if(t.length() == 0) return false;
        while (index < s.length()) {
            if(s.charAt(index) == t.charAt(flag)){
                index++;
                flag++;
            }else if(s.charAt(index) != t.charAt(flag)){
                flag++;
            }
            if(index != s.length() && flag == t.length()) return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isSubsequence("cgf","abcdegf"));
    }
}
