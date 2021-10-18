package 力扣;

public class 巧妙_任意子数组和的绝对值的最大值 {
    public int maxAbsoluteSum(int[] nums) {
        int res = 0, min=0, max=0;
        for(int i=0; i<nums.length; i++){
            if(max>=0) max+=nums[i];
            else max = nums[i];
            if(min<0) min+=nums[i];
            else min=nums[i];
            res = Math.max(res, Math.abs(max));
            res = Math.max(res, Math.abs(min));
        }
        return res;
    }
}
/*
要找和的绝对值最大的子数组，就是找和最小或最大的连续子数组。
用max记录为非负的子数组和，min记录为负的子数组和。
1、如果目前max>=0，则将当前元素加进来；
如果小于0，说明该子数组不可能有更大的值，之后的子数组加上这一段子数组，必然会导致和减少，所以当max<0，则重新建立子数组，max=nums[i]。
2、如果目前min<0，则将当前元素加进来；
如果大于等于0，说明之后的子数组加上这一段，都会导致和增加，所以当min>=0，则重建子数组，min=nums[i]。
3、每一段子数组的和都要进行比较，用res记录其中和的绝对值最大的子数组。
 */