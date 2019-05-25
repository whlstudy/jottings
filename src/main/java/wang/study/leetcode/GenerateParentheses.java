package wang.study.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        dfs(ret,1,n,"(");
        return ret;
    }

    private void dfs(List<String> ret, int curLen, int maxLen, String s) {
        if(curLen == maxLen){
            while(s.length() < maxLen*2){
                s += ")";
            }
            ret.add(s);
            return;
        }
        dfs(ret,curLen+1,maxLen,s+"(");
        if((s.length() - curLen) < curLen){
            dfs(ret,curLen,maxLen,s+")");
        }
    }

    @Test
    public void test(){
        List<String> ret = generateParenthesis(3);
        for(String str: ret){
            System.out.println(str);
        }
    }
}
