package wang.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return canBreak(0,s,wordSet);
    }

    private boolean canBreak(int start, String s, Set<String> wordSet) {
        if(start == s.length()){
            return true;
        }
        boolean flag = false;
        for(int i = start+1;i <= s.length();i++){
            String tmp = s.substring(start,i);
            if(wordSet.contains(tmp)){
                flag = canBreak(i,s,wordSet);
                if(flag){
                    return flag;
                }
            }
        }

        return flag;
    }


    public boolean wordBreak1(String s, List<String> wordDict){
        Set<String> wordSet = new HashSet<>(wordDict);
        Integer maxLen = maxLength(wordDict);
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        for(int i = 1;i <= s.length();i++){
            for(int j = 1;j <= maxLen && j <= i;j++){
                if(f[i-j] && wordSet.contains(s.substring(i-j,i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    public Integer maxLength(List<String> wordDict){
        Integer max = Integer.MIN_VALUE;
        for(String str:wordDict){
            max = Math.max(max,str.length());
        }
        return max;
    }

    @Test
    public void test(){
        List<String> wordDict = new ArrayList<>();
        wordDict.add("hello");
        wordDict.add("world");
        System.out.println(wordBreak1("helloworld",wordDict));
    }
}
