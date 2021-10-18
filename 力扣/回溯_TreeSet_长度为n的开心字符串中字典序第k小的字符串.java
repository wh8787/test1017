package 力扣;

import java.util.*;

public class 回溯_TreeSet_长度为n的开心字符串中字典序第k小的字符串 {
    public static String getHappyString(int n, int k) {
        dfs(0, n, new String());
        for(int i=0; i<k-1; i++){
            set.pollFirst();
        }
        return set.isEmpty() ? "" : set.pollFirst();
    }
    /*public static class MaxToMin implements Comparator<String>{
        public int compare(String s1, String s2){
            return s2.compareTo(s1);
        }
    }
    static TreeSet<String> set = new TreeSet<>(new MaxToMin());*/
    static TreeSet<String> set = new TreeSet<>();//默认TreeSet为升序集合，第一个元素最小；通过加比较器可得到降序集合。
    public static void dfs(int count, int n, String str){
        if(count==n) set.add(str);
        else {
            if(str.length()==0||str.charAt(str.length()-1)=='a'){
                dfs(count+1, n, str+'b');
                dfs(count+1, n, str+'c');
            }
            if(str.length()==0||str.charAt(str.length()-1)=='b'){
                dfs(count+1, n, str+'a');
                dfs(count+1, n, str+'c');
            }
            if(str.length()==0||str.charAt(str.length()-1)=='c'){
                dfs(count+1, n, str+'b');
                dfs(count+1, n, str+'a');
            }
        }
    }
    public static void main(String args[]){
        int n = 3, k = 9;
        System.out.print(getHappyString(n, k));
    }
}
