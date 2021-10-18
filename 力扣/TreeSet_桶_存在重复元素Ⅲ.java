package 力扣;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class TreeSet_桶_存在重复元素Ⅲ {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){//方法一：TreeSet
        TreeSet<Long> sets = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            if(i>k) {
                sets.remove((long)nums[i-k-1]);
            }
            Long bigger = sets.ceiling((long)nums[i]);//将nums[i]转为long类型，就可以直接赋值给Long类型了
            if(bigger!=null&&bigger-nums[i]<=t) return true;//Long类型与int类型进行运算，将结果也转为了Long类型
            Long smaller = sets.floor((long)nums[i]);
            if(smaller!=null&&nums[i]-smaller<=t) return true;
            sets.add((long)nums[i]);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate_1(int[] nums, int k, int t){//方法二：桶
        HashMap<Integer, Long> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(i>k){
                int m = nums[i-k-1]>=0 ? nums[i-k-1]/(t+1) : (nums[i-k-1]+1)/(t+1)-1;
                map.remove(m);//如果不含有m，则会返回false
            }
            int m = nums[i]>=0 ? nums[i]/(t+1) : (nums[i]+1)/(t+1)-1;
            if(map.containsKey(m)) return true;
            if(map.containsKey(m-1)&&(long)nums[i]-map.get(m-1)<=t) return true;
            if(map.containsKey(m+1)&&map.get(m+1)-(long)nums[i]<=t) return true;
            map.put(m, (long)nums[i]);
        }
        return false;
    }
}
