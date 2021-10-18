package 力扣;

public class 长度最小的子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0) return 0;
        int start=0, end=1;
        int[] sum = new int[nums.length+1];
        for(int i=1; i<sum.length; i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
        int res = sum.length;
        while(end<sum.length){
            if(sum[end]-sum[start]>=s){
                res = Math.min(res, end-start);
                start++;
            } else {
                end++;
            }
            if(start==end) return 1;
        }
        return res==sum.length ? 0 : res;
    }
}
//滑动窗口