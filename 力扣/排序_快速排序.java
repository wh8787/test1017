package 力扣;

public class 排序_快速排序 {
    public static int[] quickMerge(int nums[]) {
        merge(nums, 0, nums.length-1);
        return nums;
    }
    public static void merge(int[] nums, int i, int j){
        if(i>=j) return;
        int key = nums[(int) Math.random()*(j-i+1)+i];//随机快排
        //int key = nums[j];//经典快排
        int start=i, end=j;
        while(start<end){
            while(start<end&&nums[start]<key){
                start++;
            }
            if(start==end) break;
            nums[end--]=nums[start];
            while(start<end&&nums[end]>=key){
                end--;
            }
            if(start==end) break;
            nums[start++] = nums[end];
        }
        nums[start] = key;
        merge(nums, i, start-1);
        merge(nums, start+1, j);
    }
}
/*
每次以最后一个元素为key。
先从左往右找大于等于key的数，赋给nums[end--]；如果直到start==end都没找到，说明不存在大于等于key的数，直接跳出循环。
然后从右往左找小于key的数，赋给nums[start++]；如果直到start==end都没找到，说明不存在小于key的数，直接跳出循环。
 */
