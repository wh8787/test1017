package 并查集;

import java.util.*;

public class 账户合并 {
    public List<List<String>> accountsMerge(List<List<String>> accounts){
        HashMap<String, String> getName = new HashMap<>();
        HashMap<String, Integer> getEmail = new HashMap<>();
        int count = 0;
        for(List<String> list : accounts){
            for(int i=1; i<list.size(); i++){
                if(!getEmail.containsKey(list.get(i))){
                    getEmail.put(list.get(i), count++);
                    getName.put(list.get(i), list.get(0));
                }
            }
        }
        UnionFind set = new UnionFind(count);
        for(List<String> list : accounts){
            for(int i=2; i<list.size(); i++){
                set.union(getEmail.get(list.get(1)), getEmail.get(list.get(i)));
            }
        }
        HashMap<Integer, List<String>> map = new HashMap<>();
        for(String email : getEmail.keySet()){
            int root = set.find(getEmail.get(email));
            List<String> list = map.getOrDefault(root, new LinkedList<>());
            list.add(email);
            map.put(root, list);
        }
        List<List<String>> res = new LinkedList<>();
        for(List<String> list : map.values()){
            Collections.sort(list);
            list.add(0, getName.get(list.get(0)));
            res.add(list);
        }
        return res;
    }
    public class UnionFind{
        int root[];
        public UnionFind(int n){
            root = new int[n];
            for(int i=0; i<n; i++)
                root[i] = i;
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX==rootY) return;
            root[rootX] = rootY;
        }
        public int find(int x){
            return x==root[x] ? x : find(root[x]);
        }
    }
}
