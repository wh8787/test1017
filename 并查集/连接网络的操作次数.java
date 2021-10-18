package 并查集;

import java.util.*;

public class 连接网络的操作次数 {
    public int makeConnected(int n, int[][] connections) {
        UnionFind set = new UnionFind(n);
        HashSet<Integer> map = new HashSet<>();
        for(int i=0; i<connections.length; i++){
            set.union(connections[i][0], connections[i][1]);
        }
        for(int i=0; i<set.root.length; i++){
            int p = set.get(set.root[i]);
            map.add(p);
        }
        return set.count>=map.size()-1 ? map.size()-1 : -1;
    }
    public class UnionFind{
        int root[];
        int count = 0;
        public UnionFind(int n){
            root = new int[n];
            for(int i=0; i<n; i++){
                root[i] = i;
            }
        }
        public void union(int x, int y){
            int rootX = get(x);
            int rootY = get(y);
            if(rootX==rootY){
                count++;
                return;
            }
            root[rootX] = rootY;
        }
        public int get(int x){
            if(x==root[x]) return x;
            return get(root[x]);
        }
    }
}
