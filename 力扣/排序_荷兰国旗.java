package 力扣;

public class 排序_荷兰国旗 {
    public static int[] partition(int nums[], int target){
        int left=-1, right= nums.length;
        int i = 0;
        while(i<right){
            if(nums[i]>target) swap(nums, i, --right);
            else if(nums[i]<target) swap(nums, i++, ++left);
            else i++;
        }
        return new int[]{left, right};
    }
    public static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String args[]){
        int nums[] = {2,6,5,4,7,4,3,3,1,2,9};
        int border[] = partition(nums, 3);
        System.out.println(border[0]+" "+border[1]);
        for(int i : nums)
            System.out.print(i+" ");
    }
}
