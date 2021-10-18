package 并查集;

import  java.util.*;

public class 最小体力消耗路径 {
    public int minimumEffortPath(int[][] heights) {
        List<int[]> list = new ArrayList<>();
        int m=heights.length, n=heights[0].length;
        for(int i=0; i<heights.length; i++){
            for(int j=1; j<heights[0].length; j++){
                int p1=i*n+j-1, p2=i*n+j;
                list.add(new int[]{p1, p2, Math.abs(heights[i][j]-heights[i][j-1])});
            }
        }
        for(int i=0; i<heights[0].length; i++){
            for(int j=1; j<heights.length; j++){
                int p1=j*n+i, p2=(j-1)*n+i;
                list.add(new int[]{p1, p2, Math.abs(heights[j-1][i]-heights[j][i])});
            }
        }
        Collections.sort(list, new Comparator<int[]>(){
            public int compare(int[] i, int[] j){
                return i[2]-j[2];
            }
        });
        unionFindSet set = new unionFindSet(m*n);
        int size = list.size();
        for(int i=0; i<size; i++){
            set.union(list.get(i)[0], list.get(i)[1]);
            if(set.findRoot(0)==set.findRoot(heights.length*heights[0].length-1)){
                return list.get(i)[2];
            }
        }
        return 0;
    }
    public class unionFindSet{
        int[] root;
        int[] height;
        public unionFindSet(int n){
            root = new int[n];
            height = new int[n];
            for(int i=0; i<n; i++){
                root[i] = i;
                height[i] = 1;
            }
        }
        public int findRoot(int x){
            return x==root[x] ? x : findRoot(root[x]);
        }
        public void union(int x, int y){
            int X = findRoot(x);
            int Y = findRoot(y);
            if(X==Y) return;
            if(height[X]==height[Y]){
                root[X] = Y;
                height[Y]++;
            } else if(height[X]<height[Y]){
                root[X] = Y;
            } else {
                root[Y] = X;
            }
        }
    }
}
