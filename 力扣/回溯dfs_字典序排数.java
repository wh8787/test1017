package 力扣;

import java.util.*;

public class 回溯dfs_字典序排数 {
    public List<Integer> lexicalOrder(int n) {
        for(int i=1; i<10; i++){
            dfs(n, i);
        }
        return list;
    }
    List<Integer> list = new LinkedList<>();
    public void dfs(int n, int cur){
        if(cur>n) return;
        list.add(cur);//这个不在循环内，否者会每次循环都记录相同的数
        for(int i=0; i<10; i++){
            dfs(n, cur*10+i);
        }
    }
}
