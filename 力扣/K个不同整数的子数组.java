package 力扣;

import java.util.*;

public class K个不同整数的子数组 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return MostK(A, K)-MostK(A, K-1);
    }
    public int MostK(int A[], int K){
        int left=0, right=0, res=0, p=-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(right<A.length){
            if(right!=p) {
                map.put(A[right], map.getOrDefault(A[right], 0)+1);
                p = right;
            }
            if(map.size()<=K){
                res += right-left+1;
                right++;
            } else {
                if(map.get(A[left])>1) map.put(A[left], map.get(A[left])-1);
                else map.remove(A[left]);
                left++;
            }
        }
        return res;
    }
}
