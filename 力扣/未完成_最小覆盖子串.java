package 力扣;

import java.util.*;

public class 未完成_最小覆盖子串 {
    public String minWindow(String s, String t) {
        if(t.length()==1) return t;
        HashMap<Character, Integer> map = new HashMap<>();//记录t各个字符的个数
        HashMap<Character, Integer> dict = new HashMap<>();//记录t各个字符在s中最近出现的位置
        HashMap<Character, Integer> mapCopy = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        mapCopy.putAll(map);
        int left=0, count=0, start=0, end=s.length(), next=0;
        for(int i=0; i<s.length(); i++){
            if(left==0){
                if(mapCopy.containsKey(s.charAt(i))){
                    left = i;
                    mapCopy.put(s.charAt(i), mapCopy.get(s.charAt(i))-1);
                }
                continue;
            }
            if(mapCopy.containsKey(s.charAt(i))&&mapCopy.get(s.charAt(i))!=0){
                mapCopy.put(s.charAt(i), map.get(s.charAt(i))-1);
                count++;
                if(count==2) next=i;
            }
            if(count==t.length()){
                if(i-left<end-start){
                    end = i;
                    start = left;
                }
                left = next;
            }
        }
        return s.substring(start, end+1);

    }
}
