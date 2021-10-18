package 力扣;

import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口_双向队列_绝对差不超过限制的最长连续子数组 {
    public static int longestSubarray(int[] nums, int limit) {
        int left=0, right=0, res=0;
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        while(right<nums.length){
            while(!max.isEmpty()&&nums[max.peekLast()]<nums[right]){
                max.pollLast();
            }
            while(!min.isEmpty()&&nums[min.peekLast()]>nums[right]){
                min.pollLast();
            }
            max.add(right);
            min.add(right);
            while(!max.isEmpty()&&!min.isEmpty()&&nums[max.peekFirst()]-nums[min.peekFirst()]>limit){
                if(min.peekFirst()< max.peekFirst()){
                    left = min.peekFirst()+1;//min的队首要出队，即队首不再在窗口中，所以左边界要移到队首之后一位。
                    min.pollFirst();
                } else {
                    left = max.peekFirst()+1;//同理
                    max.pollFirst();
                }
            }
            right++;
            res = Math.max(res, right-left);
        }
        return res;
    }
}
