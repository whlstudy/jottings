package wang.study.leetcode;

import org.junit.Test;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0,j = chars.length-1;
        while (i < j){
            if(Character.isLetterOrDigit(chars[i]) && Character.isLetterOrDigit(chars[j]) ){
                if(chars[i] == chars[j]){
                    i++;
                    j--;
                }else {
                    return false;
                }
            }else {
                if (!Character.isLetterOrDigit(chars[i])) {
                    i++;
                }

                if (!Character.isLetterOrDigit(chars[j])) {
                    j--;
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isPalindrome("0p"));
    }
}
