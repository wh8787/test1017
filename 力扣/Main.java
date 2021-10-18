package 力扣;

import java.util.*;

public class Main {

    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int[] partition(int nums[], int key, int start, int end){
        int left=start-1, right= end+1;
        int i=start;
        //int key = nums[(int)(Math.random()*right)];
        while(i<right){
            if(nums[i]<key){
                swap(nums, i++, ++left);
            } else if(nums[i]>key){
                swap(nums, i, --right);
            } else {
                i++;
            }
        }
        return new int[]{left, right};
    }
    public static void quickSort(int nums[], int start, int end){
        if(start>=end) return;
        int key = nums[end];//nums[(int)(Math.random()*(end-start))+start];
        int bor[] = partition(nums, key, start, end);
        quickSort(nums, start, bor[0]);
        quickSort(nums, bor[1], end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int dp[][] = new int[n][3];//0放以i为最后一位之和
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            b[i] = sc.nextInt();
        }

        for(int i=0; i<a.length-2; i++){
            dfs(a, b, i, 1, 0);
        }
        System.out.print(res);
    }
    static int res = Integer.MAX_VALUE;
    public static void dfs(int []a, int []b, int k, int count, int sum){
        if(k==a.length||count>3) return;
        for(int i=k; i<a.length; i++){
            if(a[i]>=a[k]){
                count++;
                if(count==3) res = Math.min(res, sum+b[i]);
                dfs(a, b, i+1, count+1, sum+b[i]);
            }
        }
    }
}
//https://www.jb51.net/article/184631.htm激活码