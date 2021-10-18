package 力扣;

public class 排序_归并排序 {
    public static int[] merge(int nums[], int index1, int index2){
        if(index1==index2) return new int[]{nums[index1]};
        int mid = (index1+index2)/2;
        int[] help = new int[index2-index1+1];
        int[] help1 = merge(nums, index1, mid);
        int[] help2 = merge(nums, mid+1, index2);
        int i=0, j=0, k=0;
        while(i<help1.length||j<help2.length){
            if(i==help1.length){
                System.arraycopy(help2, j, help, k, help2.length-j);
                break;
            } else if(j==help2.length){
                System.arraycopy(help1, i, help, k, help1.length-i);
                break;
            } else if(help1[i]<=help2[j]) {
                help[k++] = help1[i++];
            } else {
                help[k++] = help2[j++];
            }
        }
        return help;
    }
    public static void main(String args[]){
        int nums[] = {1,6,3,4,2,7,9};
        nums = merge(nums, 0, nums.length-1);
        for(int i : nums)
            System.out.print(i+" ");
    }
}
