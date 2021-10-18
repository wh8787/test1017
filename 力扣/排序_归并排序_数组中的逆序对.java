package 力扣;

public class 排序_归并排序_数组中的逆序对 {
    public int reversePairs(int[] nums){
        int help[] = new int[nums.length];
        return divid(nums, 0, nums.length-1, help);
    }
    public static int divid(int nums[], int left, int right, int help[]){
        if(left>=right) return 0;
        int mid = (left+right)/2;
        int leftCount = divid(nums, left, mid, help);
        int rightCount = divid(nums, mid+1, right, help);
        if(nums[mid]<=nums[mid+1]) return leftCount+rightCount;
        return merge(nums, left, right, help)+leftCount+rightCount;
    }
    public static int merge(int nums[], int left, int right, int help[]){//排序+计算左子数组中比右子数组中各个元素大的个数的总和
        int mid = left+(right-left)/2;
        //int help[] = new int[nums.length];//因为每个重新构造数组太耗时间导致超时，所以应该在reversePairs函数中就把数组建好
        System.arraycopy(nums, 0, help, 0, nums.length);
        int index1=left, index2=mid+1, index=left, count=0;
        while(index1<=mid||index2<=right){
            if(index1>mid){
                nums[index++] = help[index2++];
            } else if(index2>right){
                nums[index++] = help[index1++];
            } else if(help[index1]>help[index2]){//说明在左子数组中有mid-index1+1个数比help[index2]大，这mid-index1+1个数与help[index2]构成逆序对
                nums[index++] = help[index2++];//计算左子数组中比各个help[index2]大的个数，即可直到左右子数组之间存在多少个逆序对。
                count += mid-index1+1;
            } else {
                nums[index++] = help[index1++];
            }
        }
        return count;
    }
}
