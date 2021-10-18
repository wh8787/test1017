package 力扣;

import java.util.*;

public class 比较器_优先级队列_滑动窗口中位数 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) return -1;
                else if(o1<o2) return 1;
                else return 0;
                //return o2.compareTo(o1);
            }
        });
        PriorityQueue<Integer> big = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            small.add(nums[i]);
        }
        for(int i=0; i<k/2; i++) {
            big.add(small.poll());
        }
        double res[] = new double[nums.length-k+1];
        int count = 0;
        res[count++] = big.size()==small.size() ? ((double)small.peek()+(double)big.peek())/2 : small.peek();
        for(int i=k; i<nums.length; i++){
            if(small.contains(nums[i-k])) {
                small.remove(nums[i-k]);
            } else {
                big.remove(nums[i-k]);
            }
            if(small.size()<=big.size()){
                big.add(nums[i]);
                small.add(big.poll());
            } else{
                small.add(nums[i]);
                big.add(small.poll());
            }
            res[count++] = small.size()==big.size() ? ((double)small.peek()+(double)big.peek())/2 : small.peek();
        }
        return  res;
    }
}
/*
用一个大根堆和一个小根堆分别存放窗口中较小和较大的一半数。
易错点：
1、窗口数字可能很大，相加容易越界。所以结果优先级队列输出元素时要以double类型数据输出。
2、比较器：存在越界问题，不可直接用 PriorityQueue<Integer> small = new PriorityQueue<>((x,y)->(y-x))，当数字较大时就会出错。
 */