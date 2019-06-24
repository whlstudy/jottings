package wang.study.leetcode.dynamic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */

public class LetterCombinationsOfPhoneNumber {

    /**
     * dfs
     */
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> ret = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return ret;
        }
        List<String> arr = new ArrayList<>();
        for(int i = 0;i < digits.length();i++){
            String tmp = map.get(digits.charAt(i));
            if(tmp != null){
                arr.add(tmp);
            }
        }

        dfs(ret, 0, new StringBuilder(), arr,digits.length());
        return ret;
    }

    private void dfs(List<String> ret, int index, StringBuilder str, List<String> arr,int end) {
        if (index == end) {
            ret.add(str.toString());
            return;
        }

        for (int i = 0; i <arr.get(index).length(); i++) {
            dfs(ret,index+1,str.append(arr.get(index).charAt(i)),arr,end);
            str.deleteCharAt(str.length()-1);
        }
    }


    @Test
    public void test(){
        letterCombinations("34");
    }
}
