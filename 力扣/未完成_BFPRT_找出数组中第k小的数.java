package 力扣;

import java.util.Arrays;

public class 未完成_BFPRT_找出数组中第k小的数 {
    public static int Kmin(int nums[], int k){
        if(nums.length==1||k>nums.length||k<1) return nums[0];
        int m = nums.length%5==0 ? nums.length/5 : nums.length/5+1;
        int midNums[] = new int[m];
        for(int i=0; i<nums.length/5; i++){
            int arr[] = new int[5];
            System.arraycopy(nums, i*5, arr, 0, 5);
            Arrays.sort(arr);
            midNums[i] = arr[2];
        }
        if(nums.length%5!=0){
            int p = nums.length-(m-1)*5;
            int arr[] = new int[p];
            System.arraycopy(nums, (m-1)*5, arr, 0, p);
            Arrays.sort(arr);
            midNums[m-1] = arr[p/2];
        }
        int num = Kmin(midNums, midNums.length/2+1);
        int border[] = partition(nums, num);
        if(k>border[0]&&k<border[1]) return num;
        else if(border[0]>=k) {
            int nums1[] = new int[border[0]+1];
            System.arraycopy(nums, 0, nums1, 0, nums1.length);
            return Kmin(nums1, k);
        } else {
            int nums1[] = new int[nums.length-border[1]];
            System.arraycopy(nums, border[1], nums1, 0, nums1.length);
            return Kmin(nums1, k-border[1]);
        }
    }
    public static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int[] partition(int nums[], int target){
        int left=-1, right= nums.length;
        int i=0;
        while (i<right){
            if(nums[i]>target) swap(nums, i, --right);
            else if(nums[i]<target) swap(nums, i++, left++);
            else i++;
        }
        return new int[]{left, right};
    }
    public static void main(String args[]){
        int nums[] = {1,7,9,8,4,5,2,3,6,0};
        System.out.println(Kmin(nums, 4));
    }
}
