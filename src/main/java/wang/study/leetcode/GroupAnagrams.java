package wang.study.leetcode;

import org.junit.Test;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        if (strs.length == 0) return ret;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] sortedArray = str.toCharArray();
            Arrays.sort(sortedArray);
            String sortNew = new String(sortedArray);
            List<String> family = map.get(sortNew);
            if(family != null) family.add(str);
            else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(sortNew,newList);
                ret.add(newList);
            }
        }
        return ret;
    }

    @Test
    public void test(){
        String[] strs = new String[]{"eat","tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }
}
