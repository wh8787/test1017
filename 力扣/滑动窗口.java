package 力扣;

public class 滑动窗口 {
    public int longestSubarray(int[] nums) {
        int left=0, count=0, next=0, res=0;
        for(int i=0; i<nums.length; i++){
            if(count==0){
                if(nums[i]==0) {
                    count++;
                    next = i+1;
                }
                if(i==nums.length-1) return nums.length-1;
            } else {
                if(nums[i]==0){
                    res = Math.max(res, i-left-1);
                    left = next;
                    next = 1+i;
                } else if(i==nums.length-1) return Math.max(res, nums.length-1-left);
            }
        }
        return res;
    }
}
