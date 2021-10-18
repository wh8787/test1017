package 力扣;

public class 贪心_非递减数列 {
    //贪心：如果前一个数比后一个数大，尽可能去改变前一个数，使它变小，这样才不会影响后面的比较。
    /*
    用count记录改变的次数。
    如果比较过程中出现前数i-1比后数i大：
    1、如果i大于等于i-2，只要去改变i-1。
    2、否则，改变i，保证0~i是非递减数列
     */
    public boolean checkPossibility(int[] nums) {
        if(nums.length==1) return true;
        int count=0;
        if(nums[0]>nums[1]) {
            nums[0]=nums[1];
            count++;
        }
        for(int i=1; i<nums.length; i++){
            if(nums[i]<nums[i-1]){
                count++;
                if(i-2>=0&&nums[i]>=nums[i-2]){
                    nums[i-1] = nums[i];
                } else{
                    nums[i] = nums[i-1];
                }
            }
            if(count>1) return false;
        }
        return true;
    }
}
