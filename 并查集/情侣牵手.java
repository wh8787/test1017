package 并查集;

public class 情侣牵手 {
    public int minSwapsCouples(int[] row) {
        UnionFind set = new UnionFind(row.length/2);
        for(int i=0; i<row.length; i=i+2){
            set.union(row[i]/2, row[i+1]/2);//每对情侣给一个编号，如情侣为(2m,2m+1)，编号为2m/2=(2m+1)/2=m。
        }
        return set.count;
    }
    public class UnionFind{
        int root[];
        int count=0;//计算合并次数
        public UnionFind(int n){
            root = new int[n];
            for(int i=0; i<n; i++){
                root[i] = i;
            }
        }
        public void union(int x, int y){
            int rootX = getRoot(x);
            int rootY = getRoot(y);
            if(rootX==rootY) return;
            root[rootX] = rootY;
            count++;//如果两者不在同一颗树中，则合并（每次合并相当于两组人交换位置）
        }
        public int getRoot(int x){
            if(root[x]==x) return x;
            return getRoot(root[x]);
        }
    }
}
